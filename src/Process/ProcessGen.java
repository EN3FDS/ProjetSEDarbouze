package process;

//import java.util.ArrayList;
import java.util.Random;

import application.Main;
import process.Process;

public class ProcessGen extends Thread {
	
//	private static ArrayList<Process> ListOfProcess = new ArrayList<>();
	private Random rand= new Random();
	int num;
	//constructor
	public ProcessGen(String s) {
		super(s);
	}
	
	public int Genarate() {
		return  rand.nextInt(5);
	}
	
	public void witch_process(int a) {
		switch (a) {
		case 0:
			//Verification(0,Main.disk.p0);
			CreateAndAddPCB(Main.disk.p0);
			//aff(p0.toString());
			break;
		case 1:
			//Verification(1,Main.disk.p1);
			CreateAndAddPCB(Main.disk.p1);
			//aff(p1.toString()); 
			break;
		case 2:
			//Verification(2,Main.disk.p2);
			CreateAndAddPCB(Main.disk.p2);
			//aff(p2.toString());
			break;
		case 3:
			//Verification(3,Main.disk.p3);
			CreateAndAddPCB(Main.disk.p3);
			//aff(p3.toString());
			break;
		case 4:
			//Verification(4,Main.disk.p4);
			CreateAndAddPCB(Main.disk.p4);
			//aff(p4.toString());
		}
		
	}
	
	public static void aff(String s) {
		System.out.println(s);
	}
	
	public void run() {
		for (int i=1;i<6;i++) {
			try {
				Thread.sleep(1000);
				int k= Genarate();
				System.out.println(this.getName());
				witch_process(k);
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	
	//Adding the PCB to the memory
	private static  void CreateAndAddPCB(Process p) {
		PCB pcb = new PCB (p, p.getPriority()); 		
		Main.mmu.allocateMemoryToProcess(p);
		Main.scheduler.addPCBToProcessQueue(pcb);
		Main.scheduler.addPCBToReadyQueue(pcb);		
		
	}
}
	
/*	private static void Verification(int id,Process p) {		
		int i=0;
		ListOfProcess = Main.RAM.getListOfProcess();
		System.out.println("Probleme:"+p.toString());
		do {
			for( i=0;i<ListOfProcess.size();i++) {
				
				if( id == ListOfProcess.get(i).getId()) {
					
					break;
				}
			}
			if( id == ListOfProcess.get(i).getId()) {
				break;
			}
			else {
				CreateAndAddPCB(p);
				break;
			}
			
		}
		while(true);
	}
	
*/



