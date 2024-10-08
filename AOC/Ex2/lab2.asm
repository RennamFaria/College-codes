.data

msgX:   .asciiz "Entre com a coordenada x do ponto P:\n"
msgY:   .asciiz "Entre com a coordenada y do ponto P:\n"
msgBrlhA:   .asciiz "Entre com o brilho do pixel A:\n"
msgBrlhB:   .asciiz "Entre com o brilho do pixel B:\n"
msgBrlhC:   .asciiz "Entre com o brilho do pixel C:\n"
msgBrlhD:   .asciiz "Entre com o brilho do pixel D:\n"
msgEnd:   .asciiz "Valor do brilho do ponto P: "
msgECord:   .asciiz "Coordenada invalida.\n"
msgEBrlh:   .asciiz "Brilho invalido.\n"

.text
.globl main

main:
    li.s $f10, 0.0
    li.s $f11, 1.0
    li $s7, 0
    li $s8, 255
    
    LoopX:
    la $a0, msgX
    jal printString
    
    jal getFloat
    mov.s $f1, $f0
    
    c.lt.s $f1, $f10      # Check if float < 0.0, se vdd, code = 1, Error
    bc1t ErrorX            # If not less than 0 or greater than 1, proceed
    c.lt.s $f11, $f1      # Check if 1.0 < float se vdd, code = 1, Error
    bc1t ErrorX            # If not less than 0 or greater than 1, proceed
    j ProxX
    
    ErrorX:
    la $a0, msgECord
    jal printString
    j LoopX 
    
    ProxX:
    ######
    LoopY:
    la $a0, msgY
    jal printString
    
    jal getFloat
    mov.s $f2, $f0
    
    c.lt.s $f2, $f10      # Check if float < 0.0, se vdd, code = 1, Error
    bc1t ErrorY            # If not less than 0 or greater than 1, proceed
    c.lt.s $f11, $f2      # Check if 1.0 < float se vdd, code = 1, Error
    bc1t ErrorY            # If not less than 0 or greater than 1, proceed
    j ProxY
    
    ErrorY:
    la $a0, msgECord
    jal printString
    j LoopY 
    
    ProxY:
    ######
    LoopA:
    
    la $a0, msgBrlhA
    jal printString
    
    jal getInt
    move $t0, $v0

    blt $t0, $s7, ErrorA       #se int < 0, entao code = 1
    blt $s8, $t0, ErrorA       #se 255 < int, entao code = 1
    j ProxA
    
    ErrorA:
    la $a0, msgEBrlh
    jal printString
    j LoopA  
    
    ProxA:
    ######
    LoopB:
    
    la $a0, msgBrlhB
    jal printString
    
    jal getInt
    move $t1, $v0

    blt $t1, $s7, ErrorB       #se int < 0, entao code = 1
    blt $s8, $t1, ErrorB       #se 255 < int, entao code = 1
    j ProxB
    
    ErrorB:
    la $a0, msgEBrlh
    jal printString
    j LoopB  
    
    ProxB:
    ######
    LoopC:
    
    la $a0, msgBrlhC
    jal printString
    
    jal getInt
    move $t2, $v0

    blt $t2, $s7, ErrorC       #se int < 0, entao code = 1
    blt $s8, $t2, ErrorC       #se 255 < int, entao code = 1
    j ProxC
    
    ErrorC:
    la $a0, msgEBrlh
    jal printString
    j LoopC  
    
    ProxC:
    ######
    LoopD:
    
    la $a0, msgBrlhD
    jal printString
    
    jal getInt
    move $t3, $v0

    blt $t3, $s7, ErrorD       #se int < 0, entao code = 1
    blt $s8, $t3, ErrorD       #se 255 < int, entao code = 1
    j ProxD
    
    ErrorD:
    la $a0, msgEBrlh
    jal printString
    j LoopD  
    
    ProxD:
    ######
    #calculo do resultado
    #(1.0 - x)
    sub.s $f3, $f11, $f1

    #(1.0 - y)
    sub.s $f4, $f11, $f2
    
    #(1.0 - x)*(1.0 - y)*Ba
    mul.s $f5, $f3, $f4
    mtc1 $t0, $f0        #convert int to float
    cvt.s.w $f0, $f0     #convert int to float
    mul.s $f5, $f5, $f0
    
    #(1.0 - x)*y*Bb
    mul.s $f6, $f3, $f2
    mtc1 $t1, $f0        #convert int to float
    cvt.s.w $f0, $f0     #convert int to float
    mul.s $f6, $f6, $f0
    
    #((1.0 - x)*(1.0 - y)*Ba) + ((1.0 - x)*y*Bb)
    add.s $f5, $f5, $f6
    
    #x*(1.0 - y)*Bc
    mul.s $f6, $f4, $f1
    mtc1 $t2, $f0        #convert int to float
    cvt.s.w $f0, $f0     #convert int to float
    mul.s $f6, $f6, $f0
    
    #((1.0 - x)*(1.0 - y)*Ba + (1.0 - x)*y*Bb) + (x*(1.0 - y)*Bc)
    add.s $f5, $f5, $f6
    
    #x*y*Bd
    mul.s $f6, $f1, $f2
    mtc1 $t3, $f0        #convert int to float
    cvt.s.w $f0, $f0     #convert int to float
    mul.s $f6, $f6, $f0
    
    #((1.0 - x)*(1.0 - y)*Ba + (1.0 - x)*y*Bb + x*(1.0 - y)*Bc)) + (x*y*Bd)
    add.s $f5, $f5, $f6
   
    la $a0, msgEnd
    jal printString
   
    cvt.w.s $f0, $f5      # Convert $f5 (result) to an integer in $f0
    mfc1 $t0, $f0         # Move the integer value from $f0 to $t0
        
    move $a0, $t0
    jal printInt

    li $v0, 10    # code for program end
    syscall

printString: 
    li $v0, 4
	syscall
	jr $ra  

getFloat:
    li $v0, 6
    syscall
    jr $ra
    
getInt:
    li $v0, 5
    syscall
    jr $ra
    
printInt:
    la $v0, 1
    syscall
    jr $ra
	
#loopInput: #Loop caso de erro na entrada, recebe o loop onde esta errado