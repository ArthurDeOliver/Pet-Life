package br.edu.ifpe.discente.PetLife.ui;

import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import java.net.URL;
import javax.swing.JList;

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
		
		JLabel petsHome = new JLabel("Últimos PETS cadastrados");
		petsHome.setFont(new Font("Tahoma", Font.BOLD, 14));
		petsHome.setBounds(65, 151, 192, 14);
		add(petsHome);
		
		JLabel adotadosHome = new JLabel("Últimos pets ADOTADOS");
		adotadosHome.setFont(new Font("Tahoma", Font.BOLD, 14));
		adotadosHome.setBounds(355, 145, 169, 27);
		add(adotadosHome);
		
		JLabel recursosHome = new JLabel("Últimos RECURSOS adicionados");
		recursosHome.setFont(new Font("Tahoma", Font.BOLD, 14));
		recursosHome.setBounds(617, 151, 231, 14);
		add(recursosHome);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Home.class.getResource("/Imagens/bicho-de-estimacao.png")));
		lblNewLabel_1.setBounds(145, 103, 32, 37);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Home.class.getResource("/Imagens/clinica-de-cuidado-de-animais-domesticos.png")));
		lblNewLabel_2.setBounds(423, 103, 32, 37);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(Home.class.getResource("/Imagens/racao-para-animais-de-estimacao1.png")));
		lblNewLabel_3.setBounds(713, 103, 39, 37);
		add(lblNewLabel_3);
		
		JList listaPetsHome = new JList();
		listaPetsHome.setBounds(65, 201, 192, 166);
		add(listaPetsHome);
		
		JList listaRecursosHome = new JList();
		listaRecursosHome.setBounds(636, 201, 192, 166);
		add(listaRecursosHome);
		
		JList listaAdotadosHome_1 = new JList();
		listaAdotadosHome_1.setBounds(343, 201, 192, 166);
		add(listaAdotadosHome_1);
		

		

        
		
	}
}
