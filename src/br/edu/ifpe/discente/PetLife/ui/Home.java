package br.edu.ifpe.discente.PetLife.ui;

import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import java.net.URL;

public class Home extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public Home() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Home");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBounds(10, 11, 62, 27);
		add(lblNewLabel);
		
        URL imgURL = getClass().getResource("/Imagens/casa.png");
        ImageIcon icon = new ImageIcon(imgURL);
		JLabel casaIcon = new JLabel(icon);
		casaIcon.setBounds(70, 6, 46, 37);
		add(casaIcon);
		
		JLabel lblNewLabel_1 = new JLabel("PetLife");
		lblNewLabel_1.setEnabled(false);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 54));
		lblNewLabel_1.setBounds(359, 156, 160, 78);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel(" Gerenciando a vida dos pets");
		lblNewLabel_2.setEnabled(false);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(359, 235, 248, 14);
		add(lblNewLabel_2);
		

		

        
		
	}

}
