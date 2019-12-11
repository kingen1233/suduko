package suduko;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

public class SudukoInterface extends Application {

	final int HEIGHT = 9;
	final int WIDTH = 9;
	static Paint value0 = Paint.valueOf("FF9900");

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage s) throws Exception {

		s.setTitle("Suduko Solver");

		Suduko suduko = new Suduko();
		AlertBox alert = new AlertBox();

		TilePane tp = new TilePane();
		tp.setPrefColumns(HEIGHT);
		tp.setPrefRows(WIDTH);

		TilePane tilePane = new TilePane(tp);

		HBox hbox = new HBox();
		hbox.setAlignment(Pos.BOTTOM_CENTER);
		hbox.setSpacing(40);

		BorderPane root = new BorderPane();
		root.setMargin(tilePane, new Insets(12, 12, 12, 12));
		root.setCenter(tilePane);
		root.setMargin(hbox, new Insets(12, 12, 12, 12));
		root.setBottom(hbox);

		Button buttonSolve = new Button("Solve");
		Button buttonClear = new Button("Clear");
		Label textLabel = new Label("");
		hbox.getChildren().addAll(buttonSolve, textLabel, buttonClear);

		
		// Skapar textfields, sätter deras pref längd till 1, ger dem rätt färg med
		// ifsatsen och lägger in i tilepane
		for (int i = 1; i <= (WIDTH * HEIGHT); i++) {
			OneNumberTextField textField = new OneNumberTextField();
			textField.setPrefColumnCount(1);

			if (i <= 27 || i > 54) {

				if (i % 9 <= 3 || i % 9 > 6)
					textField.setStyle("-fx-control-inner-background: #" + value0.toString().substring(2));
			} 
			else{
				if (i % 9 > 3 && i % 9 < 7)
					textField.setStyle("-fx-control-inner-background: #" + value0.toString().substring(2));
			}
			tp.getChildren().add(textField);
		}
		
		

		buttonClear.setOnAction(e -> SudukoInteractions.clearButton(WIDTH, HEIGHT, tp, suduko));

		buttonSolve.setOnAction(e -> SudukoInteractions.solveButton(alert, WIDTH, HEIGHT, tp, suduko));
			
		Scene scene1 = new Scene(root, 260, 300);
		s.setResizable(false);
		s.setScene(scene1);
		s.show();
	}

}