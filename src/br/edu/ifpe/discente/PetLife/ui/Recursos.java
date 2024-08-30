package br.edu.ifpe.discente.PetLife.ui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
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

import com.itextpdf.text.Document;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import br.edu.ifpe.discente.PetLife.business.AnimaisService;
import br.edu.ifpe.discente.PetLife.business.RecursosService;
import br.edu.ifpe.discente.PetLife.ui.entities.Animais;
import br.edu.ifpe.discente.PetLife.ui.entities.GraficoBarra;
import br.edu.ifpe.discente.PetLife.ui.exception.BusinessException;

import javax.swing.JScrollPane;

import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.FileOutputStream;
import java.awt.event.ItemEvent;

public class Recursos extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;
	TabelaGastos tabelaGastos;
	List<Animais> listaAnimais;
	JComboBox<String> comboBoxFiltro;
	GraficoBarra grafico;

	/**
	 * Create the panel.
	 */
	public Recursos() {
		setLayout(null);
		
		URL imgURL = getClass().getResource("/Imagens/estatisticas2.png");
        ImageIcon icon = new ImageIcon(imgURL);
		JLabel recursosIcon = new JLabel(icon);
		recursosIcon.setBounds(116, 6, 46, 37);
		add(recursosIcon);
		
		JLabel lblNewLabel = new JLabel("Recursos");
		lblNewLabel.setFont(new Font("DejaVu Sans", Font.PLAIN, 24));
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
		
		//Inialização da tabela de Gastos por Animal
		try {
			AnimaisService serviceAnimal = new AnimaisService();
			listaAnimais = serviceAnimal.retornarAnimal();
			tabelaGastos = new TabelaGastos(listaAnimais);
			add(tabelaGastos);
			tabelaGastos.setBounds(new Rectangle(41, 111, 302, 291));
			;
		} catch (BusinessException | SQLException e1) {
			 JOptionPane.showMessageDialog(null, "Erro ao inicializar tabela", "Erro", JOptionPane.ERROR_MESSAGE);
		}
		
		//Filtro de animais
		
		this.comboBoxFiltro = new JComboBox<>();
		comboBoxFiltro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				recarregarTabelaGastosPorTipo();
			}
			
			
		});
		comboBoxFiltro.setModel(new DefaultComboBoxModel(new String[] {"Todos", "Cachorro", "Gato"}));
		comboBoxFiltro.setBounds(228, 84, 115, 16);
		add(comboBoxFiltro);
		
		//Botão que vai extrair os relatórios
		
		JButton btnRelatorio = new JButton("Relatório");
		btnRelatorio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gerarPdf();
			}
		});
		btnRelatorio.setToolTipText("ListaRelatório");
		btnRelatorio.setBounds(231, 413, 112, 23);
		add(btnRelatorio);
		
		//Instanciamento do grafico
		
		RecursosService service = new RecursosService();
		try {
			this.grafico = service.criarGrafico();
			add(grafico);
		} catch (BusinessException | SQLException e) {
			 JOptionPane.showMessageDialog(null, "Erro ao inicializar gráficos", "Erro", JOptionPane.ERROR_MESSAGE);
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
				modelo.addRow(new Object[] { animal.getID(), animal.getNome(), service.totalGastosAnimal(animal)});
			}

		} catch (BusinessException | SQLException e) {
			 JOptionPane.showMessageDialog(null, "Erro ao recarregar tabela de gastos", "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}
	public void recarregarTabelaGastosPorTipo() {
		List<Animais> listaFiltrada = new ArrayList<>();
		DefaultTableModel modelo = tabelaGastos.getModelo();
		modelo.setRowCount(0);
		RecursosService service = new RecursosService();
		AnimaisService serviceAnimal = new AnimaisService();
		// Filtra a lista de animais
		if ("Todos".equals(comboBoxFiltro.getSelectedItem())) {
			recarregarTabelaGastos();
		} else {
			try {
				listaFiltrada = serviceAnimal.listarAnimaisTipo(String.valueOf(comboBoxFiltro.getSelectedItem()));
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}

		for (Animais animal : listaFiltrada) {
			try {
				modelo.addRow(new Object[] { // colocando animais filtrados
						animal.getID(), animal.getNome(), service.totalGastosAnimal(animal) });
			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage(), "Não foi possível filtrar a lista",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	private void gerarPdf() {
	    Document document = new Document();
	    try {
	        PdfWriter.getInstance(document, new FileOutputStream("RelatorioGastos.pdf"));
	        document.open();
	        
	        // Adiciona a data ao PDF
	        Date data = new Date();
	        DateFormat formatador = DateFormat.getDateInstance(DateFormat.FULL);
	        document.add(new Paragraph(formatador.format(data)));	       
	        
	        URL imgURL = getClass().getResource("/Imagens/estatisticas2.png");
	        com.itextpdf.text.Image image = com.itextpdf.text.Image.getInstance(imgURL);
	        image.setAlignment(com.itextpdf.text.Image.ALIGN_RIGHT);
	        image.scaleToFit(25, 25);
	        document.add(image);
	        
	        
	        com.itextpdf.text.Font fonteTitulo = FontFactory.getFont(FontFactory.HELVETICA, 22, Font.BOLD);
	        document.add(new Paragraph("Relatório de gastos: ", fonteTitulo));     
	        document.add(new Paragraph(" ")); // Adiciona uma linha em branco

	        // Cria uma tabela PDF com duas colunas
	        PdfPTable tabela = new PdfPTable(3);
	        tabela.addCell("ID");
	        tabela.addCell("Nome do Animal");
	        tabela.addCell("Gasto");
	        int id = 1;      //Setando o ID inicial
	        // Itera sobre o modelo da tabela e adiciona dados ao PDF
	        DefaultTableModel modelo = tabelaGastos.getModelo();
	        for (int i = 0; i < modelo.getRowCount(); i++) {
	            String nomeAnimal = (String) modelo.getValueAt(i, 1); // O 1 se refere a coluna 1(A de animal)
	            String gasto = modelo.getValueAt(i, 2).toString();    // O 2 se refere a coluna 2(A de gastos)

	           tabela.addCell(String.valueOf(id));
	            tabela.addCell(nomeAnimal);
	            tabela.addCell(gasto);
	            id++;             //Incrementação no número do ID
	        }

	        // Adiciona a tabela ao documento PDF
	        document.add(tabela);

	    } catch (Exception e) {
	        System.out.println(e);
	    } finally {
	        document.close();
	    }

	    // Abrir o PDF no leitor padrão do sistema
	    try {
	        Desktop.getDesktop().open(new File("RelatorioGastos.pdf"));
	    } catch (Exception e2) {
	        System.out.println(e2);
	    }
	}

	
	
	public JComboBox retornarComboBoxFiltro() {
		return this.comboBoxFiltro;
	}
	public void atualizarGrafico() {
		RecursosService service = new RecursosService();
		try {
			double totalRacoes = service.retornarTotalRacoes();
			double totalMedicamentos = service.retornarTotalMedicamentos();
			double totalVacinas = service.retornarTotalVacinas();
			double totalRecursos = totalRacoes + totalMedicamentos + totalVacinas;
			grafico.atualizarGrafico(totalRacoes, totalMedicamentos, totalVacinas, totalRecursos);
		} catch (SQLException | BusinessException e) {
			
		}
	}
}
