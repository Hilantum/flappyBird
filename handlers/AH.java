package handlers;

import java.awt.image.*;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;

public class AH {
	InputStream stream = getClass().getResourceAsStream("/content/SPRITES.png");
	BufferedImage atlas;
		
	public AH() {
		try {
			atlas = ImageIO.read(stream);
		} catch (IOException exception) { 
			System.out.println(exception.getMessage()); 
		}
	} 
	
	public BufferedImage[] getFlappingSprites() {
		BufferedImage[] temp = new BufferedImage[3];

        temp[0] = atlas.getSubimage(0, 491, 23, 12); 
        temp[1] = atlas.getSubimage(28, 491, 23, 12);
        temp[2] = atlas.getSubimage(56, 491, 23, 12);

		return temp;
	}

    public BufferedImage[] getStationarySprites() {
        BufferedImage temp[] = new BufferedImage[1];
        temp[0] = atlas.getSubimage(27, 491, 23 * 10, 12);

		return temp;
	}
}
