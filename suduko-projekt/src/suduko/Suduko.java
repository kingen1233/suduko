package suduko;

public class Suduko {

	private int rows = 9;
	private int cols = 9;
	private int[][] suduko;

	/**
	 * Creates a new Suduko with the specified size
	 * 
	 */
	public Suduko() {

		suduko = new int[rows][cols];
		clear();
	}

	/**
	 * Inserts the value at specified index.
	 * 
	 * @param row, specified row
	 * @param col, specified col
	 * @param value, value to be insterted
	 */
	public void setValueOfIndex(int row, int col, int value) {
		suduko[row][col] = value;
	}

	/**
	 * Returns the value from the suduko at specified index.
	 * 
	 * @param row, specified row
	 * @param col, specified col
	 * @return Integer value of the specified index 
	 */
	public int getValueOfIndex(int row, int col) {

		return suduko[row][col];
	}

	/**
	 * Solves the suduko
	 * @return True if suduko was solved, False if suduko wasn't solved
	 */
	public boolean solve() {
	
		return solve(0,0);		
	}

	private boolean solve(int i, int j) {
		
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
		
		print();
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

		col = col / 3;
        col = col * 3; 
        row = row / 3;
        row = row * 3;

        return checkQuadrant(row,col,tryNumber);
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

	/**
	 * Fills the suduko matrix with zeroes, thus clearing it.
	 */
	public void clear() {

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				suduko[i][j] = 0;
			}
		}

	}

	/**
	 * Prints out the suduko in the console window.
	 */
	public void print() {

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {

				sb.append(getValueOfIndex(i, j) + "  ");
			}

			sb.append("\n");
		}

		System.out.println(sb.toString());
	}
}