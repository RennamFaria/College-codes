#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>  //Sleep library for linux
#include <time.h>
#include <omp.h>

#define N_THREADS 5     // (1)server + (4)clients

int soma = 0;

int request = 0;
int respond = 0;
int completed_executions = 0;
int total_executions_needed = 0;

void sumProcess (int numb, int thread_id) {
    int local = soma;
    sleep(rand() %2);
    
    printf("Client: %d || Making the sum = local(%d) + numb(%d)\n\n", thread_id, local, numb);
    soma = local + numb;

    return;
}

void client (int thread_id) {
    int iterations = (thread_id * 2);
    int i = 0;      //counter

    printf("CLIENT(%d)\n\n", thread_id);
    while(1) {   //loop forever
        //non critical area
        printf("CLIENT(%d)\n\n", thread_id);
        while(respond != thread_id){
            request = thread_id;
        }
        printf("\n ---> Process %d doing the process of Sum\n", thread_id);

        for(; i < iterations; i++){     //execute critical section ID*2 times
        printf("\n ---> Process %d iteration %d/%d\n", thread_id, i+1, iterations);
        
            #pragma omp critical
            {
                sumProcess(1, thread_id);  //critical section
            }
        }
        respond = 0;
        // Entry if complete all the Sum process and increment on finished
        if (i >= iterations){
            completed_executions++;
            return;
        }
    }
    return;
}

void server () {
    while(1) {   //loop forever
        printf("SERVER \n");

        //await request != 0
        while (request == 0 && completed_executions < total_executions_needed) {  
            usleep(1000);
        }
        
        printf("\n ---> Server puting respond = request");
        respond = request;

        //await respond != 0
        while (respond != 0 && completed_executions < total_executions_needed) {  
            usleep(1000);
        }
        // If the client finished all the sum, end the server
        if(!(completed_executions < total_executions_needed)) {
            return;
        }
        request = 0;
    }
    return;
}

int main() {
    srand(time(NULL));
    
    omp_set_num_threads(N_THREADS);

    int thread_id;
    int interactions;
    int i;

    total_executions_needed = N_THREADS - 1;

    // Separate each one to exectute simultaneously 
    // with differents num of threads
    #pragma omp parallel    \
    shared (request, respond, completed_executions, total_executions_needed, soma)  \
    private (thread_id, interactions, i)
    {
        thread_id = omp_get_thread_num();
        // Server ID = 0
        if (thread_id == 0) {
            server();
        }
        else{
            client(thread_id);
        }
    }

    printf("\n|| Numb of CLIENTS    = %d ||", N_THREADS - 1);
    printf("\n|| Result of the SOMA = %d ||\n", soma);
    
    return 0;
}