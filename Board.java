package tictactoe;

public class Board {
	private String board[][] = new String[3][3];
	
	public void display() {
		for(int i=0; i<board.length; ++i) {
			for(int j=0; j<board.length; ++j) System.out.print(" " + board[i][j] + " | ");
			
			System.out.println();
			for(int k=0; k<board.length * 5; ++k) System.out.print("-");
			System.out.println();
		}
	}
	
	public boolean checkWin(String player) {
		for(int i=0; i<board.length; ++i) {
			int rCnt = 0;
			int cCnt = 0;
			for(int j=0; j<board.length; ++j) {
				rCnt += board[i][j].equals(player) ? 1 : 0;
				cCnt += board[j][i].equals(player) ? 1 : 0;
			}
			if(rCnt == 3 || cCnt == 3) return true;
		}
		
		int uCnt = 0;
		int dCnt = 0;
		for(int i=0; i<board.length; ++i) {
			uCnt += board[i][i].equals(player) ? 1 : 0;
			dCnt += board[i][board.length - i - 1].equals(player) ? 1 : 0;
		}

		return uCnt == 3 || dCnt == 3 ? true : false;
	}
	
	public boolean checkDraw() {
		for(String[] i:board) for(String j:i) {
			if(j.equals(" ")) return false;
		}
		return true;
	}
	
	public boolean checkInput(int r, int c) {
		if(board[r][c].equals(" ")) return true;
		else {
			System.out.println("Occupied!\n");
			return false;
		}
	}

	public void setInput(int r, int c, String player) {
		board[r][c] = new String(player);
	}
	
	public void getInput(String i, int[] location){
		board[location[0]][location[1]] = new String(i); 
	}
	
	public int size() {
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
