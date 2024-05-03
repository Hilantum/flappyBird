package objects;

import java.awt.image.*;

import javax.swing.JPanel;

import java.awt.*;
import java.awt.geom.AffineTransform;

import handlers.AH;

public class P extends JPanel {
    private BufferedImage[] current;
    private AH AH = new AH();

    private boolean scriptUpdating = false;
    private boolean playerFlapping = false;
    private boolean playerJumping = false;
    private boolean playerDead = false;

    private int animationSprite = 0;
    private int animationTick = 0;
    private int fallTick = 0;

    private double rotationalRadian = 0.0;
    private int modx = 0, mody = 0;
    private int oldx = 0, oldy = 0;
    private int x = 0, y = 0;

    public P(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void flap() {
        if (!playerJumping) {
            playerJumping = true;
            oldx = x; oldy = y;
        } else {
            oldx = x; oldy = y;
        }
    }

    public void update() {
        if (scriptUpdating) { return; } else { scriptUpdating = true; }

        // State regulator
        if (playerDead) {
            playerFlapping = false;
            current = AH.getStationarySprites();
        } else {
            playerFlapping = true;
            current = AH.getFlappingSprites();
        }

        // Tick Implementation with 8 revolutions p/second (200 ticks p/minute)
        if (animationTick < 25) {
            animationTick += 1;
        } else {
            animationTick = 0;

            // Sprite Implementation
            if (playerFlapping) {
                if (animationSprite >= (current.length) - 1) {
                    animationSprite = 0;
                } else {
                    animationSprite += 1;
                }
            }
        }

        // Physics Logic
        if (fallTick < 50) {
            fallTick += 1;
        } else {
            if (!playerJumping) {
                y += 1;

                if (rotationalRadian > 0.0) {
                    rotationalRadian -= .03;
                }
            } else {
                if (y > (oldy - 140)) {
                    y -= 4;
                    rotationalRadian += .03;
                } else {
                    playerJumping = false;
                }
            }
        }   

        scriptUpdating = false;
    }

    public void render(Graphics2D G2D) {
        try {
            G2D.drawImage(current[animationSprite], x, y, 23 * 5, 13 * 5, null);
        } catch (Exception exception) {

        }
    }
}
