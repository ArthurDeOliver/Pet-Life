package Telas;

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
		lblNewLabel.setFont(new Font("JetBrains Mono", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 11, 48, 27);
		add(lblNewLabel);
		
        URL imgURL = getClass().getResource("/Imagens/casa.png");
        ImageIcon icon = new ImageIcon(imgURL);
		JLabel casaIcon = new JLabel(icon);
		casaIcon.setBounds(60, 6, 46, 37);
		add(casaIcon);
		
		JLabel lblNewLabel_1 = new JLabel("PetLife");
		lblNewLabel_1.setEnabled(false);
		lblNewLabel_1.setFont(new Font("JetBrains Mono", Font.PLAIN, 54));
		lblNewLabel_1.setBounds(359, 159, 230, 78);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Cuidando dos recursos dos pets");
		lblNewLabel_2.setEnabled(false);
		lblNewLabel_2.setFont(new Font("JetBrains Mono", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(365, 233, 248, 14);
		add(lblNewLabel_2);
		

		

        
		
	}

}
