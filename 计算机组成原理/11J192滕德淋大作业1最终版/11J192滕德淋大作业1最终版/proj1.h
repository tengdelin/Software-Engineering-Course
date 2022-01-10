#include <stdio.h>
#include <stdlib.h>
#include "computer.h"
#include<string.h>
#include<stdlib.h>
#undef mips                     /* gcc already has a def for mips */

#define MAXNUMINSTRS 1024       /* max # instrs in a program */
#define MAXNUMDATA 3072         /* max # data words */

struct SimulatedComputer {
    int memory [MAXNUMINSTRS+MAXNUMDATA];
    int registers [32];
    int pc;
    int printingRegisters, printingMemory, interactive, debugging;
};

void printInfo (Computer, int changedReg, int changedMem);
void simulateInstr (Computer, unsigned int instr, int *changedReg, int *changedMem);
char * disassembled (unsigned int, unsigned int);
unsigned int contents (Computer, int);
