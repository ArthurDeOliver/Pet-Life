package br.edu.ifpe.discente.PetLife.ui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;
import java.util.List;
import br.edu.ifpe.discente.PetLife.ui.entities.Animais;

public class TabelaAnimal extends JPanel {

	private JTable tabela;
	private DefaultTableModel modelo;

	public TabelaAnimal(List<Animais> listaDeAnimais) {

		setLayout(new BorderLayout());

		String[] colunas = { "ID", "Nome", "Tipo" };
		modelo = new DefaultTableModel(colunas, 0);
		tabela = new JTable(modelo);

		// Adicionar rolagem a tabela
		JScrollPane rolagem = new JScrollPane(tabela);
		add(rolagem, BorderLayout.CENTER);

		// Adicionar dados na tabela
		for (Animais animal : listaDeAnimais) {
			Object[] linha = { animal.getID(), animal.getNome(), animal.getTipo(), };
			modelo.addRow(linha);
		}
	}

	public JTable getTabela() {
		return tabela;
	}

	public DefaultTableModel getModelo() {
		return modelo;
	}

}