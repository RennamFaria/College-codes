#include<stdio.h>
#include<time.h>
#include <windows.h>

void printStartFib(){
  printf("0 ");
  printf("1");

  return;
}

void printValue(int n){
  printf("%d", n);

  return;
}

void fib(int n){
  int a = 0;
  int b = 1;
  int c;
  printStartFib();
  
  for(int i = 2; i < n; i++){
    c=a+b;
    printf(" %d", c);
    a=b;
    b=c;
  }
  return;
}


int main(){
  int pid, time, n, val;

  do{
    printf("Insert the quantity of fibonacci sequence: ");
    scanf("%d", &n);
    if(n <= 0)
        printf("Invalid input! Type positive number\n");
  }while (n <= 0);
  
  pid = fork();

  time = clock(); /*starts clock on program*/
  
  if(pid < 0){
    printf("Forked failed error\n");
    return 0;
  }
  if (pid == 0){  //child
    printf("Fibonacci values is: ");
    
    fib(n);

    printf("\n\nChild = \n");
    printf("Time of execution %d\n", time);
    return 0;
  }
  else{  //parent
    wait(NULL);
    printf("Parent = \n");
    printf("Time of execution %d\n", time);
  }

  return 0;
}