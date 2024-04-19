package components;

import java.awt.image.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.*;

import handlers.*;

public class GamePanel extends JPanel {
	private BufferedImage[][] images;
	private BufferedImage image;
	private int x = 0, y = 0;
	
	public GamePanel() {
		Dimension dimension = new Dimension(1080, 800);
		InputHandler input = new InputHandler(this);
		
		this.setMinimumSize(dimension);
		this.setPreferredSize(dimension);
		this.setMaximumSize(dimension);
		
		this.addMouseListener(input);
		this.addKeyListener(input);
	}
	
	public void refresh() {
		
	}
	
	public void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
		
		Graphics2D G2D = (Graphics2D)graphics;
		G2D.drawImage(image.getSubimage(0, 0, 64, 40), 100, 100, 192, 120, null);
	}
}
