package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import plateforme.memory;
import plateforme.MMU;
import plateforme.Disk;
import Process.ProcessGen;
import Process.Scheduler;
import plateforme.CPU;

public class Main extends Application {
	
	public static MMU mmu = new MMU();
	public static memory RAM = new memory();
	public static Scheduler scheduler= new Scheduler();
	public static ProcessGen generateur;
	public static Disk disk = new Disk();
	public static PC execute;

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
		 execute = new PC("Executeur");
		
		generateur.start();
		execute.start();
		launch(args);
	}
}
