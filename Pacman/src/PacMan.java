import java.awt.*;
import java.awt.event.*;
import java.util.HashSet;
import java.util.random.*;
import javax.swing.*;

//Starting Pacman project!

// Pacman will inherit JPanel
// Push and Commit Testing
public class PacMan extends JPanel {
	int rowCount = 21;
	int columnCount = 19;
	int tileSize = 32;
	int boardWidth = columnCount * tileSize;
	int boardHeight = rowCount * tileSize;
	
	private Image wallImage;
	private Image blueGhostImage;
	private Image orangeGhostImage;
	private Image redGhostImage;
	private Image pinkGhostImage;
	
	private Image pacmanUpImage;
	private Image pacmanDownImage;
	private Image pacmanLeftnImage;
	private Image pacmanRightImage;
	
	PacMan(){
		setPreferredSize(new Dimension(boardWidth, boardHeight));
		setBackground(Color.BLACK);
		
		wallImage = new ImageIcon(getClass().getResource("./wall.png")).getImage();
	}
}