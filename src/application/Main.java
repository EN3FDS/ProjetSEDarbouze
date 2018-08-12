package application;
	
import OS.Scheduler;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import plateforme.Memory;
import process.ProcessGen;
import plateforme.MMU;
import plateforme.Disk;

public class Main extends Application {
	
	public static MMU mmu = new MMU();
	public static Memory RAM = new Memory();
	public static Scheduler scheduler= new Scheduler();
	public static ProcessGen generateur;
	public static Disk disk = new Disk();
	public static Executor execute;

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
	
	public static void main(String[] args) {
	//	Main.RAM.AddProcessToList(Main.disk.p1000);
		
		generateur = new ProcessGen("Generateur");
		 execute = new Executor("Executeur");
		
		generateur.start();
		//execute.start();
		//launch(args);
	}
}
