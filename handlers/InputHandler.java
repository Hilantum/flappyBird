package handlers;

import components.GamePanel;
import java.awt.event.*;
import java.awt.*;

public class InputHandler implements KeyListener, MouseListener {
	private GamePanel panel;
	
	public InputHandler(GamePanel panel) {
		this.panel = panel;
	}
	
	/* Keyboard Methods */
	@Override public void keyTyped(KeyEvent event) {
	
	}

	@Override public void keyPressed(KeyEvent event) {

	}

	@Override public void keyReleased(KeyEvent event) {

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
