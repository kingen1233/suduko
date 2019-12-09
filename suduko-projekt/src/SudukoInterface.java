import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

public class SudukoInterface extends Application {
	
	static final String VERSION = "1.0.0";
	final int HEIGHT = 9;
	final int WIDTH = 9;
	static Paint value0 = Paint.valueOf("FF9900");
	
	
	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage s) throws Exception {

		s.setTitle("Suduko Solver " + VERSION);

		TilePane tp = new TilePane();
		HBox bottomRow = new HBox();

		tp.setPrefColumns(HEIGHT);
		tp.setPrefRows(WIDTH);
		
		//Skapar textfields, sätter deras pref längd till 1, ger dem rätt färg med ifsatsen och lägger in i tilepane
		for (int i = 1; i <= (WIDTH * HEIGHT); i++) {
			TextField textField = new TextField();
			textField.setPrefColumnCount(1);

			if (i <= 27 || i > 54) {

				if (i % 9 <= 3 || i % 9 > 6)
					textField.setStyle("-fx-control-inner-background: #" + value0.toString().substring(2));
			} 
			else {
				if (i % 9 > 3 && i % 9 < 7)
					textField.setStyle("-fx-control-inner-background: #" + value0.toString().substring(2));
			}
			tp.getChildren().add(textField);
		}

		Scene scene1 = new Scene(new TilePane(tp), 500, 500);
		s.setScene(scene1);
		s.show();
	}

}
