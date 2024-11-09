#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <sys/wait.h>
#include <time.h>

void splitInput(const char* input, char* leftInput, char* rightInput) {
    int len = strlen(input);
    int mid = len / 2;

    // Split and separate the input
    strncpy(leftInput, input, mid);
    leftInput[mid] = '\0';
    strcpy(rightInput, input + mid);
}

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

void splitTask(const char* input, char* output) {
    char leftInput[50], rightInput[50];
    char childOutput[50], parentOutput[50];
    int pipefd[2];

    if (pipe(pipefd) == -1) {   //pipe for comunication parent/child
        perror("pipe failed");
        exit(1);
    }

    splitInput(input, leftInput, rightInput);

    pid_t pid = fork();   //create fork -> parent/child

    if (pid < 0) {
        perror("Fork failed");
        exit(1);
    } else if (pid == 0) {  // Child process

        close(pipefd[0]);  // Close pipe
        compressRle(rightInput, childOutput);

        // Write result in pipe
        write(pipefd[1], childOutput, strlen(childOutput) + 1);
        close(pipefd[1]);  // Close write end after writing
        exit(0);
    } else {  // Parent process
        close(pipefd[1]);  // Close pipe
        compressRle(leftInput, parentOutput);

        wait(NULL);   //Wait for child process

        // Read pipe
        read(pipefd[0], childOutput, sizeof(childOutput));
        close(pipefd[0]);  // Close the pipe

        snprintf(output, 100, "%s%s", parentOutput, childOutput);   //Combine results
    }
}

int main() {
    char input[] = "aaabbccccddddeeeeeffaaaaaaa";
    char output[100];
    clock_t start = clock();

    splitTask(input, output);

    clock_t end = clock();
    double time_spent = (double)(end - start) / CLOCKS_PER_SEC;

    printf("Compressed string: %s\n", output);
    printf("Execution time (parallel): %f seconds\n", time_spent);

    return 0;
}