package components;

import javax.swing.*;

public class GameFrame extends JFrame {	
	public GameFrame(GamePanel panel) {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.add(panel);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
		panel.requestFocus();
	}
}
