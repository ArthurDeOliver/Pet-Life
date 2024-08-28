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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

import br.edu.ifpe.discente.PetLife.business.AnimaisService;
import br.edu.ifpe.discente.PetLife.business.RecursosService;
import br.edu.ifpe.discente.PetLife.ui.entities.Animais;
import br.edu.ifpe.discente.PetLife.ui.entities.GraficoBarra;
import br.edu.ifpe.discente.PetLife.ui.exception.BusinessException;

import javax.swing.JScrollPane;
import java.awt.Dimension;
import java.awt.Rectangle;

public class Recursos extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;
	TabelaGastos tabelaGastos;
	List<Animais> listaAnimais;

	/**
	 * Create the panel.
	 */
	public Recursos() {
		setLayout(null);
		
		URL imgURL = getClass().getResource("/Imagens/estatisticas2.png");
        ImageIcon icon = new ImageIcon(imgURL);
		JLabel recursosIcon = new JLabel(icon);
		recursosIcon.setBounds(121, 6, 46, 37);
		add(recursosIcon);
		
		JLabel lblNewLabel = new JLabel("Recursos");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBounds(10, 11, 112, 27);
		add(lblNewLabel);
		
		JButton btnRegistrarRecurso = new JButton("");
		btnRegistrarRecurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaRegistroRecursos telaRecurso = new TelaRegistroRecursos(Recursos.this);
				telaRecurso.setVisible(true);				
			}
		});
		URL imgURL1 = getClass().getResource("/Imagens/mais.png");
        URL imgURL2 = getClass().getResource("/Imagens/racao-para-animais-de-estimacao1.png");
        ImageIcon imgMais = new ImageIcon(imgURL1);
        ImageIcon imgRacao = new ImageIcon(imgURL2);
		
        //Adicionar ícones ao botão
        JLabel iconMais = new JLabel(imgMais);
        JLabel iconRacao = new JLabel(imgRacao);
        
        
        iconMais.setBounds(5, 5, 32, 32);
        iconRacao.setBounds(45, 5, 32, 32);

        btnRegistrarRecurso.setLayout(null);
        btnRegistrarRecurso.add(iconMais);
        btnRegistrarRecurso.add(iconRacao);
		
		
		btnRegistrarRecurso.setBounds(812, 11, 82, 46);;
		add(btnRegistrarRecurso);
		
		//Aqui vai ter as coisas da tabela
		try {
			AnimaisService serviceAnimal = new AnimaisService();
			listaAnimais = serviceAnimal.retornarAnimal();
		} catch (BusinessException | SQLException e1) {
			e1.printStackTrace();
		}
		
		//Filtro de animais
		
		JComboBox comboBoxFiltro = new JComboBox();
		comboBoxFiltro.setModel(new DefaultComboBoxModel(new String[] {"Todos", "Cachorro", "Gato"}));
		comboBoxFiltro.setBounds(228, 84, 115, 16);
		add(comboBoxFiltro);
		
		//Botão que vai extrair os relatórios
		
		JButton btnRelatorio = new JButton("Relatório");
		btnRelatorio.setBounds(231, 413, 112, 23);
		add(btnRelatorio);
		
		//Instanciamento do grafico
		
		RecursosService service = new RecursosService();
		try {
			GraficoBarra grafico = service.criarGrafico();
			add(grafico);
			tabelaGastos = new TabelaGastos(listaAnimais);
			add(tabelaGastos);
			tabelaGastos.setBounds(new Rectangle(41, 111, 302, 291));
			;
		} catch (BusinessException | SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Erro ao adicionar gráfico", JOptionPane.ERROR_MESSAGE);
		}
	}
	public void recarregarTabelaGastos() {
		try {
			AnimaisService servico = new AnimaisService();
			List<Animais> listaPets = servico.retornarAnimal();


			// Atualizar o modelo da tabela
			DefaultTableModel modelo = tabelaGastos.getModelo();
			modelo.setRowCount(0); // Limpar o modelo atual
			RecursosService service = new RecursosService();
			for (Animais animal : listaPets) {
				modelo.addRow(new Object[] { animal.getNome(), service.totalGastosAnimal(animal)});
			}

		} catch (BusinessException | SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Erro ao recarregar a tabela de Gastos por Animal",
					JOptionPane.ERROR_MESSAGE);
		}
	}
}
