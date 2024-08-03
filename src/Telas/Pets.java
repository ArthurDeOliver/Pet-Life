package Telas;

import java.awt.Font;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Pets extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public Pets() {
		setLayout(null);

        URL imgURL = getClass().getResource("/Imagens/bicho-de-estimacao (1).png");
        ImageIcon icon = new ImageIcon(imgURL);
		JLabel petsIcon = new JLabel(icon);
		petsIcon.setBounds(60, 6, 46, 37);
		add(petsIcon);
		
		JLabel petsLabel = new JLabel("Pets");
		petsLabel.setFont(new Font("JetBrains Mono", Font.PLAIN, 20));
		petsLabel.setBounds(10, 11, 48, 27);
		add(petsLabel);
	}

}
