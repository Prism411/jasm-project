package application;

import entities.Memory;
import entities.Operation;
import entities.OperationType;

public class Main {
	public static void main(String[] args) {
	    Memory mem = new Memory(100);
	    Operation op;
	    // Armazenando os valores 5 e 5 na memória, respectivamente
	    mem.writeToMemory(0, 5);
	    mem.writeToMemory(1, 10);
	    mem.writeToMemory(2,50);
	    op = new Operation(OperationType.LDA,0);
	    mem.executeNextInstruction(op);
	    op = new Operation(OperationType.ADD, 1);
	    mem.executeNextInstruction(op);
	    op = new Operation(OperationType.ADD,2);
	    mem.executeNextInstruction(op);
	    op = new Operation(OperationType.STA,3);
	    mem.executeNextInstruction(op);
	    
	    
	  //  System.out.println("Acumlador3 = "+ mem.getAcumulador());

	    // Mostrando o resultado da soma
	    System.out.println(mem.readFromMemory(3)); 
	}
}












/*   op = new Operation(OperationType.ADD,1);
mem.executeNextInstruction(op);
op = new Operation(OperationType.STA, 2);
mem.executeNextInstruction(op); */