package tictactoe;
import java.util.ArrayList;
import java.lang.Math;

public class Minimax {
	private Board board;
	private int depth = 2;
	
	public int[] ai() {
		int bestScore = Integer.MIN_VALUE;
		int[] bestCoordinates = new int[2];
		for(int i=0; i<board.size(); ++i) {
			for(int j=0; j<board.size(); ++j) {
				if(this.board.getBoard()[i][j].equals(" ")) {
					board.getBoard()[i][j] = new String("O");
					int score = minMax(false);
					board.getBoard()[i][j] = new String(" ");
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
	
	public int minMax(boolean minimize) {
		boolean xWin = board.checkWin(new String("X"));
		boolean oWin = board.checkWin(new String("O"));
		boolean draw = board.checkDraw();
		if(xWin) return 1;
		else if(oWin) return -1;
		else if(draw) return 0;
		if(minimize) {
			int bestScore = Integer.MAX_VALUE;
			for(int i=0; i<board.size(); ++i) for(int j=0; j<board.size(); ++j) {
				if(board.getBoard()[i][j].equals(" ")) {
					board.getBoard()[i][j] = new String("O");
					int score = minMax(true);
					board.getBoard()[i][j] = new String(" ");
					bestScore = Math.min(score, bestScore);
				}
			}
			return bestScore;
		} else {
			int bestScore = Integer.MIN_VALUE;
			for(int i=0; i<board.size(); ++i) for(int j=0; j<board.size(); ++j) {
				if(board.getBoard()[i][j].equals(" ")) {
					board.getBoard()[i][j] = new String("X");
					int score = minMax(false);
					board.getBoard()[i][j] = new String(" ");
					bestScore = Math.max(score, bestScore);
				}
			}
			return bestScore;
		}
	}
	
	Minimax(Board board){
		this.board = board;
	}
}
