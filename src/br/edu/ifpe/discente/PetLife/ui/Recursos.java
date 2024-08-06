package br.edu.ifpe.discente.PetLife.ui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Recursos extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public Recursos() {
		setLayout(null);
		
		URL imgURL = getClass().getResource("/imagens/estatisticas2.png");
        ImageIcon icon = new ImageIcon(imgURL);
		JLabel recursosIcon = new JLabel(icon);
		recursosIcon.setBounds(121, 6, 46, 37);
		add(recursosIcon);
		
		JLabel lblNewLabel = new JLabel("Recursos");
		lblNewLabel.setFont(new Font("JetBrains Mono", Font.PLAIN, 24));
		lblNewLabel.setBounds(10, 11, 112, 27);
		add(lblNewLabel);
		
		JButton btnRegistrarAdocao = new JButton("");
		btnRegistrarAdocao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaRegistroRecursos telaRecurso = new TelaRegistroRecursos();
				telaRecurso.setVisible(true);
			}
		});
		URL imgURL1 = getClass().getResource("/imagens/mais.png");
        URL imgURL2 = getClass().getResource("/imagens/racao-para-animais-de-estimacao1.png");
        ImageIcon imgMais = new ImageIcon(imgURL1);
        ImageIcon imgRacao = new ImageIcon(imgURL2);
		
        //Adicionar ícones ao botão
        JLabel iconMais = new JLabel(imgMais);
        JLabel iconRacao = new JLabel(imgRacao);
        
        iconMais.setBounds(5, 5, 32, 32);
        iconRacao.setBounds(45, 5, 32, 32);

        btnRegistrarAdocao.setLayout(null);
        btnRegistrarAdocao.add(iconMais);
        btnRegistrarAdocao.add(iconRacao);
		
		
		btnRegistrarAdocao.setBounds(812, 11, 82, 46);;
		add(btnRegistrarAdocao);
		
	}

}
