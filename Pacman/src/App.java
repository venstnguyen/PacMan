import javax.swing.JFrame; //Makes the window for the game

// Main file to run the game

public class App {
	
	public static void main(String[] args) throws Exception {
		//window size
		int rowCount = 21;
		int columnCount = 19;
		int tileSize = 32;
		int boardWidth = columnCount * rowCount;
		int boardHeight = rowCount * tileSize;
		
		//creating the window object
		JFrame window = new JFrame("Pac-Man");
		window.setVisible(true);
		window.setSize(boardWidth, boardHeight);
		window.setLocationRelativeTo(null);
		window.setResizable(false);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		PacMan pacmanGame = new PacMan();
	}

}
