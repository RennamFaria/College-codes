#include <stdio.h>
#include <omp.h>

int main() {
    long long int value = 100000000;   // Sum from 1 to 100,000,000
    long long int n;
    double time_single_thread;
    double time_with_n_threads;
    int thread_counts[] = {2, 4, 8, 16}; // We skip the first test for 1 thread
    int num_thread_configs = sizeof(thread_counts) / sizeof(thread_counts[0]);

    // Calcula thread = 1 para usar como comparador de eficiencia e speedup
    omp_set_num_threads(1);
    n = 0;
    double start_time = omp_get_wtime();
    #pragma omp parallel for reduction(+:n)
    for (long long int j = 0; j < value; j++) {
        n += 1;
    }
    double end_time = omp_get_wtime();
    time_single_thread = end_time - start_time;

    printf("Threads: 1, Somatorio: %lld, Tempo: %.6f segundos\n", n, time_single_thread);
    printf("Speedup: 1.00, eficiencia: 100.00%%\n\n");

    // Executa resto das thread
    for (int i = 0; i < num_thread_configs; i++) {
        int num_threads = thread_counts[i];
        n = 0;  // Reset n for each thread configuration
        
        omp_set_num_threads(num_threads);
        
        start_time = omp_get_wtime();
        
        #pragma omp parallel for reduction(+:n)
        for (long long int j = 0; j < value; j++) {
            n += 1;
        }
        
        end_time = omp_get_wtime();
        time_with_n_threads = end_time - start_time;

        // Calculo speedup and eficiencia
        double speedup = time_single_thread / time_with_n_threads;
        double efficiency = (speedup / num_threads) * 100;
        
        // Resultados
        printf("Threads: %d, Somatorio: %lld, Tempo: %.6f segundos\n", num_threads, n, time_with_n_threads);
        printf("Speedup: %.2f, Eficiencia: %.2f%%\n\n", speedup, efficiency);
    }
    return 0;
}
