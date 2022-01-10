#include <stdio.h>
#include "bool.h"
#include "computer.h"

int main (int argc, char *argv[]) {
    int argIndex;
    int printingRegisters = FALSE;
    int printingMemory = FALSE;
    int debugging = FALSE;
    int interactive = FALSE;
    FILE *filein;
    Computer computer;

    if (argc < 2) {
        fprintf (stderr, "Not enough arguments.\n");
        return 1;
    }

    for (argIndex=1; argIndex<argc && argv[argIndex][0]=='-'; argIndex++) {
        /* Argument is an option, we hope one of -r, -m, -i, -d. */
        switch (argv[argIndex][1]) {
            case 'r':
                printingRegisters = TRUE;
                break;
            case 'm':
                printingMemory = TRUE;
                break;
            case 'i':
                interactive = TRUE;
                break;
            case 'd':
                debugging = TRUE;
                break;
            default:
                fprintf (stderr, "Invalid option \"%s\".\n", argv[argIndex]);
                fprintf (stderr, "Correct options are -r, -m, -i, -d.\n");
                return 1;
        }
    }

    if (argIndex == argc) {
        fprintf (stderr, "No file name given.\n");
        return 1;
    } else if (argIndex < argc-1) {
        fprintf (stderr, "Too many arguments.\n");
        return 1;
    }

    filein = fopen (argv[argIndex], "rb");
    if (filein == NULL) {
        fprintf (stderr, "Can't open file: %s\n", argv[argIndex]);
        return 1;
    }

    computer = newComputer (filein, printingRegisters, printingMemory, debugging, interactive);
    simulate (computer);
    return 0;
}
