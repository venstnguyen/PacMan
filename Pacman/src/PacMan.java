import java.awt.*;
import java.awt.event.*;
import java.util.HashSet;
import java.util.random.*;
import javax.swing.*;



// Pacman will inherit JPanel
// Push and Commit Testing
public class PacMan extends JPanel {
	
	class Block{
		int x;
		int y;
		int width;
		int height;
		
		Image image;;
		
		int startX;
		int startY;
		
		//Wall Constructor
		Block(Image image, int x, int y, int width, int height){
			this.image = image;
			this.x = x;
			this.y = y;
			this.width = width;
			this.height = height;
			this.startX = x;
			this.startY = y;
			
		}
		
	}
	
	private int rowCount = 21;
	private int columnCount = 19;
	private int tileSize = 32;
	private int boardWidth = columnCount * rowCount;
	private int boardHeight = rowCount * tileSize;
	
	//Creating representation
	private Image wall;
	private Image blueGhost;
	private Image orangeGhost;
	private Image pinkGhost;
	private Image redGhost;
	
	private Image pacmanDown;
	private Image pacmanLeft;
	private Image pacmanRight;
	private Image pacmanUp;
	
	
	// X = walls, O = Blankspace, P = Pac-Man, ' ' = pellets
	// Ghosts : b = Blue Ghost, o = Orange Ghost, p = Pink Ghost, r = Red Ghost
	private String[] tileMap = {
			"XXXXXXXXXXXXXXXXXXX",
	        "X        X        X",
	        "X XX XXX X XXX XX X",
	        "X                 X",
	        "X XX X XXXXX X XX X",
	        "X    X       X    X",
	        "XXXX XXXX XXXX XXXX",
	        "OOOX X       X XOOO",
	        "XXXX X XXrXX X XXXX",
	        "O       bpo       O",
	        "XXXX X XXXXX X XXXX",
	        "OOOX X       X XOOO",
	        "XXXX X XXXXX X XXXX",
	        "X        X        X",
	        "X XX XXX X XXX XX X",
	        "X  X     P     X  X",
	        "XX X X XXXXX X X XX",
	        "X    X   X   X    X",
	        "X XXXXXX X XXXXXX X",
	        "X                 X",
	        "XXXXXXXXXXXXXXXXXXX" 
	};
	
	
	HashSet<Block> walls;
	HashSet<Block> pellets;
	HashSet<Block> ghosts;
	Block pacman;
	
	//Pacman Constructor
	PacMan(){
		setPreferredSize(new Dimension(boardWidth, boardHeight));
		setBackground(Color.BLACK);
		
		//load in images for map 
		wall = new ImageIcon(getClass().getResource("./wall.png")).getImage();
		blueGhost = new ImageIcon(getClass().getResource("./blueGhost.png")).getImage();
		orangeGhost = new ImageIcon(getClass().getResource("./orangeGhost.png")).getImage();
		pinkGhost = new ImageIcon(getClass().getResource("./pinkGhost.png")).getImage();
		redGhost = new ImageIcon(getClass().getResource("./redGhost.png")).getImage();
		
		//load in images for pacman 
		pacmanDown = new ImageIcon(getClass().getResource("./pacmanDown.png")).getImage();
		pacmanLeft = new ImageIcon(getClass().getResource("./pacmanLeft.png")).getImage();
		pacmanRight = new ImageIcon(getClass().getResource("./pacmanRight.png")).getImage();
		pacmanUp = new ImageIcon(getClass().getResource("./pacmanUp.png")).getImage();
		
	}
	
}
