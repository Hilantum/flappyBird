package Objects;

import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;
import java.awt.*;

import handlers.AnimationHandler;

public class Player extends Entity {
	private AnimationHandler animations = new AnimationHandler();
	private BufferedImage[][] sprites = animations.loadSprites();
	
	public Player(float x, float y) {
		super(x, y);
	}
		
	public void update() {
			
	}
		
	public void render(Graphics2D G2D) {
		
	}
	
}
