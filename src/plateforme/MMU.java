package plateforme;


//import Process.Scheduler;
import application.Main;
import process.PCB;
import process.Process;

public class MMU {
	
	
//	private final int nombrePage = memory.getNbreDePages();// nombre de pages existantes
	//private  Pages[] tableDePage;//tableau de pages
	
	/**
	 * Methode d'allocations et de desallocation de memoire
	 **/
	 public synchronized void allocateMemoryToProcess(Process process) {
		 //
		 //System.out.println("\tAncienne valeur de la memoire:"+Main.RAM.getTailleDispo());
		 int taille=  process.getSize();
		 Main.RAM.setTailleDispo(Main.RAM.getTailleDispo()-taille);
		 Main.RAM.AddProcessToList(process);
		 PCB PCB = new PCB(process,2);
		 Main.scheduler.addPCBToReadyQueue(PCB); 
		 Main.scheduler.addPCBToProcessQueue(PCB);		 
		 //System.out.println("Nouvelle valeur de la memoire:"+Main.RAM.getTailleDispo());

	 }
	 
	 
	

}
