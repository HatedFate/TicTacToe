package tictactoe;
import java.util.Scanner;


public class Game {

	public static void main(String[] args) {
		System.out.println("Welcome to Tic-Tac-Toe!");
		
		Board board = new Board();
		Minimax minimax = new Minimax(board);
		Scanner sc = new Scanner(System.in);
		board.display();
		
		while(true) {
			int row, column;
			
			do {
				System.out.print("Enter Row: ");
				row = check(sc, validate(sc));
				System.out.print("Enter Column: ");
				column = check(sc, validate(sc));
				} while(!board.checkInput(row, column));
			
			board.setInput(row, column);
			
			if(board.getActivity()) {
				minimax.random();
				board.checkWin();
				board.checkDraw();
			}
			
			board.display();
			if(!board.getActivity()) break;
		}
		
		if(!board.getStatus()) {
			if(board.winner()) System.out.print("You've Won!");
			else System.out.print("You've Lost!");
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
