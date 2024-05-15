package objects;

import java.awt.image.*;
import java.awt.geom.*;
import javax.swing.*;
import java.awt.*;
import handlers.*;

public class Player extends JPanel {
    private BufferedImage[] current;
    private AnimationHandler AH = new AnimationHandler();

    public boolean currentSwitched = false;
    private boolean scriptUpdating = false;
    private boolean playerJumping = false;

    public boolean playerDead = false;
    public boolean playerBegun = false;

    private int currentModifier = 0;
    private int animationSprite = 0;
    private int animationTick = 0;

    private int fallTick = 0;

    private double rotationalRadian = 0.0;
    private int modx = 0, mody = 0;
    private int oldx = 0, oldy = 0;
    private int x = 0, y = 0;

    public Player(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void flap() {
        if (!playerJumping) {
            playerJumping = true;
            oldx = x;
            oldy = y;
        } else {
            oldx = x;
            oldy = y;
        }
    }

    public void update() {
        if (scriptUpdating) {
            return;
        } else {
            scriptUpdating = true;
        }

        // State regulator
        if (playerDead) {
            y += 4;
        } else if (!playerBegun) {
            current = AH.getFlappingSprites();
            animationSprite = 1;
        } else {
            if (currentSwitched) {
                current = AH.getOtherFlappingSprites();
            } else {
                current = AH.getFlappingSprites();
            }

            // Tick Implementation with 8 revolutions p/second (rate at 200 ticks p/second)
            if (animationTick < 25) {
                animationTick += 1;
            } else {
                animationTick = 0;

                // Sprite Implementation
                if (animationSprite >= (current.length) - 1) {
                    animationSprite = 0;
                } else {
                    animationSprite += 1;
                }
            }

            // Physics Logic
            if (!playerJumping) {
                y += 1;

                if (rotationalRadian > 0.0) {
                    rotationalRadian -= .03;
                }
            } else {
                if (y > (oldy - 140)) {
                    y -= 5;
                    rotationalRadian += .03;
                } else {
                    playerJumping = false;
                }
            }

            if (this.y >= 730 || this.y <= 0) {
                this.playerDead = true;
                fallTick = 0;
            }
        }

        scriptUpdating = false;
    }

    public void render(Graphics2D G2D) {
        try {
            G2D.drawImage(current[animationSprite], x, y, 23 * 5, 13 * 5, null);
        } catch (Exception exception) {}
    }
}

// For next time, go down on the value array until it's invisible, then simply do reset, which will make everything reset.
