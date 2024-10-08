.data

msgQtd:     .asciiz "Entre com a quantidade de numeros do vetor:\n"
msgOut1:    .asciiz "Entre com o numero "
msgOut2:    .asciiz " do vetor:\n"
msgVetL:    .asciiz "Vetor lido: "
msgVetN:    .asciiz "\nVetor normalizado: "
    .align 2
    
list :	.space 20

.text
.globl main

main:
    la $t5, list

    la $a0, msgQtd
    li $v0, 4
    syscall
    
    li $v0, 5
    syscall
    move $s0, $v0
    
    li $t8, 0
    
    LoopInput:
    beq $t8, $s0, Prox1   
    
    la $a0, msgOut1
    li $v0, 4
    syscall

    move $a0, $t8
    li $v0, 1
    syscall
    
    la $a0, msgOut2
    li $v0, 4
    syscall

    li $v0, 6
    syscall
    
    mfc1 $t6, $f0
    sw $t6, ($t5)
    
    add $t5, $t5, 4
    addi $t8, $t8, 1
    
    j LoopInput
    
    Prox1:

    Reductor:
    beq $t8, $zero, endRed   
    
    sub $t5, $t5, 4
    sub $t8, $t8, 1
    
    j Reductor
    
    endRed:
    
    li $t8, 0
    
    la $a0, msgVetL
    li $v0, 4
    syscall
    
    LoopInput2:
    beq $t8, $s0, Prox2    
    
    lw $t6, ($t5)
    mtc1 $t6, $f12
    
    li $v0, 2
    syscall
    
    li $v0, 11    
    li $a0, 32     
    syscall

    add $t5, $t5, 4
    addi $t8, $t8, 1   
    
    j LoopInput2

    Maior:
    mov.s $f4, $f12
    
    j loopMN

    Menor:
    mov.s $f5, $f12
    
    j loopMN

    Prox2:

    
    li $t2, 0    
    mtc1 $t2, $f4
    li.s $f5, 1000.0
    
    loopMN:
    beq $t8, $zero, Prox3   
    sub $t8, $t8, 1
    sub $t5, $t5, 4
    
    lw $t6, ($t5)
    mtc1 $t6, $f12

    c.lt.s $f4, $f12     
    bc1t Maior     
    
    c.lt.s $f12, $f5       
    bc1t Menor  
    
    j loopMN

    sub $t8, $t8, 1
    sub $t5, $t5, 4
 
    Prox3:
    
    la $a0, msgVetN
    li $v0, 4
    syscall
    
    loopEq:
    beq $t8, $s0, Prox4    

    lw $t6, ($t5)
    mtc1 $t6, $f12
    
    sub.s $f2, $f12, $f5  
    sub.s $f3, $f4, $f5   
    div.s $f12, $f2, $f3  
    
    li $v0, 2
    syscall
    
    li $v0, 11    
    li $a0, 32    
    syscall

    add $t8, $t8, 1
    add $t5, $t5, 4
    j loopEq

    Prox4:
    
    li $v0, 10    # code for program end
    syscall