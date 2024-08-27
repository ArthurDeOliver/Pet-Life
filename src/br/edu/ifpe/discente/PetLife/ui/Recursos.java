package br.edu.ifpe.discente.PetLife.ui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

import br.edu.ifpe.discente.PetLife.business.RecursosService;
import br.edu.ifpe.discente.PetLife.ui.entities.GraficoBarra;
import br.edu.ifpe.discente.PetLife.ui.exception.BusinessException;

import javax.swing.JScrollPane;

public class Recursos extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;

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
				TelaRegistroRecursos telaRecurso = new TelaRegistroRecursos();
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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(47, 111, 296, 291);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nome", "Custos"
			}
		));
		
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
		} catch (BusinessException | SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Erro ao adicionar gráfico", JOptionPane.ERROR_MESSAGE);
		}
	}
}
