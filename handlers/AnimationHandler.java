package handlers;

import java.awt.image.*;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;

public class AnimationHandler {
    InputStream stream = getClass().getResourceAsStream("/content/SPRITES.png");
    BufferedImage atlas;

    public AnimationHandler() {
        try {
            atlas = ImageIO.read(stream);
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public BufferedImage[] getOtherFlappingSprites() {
        BufferedImage[] temp = new BufferedImage[3];

        temp[0] = atlas.getSubimage(84, 491, 23, 12);
        temp[1] = atlas.getSubimage(112, 329, 23, 12);
        temp[2] = atlas.getSubimage(112, 355, 23, 12);

        return temp;
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
        temp[0] = atlas.getSubimage(28, 491, 23, 12);

        return temp;
    }
}
