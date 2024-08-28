package br.edu.ifpe.discente.PetLife.ui;

import java.awt.BorderLayout;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.edu.ifpe.discente.PetLife.business.RecursosService;
import br.edu.ifpe.discente.PetLife.ui.entities.Animais;

public class TabelaGastos extends JPanel {
	private JTable tabela;
	private DefaultTableModel modelo;

	 public TabelaGastos(List<Animais> listaDeAnimais) {
	    	
	      
	        setLayout(new BorderLayout());   
	        String[] colunas = {"Nome", "Gastos (R$)"};
	        modelo = new DefaultTableModel(colunas, 0);
	        tabela = new JTable(modelo);
	        
	     // Configura a tabela para redimensionar as colunas automaticamente
	        tabela.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
	        tabela.setEnabled(false);
	        
	        // Adicionar rolagem a tabela
	        JScrollPane rolagem = new JScrollPane(tabela);
	        add(rolagem, BorderLayout.CENTER);

	        // Adicionar dados na tabela
	        RecursosService service = new RecursosService();
	        try {
				for (Animais animal : listaDeAnimais) {
				    Object[] linha = {
				    	animal.getNome(),
				    	service.totalGastosAnimal(animal)
				        
				    };
				    modelo.addRow(linha);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
	    }
	   public JTable getTabelaGastos() {
	        return tabela;
	    }
	    
	    public DefaultTableModel getModelo() {
	    	return modelo;
	    }

}
