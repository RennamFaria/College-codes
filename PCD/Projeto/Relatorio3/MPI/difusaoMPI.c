//%%writefile difusaoMPI.c

#include "mpi.h"
#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <time.h>

#define N 2000 // Tamanho da grade
#define T 1000 // Quantidade de iterações
#define D 0.1  // Coeficiente de coesão
#define DELTA_T 0.01
#define DELTA_X 1.0

void diff_eq(double **C, double **C_new, int localN) {
    //int localUp, localDown, localRight, localLeft;
    int myId;

    MPI_Comm_rank(MPI_COMM_WORLD, &myId);

    int up = (myId >= 2) ? myId - 2 : MPI_PROC_NULL;
    int down = (myId < 2) ? myId + 2 : MPI_PROC_NULL;
    int left = (myId % 2 == 1) ? myId - 1 : MPI_PROC_NULL;
    int right = (myId % 2 == 0) ? myId + 1 : MPI_PROC_NULL;

    for (int t = 0; t < T; t++){
// Paralelização da equação de difusão
        for (int i = 1; i < localN - 1; i++){
            // Vertical
            MPI_Sendrecv(&C[1][i], 1, MPI_DOUBLE, up, 0,
                        &C[0][i], 1, MPI_DOUBLE, up, 0,
                        MPI_COMM_WORLD, &status);
                        
            MPI_Sendrecv(&C[localN-2][i], 1, MPI_DOUBLE, down, 0,
                        &C[localN-1][i], 1, MPI_DOUBLE, down, 0,
                        MPI_COMM_WORLD, &status);

            // Horizontal
            MPI_Sendrecv(&C[i][1], 1, MPI_DOUBLE, left, 0,
                        &C[i][0], 1, MPI_DOUBLE, left, 0,
                        MPI_COMM_WORLD, &status);
                        
            MPI_Sendrecv(&C[i][localN-2], 1, MPI_DOUBLE, right, 0,
                        &C[i][localN-1], 1, MPI_DOUBLE, right, 0,
                        MPI_COMM_WORLD, &status);
        }
            // Calculate new values
        double difmedio = 0.0;
        for (int i = 1; i < localN - 1; i++) {
            for (int j = 1; j < localN - 1; j++) {
                C_new[i][j] = C[i][j] + D * DELTA_T * (
                    (C[i+1][j] + C[i-1][j] + C[i][j+1] + C[i][j-1] - 4 * C[i][j]) 
                    / (DELTA_X * DELTA_X)
                );
                difmedio += fabs(C_new[i][j] - C[i][j]);
                C[i][j] = C_new[i][j];
            }
        }

        if ((t % 100) == 0)
            printf("Process %d - Iteração %d - diferença média=%g\n", myId, t, difmedio / ((localN - 2) * (localN - 2)));
    }
}

