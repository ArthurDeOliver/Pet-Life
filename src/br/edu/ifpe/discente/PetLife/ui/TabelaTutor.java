package br.edu.ifpe.discente.PetLife.ui;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.edu.ifpe.discente.PetLife.ui.entities.Animais;
import br.edu.ifpe.discente.PetLife.ui.entities.Tutor;

public class TabelaTutor extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable tabela;
    private DefaultTableModel modelo;
 
    public TabelaTutor(List<Tutor> listaDeTutor) {
    	
        
        setLayout(new BorderLayout());

        
        
        String[] colunas = {"Nome", "CPF", "Endereço", "Telefone"};
        modelo = new DefaultTableModel(colunas, 0);
        tabela = new JTable(modelo);

        // Adicionar rolagem a tabela
        JScrollPane rolagem = new JScrollPane(tabela);
        add(rolagem, BorderLayout.CENTER);

        // Adicionar dados na tabela
        for (Tutor tutor : listaDeTutor) {
            Object[] linha = {
                tutor.getNome(),
                tutor.getCpf(),
                tutor.getEndereco(),
                tutor.getTelefone()
            };
            modelo.addRow(linha);
        }
    }

    public JTable getTabela() {
        return tabela;
    }
}

    
    
    
}