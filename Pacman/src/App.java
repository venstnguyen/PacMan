import javax.swing.JFrame; //Makes the window for the game

// Main file to run the game

public class App {
	
	public static void main(String[] args) {
	int rowCount = 21;
	int columnCount = 19;
	int tileSize = 32;
	int boardWidth = columnCount * tileSize;
	int boardHeight = rowCount * tileSize;
	
	JFrame frame = new JFrame("Pac Man");
	frame.setVisible(true);
	}
}
