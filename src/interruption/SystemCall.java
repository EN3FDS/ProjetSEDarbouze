package interruption;

import operatingsystem.OS;
import plateforme.Disk;
import process.AppFile;
import process.Process;
import process.PCB;

public class SystemCall {
	private final int SIZE = 32; //size chaque entree dans la table 64 bits
	private String name;
	private short address; //adresse de la routine
/*
	public SystemCall() {
		// TODO Auto-generated constructor stub
	}
	
	public SystemCall(String name, short address) {
		this.name=name;
		this.address=address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public short getAddress() {
		return address;
	}

	public void setAddress(short address) {
		this.address = address;
	}

	public int getSIZE() {
		return SIZE;
	}
*/
	public void makeSystemCall(int numApp, int i) {
		switch (i){
		case 0: 
			//Kill Process with that name
			
			
			break;
		case 1: 
			try {
				//generate process from application on disk
				AppFile appFile = (AppFile) Disk.fileOnDisk.get(numApp);
				Process p = new Process(OS.IDProcess,appFile.getName(),appFile.getInstructions());
				
				//Allouer la memoire au processus
				OS.mmu.allocateMemoryToProcess(p);
				
				//augmenter de 1 la variable qui crée les identifiants pour les processus
				OS.IDProcess++; 
				
				//creer le PCB
				PCB pcb = new PCB(p,appFile.getPriority());
				
				//Ajouter le PCB aux différentes files du scheduler
				OS.scheduler.addPCBToProcessQueue(pcb);
				OS.scheduler.addPCBToReadyQueue(pcb);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("Process Non Créé");
				e.printStackTrace();
			}		

			break;
		default:
			//do nothing
		}
	}
}
