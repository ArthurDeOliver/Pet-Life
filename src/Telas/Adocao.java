package Telas;

import java.awt.Font;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Adocao extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public Adocao() {
		setLayout(null);
		
        URL imgURL = getClass().getResource("/Imagens/coracao (1).png");
        ImageIcon icon = new ImageIcon(imgURL);
		JLabel adocaoIcon = new JLabel(icon);
		adocaoIcon.setBounds(83, 6, 46, 37);
		add(adocaoIcon);
		
		JLabel lblNewLabel = new JLabel("Adoção");
		lblNewLabel.setFont(new Font("JetBrains Mono", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 11, 72, 27);
		add(lblNewLabel);
	}

}
