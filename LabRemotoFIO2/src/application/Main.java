package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;
//IMPORTANTE!!!!!!
//para compilación
//se debe cargar en Run Configuración-->Java->Aplication->Main-VW Arguments
//--module-path "/home/rome/eclipse-workspace/librerias externas/openjfx-15.0.1_linux-x64_bin-sdk/javafx-sdk-15.0.1/lib" --add-modules javafx.controls,javafx.fxml


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("Sample.fxml"));
			Scene scene = new Scene(root,960,540);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
