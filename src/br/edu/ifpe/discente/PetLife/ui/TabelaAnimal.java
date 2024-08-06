package br.edu.ifpe.discente.PetLife.ui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class TabelaAnimal extends JPanel {

    private JTable tabela;
    private DefaultTableModel modelo;

    public TabelaAnimal() {
    	
    
        // configurando a tabela
    	
        String[] colunas = {"Nome", "Tipo", "Status"};
        modelo = new DefaultTableModel(colunas, 1000);
        tabela = new JTable(modelo);
        

        // colocando uma rolagem na tabela
        JScrollPane rolagem = new JScrollPane(tabela);

    }

    public JTable getTabela() {
        return tabela;
    }
}
