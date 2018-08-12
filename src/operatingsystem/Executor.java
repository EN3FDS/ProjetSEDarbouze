package operatingsystem;

import java.util.ArrayList;
import process.PCB;
import process.Process;
import operatingsystem.OS;

public class Executor extends Thread {
private static ArrayList<Process> ListOfProcess = new ArrayList<>();
	
	public Executor(String string) {//executer un processus
		// TODO Auto-generated constructor stub
		super(string);
	}
	public void run() {
		while(true) {
			try {
				Thread.sleep(1000);
				//on retire le pcb de la liste readyqueue
				PCB pcb = OS.scheduler.removePCBFromReadyQueue(); 
				System.out.println("ID du processus: "+ pcb.getPid());
				OS.RAM.currentPCB = pcb;
				
				int i;
				ListOfProcess=OS.RAM.getListOfProcess(); //on prend la liste des processus deja sur la memoire
				for(i=0;i<ListOfProcess.size();i++) {
					if (pcb.getPid()==ListOfProcess.get(i).getId()) { //prend le processus correspondant au PCB choisi
						aff(ListOfProcess.get(i).toString());	//simulation d'execution a cet espace on fait appel au cpu
						break;
					}
						
				}
				System.out.println(this.getName());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("exception generated");
				e.printStackTrace();
				
			}
			
		}
	}
	private static void aff(String s) {
		System.out.println(s);
	}

}
