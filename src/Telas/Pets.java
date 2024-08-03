package Telas;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Pets extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public Pets() {
		setLayout(null);
		
		//carregar imagem no JPainel
        URL imgURL = getClass().getResource("/Imagens/bicho-de-estimacao (1).png");
        ImageIcon icon = new ImageIcon(imgURL);
		JLabel petsIcon = new JLabel(icon);
		petsIcon.setBounds(60, 6, 46, 37);
		add(petsIcon);
		
		//ação do botão para abrir a tela de cadastro
		JButton btnCadastroPet = new JButton("Cadastrar Pet");
		btnCadastroPet.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        TelaCadastroPet telaCadastroPet = new TelaCadastroPet();
		        telaCadastroPet.setVisible(true);
		    }
		});
		btnCadastroPet.setBounds(730, 11, 150, 30);
		add(btnCadastroPet);
		
		//Label escrito Pets
		JLabel petsLabel = new JLabel("Pets");
		petsLabel.setFont(new Font("JetBrains Mono", Font.PLAIN, 20));
		petsLabel.setBounds(10, 11, 48, 27);
		add(petsLabel);
	}

}
