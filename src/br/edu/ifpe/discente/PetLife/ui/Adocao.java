package br.edu.ifpe.discente.PetLife.ui;

import java.awt.Font;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.awt.ComponentOrientation;
import javax.swing.JScrollPane;

public class Adocao extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public Adocao() {
		setLayout(null);
		
        URL imgURL = getClass().getResource("/Imagens/coracaom.png");
        ImageIcon icon = new ImageIcon(imgURL);
		JLabel adocaoIcon = new JLabel(icon);
		adocaoIcon.setBounds(90, 6, 46, 37);
		add(adocaoIcon);
		
		
		JLabel lblNewLabel = new JLabel("Adoção");
		lblNewLabel.setFont(new Font("JetBrains Mono", Font.PLAIN, 24));
		lblNewLabel.setBounds(10, 11, 84, 27);
		add(lblNewLabel);
		
		JButton btnRegistrarAdocao = new JButton("");
		btnRegistrarAdocao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaRegristroAdocao telaAdocao = new TelaRegristroAdocao();
				telaAdocao.setVisible(true);
			}
		});
		URL imgURL1 = getClass().getResource("/Imagens/mais.png");
        URL imgURL2 = getClass().getResource("/Imagens/pawprint2.png");
        ImageIcon imgMais = new ImageIcon(imgURL1);
        ImageIcon imgPata = new ImageIcon(imgURL2);
		
        //Adicionar ícones ao botão
        JLabel iconMais = new JLabel(imgMais);
        JLabel iconPata = new JLabel(imgPata);
        
        iconMais.setBounds(5, 5, 32, 32);
        iconPata.setBounds(45, 5, 32, 32);

        btnRegistrarAdocao.setLayout(null);
        btnRegistrarAdocao.add(iconMais);
        btnRegistrarAdocao.add(iconPata);
		
		
		btnRegistrarAdocao.setBounds(812, 11, 82, 46);;
		add(btnRegistrarAdocao);
		
		//Label para tabela de Pets para adoção
		JLabel lblPetsParaAdocao = new JLabel("Pets para adoção");
		lblPetsParaAdocao.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPetsParaAdocao.setBounds(54, 48, 182, 70);
		add(lblPetsParaAdocao);
		
		//Label para tabela de Pets adotados
		JLabel lblPetsAdotados = new JLabel("Pets adotados");
		lblPetsAdotados.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPetsAdotados.setBounds(444, 53, 234, 60);
		add(lblPetsAdotados);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(54, 158, 156, 229);
		add(scrollPane);
		
		table = new JTable();
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scrollPane.setViewportView(table);
		table.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
	}
}
