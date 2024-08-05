package Telas;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Pets extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public Pets() {
		setLayout(null);
		
		//carregar imagem no JPainel
		JLabel petsIcon = new JLabel(new ImageIcon(Pets.class.getResource("/Imagens/bicho-de-estimacao (1).png")));
		petsIcon.setBounds(63, 6, 46, 37);
		add(petsIcon);
		
		//ação do botão para abrir a tela de cadastro
		JButton btnCadastroPet = new JButton("");
		btnCadastroPet.setHorizontalAlignment(SwingConstants.LEFT);
		btnCadastroPet.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        TelaCadastroPet telaCadastroPet = new TelaCadastroPet();
		        telaCadastroPet.setVisible(true);
		    }
		});
		btnCadastroPet.setBounds(812, 11, 82, 46);

		//carregar imagem
		URL imgURL1 = getClass().getResource("/Imagens/mais.png");
        URL imgURL2 = getClass().getResource("/Imagens/cachorro (2).png");
        ImageIcon imgMais = new ImageIcon(imgURL1);
        ImageIcon imgPata = new ImageIcon(imgURL2);
		
        //Adicionar ícones ao botão
        JLabel iconMais = new JLabel(imgMais);
        JLabel iconPata = new JLabel(imgPata);
        
        iconMais.setBounds(5, 5, 32, 32);
        iconPata.setBounds(45, 5, 32, 32);

        btnCadastroPet.setLayout(null);
        btnCadastroPet.add(iconMais);
        btnCadastroPet.add(iconPata);
        
        add(btnCadastroPet);
		
		//Label escrito Pets
		JLabel petsLabel = new JLabel("Pets");
		petsLabel.setFont(new Font("JetBrains Mono", Font.PLAIN, 24));
		petsLabel.setBounds(10, 11, 56, 27);
		add(petsLabel);
	}

}
