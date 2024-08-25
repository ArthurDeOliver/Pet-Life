package br.edu.ifpe.discente.PetLife.ui;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import br.edu.ifpe.discente.PetLife.ui.entities.Adocoes;

public class TabelaAdocoes extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static JTable tabela;
    private static DefaultTableModel modelo;
 
    public TabelaAdocoes(List<Adocoes> listaDeAdocoes) {
    	
        
        setLayout(new BorderLayout());


        String[] colunas = {"ID", "Nome pet", "Tipo Pet", "Tutor", "CPF", "Telefone" , "Endereço"};
        modelo = new DefaultTableModel(colunas, 0);
        tabela = new JTable(modelo);

        // Adicionar rolagem a tabela
        JScrollPane rolagem = new JScrollPane(tabela);
        add(rolagem, BorderLayout.CENTER);

        // Adicionar dados na tabela
        for (Adocoes adocao : listaDeAdocoes) {
            Object[] linha = {
            	adocao.getIdPet(),
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

    public static JTable getTabela() {
        return tabela;
    }
    public static DefaultTableModel getModelo() {
    	return modelo;
    }
}

    
    
    
