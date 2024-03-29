public class MineGrid {
	// receives the size of the grid nxm, and the probabiility of a mine.
	// creates a matching random grid
	public static int[][] createGrid(int n, int m, double p) {
		int[][] grid = new int[n][m];
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (Math.random() < p) {
					grid[i][j] = -1;
				}
			}
		}
		return grid;
	}
	// Receives a grid, and prints it
	public static void displayGrid(int[][] mineGreed) {
		for (int i = 0; i < mineGreed.length; i++) {
			for (int j = 0; j < mineGreed[i].length; j++) {
				if (mineGreed[i][j] == -1) {
					System.out.print("x ");
				} else {
					System.out.print(mineGreed[i][j] + " ");
				}
			}
			System.out.println();
		}
	}
	// main method
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);			// get 3
		int m = Integer.parseInt(args[1]);			// get 5
		double p = Double.parseDouble(args[2]);		// get 0.3
		int[][] mineGreed = createGrid(n, m, p);	
		displayGrid(mineGreed);
	}
}
