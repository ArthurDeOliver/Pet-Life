package br.edu.ifpe.discente.PetLife.ui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import br.edu.ifpe.discente.PetLife.business.AnimaisService;
import br.edu.ifpe.discente.PetLife.ui.entities.Animais;
import javax.swing.JTable;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;


public class Pets extends JPanel {

    private static final long serialVersionUID = 1L;
    private JTable table;
    private JTextField textFieldNomePet;
    private JTextField textFieldTipoPet;
    private JTextField textFieldIdadePet;
    private JTextField textFieldRacaPet;
    private JTextField textFieldStatusPet;
    private List<Animais> listaDeAnimais;
    private JLabel labelFotoPet;
    private TabelaAnimal tabelaAnimal;
    


   
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
        petsLabel.setFont(new Font("JetBrains Mono", Font.PLAIN, 24));
        petsLabel.setBounds(10, 11, 56, 27);
        add(petsLabel);
       

        
     // Iniciar tabela de animais      
        try {
            AnimaisService servico = new AnimaisService();
            List<Animais> listaDeAnimais = servico.retornarAnimal();
            tabelaAnimal = new TabelaAnimal(listaDeAnimais);

            JTable tabela = tabelaAnimal.getTabela();
            tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

            tabela.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    int linhaSelecionada = tabela.getSelectedRow();

                    if (linhaSelecionada >= 0) {  // Verifica se alguma linha foi selecionada
                        String nomeAnimal = tabela.getValueAt(linhaSelecionada, 0).toString().trim();

                        Animais animalSelecionado = null;
                        for (Animais animal : listaDeAnimais) {
                            if (animal.getNome().equals(nomeAnimal)) {
                                animalSelecionado = animal;
                                break;
                            }
                        }

                        if (animalSelecionado != null) {
                            textFieldNomePet.setText(animalSelecionado.getNome());
                            textFieldTipoPet.setText(animalSelecionado.getTipo());
                            textFieldRacaPet.setText(animalSelecionado.getRaca());
                            textFieldIdadePet.setText(String.valueOf(animalSelecionado.getIdade()));
                            textFieldStatusPet.setText(animalSelecionado.getStatus());

                            ImageIcon foto = new ImageIcon(animalSelecionado.getFoto());
                            labelFotoPet.setIcon(foto);
                        }
                    }
                }
            });

            JScrollPane scrollPaneAnimal = new JScrollPane(tabela);
            scrollPaneAnimal.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
            scrollPaneAnimal.setBounds(76, 131, 309, 280);
            add(scrollPaneAnimal);

            // Filtro de animais
            JComboBox<String> comboBoxFiltro = new JComboBox<>();
            comboBoxFiltro.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                	List<Animais> listaFiltrada = new ArrayList<>();
                    String tipoSelecionado = (String) comboBoxFiltro.getSelectedItem();
                    DefaultTableModel modelo = tabelaAnimal.getModelo();
                    modelo.setRowCount(0); 

                    for (Animais animalLista : listaDeAnimais) {
                        if (tipoSelecionado.equals("Todos")) {
                        	listaFiltrada.addAll(listaDeAnimais);
                		    break;
                		} else if (animalLista.getTipo().equals(tipoSelecionado)) {
            	        	listaFiltrada.add(animalLista);
            	        }            	        		
                    }
                    		
                   	for (Animais animalFiltrado : listaFiltrada) {
                   	    modelo.addRow(new Object[]{ //colocndo anmais filtrados
                   	            animalFiltrado.getNome(),
                   	            animalFiltrado.getIdade(),
                   	            animalFiltrado.getTipo(),
                   	            animalFiltrado.getRaca(),
                   	            animalFiltrado.getRacao(),
                   	            animalFiltrado.getStatus(),
                   	            animalFiltrado.getVacina(),
                   	            animalFiltrado.getFoto()
                   	      });
                        }
                    
                }
            });

            comboBoxFiltro.setModel(new DefaultComboBoxModel<>(new String[]{"Todos", "Cachorro", "Gato"}));
            comboBoxFiltro.setBounds(270, 105, 115, 16);
            add(comboBoxFiltro);

        } catch (SQLException e) {
            e.printStackTrace();
            tabelaAnimal = new TabelaAnimal(List.of());
        }

        
        
        //botão editar
        JButton botaoEditarPets = new JButton("Editar");
        botaoEditarPets.setBounds(493, 426, 85, 21);
        add(botaoEditarPets);
        
        
        // botão excluir
        JButton botaoExcluirPets = new JButton("Excluir");
        botaoExcluirPets.setBounds(644, 426, 85, 21);
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
        add(recarregarTabela);
        
        JLabel labelImagemPet = new JLabel("Foto");
        labelImagemPet.setFont(new Font("Tahoma", Font.BOLD, 11));
        labelImagemPet.setBounds(582, 106, 46, 14);
        add(labelImagemPet);
        
        JLabel labelIdadePet = new JLabel("Idade");
        labelIdadePet.setFont(new Font("Tahoma", Font.BOLD, 11));
        labelIdadePet.setBounds(628, 288, 33, 27);
        add(labelIdadePet);
        
        JLabel labelNomePet = new JLabel("Nome");
        labelNomePet.setFont(new Font("Tahoma", Font.BOLD, 11));
        labelNomePet.setBounds(421, 288, 33, 27);
        add(labelNomePet);
        
        JLabel labelTipoPet = new JLabel("Tipo");
        labelTipoPet.setFont(new Font("Tahoma", Font.BOLD, 11));
        labelTipoPet.setBounds(421, 338, 33, 27);
        add(labelTipoPet);
        
        JLabel labelRacaPet = new JLabel("Raça");
        labelRacaPet.setFont(new Font("Tahoma", Font.BOLD, 11));
        labelRacaPet.setBounds(628, 338, 33, 27);
        add(labelRacaPet);
        
        JLabel labelStatusPet = new JLabel("Status");
        labelStatusPet.setFont(new Font("Tahoma", Font.BOLD, 11));
        labelStatusPet.setBounds(499, 384, 37, 27);
        add(labelStatusPet);
        
        textFieldNomePet = new JTextField();
        textFieldNomePet.setEditable(false);
        textFieldNomePet.setBounds(460, 288, 105, 27);
        add(textFieldNomePet);
        textFieldNomePet.setColumns(10);
        
        textFieldTipoPet = new JTextField();
        textFieldTipoPet.setEditable(false);
        textFieldTipoPet.setColumns(10);
        textFieldTipoPet.setBounds(460, 338, 105, 27);
        add(textFieldTipoPet);
        
        textFieldIdadePet = new JTextField();
        textFieldIdadePet.setEditable(false);
        textFieldIdadePet.setColumns(10);
        textFieldIdadePet.setBounds(667, 288, 105, 27);
        add(textFieldIdadePet);
        
        textFieldRacaPet = new JTextField();
        textFieldRacaPet.setEditable(false);
        textFieldRacaPet.setColumns(10);
        textFieldRacaPet.setBounds(667, 341, 105, 27);
        add(textFieldRacaPet);
        
        textFieldStatusPet = new JTextField();
        textFieldStatusPet.setEditable(false);
        textFieldStatusPet.setColumns(10);
        textFieldStatusPet.setBounds(546, 384, 105, 27);
        add(textFieldStatusPet);
        
        labelFotoPet = new JLabel("");
        labelFotoPet.setBounds(520, 131, 140, 140);
        add(labelFotoPet);
        

    }

}
