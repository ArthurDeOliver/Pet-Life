package br.edu.ifpe.discente.PetLife.ui;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.edu.ifpe.discente.PetLife.ui.entities.Animais;
import br.edu.ifpe.discente.PetLife.ui.entities.Adocoes;

public class TabelaAdocoes extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable tabela;
    private DefaultTableModel modelo;
 
    public TabelaAdocoes(List<Adocoes> listaDeAdocoes) {
    	
        
        setLayout(new BorderLayout());


        String[] colunas = {"Nome", "CPF", "Endereço", "Telefone"};
        modelo = new DefaultTableModel(colunas, 0);
        tabela = new JTable(modelo);

        // Adicionar rolagem a tabela
        JScrollPane rolagem = new JScrollPane(tabela);
        add(rolagem, BorderLayout.CENTER);

        // Adicionar dados na tabela
        for (Adocoes adocao : listaDeAdocoes) {
            Object[] linha = {
            	adocao.getNomePet(),
            	adocao.getTipoPet(),
            	adocao.getNomeTutor(),
            	adocao.getCpf(),
                adocao.getTelefone(),
                adocao.getEndereco()
            };
            modelo.addRow(linha);
        }
    }

    public JTable getTabela() {
        return tabela;
    }
}

    
    
    
