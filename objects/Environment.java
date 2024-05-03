package objects;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.image.*;
import java.awt.*;
import java.io.*;

public class Environment extends JPanel {
    private InputStream stream = getClass().getResourceAsStream("/content/SPRITES.png");
    private BufferedImage[] currentBackgrounds = new BufferedImage[3];
    private BufferedImage platform;

    private int[][] backgroundValues = new int[3][2];
    private int[][] platformValues = new int[3][2];

    public String currentBackground = "none";
    public boolean moving = false;
    

    public Environment() {
        addNormalBackground();
        addPlatform();

        reset();
    }

    public void reset() {
        backgroundValues[0][0] = 0; backgroundValues[0][1] = 603;
        backgroundValues[1][0] = 432; backgroundValues[1][1] = 603;
        backgroundValues[2][0] = 0; backgroundValues[2][1] = 603;

        platformValues[0][0] = 0; platformValues[0][1] = 603;
        platformValues[0][0] = 504; platformValues[0][1] = 603;
        platformValues[0][0] = 0; platformValues[0][1] = 603;
    }

    public void addNormalBackground() {
        currentBackground = "normal";

        try {
            BufferedImage image = ImageIO.read(stream);

			currentBackgrounds[0] = image.getSubimage(0, 0, 144, 256);
            currentBackgrounds[1] = image.getSubimage(0, 0, 144, 256);
            // currentBackgrounds[2] = image.getSubimage(0, 0, 144, 256);
        } catch (IOException exception) { 
			System.out.println(exception.getMessage()); 
		}
    }

    public void addNightBackground() {
        currentBackground = "night";
        //.getSubimage(145, 0, 155, 256);
    }

    public void addPlatform() {
        try {
            BufferedImage image = ImageIO.read(stream);
            platform = image.getSubimage(291, 0, 165, 55);
        } catch (IOException exception) { 
			System.out.println(exception.getMessage()); 
		}
    }

    public void update() {
        if (moving) {
            // Moving background logic here
        }
    }

    public void render(Graphics2D G2D) {
        try {
            G2D.drawImage(currentBackgrounds[0], backgroundValues[0][0], backgroundValues[0][1], 144 * 3, 256 * 3, null);
            G2D.drawImage(currentBackgrounds[1], backgroundValues[1][0], backgroundValues[1][1], 144 * 3, 256 * 3, null);
            G2D.drawImage(currentBackgrounds[2], backgroundValues[2][0], backgroundValues[2][1], 144 * 3, 256 * 3, null);

            G2D.drawImage(platform, platformValues[0][0], platformValues[0][1], 165 * 3, 55 * 3, null);
            G2D.drawImage(platform, platformValues[1][0], platformValues[1][1], 165 * 3, 55 * 3, null);
            G2D.drawImage(platform, platformValues[2][0], platformValues[2][1], 165 * 3, 55 * 3, null);
        } catch (Exception exception) {
            System.out.println("ERROR | Failed to display ENV background");
        }
    }
}
