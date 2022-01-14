package tictactoe;

public class Board {
	private String board[][] = new String[3][3];
	private boolean draw = false;
	private boolean xWin = false;
	private boolean oWin = false;
	private boolean activity = true;
	
	public void display() {
		for(int i=0; i<board.length; ++i) {
			for(int j=0; j<board.length; ++j) System.out.print(" " + board[i][j] + " | ");
			
			System.out.println();
			for(int k=0; k<board.length * 5; ++k) System.out.print("-");
			System.out.println();
		}
	}
	
	public void checkWin() {
		int rCnt;
		int cCnt;

		// Row + Column Checker
		for(int i=0; i<board.length; ++i) {
	
			// Setting counters
			rCnt = 0;
			cCnt = 0;
	
			for(int j=0; j<board.length; ++j) {
				rCnt += board[i][j].equals("X") ? 1 : board[i][j].equals("O") ? -1 : 0;
				cCnt += board[j][i].equals("X") ? 1 : board[j][i].equals("O") ? -1 : 0;
			}
			
			// Check win conditions
			if(rCnt == 3 || cCnt == 3) { this.xWin = true; this.activity = false; return; }
			else if(rCnt == -3 || cCnt == -3) { this.oWin = true; this.activity = false; return; }
		}
		
		int uCnt = 0;
		int dCnt = 0;
		
		// Diagonal Checker
		int range = board.length - 1;
		for(int i=0; i<board.length; ++i) {
			uCnt += board[i][i].equals("X") ? 1 : board[i][i].equals("O") ? -1 : 0;
			dCnt += board[range - i][range - i].equals("X") ? 1 : board[range - i][range - i].equals("O") ? -1 : 0;
		}
		
		if(uCnt == 3 || dCnt == 3) { this.xWin = true; this.activity = false; return; }
		else if(uCnt == -3 || dCnt == -3) { this.oWin = true; this.activity = false; return; }
	}
	
	public void checkDraw() {
		if(xWin || oWin) return;
		for(String[] i:board) for(String j:i) {
			if(j.equals(" ")) return;
		}
		this.activity = false;
		this.draw = true;
	}
	
	public boolean checkInput(int r, int c) {
		if(board[r][c].equals(" ")) return true;
		else {
			System.out.println("Occupied!\n");
			return false;
		}
	}

	public void setInput(int r, int c) {
		board[r][c] = new String("X");
		checkWin();
		checkDraw();
	}
	
	public void getInput(String i, int[] location){
		board[location[0]][location[1]] = new String(i); 
	}
	
	public boolean winner() {
		return xWin ? true : false;
	}

	public void endGame() {
		activity = xWin || oWin? false : true;
	}
	
	public boolean getActivity() {
		return this.activity;
	}
	
	public boolean getStatus() {
		if(xWin || oWin) return false;
		return this.draw;
	}
	
	public int getSize() {
		return board.length;
	}
	
	public String[][] getBoard(){
		return board;
	}
	
	Board(){
		for(String i[]:board) for(int j=0; j<i.length; ++j) {
			i[j] = " ";
		}
	}
}
