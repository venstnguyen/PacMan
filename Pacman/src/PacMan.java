import java.awt.*;
import java.awt.event.*;
import java.util.HashSet;
import java.util.random.*;
import javax.swing.*;



// Pacman will inherit JPanel
// Push and Commit Testing
public class PacMan extends JPanel implements ActionListener {
	
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
	private Image wallPic;
	private Image blueGhostPic;
	private Image orangeGhostPic;
	private Image pinkGhostPic;
	private Image redGhostPic;
	
	private Image pacmanDownPic;
	private Image pacmanLeftPic;
	private Image pacmanRightPic;
	private Image pacmanUpPic;
	
	
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
	
	Timer gameLoop;
	
	//Pacman Constructor
	PacMan(){
		setPreferredSize(new Dimension(boardWidth, boardHeight));
		setBackground(Color.BLACK);
		
		//load in images for map 
		wallPic = new ImageIcon(getClass().getResource("./wall.png")).getImage();
		blueGhostPic = new ImageIcon(getClass().getResource("./blueGhost.png")).getImage();
		orangeGhostPic = new ImageIcon(getClass().getResource("./orangeGhost.png")).getImage();
		pinkGhostPic = new ImageIcon(getClass().getResource("./pinkGhost.png")).getImage();
		redGhostPic = new ImageIcon(getClass().getResource("./redGhost.png")).getImage();
		
		//load in images for pacman 
		pacmanDownPic = new ImageIcon(getClass().getResource("./pacmanDown.png")).getImage();
		pacmanLeftPic = new ImageIcon(getClass().getResource("./pacmanLeft.png")).getImage();
		pacmanRightPic = new ImageIcon(getClass().getResource("./pacmanRight.png")).getImage();
		pacmanUpPic = new ImageIcon(getClass().getResource("./pacmanUp.png")).getImage();
		 
		loadMap();
		gameLoop = new Timer (50, this);
		
	}
	// Init all of the Hashset for map
	public void loadMap() {
		walls = new HashSet<Block>();
		pellets = new HashSet<Block>();
		ghosts = new HashSet<Block>();
		
		//Going throght the map 
		for (int r = 0; r < rowCount; r++) {
			for (int c =0; c < columnCount; c++) {
				String row = tileMap[r];
				char tileMapChar = row.charAt(c);
				
				int x = c * tileSize;
				int y = r * tileSize;
				
				if(tileMapChar == 'X') {
					Block wall = new Block(wallPic, x, y, tileSize, tileSize);
					walls.add(wall);
				} 
				else if (tileMapChar == 'b') {
					Block ghost = new Block(blueGhostPic, x, y, tileSize, tileSize);
					ghosts.add(ghost);
				}
				else if (tileMapChar == 'o') {
					Block ghost = new Block(orangeGhostPic, x, y, tileSize, tileSize);
					ghosts.add(ghost);
				}	
				else if (tileMapChar == 'p') {
					Block ghost = new Block(pinkGhostPic, x, y, tileSize, tileSize);
					ghosts.add(ghost);
				}
				else if (tileMapChar == 'r') {
					Block ghost = new Block(redGhostPic, x, y, tileSize, tileSize);
					ghosts.add(ghost);
				 
				} 
				else if (tileMapChar == 'P') {
					pacman = new Block(pacmanLeftPic, x, y, tileSize, tileSize);
					
				}
				else if (tileMapChar == ' ') {
					Block pellet = new Block(null, x + 14, y + 14, 4, 4);
					pellets.add(pellet);
				}
			}
		}
			
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		draw(g);
	}
	public void draw(Graphics g) {
		g.drawImage(pacman.image, pacman.x, pacman.y, pacman.width, pacman.height, null);
		
		for (Block ghost: ghosts) {
			g.drawImage(ghost.image, ghost.x, ghost.y, ghost.width, ghost.height, null);
		}
		
		for (Block wall: walls) {
			g.drawImage(wall.image, wall.x, wall.y, wall.width, wall.height, null);
		}
		
		g.setColor(Color.white);
		for (Block pellet: pellets) {
			g.fillRect(pellet.x, pellet.y, pellet.width, pellet.height);
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
		
	}
}
