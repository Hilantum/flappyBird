package components;

import java.awt.image.*;

import objects.Environment;
import objects.P;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.*;

import handlers.*;

public class GamePanel extends JPanel {
	Environment environment = new Environment();
	P player = new P(432 - (23 * 5 / 2), 384 - (13 * 5 / 2));
	
	public GamePanel() {
		Dimension dimension = new Dimension(288 * 3, 256 * 3);
		InputHandler input = new InputHandler(this, player, environment);

		this.setFocusable(true);
		this.requestFocus();
		
		this.setMinimumSize(dimension);
		this.setPreferredSize(dimension);
		this.setMaximumSize(dimension);
		
		this.addMouseListener(input);
		this.addKeyListener(input);
	}
	
	public void refresh() {
		environment.update();
		player.update();
	}
	
	public void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
		Graphics2D G2D = (Graphics2D)graphics;
		
		environment.render(G2D);
		player.render(G2D);
	}
}
