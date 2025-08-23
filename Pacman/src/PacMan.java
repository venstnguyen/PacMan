import java.awt.*;
import java.awt.event.*;
import java.util.HashSet;
import java.util.random.*;
import javax.swing.*;

//Starting Pacman project!

// Pacman will inherit JPanel
// Push and Commit Testing
public class PacMan extends JPanel {
	
	class Block{
		int x;
		int y;
		int width;
		int height;
		Image image;
		
		int startX;
		int startY;
		
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
	
	//X = wall, O = skip, P = Pac-Man, ' ' = food
    //Ghosts: b = blue, o = orange, p = pink, r = red
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
	HashSet<Block> foods;
	HashSet<Block> ghosts;
	Block pacman;
	
	
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
	
	
	public void loadMap() {
		walls = new HashSet<Block>();
		foods = new HashSet<Block>();
		ghosts = new HashSet<Block>();
		
		for (int r = 0; r < rowCount; r++) {
			for (int c = 0; c < columnCount; c ++) {
				String row = tileMap[r];
				char tileMapChar = row.charAt(c);
				
				int x = c*tileSize;
				int y = r*tileSize;
				
				if (tileMapChar == 'X') { //for walls
					Block wall = new Block(wallImage, x, y, tileSize, tileSize);
					walls.add(wall);
					}
				else if (tileMapChar == 'b'){ //for blue ghost
					Block ghost = new Block(blueGhostImage, x, y, tileSize, tileSize);
					ghosts.add(ghost);
					}
				else if (tileMapChar == 'r'){ //for red ghost
					Block ghost = new Block(redGhostImage, x, y, tileSize, tileSize);
					ghosts.add(ghost);
					}
				else if (tileMapChar == 'p'){ //for pink ghost
					Block ghost = new Block(pinkGhostImage, x, y, tileSize, tileSize);
					ghosts.add(ghost);
					}
				else if (tileMapChar == 'o'){ //for orange ghost
					Block ghost = new Block(orangeGhostImage, x, y, tileSize, tileSize);
					ghosts.add(ghost);
					}
				
					}
					
				}
			}
		}
		
	}
}