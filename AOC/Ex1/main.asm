.data

str1:   .asciiz "Entre com a altura do paralelepipedo:"
str2:   .asciiz "\nEntre com a largura do paralelepipedo:"
str3:   .asciiz "\nEntre com a espessura do paralelepipedo:"
msgf:   .asciiz "\nVolume do paralelepipedo: "
msge:   .asciiz "\nMedida invalida."
        .align 2    # move to a word boundary
res1:   .space 4    # reserve space to store result
res2:   .space 4    # reserve space to store result
res3:   .space 4        # reserve space to store result

.text
.globl main

main:
    Loop1:
    li $v0, 4
    la $a0, str1
    syscall
    li $v0, 5
    syscall
    # tem algum erro aqui dentro na hora de receber o numero e no if, arrumar
    
    slt $t0, $zero, $v0     # se 0<v0 verdade t0 = 1, se nao t0 = 0
    beq $t0, 1, Prox1
    
    li $v0, 4
    la $a0, msge
    syscall
    j Loop1
    
    Prox1:
    move $t0, $v0	# move the value read to $t0, qual o valor de $t0?
    sw $t0, res1($0)	# store result in memory

    ##############################################    
    Loop2:
    li $v0, 4
    la $a0, str2
    syscall
    
    li $v0, 5
    syscall
    
    slt $t1, $zero, $v0     # se 0<v0 verdade t0 = 1, se nao t0 = 0
    beq $t1, 1, Prox2
    
    li $v0, 4
    la $a0, msge
    syscall
    j Loop2
    
    Prox2:
    move $t1, $v0	# move the value read to $t0
    sw $t1, res2($0)	# store result in memory
    
    #################################################
    Loop3:
    li $v0, 4
    la $a0, str3
    syscall
    
    li $v0, 5
    syscall
    
    slt $t2, $zero, $v0     # se 0<v0 verdade t0 = 1, se nao t0 = 0
    beq $t2, 1, Prox3
    
    li $v0, 4
    la $a0, msge
    syscall
    j Loop2
    
    Prox3:
    move $t2, $v0	# move the value read to $t0
    sw $t2, res3($0)	# store result in memory

    ################################################
    # falta multiplicar os valores
    
    move $t3, $t0
    
    mult1:
    
    slt $t5, $t1, 2     # se t1<2 verdade t5 = 1, se nao t5 = 0
    beq $t5, 1, Exit1
    
    sub $t1, $t1, 1     #subtract the loop for 1
	add $t3, $t3, $t0	# multiply by 2
	
	j mult1
	Exit1:
	################################################
	move $t4, $t3
    
    mult2:
    
    slt $t5, $t2, 2     # se t2<2 verdade t5 = 1, se nao t5 = 0
    beq $t5, 1, Exit2
    
    sub $t2, $t2, 1     #subtract the loop for 1 
	add $t4, $t4, $t3	# multiply by 2
	
	
	j mult2
	Exit2:
	
    ################################################
    li $v0, 4
    la $a0, msgf
    syscall
    
    li $v0, 1  
    move $a0, $t4
    syscall
    
    li $v0, 10	# code for program end
    syscall