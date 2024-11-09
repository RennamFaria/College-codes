#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>

void compressRle(const char* input, char* output) {
    int count, i = 0, j = 0;
    while (input[i] != '\0') {
        output[j++] = input[i];
        count = 1;
        while (input[i] == input[i + 1]) {
            count++;
            i++;
        }
        j += sprintf(&output[j], "%d", count);
        i++;
    }
    output[j] = '\0';
}

int main() {
    char input[] = "aaabbccccddddeeeeeffaaaaaaa";
    char output[100];

    clock_t start = clock();
    compressRle(input, output);
    clock_t end = clock();

    double time_spent = (double)(end - start) / CLOCKS_PER_SEC;
    printf("String comprimida: %s\n", output);
    printf("Tempo de execução (sequencial): %f segundos\n", time_spent);

    return 0;
}
