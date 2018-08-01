package Process;

public class Instruction {
	private boolean interrupted; //dit si l'instruction genere une interruption ou pas
	private byte address; //Adresse logique de l'instruction en question
	private short typeOfInterruption;
	//Constructor
	public Instruction(boolean interrupted, byte address) {
		super();
		this.interrupted = interrupted;
		this.address = address;
	}
	
	/*
	 * Getters 
	 */
	public boolean isInterrupted() {
		return interrupted;
	}
	public byte getAddress() {
		return address;
	}
	
	public String toString() {
		return "(Interrupted: " + interrupted + ", Address: " + address + ")";
	}

}
