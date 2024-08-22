package br.edu.ifpe.discente.PetLife.ui;

import java.awt.BorderLayout;
import java.util.List;
import javax.swing.JTable;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import br.edu.ifpe.discente.PetLife.ui.entities.Animais;

public class TabelaAdotaveis extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable tabelaAdotaveis;
    private DefaultTableModel modeloAdotaveis;

    public TabelaAdotaveis(List<Animais> listaDeAnimaisAptos) {
    	
   
        setLayout(new BorderLayout());

        
        String[] colunas = {"ID", "Nome", "Idade", "Tipo", "Raça"};
        modeloAdotaveis = new DefaultTableModel(colunas, 0);
        tabelaAdotaveis = new JTable(modeloAdotaveis);

        // Adicionar rolagem a tabela
        JScrollPane rolagem = new JScrollPane(tabelaAdotaveis);
        add(rolagem, BorderLayout.CENTER);

        // Adicionar dados na tabela
        for (Animais animal : listaDeAnimaisAptos) {
            Object[] linha = {
            	animal.getID(),
                animal.getNome(),
                animal.getIdade(),
                animal.getTipo(),
                animal.getRaca(),
            };
            modeloAdotaveis.addRow(linha);
        }
    }

    public JTable getTabela() {
        return tabelaAdotaveis;
    }
    
    public DefaultTableModel getModelo() {
    	return modeloAdotaveis;
    }
}


