package tictactoe;
import java.util.Scanner;


public class Game {

	public static void main(String[] args) {
		System.out.println("Welcome to Tic-Tac-Toe!");
		
		Minimax minimax;
		Board board = new Board();
		Scanner sc = new Scanner(System.in);
		board.display();
		
		boolean xWin = false;
		boolean oWin = false;
		boolean draw = false;
		boolean endGame = false;
		while(true) {
			int row, column;
			
			do {
				System.out.print("Enter Row: ");
				row = check(sc, validate(sc));
				System.out.print("Enter Column: ");
				column = check(sc, validate(sc));
				} while(!board.checkInput(row, column));
			
			board.setInput(row, column, new String("X"));
			
			oWin = board.checkWin(new String("O"));
			xWin = board.checkWin(new String("X"));
			draw = !xWin && !oWin ? board.checkDraw() : false; 
			endGame = oWin || xWin || draw ? true : false;
			if(!endGame) {
				minimax = new Minimax(board);
				int[] coordinates = minimax.ai();
				board.setInput(coordinates[0], coordinates[1], new String("O"));
			} else { board.display(); break; }
			
			board.display();
		}
		
		if(!draw) {
			if(xWin) System.out.print("You've Won!");
			else if(oWin) System.out.print("You've Lost!");
		} else {
			System.out.println("Draw!");
		}
		
		sc.close();
	}

	public static int check(Scanner sc, int num) {
		while(num > 2 || num < 0) {
			System.out.print("Enter a number in range: ");
			num = validate(sc);
		}
		return num;
	}
	
	public static int validate(Scanner sc) {
		int num;
		while(!sc.hasNextInt()) {
			System.out.print("Enter a valid number: ");
			sc.next();
		}
		num = sc.nextInt();
		return num;
	}
}

