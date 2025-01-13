import java.awt.*;
import java.awt.event.*;
import java.util.random.*;
import javax.swing.*;



// Pacman will inherit JPanel

public class PacMan extends JPanel {
	private int rowCount = 21;
	private int columnCount = 19;
	private int tileSize = 32;
	private int boardWidth = columnCount * rowCount;
	private int boardHeight = rowCount * tileSize;
	
	PacMan(){
		setPreferredSize(new Dimension(boardWidth, boardHeight));
		setBackground(Color.BLACK);
	}
	
}
