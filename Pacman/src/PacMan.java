import java.awt.*;
import java.awt.event.*;
import java.util.HashSet;
import java.util.random.*;
import javax.swing.*;

//Starting Pacman project!

// Pacman will inherit JPanel
// Push and Commit Testing
public class PacMan extends JPanel implements ActionListener {
	int rowCount = 21;
	int columnCount = 19;
	int tileSize = 32;
	int boardWidth = columnCount * tileSize;
	int boardHeight = rowCount * tileSize;
}