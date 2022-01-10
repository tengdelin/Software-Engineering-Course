main:	li $v0 5
	syscall 
	move $s0 $v0

	li $v0 5
	syscall 
	move $s1 $v0

	add $t0 $0 $s0
	add $t1 $0 $s1
	add $t2 $t0 $t1
	add $t3 $t1 $t2
	add $t4 $t2 $t3
	add $t5 $t3 $t4
	add $t6 $t4 $t5
	add $t7 $t5 $t6
