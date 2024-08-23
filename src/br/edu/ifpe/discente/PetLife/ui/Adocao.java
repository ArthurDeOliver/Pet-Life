package br.edu.ifpe.discente.PetLife.ui;

import java.awt.Font;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;


import br.edu.ifpe.discente.PetLife.business.AdocaoService;
import br.edu.ifpe.discente.PetLife.business.AnimaisService;
import br.edu.ifpe.discente.PetLife.ui.entities.Adocoes;
import br.edu.ifpe.discente.PetLife.ui.entities.Animais;
import javax.swing.JScrollPane;
import br.edu.ifpe.discente.PetLife.ui.TabelaAdotaveis;

public class Adocao extends JPanel {

	private static final long serialVersionUID = 1L;
    private TabelaAdotaveis tabelaAnimaisAptos;
    private List<Animais> listaPetsAdotaveis;
    private List<Adocoes> listaPetsAdotados;
    TabelaAdocoes tabelaPetsAdotados;
	private Animais animalSelecionado;
	private int idPet;
	private String nomePet;
	private String tipoPet;

    
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
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBounds(10, 14, 84, 20);
		add(lblNewLabel);
		

		
		//Label para tabela de Pets para adoção
		JLabel lblPetsParaAdocao = new JLabel("Pets para adoção");
		lblPetsParaAdocao.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPetsParaAdocao.setBounds(32, 53, 182, 70);
		add(lblPetsParaAdocao);
		

		
		JButton btnRegistrarAdocao = new JButton("");
		btnRegistrarAdocao.setEnabled(false);
		btnRegistrarAdocao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (animalSelecionado != null) {
					TelaRegistroAdocao telaAdocao = new TelaRegistroAdocao(idPet, nomePet, tipoPet);
					telaAdocao.setVisible(true);
				}	
				}
				});
		add(btnRegistrarAdocao);
		

		
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
		 
		 
		//Criação da tabela de animais aptos
		 try {
	        	AnimaisService servico = new AnimaisService();
	        	listaPetsAdotaveis= servico.retornarAnimaisAptos();
	            tabelaAnimaisAptos = new TabelaAdotaveis(listaPetsAdotaveis); // adicionando a lista de animais aptos na tabela
	            
	            JTable tabelaAdotaveis = tabelaAnimaisAptos.getTabela();
	            tabelaAdotaveis.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				
	            tabelaAdotaveis.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent e) {
        	
						int linhaSelecionada = tabelaAdotaveis.getSelectedRow();

						if (linhaSelecionada >= 0) { 
							int idAnimal = (int) tabelaAdotaveis.getValueAt(linhaSelecionada, 0);

							animalSelecionado = null;
							for (Animais animal : listaPetsAdotaveis) {
								if (animal.getID() == idAnimal) {
									animalSelecionado = animal;
									break;
								}
							}

							if (animalSelecionado != null) {
		    					idPet = animalSelecionado.getID();
		    					nomePet = animalSelecionado.getNome();
								tipoPet= animalSelecionado.getTipo();
		    				
		    					btnRegistrarAdocao.setEnabled(true);
							}
							else {
								btnRegistrarAdocao.setEnabled(false);
							}
						}
					}
					
	            });
		 }
	          
	    catch (Exception e) {
	    	
	    }

        JScrollPane scrollPanePetsAdotaveis = new JScrollPane(tabelaAnimaisAptos.getTabela());
		scrollPanePetsAdotaveis.setBounds(32, 128, 310, 300);
		add(scrollPanePetsAdotaveis);
		
        
		
		//Label para tabela de Pets adotados
		JLabel lblPetsAdotados = new JLabel("Pets adotados");
		lblPetsAdotados.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPetsAdotados.setBounds(414, 58, 234, 60);
		add(lblPetsAdotados);
		
		//Criação da tabela de animais adotados
		 try {
		 	AdocaoService servicoAdotados = new AdocaoService();
        	listaPetsAdotados = servicoAdotados.listarAdocoes();
            tabelaPetsAdotados = new TabelaAdocoes(listaPetsAdotados); // adicionando a lista de animais aptos na tabela
            
            JTable tabelaAdotados = tabelaPetsAdotados.getTabela();
            tabelaAdotados.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            
            JScrollPane scrollPanePetsAdotados = new JScrollPane(tabelaPetsAdotados.getTabela());
            scrollPanePetsAdotados.setBounds(414, 128, 480, 300);
            add(scrollPanePetsAdotados);
	 
					
		} catch (Exception e) {

		}


}
}
