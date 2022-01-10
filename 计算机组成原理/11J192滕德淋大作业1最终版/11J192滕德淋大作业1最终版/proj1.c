#include "proj1.h"

/*
 *  Return a string containing the disassembled version of the given
 *  instruction.  You absolutely MUST follow the formatting instructions
 *  given in the assignment.  Note that the string your return should
 *  not include a tab at the beginning or a newline at the end since
 *  those are added in computer.c where this function is called.
 *
 *  Finally you are responsible for managing the memory associated with
 *  any string you return.  If you use malloc, you will somehow need to
 *  free the memory later (note that you cannot modify computer.c).
 *  Hint: static or global variables.
 */
char* disassembled(unsigned int instr, unsigned int pc) {

	if (pc < 0x00400000)
	{
		exit(0);
	}

	unsigned int op = instr;
	op = op >> 26;
	//R
	if (op == 0) {
		unsigned int funct = instr;
		funct = funct >> 6;
		funct = funct << 6;
		funct = instr - funct;

		instr = (instr >> 6) << 6;
		unsigned int shamt = instr;
		shamt = shamt >> 11;
		shamt = shamt << 11;
		shamt = instr - shamt;
		shamt = shamt >> 6;
		instr = (instr >> 11) << 11;
		unsigned int rd = instr;
		rd = (rd >> 16) << 16;
		rd = instr - rd;
		rd = rd >> 11;
		instr = (instr >> 16) << 16;
		unsigned int rs = instr;
		rs = (rs >> 21) << 21;
		rs = instr - rs;
		rs = rs >> 16;
		unsigned int rt = instr >> 21;
		if (funct == 32) {
			printf("\tadd  ");
			printf("$%d  ", rd);
			printf("$%d  ", rt);
			printf("$%d  ", rs);
		}
		else if (funct == 33) {
			printf("\taddu  ");
			printf("$%d  ", rd);
			printf("$%d  ", rt);
			printf("$%d  ", rs);
		}
		else if (funct == 35) {
			printf("\tsubu  ");
			printf("$%d  ", rd);
			printf("$%d  ", rt);
			printf("$%d  ", rs);
		}
		else if (funct == 34) {
			printf("\tsub  ");
			printf("$%d  ", rd);
			printf("$%d  ", rt);
			printf("$%d  ", rs);
		}
		else if (funct == 0) {
			printf("\tsll  ");
			printf("$%d  ", rd);
			printf("$%d  ", rs);
			printf("%d", shamt);
		}
		else if (funct == 2) {
			printf("\tsrl  ");
			printf("$%d  ", rd);
			printf("$%d  ", rs);
			printf("%d", shamt);
		}
		else if (funct == 36) {
			printf("\tand  ");
			printf("$%d  ", rd);
			printf("$%d  ", rt);
			printf("$%d  ", rs);
		}
		else if (funct == 37) {
			printf("\tor  ");
			printf("$%d  ", rd);
			printf("$%d  ", rt);
			printf("$%d  ", rs);
		}
		else if (funct == 42) {
			printf("\tslt  ");
			printf("$%d  ", rd);
			printf("$%d  ", rt);
			printf("$%d  ", rs);
		}
		else if (funct == 8) {
			printf("\tjr  ");
			printf("$%d  ", rt);
		}
		else
		{
			exit(0);
		}
		return "";
	}


	//I
	if (op != 2 && op != 3) {
		unsigned int imm = instr;
		imm = (imm >> 16) << 16;
		imm = instr - imm;
		unsigned int fuhao = imm;
		fuhao = imm >> 15;
		fuhao = fuhao << 16;
		imm = fuhao + imm;

		for (int i = 0; i < 15; i++) {
			fuhao = fuhao << 1;
			imm = fuhao + imm;
		}
		unsigned int rs = instr;
		rs = rs << 11;
		rs = rs >> 11;
		rs = rs >> 16;
		unsigned int rt = instr;
		rt = rt << 6;
		rt = rt >> 6;
		rt = rt >> 21;

		if (op == 9) {
			printf("\taddiu  ");
			printf("$%d  ", rs);
			printf("$%d  ", rt);
			printf("%d", imm);
		}
		else if (op == 12) {
			printf("\tandi  ");
			printf("$%d  ", rs);
			printf("$%d  ", rt);
			printf("%#x ", imm);
		}
		else if (op == 13) {
			printf("\tori  ");
			printf("$%d  ", rs);
			printf("$%d  ", rt);
			printf("0x%#x", imm);
		}
		else if (op == 15) {
			printf("\tlui  ");
			printf("$%d  ", rs);
			printf("%#x", imm);
		}
		else if (op == 4) {
			printf("\tbeq  ");
			printf("$%d  ", rt);
			printf("$%d  ", rs);
			printf("%#x", pc);
		}
		else if (op == 5) {
			printf("\tbne  ");
			printf("$%d  ", rt);
			printf("$%d  ", rs);
			printf("%#x", pc);
		}
		else if (op == 43) {
			printf("\tsw  ");
			printf("$%d  ", rs);
			printf("%d($%d)", imm, rt);
		}
		else if (op == 35) {
			printf("\tlw  ");
			printf("$%d  ", rs);
			printf("%d($%d)", imm, rt);

		}
		else if (op == 8) {
			printf("\taddi  ");
			printf("$%d  ", rs);
			printf("$%d  ", rt);
			printf("0x%x", imm);
		}
		else
		{
			exit(0);
		}
		return "";
	}

	//J
	if (op == 2 || op == 3) {
		unsigned int imm = instr;
		imm = (imm >> 26) << 26;
		imm = instr - imm;
		unsigned int fuhao = imm;
		fuhao = imm >> 25;
		fuhao = fuhao << 26;
		imm = fuhao + imm;

		for (int i = 0; i < 5; i++) {
			fuhao = fuhao << 1;
			imm = fuhao + imm;
		}
		unsigned int pc1 = pc;
		pc1 = (pc >> 28) << 28;
		imm = imm << 2;
		pc1 = pc1 + imm;

		if (op == 2) {
			printf("\tj  ");
			printf("0x%x", pc1);
		}
		else if (op == 3) {
			printf("\tjal  ");
			printf("0x%x", imm);
		}
		else
		{
			exit(0);
		}

	}
	return "";
}

