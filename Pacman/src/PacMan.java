import java.awt.*;
import java.awt.event.*;
import java.util.HashSet;
import java.util.random.*;
import javax.swing.*;

//Starting Pacman project!

// Pacman will inherit JPanel
// Push and Commit Testing
public class PacMan extends JPanel {
	
	class block{
		int x;
		int y;
		int width;
		int height;
		Image image;
		
		int startX;
		int startY;
		
		block(Image image, int x, int y, int width, int height){
			this.image = image;
			this.x = x;
			this.y = y;
			this.width = width;
			this.height = height;
			
			this.startX = x;
			this.startY = y;
		}
	}
	
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
	private Image pacmanLeftImage;
	private Image pacmanRightImage;
	
	HashSet<block> walls;
	HashSet<block> foods;
	HashSet<block> ghosts;
	block pacman;
	
	
	PacMan(){
		setPreferredSize(new Dimension(boardWidth, boardHeight));
		setBackground(Color.BLACK);
		
		wallImage = new ImageIcon(getClass().getResource("./wall.png")).getImage();
		blueGhostImage = new ImageIcon(getClass().getResource("./blueGhost.png")).getImage();
		orangeGhostImage = new ImageIcon(getClass().getResource("./orangeGhost.png")).getImage();
		pinkGhostImage = new ImageIcon(getClass().getResource("./pinkGhost.png")).getImage();
		redGhostImage = new ImageIcon(getClass().getResource("./redGhost.png")).getImage();
		
		pacmanUpImage = new ImageIcon(getClass().getResource("./pacmanUp.png")).getImage();
		pacmanDownImage = new ImageIcon(getClass().getResource("./pacmanDown.png")).getImage();
		pacmanLeftImage = new ImageIcon(getClass().getResource("./pacmanLeft.png")).getImage();
		pacmanRightImage = new ImageIcon(getClass().getResource("./pacmanRight.png")).getImage();

	}
}