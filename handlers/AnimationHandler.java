package handlers;

import java.awt.image.*;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;

public class AnimationHandler {
	InputStream stream = getClass().getResourceAsStream("/content/player_sprites.png");
	BufferedImage atlas;
		
	public AnimationHandler() {
		try {
			atlas = ImageIO.read(stream);
		} catch (IOException exception) { 
			System.out.println(exception.getMessage()); 
		}
	} 
	
	public BufferedImage[] getIdleSprites() {
		BufferedImage[] temp = new BufferedImage[5];

		for (int i = 0; i < 5; i++) {
			temp[i] = atlas.getSubimage(i * 64, 0 * 40, 64, 40);
		}

		return temp;
	}
	
	public BufferedImage[] getMovingSprites() {
		BufferedImage[] temp = new BufferedImage[6];

		for (int i = 0; i < 6; i++) {
			temp[i] = atlas.getSubimage(i * 64, 1 * 40, 64, 40);
		}

		return temp;
	}

	public BufferedImage[] getJumpingSprites() {
		BufferedImage[] temp = new BufferedImage[3];

		for (int i = 0; i < 3; i++) {
			temp[i] = atlas.getSubimage(i * 64, 2 * 40, 64, 40);
		}

		return temp;	
	}
}
