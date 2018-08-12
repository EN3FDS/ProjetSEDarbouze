package operatingsystem;
	
import interruption.SystemCall;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import plateforme.Memory;
import process.File;
import process.ProcessGen;

import plateforme.MMU;
import plateforme.Disk;

public class OS extends Application {
	// fichier root
	public static File rootFile = new File(null, "root", true);
	// fichier user
	public static File userFile = new File(rootFile, "user", true);

	
	public static MMU mmu = new MMU();
	public static Memory RAM = new Memory();
	public static Scheduler scheduler= new Scheduler();
	public static ProcessGen generateur;
	public static Disk disk = new Disk();
	public static Executor execute;
	public static SystemCall systemCall = new SystemCall();
	public static int IDProcess = 1;

	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	private static void startup() {
		disk.loadAppOnDisk();
	}
	
	public static void main(String[] args) {
	//	Main.RAM.AddProcessToList(Main.disk.p1000);
		startup();
		
		generateur = new ProcessGen("Generateur");
		 execute = new Executor("Executeur");
		
		generateur.start();
		execute.start();
		//launch(args);
	}
}
