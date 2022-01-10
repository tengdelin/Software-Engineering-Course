struct SimulatedComputer;
typedef struct SimulatedComputer *Computer;
Computer newComputer (FILE*, int printingRegisters, int printingMemory, int debugging, int interactive);
void simulate (Computer);
