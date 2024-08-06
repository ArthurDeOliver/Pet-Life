package br.edu.ifpe.discente.PetLife.ui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.JInternalFrame;
import javax.swing.JTable;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Pets extends JPanel {

    private static final long serialVersionUID = 1L;
    private JTable table;

    /**
     * Create the panel.
     */
    public Pets() {
        setLayout(null);
        
        // Carregar imagem no JPanel
        JLabel petsIcon = new JLabel(new ImageIcon(Pets.class.getResource("/Imagens/bicho-de-estimacao (1).png")));
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
        URL imgURL2 = getClass().getResource("/Imagens/cachorro (2).png");
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
        
        TabelaAnimal tabelaAnimal = new TabelaAnimal();
        JScrollPane barraDeRolagemAnimal = new JScrollPane(tabelaAnimal.getTabela());
        
        barraDeRolagemAnimal.setBounds(35, 135, 309, 280);
        
        
        add(barraDeRolagemAnimal);
        
        JComboBox comboBoxFiltro = new JComboBox();
        comboBoxFiltro.setModel(new DefaultComboBoxModel(new String[] {"Todos", "Cachorro ", "Gato"}));
        comboBoxFiltro.setBounds(229, 109, 115, 16);
        add(comboBoxFiltro);
        
        JButton botaoEditarPets = new JButton("Editar");
        botaoEditarPets.setBounds(437, 394, 85, 21);
        add(botaoEditarPets);
        
        JButton botaoExcluirPets = new JButton("Excluir");
        botaoExcluirPets.setBounds(605, 394, 85, 21);
        add(botaoExcluirPets);
    
    }
}
