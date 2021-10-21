package gameXO;

public class Player {
	private int choice;
	private char[] grid = new char[9];
	
	public void setChoice(int choice) {
		this.choice = choice;
	}
	
	public int getChoice() {
		return choice;
	}
	
	public void setGrid(int choice, char x) {
		this.grid[choice] = x;
	}
	
	public char[] getGrid() {
		return grid;
	}
	
	public boolean used(int choice) {
		if (grid[choice] == 'x' || grid[choice] == 'o') {
			return true;
		}
		return false;
	}
}
