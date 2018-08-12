package plateforme;
import java.util.ArrayList;
import java.util.Random;

import operatingsystem.OS;
import process.Instruction;
import process.AppFile;
import process.File;

public class Disk {
	private static final int size = 10*1024*1024; // GB convertit en KB
	private static int tailleOccupe;
	private static int tailleDispo = size;
	
	public static ArrayList<File> fileOnDisk = new ArrayList<>();
	
	
	public int getTailleOccupe() {
		return tailleOccupe;
	}
	public void setTailleOccupe(int tailleOccupe) {
		this.tailleOccupe = tailleOccupe;
	}
	public int getTailleDispo() {
		return tailleDispo;
	}
	public void setTailleDispo(int tailleDispo) {
		this.tailleDispo = tailleDispo;
	}
	public int getSize() {
		return size;
	}
	
	public static void write(AppFile file) {
			tailleDispo = tailleDispo - file.getInstructions().size();
	}
	
	public void loadOS() {
		ArrayList<Instruction> instructions = new ArrayList<>();
		Random rand = new Random();
		Instruction instruction;
		
		byte i;
		// Load OperatingSys
		//creation des instructions de l'app
		for (i = 0; i < 15000 ; i++ ) {
			instruction = new Instruction(false,i);
			instructions.add(instruction);
		}
		AppFile OperatingSys = new AppFile(OS.rootFile,"OperatingSys",1000,instructions);
		write(OperatingSys);
		
	}

	public void loadAppOnDisk() {
		ArrayList<Instruction> instructions = new ArrayList<>();
		Random rand = new Random();
		Instruction instruction;
		
		byte i;
		// Load MuzixPlayer
		//creation des instructions de l'app
		for (i = 0; i < 1500 ; i++ ) {
			instruction = new Instruction(rand.nextBoolean(),i);
			instructions.add(instruction);
		}
		AppFile MusicPlayer = new AppFile(OS.userFile,"MusicPlayer",20,instructions);
		write(MusicPlayer);
		fileOnDisk.add(MusicPlayer);
		
		// Load Tetris
		//creation des instructions de l'app
		instructions = new ArrayList<>(); //reinitialisation de lįrraylist des instructions
		for (i = 0; i < 2000 ; i++ ) {
			instruction = new Instruction(rand.nextBoolean(),i);
			instructions.add(instruction);
		}
		AppFile Tetris = new AppFile(OS.userFile,"Tetris",10,instructions);
		write(Tetris);
		fileOnDisk.add(Tetris);
		
		// Load Calculator
		//creation des instructions de l'app
		instructions = new ArrayList<>(); //reinitialisation de lįrraylist des instructions
		for (i = 0; i < 1000 ; i++ ) {
			instruction = new Instruction(rand.nextBoolean(),i);
			instructions.add(instruction);
		}
		AppFile Calculator = new AppFile(OS.userFile,"Calculator",10,instructions);
		write(Calculator);
		fileOnDisk.add(Calculator);
		
		// Load Writer
		//creation des instructions de l'app
		instructions = new ArrayList<>(); //reinitialisation de lįrraylist des instructions
		for (i = 0; i < 3000 ; i++ ) {
			instruction = new Instruction(rand.nextBoolean(),i);
			instructions.add(instruction);
		}
		AppFile Writer = new AppFile(OS.userFile,"Writer",50,instructions);
		write(Writer);
		fileOnDisk.add(Writer);

		// Load FIFA
		//creation des instructions de l'app
		instructions = new ArrayList<>(); //reinitialisation de lįrraylist des instructions
		for (i = 0; i < 7000 ; i++ ) {
			instruction = new Instruction(rand.nextBoolean(),i);
			instructions.add(instruction);
		}
		AppFile FIFA = new AppFile(OS.userFile,"FIFA",100,instructions);
		write(FIFA);
		fileOnDisk.add(FIFA);
		
	}
	
}
