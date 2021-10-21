package gameXO;

import java.io.IOException;

public class GameXO extends Display{
	
	public static void main(String[] args) throws IOException {
		
		System.out.println("Welcome to the TicTacToe game!\n" + "Enter the number you would like to mark in the corresponding grid\n");
		System.out.println(" 1 | 2 | 3\n" + "---|---|---\n" +" 4 | 5 | 6\n" + "---|---|---\n" + " 7 | 8 | 9\n");
		
		Display firstGame = new Display();
		firstGame.enterChoice();
		

	}
}
