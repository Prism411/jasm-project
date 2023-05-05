package entities;

public class Operation {
	private final OperationType type;
	private final int adress;
	
	public Operation(OperationType type, int adress) {
		this.type = type;
		this.adress = adress;
	}

	
	public OperationType getType() {
		return type;
	}
	public int getAdress() {
		return adress;
	}
	
	
	
	
	
}
