package components;

import java.awt.image.*;
import objects.Player;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.*;

import handlers.*;

public class GamePanel extends JPanel {
	Player player = new Player(500, 500);
	private BufferedImage[][] images;
	private BufferedImage image;
	private int x = 0, y = 0;
	
	public GamePanel() {
		Dimension dimension = new Dimension(1080, 800);
		InputHandler input = new InputHandler(this, player);
		
		this.setMinimumSize(dimension);
		this.setPreferredSize(dimension);
		this.setMaximumSize(dimension);
		
		this.addMouseListener(input);
		this.addKeyListener(input);
	}
	
	public void refresh() {
		player.update();
	}
	
	public void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
		Graphics2D G2D = (Graphics2D)graphics;
		
		player.render(G2D);
	}
}
