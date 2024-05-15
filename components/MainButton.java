package components;

import javax.imageio.ImageIO;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;
import java.awt.*;
import java.io.*;

public class MainButton extends JButton {
    InputStream stream = getClass().getResourceAsStream("/content/SPRITES.png");
    BufferedImage image;
    Image iconImage;
    GamePanel panel;

    public MainButton(GamePanel panel) {
        try {
            image = ImageIO.read(stream);
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }

        Dimension dimension = new Dimension(52 * 4, 29 * 4);
        image = image.getSubimage(354, 118, 52, 29);
        iconImage = image.getScaledInstance(52 * 4, 29 * 4, java.awt.Image.SCALE_SMOOTH);

        this.setMinimumSize(dimension);
        this.setPreferredSize(dimension);
        this.setMaximumSize(dimension);

        this.setIcon(new ImageIcon(iconImage));
        this.setBorder(BorderFactory.createEmptyBorder());
        this.setContentAreaFilled(false);

        this.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                panel.begin();
                System.out.println("clicked");
            }
        });
    }

    public void actionPerformed(ActionEvent event) {
        panel.begin();
        System.out.println("clicked");
    }
}
