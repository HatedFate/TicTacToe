package tictactoe;

import java.util.ArrayList;
import java.lang.Math;

public class Minimax {
	private Board board;
	
	public void minMax() {
		for(int i=0; i<board.getSize(); ++i) {
			for(int j=0; j<board.getSize(); ++j) {
				
			}
		}
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
		this.board = board;
	}
}
