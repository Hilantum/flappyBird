package objects;

import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;
import java.awt.*;

import handlers.AnimationHandler;

public class Player {
	private AnimationHandler AH = new AnimationHandler();
	private BufferedImage[] current = AH.getIdleSprites();
	
	private String direction = "";
	
	private boolean movingRight = false;
	private boolean movingLeft = false;
	private boolean jumping = false;
	private boolean falling = false;
	private boolean running = false;
	
	private int animTick = 0, animSprite = 0;
	private int diff = 0, diff2 = 0;
	private int x = 0, y = 0;
	
	public Player(int x, int y) {
		this.x = x; 
		this.y = y;
	}

	public void move(String direction) {
		if (direction == "left") { 
			movingLeft = true;
		} else if (direction == "right") { 
			movingRight = true;
		}
	}
	
	public void stop(String direction) {
		if (direction == "left") { 
			movingLeft = false;
		} else if (direction == "right") { 
			movingRight = false;
		}
	}

	public void update() {
		if (running) { return; } else { running = true; }  // Prevents length errors

		// Sprite Logical Implementation
		if ((movingLeft || movingRight) && !jumping) {
			current = AH.getMovingSprites();
		} else if (jumping) {
			current = AH.getJumpingSprites();
		} else {
			current = AH.getIdleSprites();
		}

		// Animation Tick
		if (animTick < 25) {
			animTick += 1;
		} else {
			animTick = 0;

			// Sprite Concurrency
			if (animSprite < (current.length - 1)) {
				animSprite += 1;
			} else {
				animSprite = 0;
			}	
		}

		running = false;
	}
	
	public void render(Graphics2D G2D) {
		if (movingLeft && !movingRight) {
			x -= 2;
		} else if (movingRight && !movingLeft) {
			x += 2;
		}
				
		G2D.drawImage(current[animSprite], x, y, 192, 120, null);
	}
}
