package application;
	
import java.io.IOException;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	
	private static Scene scene;
	
	@Override
	public void start(Stage primaryStage) throws IOException {
		
		scene= new Scene(loadFXML("Giris"));
		primaryStage.setScene(scene);
		primaryStage.setTitle("MAAŞ TAKİP SİSTEMİ");
		primaryStage.show();
		
	}
	
	// parametre olarak gönderilen fxml dosyasını yükleyen metod
	public static Parent loadFXML(String FXML) throws IOException {
		
		FXMLLoader fxmlLoader= new FXMLLoader(Main.class.getResource("/views/"+FXML+".fxml"));
		Parent parent=fxmlLoader.load();
		
		return parent;
	
	}
	
	@Override
	public void stop() throws IOException {
		
	}
	
	
	
	public static void main(String[] args) {
		launch(args);
		//girisController girisCont=new girisController();
		//girisCont.hesapEkle("admin", "admin");
	}
}
