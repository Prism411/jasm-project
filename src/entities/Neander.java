package entities;

public class Neander {
    private int accumulator;
    private int instructionPointer;
    private boolean carryFlag;
    private boolean zeroFlag;
    private int[] memory;

    public Neander() {
        accumulator = 0;
        instructionPointer = 0;
        carryFlag = false;
        zeroFlag = false;
        memory = new int[256];
    }

    public void load(int[] program) {
        for (int i = 0; i < program.length; i++) {
            getMemory()[i] = program[i];
        }
    }

    public void execute() {
    	    while (instructionPointer < getMemory().length) {
    	        int instruction = getMemory()[instructionPointer];

    	        switch (instruction) {
    	            case 0: // NOP
    	            	System.out.println("Entrando no NOP");
    	                break;

    	            case 1: // STA
    	                getMemory()[getMemory()[instructionPointer + 1]] = accumulator;
    	                instructionPointer += 2;
    	                System.out.println("Entrando no STA");
    	                break;

    	            case 2: // LDA
    	                accumulator = getMemory()[getMemory()[instructionPointer + 1]];
    	                instructionPointer += 2;
    	                System.out.println("Entrando no LDA");
    	                break;

    	            case 3: // ADD
    	                int value = getMemory()[getMemory()[instructionPointer + 1]];
    	                int result = accumulator + value;
    	                carryFlag = (result > 255);
    	                accumulator = result & 0xFF;
    	                zeroFlag = (accumulator == 0);
    	                instructionPointer += 2;
    	                System.out.println("Entrando no ADD");
    	                break;

    	            case 4: // OR
    	                accumulator |= getMemory()[getMemory()[instructionPointer + 1]];
    	                zeroFlag = (accumulator == 0);
    	                instructionPointer += 2;
    	                break;

    	            case 5: // AND
    	                accumulator &= getMemory()[getMemory()[instructionPointer + 1]];
    	                zeroFlag = (accumulator == 0);
    	                instructionPointer += 2;
    	                break;

    	            case 6: // NOT
    	                accumulator = ~accumulator & 0xFF;
    	                zeroFlag = (accumulator == 0);
    	                instructionPointer++;
    	                break;

    	            case 7: // JMP
    	                instructionPointer = getMemory()[instructionPointer + 1];
    	                System.out.println("Entrando no JUMP");
    	                break;

    	            case 8: // JN
    	                if (carryFlag) {
    	                    instructionPointer = getMemory()[instructionPointer + 1];
    	                } else {
    	                    instructionPointer += 2;
    	                }
    	                System.out.println("Entrando no Carry");
    	                break;

    	            case 9: // JZ
    	                if (zeroFlag) {
    	                    instructionPointer = getMemory()[instructionPointer + 1];
    	                } else {
    	                    instructionPointer += 2;
    	                }
    	                break;

    	            case 10: // HALT
    	            	System.out.println("HAAALTT");
    	            	 System.out.println("Memória na posição 0: " + getMemory()[0]);
    	                return;

    	            default:
    	                System.err.println("Invalid instruction: " + instruction);
    	                System.exit(1);
    	        }
    	    }
    	}


	public int getAccumulator() {
		return this.accumulator;
	}

	public int[] getMemory() {
		return memory;
	}
}
