package suduko;

public class Suduko {

	private int rows = 9;
	private int cols = 9;
	private int[][] suduko;

	/**
	 * Creates a new Suduko
	 * 
	 */
	public Suduko() {

		suduko = new int[rows][cols];
		clear();
	}

	public void setValueOfIndex(int row, int col, int value) {
		suduko[row][col] = value;
	}

	public int getValueOfIndex(int row, int col) {

		return suduko[row][col];
	}

	public boolean solve() {
		
		
		
		return solve(0,0);		
	}

	public boolean solve(int i, int j) {
		
		if(i >= 81 || j >= 81)
			return true;
		
		int currentNbr = getValueOfIndex(i / 9, j % 9);
		
		

		if (currentNbr != 0) {

			setValueOfIndex(i / 9, j % 9, 0);
			
			if (checkNumber(i / 9, j % 9, currentNbr) == 0) {
				setValueOfIndex(i / 9, j % 9, currentNbr);
				return false;				
			}				
			
			setValueOfIndex(i / 9, j % 9, currentNbr);
			
			if (i == 81)
				return true;
			
			if (solve(i + 1, j + 1))
				return true;

			else
				return false;

		}

		for (int k = 1; k <= 9; k++) {

			if (checkNumber(i / 9, j % 9, k) != 0) {

				setValueOfIndex(i / 9, j % 9, k);

				if (solve(i + 1, j + 1))
					return true;

			}
			
			

		}
		
		System.out.println(print());
		setValueOfIndex(i/9, j%9, 0);
		return false;

	}
	
	private int checkNumber(int row, int col, int number) {

		if (checkRow(row, col, number) && checkCol(row, col, number) && checkArea(row, col, number)) {

			return number;
		}

		return 0;

	}

	private boolean checkRow(int row, int col, int tryNumber) {

		for (int i = 0; i < 9; i++) {

			if (suduko[row][i] == tryNumber) {
				return false;
			}
		}

		return true;
	}

	private boolean checkCol(int row, int col, int tryNumber) {
		
		for (int i = 0; i < 9; i++) {

			if (suduko[i][col] == tryNumber) {
				return false;
			}
		}

		return true;
	}
	
	private boolean checkArea(int row, int col, int tryNumber) {

		if (row == 0 || row == 1 || row == 2) {

			if (col == 0 || col == 1 || col == 2) {
				 return checkQuadrant(0, 0, tryNumber);
			}
			else if (col == 3 || col == 4 || col == 5) {
				return checkQuadrant(0, 3, tryNumber);
			}
			else {
				return checkQuadrant(0, 6, tryNumber);
			}
		}

		else if (row == 3 || row == 4 || row == 5) {
			if (col == 0 || col == 1 || col == 2) {
				return checkQuadrant(3, 0, tryNumber);
			}
			else if (col == 3 || col == 4 || col == 5) {
				return checkQuadrant(3, 3, tryNumber);
			} 
			else {
				return checkQuadrant(3, 6, tryNumber);
			}
		}

		else {
			if (col == 0 || col == 1 || col == 2) {
				return checkQuadrant(6, 0, tryNumber);
			}
			if (col == 3 || col == 4 || col == 5) {
				return checkQuadrant(6, 3, tryNumber);
			} else 	{
				return checkQuadrant(6, 6, tryNumber);
			}
		}
	}
	
	private boolean checkQuadrant(int row, int col, int tryNumber) {
		
		for (int i = row; i < row+3; i++) {
			for (int j = col; j < col+3; j++) {
				if(suduko[i][j] == tryNumber) {
					return false;					
				}
			}
		}
		
		return true;

	}

	public void clear() {

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				suduko[i][j] = 0;
			}
		}

	}

	public String print() {

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {

				sb.append(getValueOfIndex(i, j) + "  ");
			}

			sb.append("\n");
		}

		return sb.toString();

	}

}