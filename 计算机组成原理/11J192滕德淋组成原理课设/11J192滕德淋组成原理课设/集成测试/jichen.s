	jal 	ra label
	addi	t1 x0 2
	addi	t2 x0 2
	beq	t1 t2 lsub
	lui 	x0 0
	lui 	s0 74565
	sw 	s0 40(x0)
	lw 	t1 40(x0)
	lb	t1 40(x0)
	lb 	t1 40(x0)
	addi 	t0,x0,8
	addi 	t1,x0,9
	xor 	s0,t0,t1
	or 	s0,t0,t1
	ori 	s0,t0,11
	and 	s0,t0,t1
	andi 	s0,t0,10
label:
	lui 	t0 5
	addi 	t1 x0 2
	add 	t2 t1 x0
	mul 	t2 t2 t1
	sll 	t2 t2 t1
	srl 	t2 t2 t1
	sll 	t2 t2 t1
	srli 	t2 t2 3
	slli 	t2 t2 2
	slt 	s0 t0 t1
	blt 	s0 x0 loop1
	beq 	s0 x0 loop2
	jalr 	x0 ra 0
loop1:
	addi 	s1 x0 1
loop2:
	divu 	a0 t0 t1
	remu 	a0 t0 t1
lsub:
	sub 	a0 t0 t1
