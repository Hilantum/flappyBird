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
	
	private boolean moving = false;
	private boolean jumping = false;
	private boolean falling = false;
	
	private int animTick = 0, animSprite = 0;
	private int x = 0, y = 0, diff = 0;;
	
	public Player(int x, int y) {
		this.x = x; 
		this.y = y;
	}
	
	public void update() {
		animationTick();
	}
	
	public void render(Graphics2D G2D) {
		if (!moving && !jumping) {
			current = AH.getIdleSprites();
		}
		
		if (moving) {
			if (direction == "left") {
				x -= 5;
			} else if (direction == "right") {
				x += 5;
			}
			
			current = AH.getMovingSprites();
		}
				
		G2D.drawImage(current[animSprite], x, y, 192, 120, null);
	}	
	
	public void move(String direction) {
		this.direction = direction;
		moving = true;
	}
	
	public void stop() {
		this.direction = "";
		moving = false;
	}
	
	public void animationTick() {
		animTick += 1;
		
		if (animTick >= 25) {
			animTick = 0;
			animSprite += 1;
			if (animSprite == (current.length-1)) {
				animSprite = 0;
			}
		}
	}
}
