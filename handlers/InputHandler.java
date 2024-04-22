package handlers;

import components.GamePanel;
import objects.Player;

import java.awt.event.*;
import java.awt.*;

public class InputHandler implements KeyListener, MouseListener {
	private GamePanel panel;
	private Player player;
	
	public InputHandler(GamePanel panel, Player player) {
		this.panel = panel;
		this.player = player;
	}
	
	/* Keyboard Methods */
	@Override public void keyTyped(KeyEvent event) {
		
	}

	@Override public void keyPressed(KeyEvent event) {
		switch(event.getKeyCode()) {
			case(KeyEvent.VK_A): player.move("left");
			break;
			
			case(KeyEvent.VK_D): player.move("right");
			break;
			
			case(KeyEvent.VK_SPACE): player.jump();
			break;
		}
	}

	@Override public void keyReleased(KeyEvent event) {
		switch(event.getKeyCode()) {
			case(KeyEvent.VK_A): player.stop("left");
			break;
			
			case(KeyEvent.VK_D): player.stop("right");
			break;
	}
	}
	
	/* Mouse Methods */
	@Override public void mouseClicked(MouseEvent event) {
		
	}

	@Override public void mousePressed(MouseEvent event) {
		
	}

	@Override public void mouseReleased(MouseEvent event) {
		
	}

	// Not In Use \\
	@Override public void mouseEntered(MouseEvent event) {}
	@Override public void mouseExited(MouseEvent event) {}
}
