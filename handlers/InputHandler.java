package handlers;

import components.GamePanel;
import objects.*;

import java.awt.event.*;
import java.awt.*;

public class InputHandler implements KeyListener, MouseListener {
	private Environment environment;
	private GamePanel panel;
	private P player;
	
	public InputHandler(GamePanel panel, P player, Environment environment) {
		this.panel = panel;
		this.player = player;
		this.environment = environment;
	}
	
	/* Keyboard Methods */
	@Override public void keyTyped(KeyEvent event) {
		
	}

	@Override public void keyPressed(KeyEvent event) {
		/*switch(event.getKeyCode()) {
			case(KeyEvent.VK_A): player.move("left");
			break;
			
			case(KeyEvent.VK_D): player.move("right");
			break;
			
			case(KeyEvent.VK_SPACE): player.jump();
			break;
		}*/

		switch(event.getKeyCode()) {
			case(KeyEvent.VK_SPACE): player.flap();
			break;
		}
	}

	@Override public void keyReleased(KeyEvent event) {
		/*switch(event.getKeyCode()) {
			case(KeyEvent.VK_A): player.stop("left");
			break;
			
			case(KeyEvent.VK_D): player.stop("right");
			break;
		}*/
	}
	
	/* Mouse Methods */
	@Override public void mouseClicked(MouseEvent event) {
		if (!player.playerBegun) {
			environment.moving = true;
			player.playerBegun = true;
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
