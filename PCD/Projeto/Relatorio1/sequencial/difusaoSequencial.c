// %%writefile difusaoSequencial.c
#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <time.h>

#define N 2000  // Tamanho da grade
#define T 1000  // Quantidade de iterações
#define D 0.1   // Coeficiente de coesão
#define DELTA_T 0.01
#define DELTA_X 1.0

void diff_eq(double **C, double **C_new) { //diff_eq(double C[N][N], double C_new[N][N]) {
    for (int t = 0; t < T; t++) {

        // Calculo da equação de difusão para toda a matrix
        for (int i = 1; i < N - 1; i++) {
            for (int j = 1; j < N - 1; j++) {
                C_new[i][j] = C[i][j] + D * DELTA_T * (
                    (C[i+1][j] + C[i-1][j] + C[i][j+1] + C[i][j-1] - 4 * C[i][j]) / (DELTA_X * DELTA_X)
                );
            }
        }

        // Atualiza a matriz para a próxima iteração
        double difmedio = 0.;
        for (int i = 1; i < N - 1; i++) {
            for (int j = 1; j < N - 1; j++) {
                difmedio += fabs(C_new[i][j] - C[i][j]);    // fabs = pega o valor absoluto
                C[i][j] = C_new[i][j];
            }
        }
        if ((t % 100) == 0)
          printf("Iteração %d - diferença média=%g\n", t, difmedio / ((N - 2) * (N - 2)));
    }
}

int main() {
    clock_t start_time, elapsed_time;

    // ------- Concentração Inicial -------
    // Cria a matriz C de tamanho N
    double **C = (double **)malloc(N * sizeof(double *));

    // Verifica se a matriz foi criada corretamente
    if (C == NULL) {     
      fprintf(stderr, "Falha na alocação de memória\n");
      return 1;
    }

    // Cria o restante da matriz C de tamanho N*N
    for (int i = 0; i < N; i++) {     
      C[i] = (double *)malloc(N * sizeof(double));
      if (C[i] == NULL) {
        fprintf(stderr, "Falha na alocação de memória\n");
        return 1;
      }
    }

    // Limpa a matriz C
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        C[i][j] = 0.;
      }
    }

    // ------- Concentração para a próxima iteração -------
    // Cria a matriz C_new de tamanho N
    double **C_new = (double **)malloc(N * sizeof(double *));

    // Verifica se a matriz foi criada corretamente
    if (C_new == NULL) {
      fprintf(stderr, "Falha na alocação de memória\n");
      return 1;
    }

    // Cria o restante da matriz C_new de tamanho N*N
    for (int i = 0; i < N; i++) {
      C_new[i] = (double *)malloc(N * sizeof(double));
      if (C_new[i] == NULL) {
        fprintf(stderr, "Falha na alocação de memória\n");
        return 1;
      }
    }

    // Limpa a matriz C_new
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        C_new[i][j] = 0.;
      }
    }

    // Inicializa a concentração no centro da matriz C
    C[N / 2][N / 2] = 1.0;

    // Começa o tempo do processo da equação
    start_time = clock();

    // Executa o processo da equação de difusão com as matrizes
    diff_eq(C, C_new);

    // Termina o tempo do processo da equação
    elapsed_time = (clock() - start_time);

    // Exibe os resultados
    printf("Tempo final de processo: %f\n", ((double)elapsed_time)/CLOCKS_PER_SEC);
    printf("Concentração final no centro: %f\n", C[N / 2][N / 2]);
    return 0;
}


// !rm difusaoSequencial.x
// !gcc difusaoSequencial.c -o difusaoSequencial.x
// !time ./difusaoSequencial.x

// !more /proc/cpuinfo &> processador.txt
// !more processador.txt | grep model