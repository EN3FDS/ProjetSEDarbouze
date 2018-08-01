package Process;

import java.util.ArrayList;

public class Process {
	private int id;
	private String nom;
	private int size;
	private int priority=1;
	private ArrayList<Instruction> instructions= new ArrayList<>();
	//Constructor
	public Process(int i, String s) {
		this.id=i;
		this.nom=s;
		this.size = 72;
	}
	public ArrayList<Instruction> getInstructions() {
		return instructions;
	}
	public void setInstructions(ArrayList<Instruction> instructions) {
		this.instructions = instructions;
	}
	//GEtters
	public int getId() {
		return id;
	}
	public String getNom() {
		return nom;
	}
	public int getSize() {
		return size;
	}
	public int getPriority() {
		return priority;
	}

	
	public String toString() {
		return "ProcessID: "+id+" ProcessName: "+nom+" ProcessSize: "+size;
	}

}
