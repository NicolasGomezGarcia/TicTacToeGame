package gameXO;

import java.util.Scanner;
import java.util.Arrays;
import java.io.IOException;

public class Display extends Player {
	Scanner playerInput = new Scanner(System.in); 
	char[] grid;
	int turn = 1;
	
	public void enterChoice() throws IOException {
	int x = 1;
	
	do {
		try {
			if (turn == 1) {
				System.out.print("Player 1, please enter your choice: ");
				setChoice(playerInput.nextInt()-1);
				
				if (used(getChoice()) == true) {
					System.out.println("Slot has been used. Please try again");
					continue;
				}
				setGrid(getChoice(), 'x');
				showGrid();
				turn = 2;
			} else {
				System.out.print("Player 2, please enter your choice: ");
				setChoice(playerInput.nextInt()-1);
				
				if (used(getChoice()) == true) {
					System.out.println("Slot has been used. Please try again");
					continue;
				}
				setGrid(getChoice(), 'o');
				showGrid();
				turn = 1;
			}
		} 
		catch (Exception e) {
			System.out.println("Invalid entry. Please try again");	
			playerInput.next();
		
		}
		
		switch(winCheck()) {
			case 1:
				System.out.println("Congrats Player 1 wins!");
				x = 2;
				break;
			case 2:
				System.out.println("Congrats Player 2 wins!");
				x = 2;
				break;
			case 3:
				System.out.println("It's a tie!");
				x = 2;
				break;
		}
	}
	while (x == 1);	
	}
	
	public void showGrid() {
		grid = getGrid();
		
		for (int i = 0; i < 9; i += 3) {
			System.out.println(" " + grid[i] + " | " + grid[i+1] + " | " + grid[i+2]);
			if (i < 6) {
				System.out.println("---|---|---");
			}
		}
	}
	
	public int winCheck() {
		int count = 0;
		grid = getGrid();
		String check = Arrays.toString(grid);	
		
		if (check.indexOf("x, x, x") == 1 || check.indexOf("x, x, x") == 10 || check.indexOf("x, x, x") == 19) return 1;
		else if (check.indexOf("o, o, o") == 1 || check.indexOf("o, o, o") == 10 || check.indexOf("o, o, o") == 19 ) return 2;
		else if (grid[0] == 'x' && grid[4] == 'x' && grid[8] == 'x' || grid[2] == 'x' && grid[4] == 'x' && grid[6] == 'x') 
			return 1;
		else if (grid[0] == 'o' && grid[4] == 'o' && grid[8] == 'o' || grid[2] == 'o' && grid[4] == 'o' && grid[6] == 'o') 
			return 2;
		
		for (int i = 0; i < 3; i++) {
			if (grid[i] == 'x' && grid[i+3] == 'x' && grid[i+6] == 'x') return 1;
			else if ((grid[i] == 'o' && grid[i+3] == 'o' && grid[i+6] == 'o')) return 2;
		}
		for (char s : grid) {
			if (s == 'x' || s == 'o') count++;
			if(count == 9) return 3;
		}
		
		return 0;
	
	}
}
