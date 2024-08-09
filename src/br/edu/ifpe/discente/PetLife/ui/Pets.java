package br.edu.ifpe.discente.PetLife.ui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import br.edu.ifpe.discente.PetLife.business.AnimaisService;
import br.edu.ifpe.discente.PetLife.data.AnimaisRepository;
import br.edu.ifpe.discente.PetLife.ui.entities.Animais;

import javax.swing.JInternalFrame;
import javax.swing.JTable;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ScrollPaneConstants;

public class Pets extends JPanel {

    private static final long serialVersionUID = 1L;
    private JTable table;

   
    public Pets() {
        setLayout(null);
        
        // Carregar imagem no JPanel
        JLabel petsIcon = new JLabel(new ImageIcon(Pets.class.getResource("/Imagens/bicho-de-estimacao.png")));
        petsIcon.setBounds(63, 6, 46, 37);
        add(petsIcon);
        
        // Ação do botão para abrir a tela de cadastro
        JButton btnCadastroPet = new JButton("");
        btnCadastroPet.setHorizontalAlignment(SwingConstants.LEFT);
        btnCadastroPet.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TelaCadastroPet telaCadastroPet = new TelaCadastroPet();
                telaCadastroPet.setVisible(true);
            }
        });
        btnCadastroPet.setBounds(812, 11, 82, 46);

        // Carregar imagem
        URL imgURL1 = getClass().getResource("/Imagens/mais.png");
        URL imgURL2 = getClass().getResource("/Imagens/cachorrop.png");
        ImageIcon imgMais = new ImageIcon(imgURL1);
        ImageIcon imgPata = new ImageIcon(imgURL2);
        
        // Adicionar ícones ao botão
        JLabel iconMais = new JLabel(imgMais);
        JLabel iconPata = new JLabel(imgPata);
        
        iconMais.setBounds(5, 5, 32, 32);
        iconPata.setBounds(45, 5, 32, 32);

        btnCadastroPet.setLayout(null);
        btnCadastroPet.add(iconMais);
        btnCadastroPet.add(iconPata);
        
        add(btnCadastroPet);
        
        // Label escrito Pets
        JLabel petsLabel = new JLabel("Pets");
        petsLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
        petsLabel.setBounds(10, 11, 46, 27);
        add(petsLabel);
       

        
        // Iniciar tabela de animais
        
        TabelaAnimal tabelaAnimal;
        
        try {
        	AnimaisService servico = new AnimaisService();
            List<Animais> listaDeAnimais = servico.retornarAnimal();
            tabelaAnimal = new TabelaAnimal(listaDeAnimais); // adicionando a lista de animais na tabela
            
        } catch (SQLException e) {
            e.printStackTrace();
            tabelaAnimal = new TabelaAnimal(List.of()); // Cria uma tabela vazia se houver erro -- coloquei pra nao ficar vazio
        }
        
        
        JScrollPane scrollPaneAnimal = new JScrollPane(tabelaAnimal.getTabela());
        scrollPaneAnimal.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPaneAnimal.setBounds(76, 131, 309, 280); 

        add(scrollPaneAnimal); // adicionar a tabela
        
       
        
    
        //filtro de animais
        JComboBox comboBoxFiltro = new JComboBox();
        comboBoxFiltro.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		// vazio por enquanto
        	}
        });
        
        comboBoxFiltro.setModel(new DefaultComboBoxModel(new String[] {"Todos", "Cachorro ", "Gato"}));
        comboBoxFiltro.setBounds(270, 105, 115, 16);
        add(comboBoxFiltro);
        
        
        //botão editar
        JButton botaoEditarPets = new JButton("Editar");
        botaoEditarPets.setBounds(493, 391, 85, 21);
        add(botaoEditarPets);
        
        
        // botão excluir
        JButton botaoExcluirPets = new JButton("Excluir");
        botaoExcluirPets.setBounds(644, 391, 85, 21);
        add(botaoExcluirPets);

        
        //recarregar tabela -- precisa aprimorar isso aqui pois foi uma mini gambiarra
        JButton recarregarTabela = new JButton("🔄");
        recarregarTabela.setBackground(new Color(244, 255, 254));
        recarregarTabela.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		 TabelaAnimal tabelaAnimal;
       
        	        try {
        	        	AnimaisService servico = new AnimaisService();
        	            List<Animais> listaDeAnimais = servico.retornarAnimal();
        	            tabelaAnimal = new TabelaAnimal(listaDeAnimais);
        	        } catch (SQLException e1) {
        	            e1.printStackTrace();
        	            tabelaAnimal = new TabelaAnimal(List.of()); // mesma coisa lá de cima
        	        }
        	        
        	        JScrollPane barraDeRolagemAnimal = new JScrollPane(tabelaAnimal.getTabela());
        	        barraDeRolagemAnimal.setBounds(76, 131, 309, 280);
        	        add(barraDeRolagemAnimal);
        	}
        });
        recarregarTabela.setBounds(215, 105, 46, 16);
        add(recarregarTabela); // recarrega a tabela
    }
}