int main(int argc, char *argv[]){
    int myId, numProcs;

    MPI_Init(&argc, &argv);
    MPI_Comm_rank(MPI_COMM_WORLD, &myId);
    MPI_Comm_size(MPI_COMM_WORLD, &numProcs);

    int localN = N / numProcs;
    // int iPart =  partition*myId;
    // int nPart = (partition*myId) + partition;
    // int tPart = ((T/numProcs)*myId) + (T/numProcs);
    int lineStart = (myId / 2) * local_N;
    int colStart = (myId % 2) * local_N;

    double **C = (double **)malloc(localN * sizeof(double *));
    if (C == NULL) {
        fprintf(stderr, "Falha na alocação de memória para C\n");
        MPI_Abort(MPI_COMM_WORLD, 1);
        return 1;
    }

    double **C_new = (double **)malloc(localN * sizeof(double *));
    if (C_new == NULL) {
        fprintf(stderr, "Falha na alocação de memória para C_new\n");
        free(C);
        MPI_Abort(MPI_COMM_WORLD, 1);
        return 1;
    }

    // ------- Inicializando matrizes -------

    for (int i = 0; i < localN; i++) {
        C[i] = (double *)malloc(localN * sizeof(double));
        C_new[i] = (double *)malloc(localN * sizeof(double));
        
        if (C[i] == NULL || C_new[i] == NULL) {
            fprintf(stderr, "Falha na alocação de memória\n");
            MPI_Abort(MPI_COMM_WORLD, 1);
            return 1;
        }

        // Inicializa os valores
        for (int j = 0; j < localN; j++) {
            C[i][j] = 0.0;
            C_new[i][j] = 0.0;
        }
    }
        
    // Encontra o processo que posssui o centro da matriz geral e seta o valor inicial
    int centerGlobal = N/2;
    if ((centerGlobal >= lineStart && centerGlobal < lineStart + local_N) &&
        (centerGlobal >= colStart && centerGlobal < colStart + local_N)) {
        int localI = centerGlobal - lineStart;
        int localJ = centerGlobal - colStart;
        C[localI][localJ] = 1.0;
    }

    diff_eq(C, C_new, localN);

    // Cria uma memória temporária para juntar os resultados
    double **globalC = NULL;
    if (myId == 0) {
        globalC = (double **)malloc(N * sizeof(double *));
        for (int i = 0; i < N; i++) {
            globalC[i] = (double *)malloc(N * sizeof(double));
        }
    }

    // Junta resultados
    for (int i = 0; i < localN; i++) {
        MPI_Gather(C[i], localN, MPI_DOUBLE,
                  globalC[lineStart + i] + colStart, localN,
                  MPI_DOUBLE, 0, MPI_COMM_WORLD);
    }

    if (myId == 0) {
        // Salva a matrix no arquivo de planilha
        FILE *fp = fopen("/content/matriz_MPI_output.txt", "w");

        // Salvando matrix no aqruivo txt
        if (fp == NULL){
            printf("Erro ao abrir arquivo.txt");
        }
        else{
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (globalC[i][j] >= 0.0001) {
                        fprintf(fp, "i:%d j:%d Matriz:%f ", i, j, globalC[i][j]);
                    }
                }
                fprintf(fp, "\n");
            }
            fclose(fp);
            printf("\nConcentração final no centro: %f\n", globalC[N/2][N/2]);
        }
        
        // Libera memória temporária
        for (int i = 0; i < N; i++) {
            free(globalC[i]);
        }
        free(globalC);
    }

    // Libera memória alocada
    for (int i = 0; i < localN; i++) {
        free(C[i]);
        free(C_new[i]);
    }
    free(C);
    free(C_new);

    MPI_Finalize();

    return 0;
}


/*

void diff_eq(double **C, double **C_new, int localN) {
    int i, j;
    int localUp, localDown, localRight, localLeft;

    for (int t = 0; t < T; t++){
// Paralelização da equação de difusão
        for (int i = 1; i < localN - 1; i++){
            for (int j = 1; j < localN - 1; j++){
                localUp = C[i + 1][j];
                localDown = C[i - 1][j];
                localRight = C[i][j + 1];
                localLeft = C[i][j - 1];

                // Checa e recebe os valores necessários
                // Caso if verdadeiro, necessita pegar valor de outro processo
                if((i-1) <= 1){         // localUp
                    MPI_Recv();
                    MPI_ISendv();
                }
                else if((i+1) >= localN){    // localDown
                    MPI_Recv();
                    MPI_ISendv();
                }
                if((j+1) >= localN){    // localRight
                    MPI_Recv();
                    MPI_ISendv();
                }
                else if((j-1) <= 1){         // localLeft
                    MPI_Recv();
                    MPI_ISendv();
                }
                


                // Calculo
                C_new[i][j] = C[i][j] + D * DELTA_T * (
                    (localUp + localDown + localRight + localLeft - 4 * C[i][j]) / (DELTA_X * DELTA_X)
                    );

                // Se estiver no indice borda, envia o resultado para seus processo vizinhos
                if(i == localN - 1) {   
                    MPI_Bcast();    //Make broadcast just for the adjacent processs
                    // If i cant do this, just make a Isend two times
                }
                if(j == localN - 1) {
                    MPI_Bcast();
                }



                // actually i can put the both in the same if, like a send/recv
                //another way to do
                // if(i == 1){         // send to process upper
                //     MPI_Recv();
                // }
                // if(i == localN){    // send to process lower
                //     MPI_Recv();
                // }
                // if(j == 1){         // send to process right
                //     MPI_Recv();
                // }
                // if(j == localN){   // send to process left
                //     MPI_Recv();
                // }
            }
        }

        // Atualiza a matriz para a próxima iteração
        double difmedio = 0.;

// Paralelização da diferença média
        for (int i = 1; i < localN - 1; i++){
            for (int j = 1; j < localN - 1; j++){
                difmedio += fabs(C_new[i][j] - C[i][j]); // fabs = pega o valor absoluto
                C[i][j] = C_new[i][j];
            }
        }

        if ((t % 100) == 0)
            printf("Iteração %d - diferença média=%g\n", t, difmedio / ((localN - 2) * (localN - 2)));
    }
}
*/