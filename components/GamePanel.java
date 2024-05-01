package components;

import java.awt.image.*;
import objects.P;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.*;

import handlers.*;

public class GamePanel extends JPanel {
	P player = new P(600, 700);
	
	public GamePanel() {
		Dimension dimension = new Dimension(1080, 800);
		InputHandler input = new InputHandler(this, player);

		this.setFocusable(true);
		this.requestFocus();
		
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
