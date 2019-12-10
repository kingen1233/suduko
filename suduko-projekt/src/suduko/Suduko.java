package suduko;

public class Suduko {
	
	private int rows = 9;
	private int cols = 9;
	private int[][] suduko ;
	
	/**Creates a new Suduko 
	 *  
	 */
	public Suduko() {
		
		suduko = new int[rows][cols];
	}
	

	public void setValueOfIndex(int row, int col, int value) {
		suduko[row][col] = value;
	}
	
	public int getValueOfIndex(int row, int col) {
		
		
		
		return  suduko[row][col];
	}
	
	public boolean solve() {
		
		
		
	     return solve(0,0);
		
	}
	
	private boolean solve(int i, int j) {
		
		
		return false;
		
	}
   public void clear() {
	  
	      for (int i = 0; i < rows; i++) {
	    	  for (int j = 0; j < cols ; j++) {
	    		  suduko[i][j] = 0;
	    	  }
	      }
	 
   }
   
	public String print() {
		
		
		StringBuilder sb = new StringBuilder();
		
		   for (int i = 0; i < rows; i++) {
		    	  for (int j = 0; j < cols ; j++) {

		    		  sb.append(getValueOfIndex(i, j) + "  ");
		    	  }
		    	  
		    	  sb.append("\n");
		      }
		 

		return sb.toString();

	}
   
   

}
