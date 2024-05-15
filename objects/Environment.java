package objects;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.image.*;
import java.awt.*;
import java.io.*;

public class Environment extends JPanel {
    private InputStream stream = getClass().getResourceAsStream("/content/SPRITES.png");
    private BufferedImage background;
    private BufferedImage platform;
    private BufferedImage image;
    private Player player;

    private int[][] backgroundValues = new int[3][2];
    private int[][] platformValues = new int[3][2];

    public boolean currentBackground = false;
    public boolean transition = false;
    public int currentModifier = 0;
    public boolean moving = false;

    public Environment(Player player) {
        try {
            image = ImageIO.read(stream);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }

        this.player = player;

        addNormalBackground();
        resetBackground();

        addPlatform();
        resetPlatform();
    }

    public void resetBackground() {
        backgroundValues[0][0] = 0;
        backgroundValues[0][1] = 0;
        backgroundValues[1][0] = 432;
        backgroundValues[1][1] = 0;
        backgroundValues[2][0] = 864;
        backgroundValues[2][1] = 0;
    }

    public void resetPlatform() {
        platformValues[0][0] = 0;
        platformValues[0][1] = 603;
        platformValues[1][0] = 504;
        platformValues[1][1] = 603;
        platformValues[2][0] = 1008;
        platformValues[2][1] = 603;
    }

    public void addNormalBackground() {
        background = image.getSubimage(0, 0, 144, 256);
    }

    public void addNightBackground() {
        background = image.getSubimage(146, 0, 144, 256);
    }

    public void addPlatform() {
        platform = image.getSubimage(292, 0, 168, 55);
    }

    public void update() {
        if (moving) {
            if (backgroundValues[0][0] <= -432) {
                resetBackground();
            } else {
                backgroundValues[0][0] -= 1;
                backgroundValues[1][0] -= 1;
                backgroundValues[2][0] -= 1;
            }

            if (platformValues[0][0] <= -504) {
                resetPlatform();
            } else {
                platformValues[0][0] -= 1;
                platformValues[1][0] -= 1;
                platformValues[2][0] -= 1;
            }

            if (currentModifier >= 3000) {
                currentBackground = !currentBackground;
                currentModifier = 0;
            } else {
                currentModifier += 1;
            }

            if (!currentBackground) {
                addNormalBackground();
                player.currentSwitched = false;
            } else {
                addNightBackground();
                player.currentSwitched = true;
            }
        }
    }

    public void render(Graphics2D G2D) {
        try {
            for (int i = 0; i < 3; i++) {
                G2D.drawImage(background, backgroundValues[i][0], backgroundValues[i][1], 144 * 3, 256 * 3, null);
            }

            for (int i = 0; i < 3; i++) {
                G2D.drawImage(platform, platformValues[i][0], platformValues[i][1], 168 * 3, 55 * 3, null);
            }
        } catch (Exception exception) {
            System.out.println("ERROR | Failed to display ENV background");
        }
    }
}
