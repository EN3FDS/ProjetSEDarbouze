package plateforme;

import java.util.ArrayList;

import Process.Process;

public class Disk {
	
	public static ArrayList<Process> ListOfProcess = new ArrayList<>();
	public Process p0= new Process(0,"Muzixmatch");
	public Process p1= new Process(1,"Tetrix");
	public Process p2= new Process(2,"FIFA");
	public Process p3= new Process(3,"Calculator");
	public Process p4= new Process(4,"OFfice Writer");
	public Process p1000= new Process(1000,"Residuel");
	
	public void AddProcessToList(Process p){
		ListOfProcess.add(p);
	}

}
