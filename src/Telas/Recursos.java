package Telas;

import java.awt.Font;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Recursos extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public Recursos() {
		setLayout(null);
		
		URL imgURL = getClass().getResource("/Imagens/estatisticas (2).png");
        ImageIcon icon = new ImageIcon(imgURL);
		JLabel recursosIcon = new JLabel(icon);
		recursosIcon.setBounds(105, 6, 46, 37);
		add(recursosIcon);
		
		JLabel lblNewLabel = new JLabel("Recursos");
		lblNewLabel.setFont(new Font("JetBrains Mono", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 11, 101, 27);
		add(lblNewLabel);
	}

}