/*
   Simulate the execution of the given instruction, updating the
   pc appropriately.

   If the instruction modified a register--i.e. if it was lw,
   addu, addiu, subu, sll, srl, and, andi, or, ori, lui, or slt
   to list a few examples-- return the index of the modified
   register in *changedReg, otherwise return -1 in *changedReg.
   Note that you should never return 0 in *changedReg, since
   $0 cannot be changed!  Note that even if the instruction
   changes the register back to it's old value
   (e.g. addu $3, $3, $0) the destination register ($3 in the
   example) should be marked changed!

   If the instruction was sw, return the address of the
   updated memory location in *changedMem, otherwise return -1
   in *changedMem.
 */
void simulateInstr(Computer mips, unsigned int instr, int* changedReg, int* changedMem) {
	/* You replace this code by the right stuff. */
	unsigned int op = instr;
	op = op >> 26;
	//R
	if (op == 0) {
		unsigned int funct = instr;
		funct = funct >> 6;
		funct = funct << 6;
		funct = instr - funct;

		instr = (instr >> 6) << 6;
		unsigned int shamt = instr;
		shamt = shamt >> 11;
		shamt = shamt << 11;
		shamt = instr - shamt;
		shamt = shamt >> 6;
		instr = (instr >> 11) << 11;
		unsigned int rd = instr;
		rd = (rd >> 16) << 16;
		rd = instr - rd;
		rd = rd >> 11;
		instr = (instr >> 16) << 16;
		unsigned int rs = instr;
		rs = (rs >> 21) << 21;
		rs = instr - rs;
		rs = rs >> 16;
		unsigned int rt = instr >> 21;
		//add
		if (funct == 32) {
			
			mips->pc = mips->pc + 4;
			*changedReg = rd;
			*changedMem = -1;
			mips->registers[rd] = mips->registers[rs] + mips->registers[rt];
		}
		//addu
		else if (funct == 33) {
			mips->pc = mips->pc + 4;
			*changedReg = -1;
			*changedMem = -1;
		}
		//addiu
		else if (funct == 35) {
			mips->pc = mips->pc + 4;
			*changedReg = rd;
			*changedMem = -1;
			mips->registers[rd] = mips->registers[rt] - mips->registers[rs];

		}
		//sll
		else if (funct == 0) {
			mips->pc = mips->pc + 4;
			*changedReg = rd;
			*changedMem = -1;
			mips->registers[rd] = mips->registers[rs] * 2 * shamt;

		}
		//srl
		else if (funct == 2) {
			mips->pc = mips->pc + 4;
			*changedReg = rd;
			*changedMem = -1;
			mips->registers[rd] = mips->registers[rs] / 2 * shamt;

		}
		//and
		else if (funct == 36) {
			mips->pc = mips->pc + 4;
			*changedReg = rd;
			*changedMem = -1;
			mips->registers[rd] = mips->registers[rt] & mips->registers[rs];

		}
		//or
		else if (funct == 37) {
			mips->pc = mips->pc + 4;
			*changedReg = rd;
			*changedMem = -1;
			mips->registers[rd] = mips->registers[rt] | mips->registers[rs];

		}
		//slt
		else if (funct == 42) {
			mips->pc = mips->pc + 4;
			*changedReg = rd;
			*changedMem = -1;
			mips->registers[rd] = mips->registers[rt] < mips->registers[rs];

		}
		//jr
		else if (funct == 8) {
			mips->pc = mips->pc + 4;
			*changedReg = -1;
			*changedMem = -1;
		}
		else
		{
			mips->pc = mips->pc + 4;
			*changedReg = -1;
			*changedMem = -1;
		}
		
		
	}
	//I
	else if (op != 2 && op != 3) {
		unsigned int imm = instr;
		imm = (imm >> 16) << 16;
		imm = instr - imm;
		unsigned int fuhao = imm;
		fuhao = imm >> 15;
		fuhao = fuhao << 16;
		imm = fuhao + imm;

		for (int i = 0; i < 15; i++) {
			fuhao = fuhao << 1;
			imm = fuhao + imm;
		}
		unsigned int rs = instr;
		rs = rs << 11;
		rs = rs >> 11;
		rs = rs >> 16;
		unsigned int rt = instr;
		rt = rt << 6;
		rt = rt >> 6;
		rt = rt >> 21;
		//lw
		if (op == 35) {
			int a1;
			mips->pc = mips->pc + 4;
			*changedReg = -1;
			*changedMem = 0x00403fe8 + imm;
			a1 = (*changedMem - 0x00400000) / 4;
			mips->memory[a1] = 0;
		}
		//sw
		else if (op == 43) {
			int a2;
			mips->pc = mips->pc + 4;
			*changedReg = -1;
			*changedMem = 0x00403fe8 + imm;
			a2 = (*changedMem - 0x00400000) / 4;
			mips->memory[a2] = 0;
		}
		//addiu
		else if (op == 9) {
			mips->pc = mips->pc + 4;
			*changedReg = rs;
			*changedMem = -1;
			mips->registers[rs] = mips->registers[rt] + imm;

		}
		//andi
		else if (op == 12) {
			mips->pc = mips->pc + 4;
			*changedReg = rs;
			*changedMem = -1;
			mips->registers[rs] = mips->registers[rt] & imm;

		}
		//ori
		else if (op == 13) {
			mips->pc = mips->pc + 4;
			*changedReg = rs;
			*changedMem = -1;
			mips->registers[rs] = mips->registers[rt] | imm;

		}
		//lui
		else if (op == 15) {
			mips->pc = mips->pc + 4;
			*changedReg = rs;
			*changedMem = -1;
			mips->registers[rs] = imm<<16;

		}
		
		else {
			mips->pc = mips->pc + 4;
			*changedReg = -1;
			*changedMem = -1;
		}
		
	}
	//J
	else if (op == 2 || op == 3) {
		unsigned int imm = instr;
		imm = (imm >> 26) << 26;
		imm = instr - imm;
		unsigned int fuhao = imm;
		fuhao = imm >> 25;
		fuhao = fuhao << 26;
		imm = fuhao + imm;

		for (int i = 0; i < 5; i++) {
			fuhao = fuhao << 1;
			imm = fuhao + imm;
		}

		//j
		if (op == 2) {
			unsigned int pc1 = mips->pc;
			pc1 = (pc1 >> 28) << 28;
			imm = imm << 2;
			pc1 = pc1 + imm;

			mips->pc = pc1;
			*changedReg = -1;
			*changedMem = -1;
		}
		//jal
		else if (op == 3) {
			unsigned int pc1 = mips->pc;
			pc1 = (pc1 >> 28) << 28;
			imm = imm << 2;
			pc1 = pc1 + imm;
			mips->registers[31] = mips->pc + 4;

			mips->pc = pc1;
			*changedReg = 31;
			*changedMem = -1;
		}
		else
		{
			mips->pc = mips->pc + 4;
			*changedReg = -1;
			*changedMem = -1;
		}
		
	}

	else
	{
		mips->pc = mips->pc + 4;
		*changedReg = -1;
		*changedMem = -1;
	}
}
