package suduko;

import javafx.scene.layout.TilePane;

public class SudukoInteractions {

	/**
	 * Method that solves the suduko based on the start values entered by the user.
	 * 
	 * @param alert, Alertbox for indicating success or failure.
	 * @param WIDTH, Specified width of the suduko.
	 * @param HEIGHT, Specified height of the suduko.
	 * @param tp, TilePane which consists of the suduko tiles.
	 * @param suduko, Class with suduko actions.
	 */
	public static void solveButton(AlertBox alert, int WIDTH, int HEIGHT, TilePane tp, Suduko suduko) {

		for (int i = 0; i < (WIDTH * HEIGHT); i++) {

			OneNumberTextField temp = new OneNumberTextField();
			temp = (OneNumberTextField) tp.getChildren().get(i);

			if (!temp.getText().equals("")) {

				int value = Integer.parseInt(temp.getText());
				suduko.setValueOfIndex(i / 9, i % 9, value);
			}
		}

		boolean solved = suduko.solve();

		// If solved notify the user and print results
		if (solved) {

			for (int i = 0; i < (WIDTH * HEIGHT); i++) {

				OneNumberTextField temp = new OneNumberTextField();
				temp = (OneNumberTextField) tp.getChildren().get(i);
				temp.setText(Integer.toString(suduko.getValueOfIndex(i / 9, i % 9)).strip());
				tp.getChildren().set(i, temp);

			}

			AlertBox.display("Solution found!",
					"Atleast one solution for your suduko\nwas found and is now being displayed!");

		} 
		else {

			AlertBox.display("No solutions!", "No solution exists for you suduko.");
		}

		suduko.print();
	}
	/**
	 * Method that clears the suduko and displays the empty tiles.
	 * 
	 * @param WIDTH, Specified width of the suduko.
	 * @param HEIGHT, Specified height of the suduko.
	 * @param tp, TilePane which consists of the suduko tiles.
	 * @param suduko, Class with suduko actions.
	 */
	public static void clearButton(int WIDTH, int HEIGHT, TilePane tp, Suduko suduko) {
		
		for (int i = 0; i < (WIDTH * HEIGHT); i++) {

			OneNumberTextField temp = new OneNumberTextField();
			temp = (OneNumberTextField) tp.getChildren().get(i);
			temp.setText("");
			tp.getChildren().set(i, temp);
		}

		suduko.clear();
	}
}
