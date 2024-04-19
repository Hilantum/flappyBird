package handlers;

import java.awt.image.*;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;

public class AnimationHandler {
	public BufferedImage[][] loadSprites() {
		InputStream stream = getClass().getResourceAsStream("/content/player_sprites.png");
		BufferedImage[][] spriteAnimations = new BufferedImage[9][6];

		try {
			BufferedImage image = ImageIO.read(stream); 
			
			for (int i = 0; i < spriteAnimations.length; i++) {
				for (int j = 0; j < spriteAnimations[i].length; j++) {
					spriteAnimations[i][j] = image.getSubimage(j * 64, i * 40, 64, 40);
				}
			}
		} catch (IOException exception) { } 
		
		return spriteAnimations;
	}
}
