package tictactoe;
import java.util.ArrayList;
import java.lang.Math;

public class Minimax {
	private Board board = new Board();
	private int depth = 2;
	
	public int[] ai() {
		int bestScore = Integer.MAX_VALUE;
		int[] bestCoordinates = new int[2];
		for(int i=0; i<board.getSize(); ++i) {
			for(int j=0; j<board.getSize(); ++j) {
				if(this.board.getBoard()[i][j].equals(" ")) {
					int score = minMax();
					if(score > bestScore) {
						bestScore = score;
						bestCoordinates[0] = i;
						bestCoordinates[1] = j;
					}
				}
			}
		}
		return bestCoordinates;
	}
	
	public int minMax() {
		boolean checkWin = board.winner();
		int bestScore = Integer.MAX_VALUE;
		return 1; // TODO Min Max Players
	}
	
	
	// Random 
	public void random() {
		ArrayList<Integer[]> coordinates = new ArrayList<Integer[]>();
		for(int i=0; i<board.getSize(); ++i) for(int j=0; j<board.getSize(); ++j) {
			if(board.getBoard()[i][j].equals(" ")) {
				Integer[] coord = {i, j};
				coordinates.add(coord);
			}
		}
	    if(coordinates.size()!=0) {	
			Integer[] randomPick = coordinates.get((int)(Math.random() * coordinates.size()));
	    	board.getBoard()[randomPick[0]][randomPick[1]] = new String("O");
	    }
    }
	
	Minimax(Board board){
		for(int i=0; i<board.getSize(); ++i) for(int j=0; j<board.getSize(); ++j) {
			this.board.getBoard()[i][j] = new String(board.getBoard()[i][j]);
		}
	}
	
	Minimax(Board board, int depth){
		this.depth = depth;
		for(int i=0; i<board.getSize(); ++i) for(int j=0; j<board.getSize(); ++j) {
			this.board.getBoard()[i][j] = new String(board.getBoard()[i][j]);
		}
	}
}
