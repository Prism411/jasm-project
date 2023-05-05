package entities;

public class Memory {
	
	private int ram[];
	private int acumulador;
	private int counter;
	
	public Memory(int tamanhoRam) {
		this.ram = new int[tamanhoRam];
		this.acumulador = 0;
		this.counter = 0;
	}

	public int[] getRam() {
		return ram;
	}

	public void setRam(int[] ram) {
		this.ram = ram;
	}

	public int getAcumulador() {
		return acumulador;
	}

	public void setAcumulador(int acumulador) {
		this.acumulador = acumulador;
	}

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

	
	public int executeNextInstruction(Operation op){

	    int result = 0;

	    switch (op.getType()) {
	        case NOP:
	            // não faz nada, apenas atualiza o contador
	            counter++;
	            break;

	        case ADD:
	        	System.out.println("addAdress = "+ op.getAdress());
	            result = add(op.getAdress());
	            counter++;
	            break;

	        case STA:
	            writeToMemory(op.getAdress(), acumulador);
	            counter++;
	            break;

	        case LDA:
	            acumulador = readFromMemory(op.getAdress());
	            counter++;
	            break;

	        case HLT:
	            // interrompe a execução
	            break;
	    }

	    return result;
	}
	
	public int add(int address) {
	    int value = readFromMemory(address); // lê o valor do endereço de memória
	    acumulador += value; // soma o valor ao acumulador
	    counter++; // incrementa o contador de programa
	   System.out.println("Acumulador = " +acumulador);
	    System.out.println("Adress = " + address);
	    System.out.println("Valor = "+ value);
	    return acumulador;
	}
	
	public int readFromMemory(int adress) {
		System.out.println("MAdress = " + adress);
		return this.ram[adress];
	}
	public void writeToMemory(int adress, int value) {
		this.ram[adress] = value;
	}
	
	

}
