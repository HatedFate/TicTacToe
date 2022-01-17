package tictactoe;
import java.util.Scanner;


public class Game {

	private static boolean xWin = false;
	private static boolean oWin = false;
	private static boolean draw = false;
	private static boolean endGame = false;
	private static Minimax minimax;
	private static Board board = new Board();
	
	
	public static void main(String[] args) {
		System.out.println("Welcome to Tic-Tac-Toe!");

		Scanner sc = new Scanner(System.in);
		board.display();
		
		while(true) {
			int row, column;
			endGame();
			if(endGame) break;
			
			do {
				System.out.print("Enter Row: ");
				row = check(sc, validate(sc)) - 1;
				System.out.print("Enter Column: ");
				column = check(sc, validate(sc)) - 1;
				} while(!board.checkInput(row, column));
			
			board.setInput(row, column, new String("X"));
			
			endGame();
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

	public static void endGame() {
		oWin = board.checkWin(new String("O"));
		xWin = board.checkWin(new String("X"));
		draw = !xWin && !oWin ? board.checkDraw() : false; 
		endGame = oWin || xWin || draw ? true : false;
	}
	
	public static int check(Scanner sc, int num) {
		while(num > 3 || num < 1) {
			System.out.print("Enter a number in range (1 - 3): ");
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

