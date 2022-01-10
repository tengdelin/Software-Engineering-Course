.data 
countmsg1: .asciiz  "yes\n"
countmsg2: .asciiz  "no"
.text 
	li $t5,1
	add $t2,$t3,$t4
	sleu $t2,$t2,$0
	beq $t2,$0 ,NO
	beq $t2,$t5 ,YES
	NO:
	li $v0 4
	la $a0,countmsg2
	syscall
	li $v0 10
	syscall
	YES:
	li $v0 4
	la $a0,countmsg1
	syscall
	li $v0 10
	syscall