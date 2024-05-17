package handlers;

import components.GamePanel;
import objects.*;

import java.awt.event.*;
import java.awt.*;

public class InputHandler implements KeyListener, MouseListener {
	private Environment environment;
	private GamePanel panel;
	private Player player;
	
	public InputHandler(GamePanel panel, Player player, Environment environment) {
		this.panel = panel;
		this.player = player;
		this.environment = environment;
	}
	
	/* Keyboard Methods */
	@Override public void keyTyped(KeyEvent event) {
		
	}

	@Override public void keyPressed(KeyEvent event) {
		switch(event.getKeyCode()) {
			case(KeyEvent.VK_SPACE): player.flap();
			break;
		}
	}

	@Override public void keyReleased(KeyEvent event) {}
	
	/* Mouse Methods */
	@Override public void mouseClicked(MouseEvent event) {
		if (!player.playerBegun) {
			
		} else {
			player.flap();
		}
	}

	@Override public void mousePressed(MouseEvent event) {
		
	}

	@Override public void mouseReleased(MouseEvent event) {
		
	}

	// Not In Use \\
	@Override public void mouseEntered(MouseEvent event) {}
	@Override public void mouseExited(MouseEvent event) {}
}