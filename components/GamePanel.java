package components;

import java.awt.image.*;

import objects.*;
import javax.imageio.*;
import javax.swing.*;
import java.awt.*;
import java.io.*;

import handlers.*;

public class GamePanel extends JPanel {
    Player player = new Player(432 - (23 * 5 / 2), 384 - (13 * 5 / 2));
    Environment environment = new Environment(player);
    MainButton button = new MainButton(this);

    public GamePanel() {
        Dimension dimension = new Dimension(288 * 3, 256 * 3);
        InputHandler input = new InputHandler(this, player, environment);

        this.setFocusable(true);
        this.requestFocus();

        this.setMinimumSize(dimension);
        this.setPreferredSize(dimension);
        this.setMaximumSize(dimension);

        this.addMouseListener(input);
        this.addKeyListener(input);

        this.add(button);
        button.setSize(100, 100);
    }

    public Environment getEnvironment() {
        return environment;
    }

    public Player getPlayer() {
        return player;
    }

    public void begin() {
        environment.moving = true;
        player.playerBegun = true;
        this.remove(button);
    }

    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D G2D = (Graphics2D) graphics;

        if (player.playerDead) {
            environment.moving = false;
        }

        environment.render(G2D);
        player.render(G2D);
    }
}
