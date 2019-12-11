package suduko;

public class Suduko {
	private boolean CheckSolve= true;
	private int rows = 9;
	private int cols = 9;
	private int[][] suduko ;
	private int rowcol;
	
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
	
		 rowcol = 0;
	     return solve(rowcol,rowcol);
		
	}
	
	private boolean solve(int i, int j) {
		
		if (CheckSolve = false && rowcol == 0) {
			return false;
		}
		
		
		int testVariable = 0;
		if (getValueOfIndex(i,j) > 0) {
			if (CheckSolve = true) {
				rowcol++;
				solve(rowcol/9, rowcol%9);
			}
			else {
				testVariable = getValueOfIndex(i,j);
			}
		}
		
		testVariable ++;
	
		
		int temp = checkNumber(i,j,testVariable);
	
		while (temp == 0) {
			testVariable++;
			temp = checkNumber(i,j,testVariable);
			if (testVariable > 9) {
				rowcol--;
			    CheckSolve = false;
				solve(rowcol/9, rowcol%9);
			   }
			}
	    
        
		suduko[i][j] = temp;
	    
	    rowcol++;
		if (rowcol > 81 ) {
			return true;
		}
		
		else {
			solve(rowcol/9, rowcol%9);
		}
         return CheckSolve;
		
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
	            } else  {
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
