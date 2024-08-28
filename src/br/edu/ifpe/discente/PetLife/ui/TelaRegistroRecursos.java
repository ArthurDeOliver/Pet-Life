package br.edu.ifpe.discente.PetLife.ui;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.edu.ifpe.discente.PetLife.business.AnimaisService;
import br.edu.ifpe.discente.PetLife.business.RecursosService;
import br.edu.ifpe.discente.PetLife.ui.entities.Animais;
import br.edu.ifpe.discente.PetLife.ui.entities.Medicamentos;
import br.edu.ifpe.discente.PetLife.ui.entities.Racoes;
import br.edu.ifpe.discente.PetLife.ui.entities.Vacinas;
import br.edu.ifpe.discente.PetLife.ui.exception.BusinessException;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.KeyStroke;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.Box;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class TelaRegistroRecursos extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private CardLayout cl_telaRegistrar;
	private JTextField textFieldNomeMedicamentoNovo;
	private JTextField textFieldMarcaRacaoNova;
	private JTextField textFieldVacinaNova;
	private JTextField textFieldQuantidade;
	private JTextField textFieldQuantidadeMedicamento;
	private JTextField textFieldQuantidadeRacao;
	private JTextField textFieldQuantidadeMedicamentoNovo;
	private JTextField textFieldQuantidadeRacaoNova;
	private JTextField textFieldQuantidadeVacinaNova;
	private JTextField textFieldValorMedicamentoNovo;
	private JTextField textFieldValorMedicamento;
	private JTextField textFieldValorRacao;
	private JTextField textFieldValorRacaoNova;
	private JTextField textFieldValorVacinaNova;
	private CardLayout cl_panelMudar;
	private Recursos recursosWindow;
	private JLabel lblVacina;
	private JLabel lblQuantidadeVacina;
	private JLabel lblValorVacina;
	private JButton btnRegistrarVacina;
	private JLabel lblValorMedicamento;
	private JLabel lblQuantidadeMedicamente;
	private JButton btnRegistrarMedicamentoNovo;
	private JTextField textFieldNomeMedicamento;
	private JTextField textFieldNomeMarcaRacao;
	private JTextField textFieldNomeVacina;

	public TelaRegistroRecursos(Recursos recursosWindow) {
		this.recursosWindow = recursosWindow;
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 580, 455);
		JPanel telaPrincipalRecursos = new JPanel();
		telaPrincipalRecursos.setBackground(new Color(6, 26, 53));
		telaPrincipalRecursos.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(telaPrincipalRecursos);
		telaPrincipalRecursos.setLayout(null);

		JPanel containerLabelRegistroRecursos = new JPanel();
		containerLabelRegistroRecursos.setBounds(10, 11, 544, 42);
		telaPrincipalRecursos.add(containerLabelRegistroRecursos);

		JLabel labelRegistroRecursos = new JLabel("Registro de recursos");
		labelRegistroRecursos.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelRegistroRecursos.setIcon(
				new ImageIcon(TelaRegistroAdocao.class.getResource("/Imagens/racao-para-animais-de-estimacao.png")));
		containerLabelRegistroRecursos.add(labelRegistroRecursos);

		cl_telaRegistrar = new CardLayout();

		JPanel telaRegistrar = new JPanel(cl_telaRegistrar);
		JButton btnEstoque = new JButton("Estoque");

		btnEstoque.setBounds(10, 64, 251, 42);
		btnEstoque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl_telaRegistrar.show(telaRegistrar, "telaEstoque");
			}
		});
		btnEstoque.setFont(new Font("Tahoma", Font.PLAIN, 16));
		telaPrincipalRecursos.add(btnEstoque);

		JButton btnMedicamentos = new JButton("Medicamentos/Vacinas");
		btnMedicamentos.setBounds(297, 64, 257, 42);
		telaPrincipalRecursos.add(btnMedicamentos);
		btnMedicamentos.setFont(new Font("Tahoma", Font.PLAIN, 16));

		telaRegistrar.setBounds(10, 117, 544, 288);
		telaRegistrar.setBackground(new Color(6, 26, 53));
		telaPrincipalRecursos.add(telaRegistrar);

		JPanel homeTelaRegistrar = new JPanel();
		telaRegistrar.add(homeTelaRegistrar, "home");
		homeTelaRegistrar.setBackground(new Color(6, 26, 53));
		homeTelaRegistrar.setLayout(null);

		JPanel telaEstoque = new JPanel();
		telaRegistrar.add(telaEstoque, "telaEstoque");
		telaEstoque.setBackground(new Color(6, 26, 53));
		telaEstoque.setLayout(null);

		cl_panelMudar = new CardLayout();
		JPanel panelMudar = new JPanel(cl_panelMudar);
		panelMudar.setLocation(0, 59);
		panelMudar.setSize(544, 229);
		telaEstoque.add(panelMudar);
		panelMudar.setLayout(cl_panelMudar);

		JComboBox comboBoxEstoque = new JComboBox();
		comboBoxEstoque.setFont(new Font("Tahoma", Font.BOLD, 14));
		comboBoxEstoque.setModel(new DefaultComboBoxModel(
				new String[] { "Novo Medicamento", "Nova Ração", "Nova Vacina", "Medicamentos", "Rações", "Vacinas" }));
		comboBoxEstoque.setBounds(188, 11, 128, 22);
		telaEstoque.add(comboBoxEstoque);

		JPanel panelNovoMedicamento = new JPanel();
		panelNovoMedicamento.setBounds(0, 0, 544, 229);
		panelMudar.add(panelNovoMedicamento, "Novo Medicamento");
		panelNovoMedicamento.setLayout(null);

		JLabel lblNomeMedicamentoNovo = new JLabel("Nome Medicamento");
		lblNomeMedicamentoNovo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNomeMedicamentoNovo.setBounds(188, 25, 138, 21);
		panelNovoMedicamento.add(lblNomeMedicamentoNovo);

		textFieldNomeMedicamentoNovo = new JTextField();
		textFieldNomeMedicamentoNovo.addKeyListener(new KeyAdapter() {

			// Limita o tamanho do texto digitado

			public void keyTyped(KeyEvent e) {
				if (textFieldNomeMedicamentoNovo.getText().length() > 20) {
					e.consume();
				}

				if (Character.isDigit(e.getKeyChar())) {
					e.consume();
				}
			}
		});

		textFieldNomeMedicamentoNovo.setBounds(169, 50, 173, 20);
		panelNovoMedicamento.add(textFieldNomeMedicamentoNovo);
		textFieldNomeMedicamentoNovo.setColumns(10);
		// Impede o uso do CTRL + V
		textFieldNomeMedicamentoNovo.getInputMap().put(KeyStroke.getKeyStroke("control V"), "none");

		JLabel lblQuantidadeMedicamentoNovo = new JLabel("Quantidade");
		lblQuantidadeMedicamentoNovo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblQuantidadeMedicamentoNovo.setBounds(211, 80, 86, 17);
		panelNovoMedicamento.add(lblQuantidadeMedicamentoNovo);

		textFieldQuantidadeMedicamentoNovo = new JTextField();
		// Impede o uso do CTRL + V

		textFieldQuantidadeMedicamentoNovo.getInputMap().put(KeyStroke.getKeyStroke("control V"), "none");
		textFieldQuantidadeMedicamentoNovo.addKeyListener(new KeyAdapter() {

			// Permite apenas a digitação de números e limita a quantidade de caracteres
			// digitados

			public void keyTyped(KeyEvent e) {
				String caracteres = "0123456789";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}

				if (textFieldQuantidadeMedicamentoNovo.getText().length() > 10) {
					e.consume();
				}

			}
		});

		textFieldQuantidadeMedicamentoNovo.setBounds(169, 108, 173, 20);
		panelNovoMedicamento.add(textFieldQuantidadeMedicamentoNovo);
		textFieldQuantidadeMedicamentoNovo.setColumns(10);

		JLabel lblValorMedicamentoNovo = new JLabel("Valor (Unitário)");
		lblValorMedicamentoNovo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblValorMedicamentoNovo.setBounds(203, 139, 110, 14);
		panelNovoMedicamento.add(lblValorMedicamentoNovo);

		textFieldValorMedicamentoNovo = new JTextField();

		// Impede o uso do CTRL + V
		textFieldValorMedicamentoNovo.getInputMap().put(KeyStroke.getKeyStroke("control V"), "none");
		textFieldValorMedicamentoNovo.addKeyListener(new KeyAdapter() {

			// Permite apenas a digitação de números e limita a quantidade de caracteres
			// digitados

			public void keyTyped(KeyEvent e) {
				String caracteres = "0123456789.";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}

				if (textFieldValorMedicamentoNovo.getText().length() > 10) {
					e.consume();
				}

			}
		});
		textFieldValorMedicamentoNovo.setBounds(169, 164, 173, 20);
		panelNovoMedicamento.add(textFieldValorMedicamentoNovo);
		textFieldValorMedicamentoNovo.setColumns(10);

		btnRegistrarMedicamentoNovo = new JButton("Registrar");

		btnRegistrarMedicamentoNovo.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnRegistrarMedicamentoNovo.setBounds(417, 179, 105, 30);
		panelNovoMedicamento.add(btnRegistrarMedicamentoNovo);

		JPanel panelNovaRacao = new JPanel();
		panelNovaRacao.setBounds(0, 0, 544, 229);
		panelMudar.add(panelNovaRacao, "Nova Ração");
		panelNovaRacao.setLayout(null);

		JLabel lblMarcaRacaoNova = new JLabel("Marca da Ração");
		lblMarcaRacaoNova.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMarcaRacaoNova.setBounds(188, 25, 138, 21);
		panelNovaRacao.add(lblMarcaRacaoNova);

		JTextField textFieldMarcaRacaoNova = new JTextField();

		// Limita a quantidade de caracteres digitados

		textFieldMarcaRacaoNova.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				if (textFieldMarcaRacaoNova.getText().length() > 20) {
					e.consume();
				}

				if (Character.isDigit(e.getKeyChar())) {
					e.consume();
				}
			}
		});
		textFieldMarcaRacaoNova.getInputMap().put(KeyStroke.getKeyStroke("control V"), "none");
		textFieldMarcaRacaoNova.setBounds(169, 50, 173, 20);
		panelNovaRacao.add(textFieldMarcaRacaoNova);
		textFieldMarcaRacaoNova.setColumns(10);

		JLabel lblQuantidadeRacaoNova = new JLabel("Quantidade (KG)");
		lblQuantidadeRacaoNova.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblQuantidadeRacaoNova.setBounds(188, 80, 131, 17);
		panelNovaRacao.add(lblQuantidadeRacaoNova);

		JTextField textFieldQuantidadeRacaoNova = new JTextField();
		textFieldQuantidadeRacaoNova.getInputMap().put(KeyStroke.getKeyStroke("control V"), "none");
		textFieldQuantidadeRacaoNova.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				String caracteres = "0123456789.";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}

				if (textFieldQuantidadeRacaoNova.getText().length() > 10) {
					e.consume();
				}
			}
		});
		textFieldQuantidadeRacaoNova.setBounds(169, 108, 173, 20);
		panelNovaRacao.add(textFieldQuantidadeRacaoNova);
		textFieldQuantidadeRacaoNova.setColumns(10);

		JLabel lblValorRacaoNova = new JLabel("Valor");
		lblValorRacaoNova.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblValorRacaoNova.setBounds(232, 139, 42, 14);
		panelNovaRacao.add(lblValorRacaoNova);

		JTextField textFieldValorRacaoNova = new JTextField();
		textFieldValorRacaoNova.getInputMap().put(KeyStroke.getKeyStroke("control V"), "none");
		textFieldValorRacaoNova.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				String caracteres = "0123456789.";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}

				if (textFieldValorRacaoNova.getText().length() > 10) {
					e.consume();
				}

			}
		});
		textFieldValorRacaoNova.setBounds(169, 164, 173, 20);
		panelNovaRacao.add(textFieldValorRacaoNova);
		textFieldValorRacaoNova.setColumns(10);

		JButton btnRegistrarRacaoNova = new JButton("Registrar");

		btnRegistrarRacaoNova.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnRegistrarRacaoNova.setBounds(417, 179, 105, 30);
		panelNovaRacao.add(btnRegistrarRacaoNova);

		JPanel panelNovaVacina = new JPanel();
		panelNovaVacina.setBounds(0, 0, 544, 229);
		panelMudar.add(panelNovaVacina, "Nova Vacina");
		panelNovaVacina.setLayout(null);

		JLabel lblVacinaNova = new JLabel("Vacina");
		lblVacinaNova.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblVacinaNova.setBounds(227, 22, 45, 21);
		panelNovaVacina.add(lblVacinaNova);

		JTextField textFieldVacinaNova = new JTextField();
		textFieldVacinaNova.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				if (textFieldVacinaNova.getText().length() > 20) {
					e.consume();
				}

				if (Character.isDigit(e.getKeyChar())) {
					e.consume();
				}
			}
		});
		textFieldVacinaNova.getInputMap().put(KeyStroke.getKeyStroke("control V"), "none");
		textFieldVacinaNova.setBounds(169, 50, 173, 20);
		panelNovaVacina.add(textFieldVacinaNova);
		textFieldVacinaNova.setColumns(10);

		JLabel lblQuantidadeVacinaNova = new JLabel("Quantidade");
		lblQuantidadeVacinaNova.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblQuantidadeVacinaNova.setBounds(211, 80, 86, 17);
		panelNovaVacina.add(lblQuantidadeVacinaNova);

		JTextField textFieldQuantidadeVacinaNova = new JTextField();
		textFieldQuantidadeVacinaNova.getInputMap().put(KeyStroke.getKeyStroke("control V"), "none");
		textFieldQuantidadeVacinaNova.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				String caracteres = "0123456789";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}

				if (textFieldQuantidadeVacinaNova.getText().length() > 10) {
					e.consume();
				}
			}
		});
		textFieldQuantidadeVacinaNova.setBounds(169, 108, 173, 20);
		panelNovaVacina.add(textFieldQuantidadeVacinaNova);
		textFieldQuantidadeVacinaNova.setColumns(10);

		JLabel lblValorVacinaNova = new JLabel("Valor (Unitário)");
		lblValorVacinaNova.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblValorVacinaNova.setBounds(202, 139, 110, 14);
		panelNovaVacina.add(lblValorVacinaNova);

		JTextField textFieldValorVacinaNova = new JTextField();
		textFieldValorVacinaNova.getInputMap().put(KeyStroke.getKeyStroke("control V"), "none");
		textFieldValorVacinaNova.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				String caracteres = "0123456789.";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}

				if (textFieldValorVacinaNova.getText().length() > 10) {
					e.consume();
				}
			}
		});
		textFieldValorVacinaNova.setBounds(169, 164, 173, 20);
		panelNovaVacina.add(textFieldValorVacinaNova);
		textFieldValorVacinaNova.setColumns(10);

		JButton btnRegistrarVacinaNova = new JButton("Registrar");
		btnRegistrarVacinaNova.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnRegistrarVacinaNova.setBounds(417, 179, 105, 30);
		panelNovaVacina.add(btnRegistrarVacinaNova);

		JPanel panelMedicamento = new JPanel();
		panelMudar.add(panelMedicamento, "Medicamentos");

		JScrollPane scrollPaneMedicamento = new JScrollPane();
		scrollPaneMedicamento.setBounds(150, 11, 210, 24);
		panelMedicamento.add(scrollPaneMedicamento);

		JComboBox comboBoxMedicamento = new JComboBox();
		scrollPaneMedicamento.setViewportView(comboBoxMedicamento);

		JLabel lblQuantidadeMedicamento = new JLabel("Quantidade");
		lblQuantidadeMedicamento.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblQuantidadeMedicamento.setBounds(211, 100, 86, 17);
		panelMedicamento.add(lblQuantidadeMedicamento);

		JTextField textFieldQuantidadeMedicamento = new JTextField();
		textFieldQuantidadeMedicamento.getInputMap().put(KeyStroke.getKeyStroke("control V"), "none");
		textFieldQuantidadeMedicamento.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				String caracteres = "0123456789";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}

				if (textFieldQuantidadeMedicamento.getText().length() > 10) {
					e.consume();
				}
			}

		});
		textFieldQuantidadeMedicamento.setBounds(150, 128, 210, 20);
		panelMedicamento.add(textFieldQuantidadeMedicamento);
		textFieldQuantidadeMedicamento.setColumns(10);

		JLabel lblValorMedicamento = new JLabel("Valor (Unitário)");
		lblValorMedicamento.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblValorMedicamento.setBounds(202, 159, 106, 14);
		panelMedicamento.add(lblValorMedicamento);

		JTextField textFieldValorMedicamento = new JTextField();
		textFieldValorMedicamento.getInputMap().put(KeyStroke.getKeyStroke("control V"), "none");
		textFieldValorMedicamento.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				String caracteres = "0123456789. ";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}

				if (textFieldValorMedicamento.getText().length() > 10) {
					e.consume();
				}
			}
		});
		textFieldValorMedicamento.setBounds(150, 184, 210, 20);
		panelMedicamento.add(textFieldValorMedicamento);
		textFieldValorMedicamento.setColumns(10);

		JButton btnAdicionarMedicamento = new JButton("Adicionar");
		btnAdicionarMedicamento.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAdicionarMedicamento.setBounds(417, 179, 105, 30);
		panelMedicamento.add(btnAdicionarMedicamento);
		panelMedicamento.setLayout(null);

		JPanel panelRacao = new JPanel();
		panelMudar.add(panelRacao, "Rações");
		panelRacao.setLayout(null);

		JScrollPane scrollPaneRacao = new JScrollPane();
		scrollPaneRacao.setBounds(150, 11, 210, 24);
		panelRacao.add(scrollPaneRacao);

		JComboBox comboBoxRacao = new JComboBox();

		JLabel lblNomeMedicamento = new JLabel(" Nome");
		lblNomeMedicamento.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNomeMedicamento.setBounds(224, 46, 51, 17);
		panelMedicamento.add(lblNomeMedicamento);

		textFieldNomeMedicamento = new JTextField();
		textFieldNomeMedicamento.setBounds(150, 69, 210, 20);
		panelMedicamento.add(textFieldNomeMedicamento);
		textFieldNomeMedicamento.setColumns(10);
		textFieldNomeMedicamento.getInputMap().put(KeyStroke.getKeyStroke("control V"), "none");
		textFieldNomeMedicamento.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				if (textFieldNomeMedicamento.getText().length() > 20) {
					e.consume();
				}

				if (Character.isDigit(e.getKeyChar())) {
					e.consume();
				}
			}
		});
		scrollPaneRacao.setViewportView(comboBoxRacao);

		JLabel lblNomeMarcaRacao = new JLabel("Nome");
		lblNomeMarcaRacao.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNomeMarcaRacao.setBounds(224, 46, 51, 17);
		panelRacao.add(lblNomeMarcaRacao);

		textFieldNomeMarcaRacao = new JTextField();
		textFieldNomeMarcaRacao.setBounds(150, 69, 210, 20);
		panelRacao.add(textFieldNomeMarcaRacao);
		textFieldNomeMarcaRacao.getInputMap().put(KeyStroke.getKeyStroke("control V"), "none");
		textFieldNomeMarcaRacao.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				if (textFieldNomeMarcaRacao.getText().length() > 20) {
					e.consume();
				}

				if (Character.isDigit(e.getKeyChar())) {
					e.consume();
				}
			}
		});
		textFieldNomeMarcaRacao.setColumns(10);

		JLabel lblQuantidadeRacao = new JLabel("Quantidade");
		lblQuantidadeRacao.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblQuantidadeRacao.setBounds(211, 100, 86, 17);
		panelRacao.add(lblQuantidadeRacao);

		JTextField textFieldQuantidadeRacao = new JTextField();
		textFieldQuantidadeRacao.getInputMap().put(KeyStroke.getKeyStroke("control V"), "none");
		textFieldQuantidadeRacao.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				String caracteres = "0123456789.";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}

				if (textFieldQuantidadeRacao.getText().length() > 10) {
					e.consume();
				}
			}
		});
		textFieldQuantidadeRacao.setBounds(150, 128, 210, 20);
		panelRacao.add(textFieldQuantidadeRacao);
		textFieldQuantidadeRacao.setColumns(10);

		JLabel lblValorRacao = new JLabel("Valor");
		lblValorRacao.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblValorRacao.setBounds(233, 159, 42, 14);
		panelRacao.add(lblValorRacao);

		JTextField textFieldValorRacao = new JTextField();
		textFieldValorRacao.getInputMap().put(KeyStroke.getKeyStroke("control V"), "none");
		textFieldValorRacao.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				String caracteres = "0123456789.";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}

				if (textFieldValorRacao.getText().length() > 10) {
					e.consume();
				}

			}
		});
		textFieldValorRacao.setBounds(150, 184, 210, 20);
		panelRacao.add(textFieldValorRacao);
		textFieldValorRacao.setColumns(10);

		JButton btnAdicionarRacao = new JButton("Adicionar");

		btnAdicionarRacao.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAdicionarRacao.setBounds(417, 179, 105, 30);
		panelRacao.add(btnAdicionarRacao);
		panelRacao.setLayout(null);

		JPanel panelVacina = new JPanel();
		panelMudar.add(panelVacina, "Vacinas");
		panelVacina.setLayout(null);

		JScrollPane scrollPaneVacina = new JScrollPane();
		scrollPaneVacina.setBounds(150, 11, 210, 24);
		panelVacina.add(scrollPaneVacina);

		JComboBox comboBoxVacina = new JComboBox();
		scrollPaneVacina.setViewportView(comboBoxVacina);

		JLabel lblQuantidadeVacina = new JLabel("Quantidade");
		lblQuantidadeVacina.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblQuantidadeVacina.setBounds(211, 100, 86, 17);
		panelVacina.add(lblQuantidadeVacina);

		JTextField textFieldQuantidadeVacina = new JTextField();
		textFieldQuantidadeVacina.getInputMap().put(KeyStroke.getKeyStroke("control V"), "none");
		textFieldQuantidadeVacina.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				String caracteres = "0123456789";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}

				if (textFieldQuantidadeVacina.getText().length() > 10) {
					e.consume();
				}
			}
		});
		textFieldQuantidadeVacina.setBounds(150, 128, 210, 20);
		panelVacina.add(textFieldQuantidadeVacina);
		textFieldQuantidadeVacina.setColumns(10);

		JLabel lblValorVacina = new JLabel("Valor (Unitário)");
		lblValorVacina.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblValorVacina.setBounds(201, 159, 112, 14);
		panelVacina.add(lblValorVacina);

		JTextField textFieldValorVacina = new JTextField();
		textFieldValorVacina.getInputMap().put(KeyStroke.getKeyStroke("control V"), "none");
		textFieldValorVacina.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				String caracteres = "0123456789.";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}

				if (textFieldValorVacina.getText().length() > 10) {
					e.consume();
				}
			}
		});
		textFieldValorVacina.setBounds(150, 184, 210, 20);
		panelVacina.add(textFieldValorVacina);
		textFieldValorVacina.setColumns(10);

		JLabel lblNomeVacina = new JLabel("Nome");
		lblNomeVacina.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNomeVacina.setBounds(224, 46, 51, 17);
		panelVacina.add(lblNomeVacina);

		textFieldNomeVacina = new JTextField();
		textFieldNomeVacina.setBounds(150, 69, 210, 20);
		panelVacina.add(textFieldNomeVacina);
		textFieldNomeVacina.getInputMap().put(KeyStroke.getKeyStroke("control V"), "none");
		textFieldNomeVacina.setColumns(10);
		textFieldNomeVacina.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				if (textFieldNomeVacina.getText().length() > 20) {
					e.consume();
				}

				if (Character.isDigit(e.getKeyChar())) {
					e.consume();
				}
			}
		});

		JButton btnAdicionarVacina = new JButton("Adicionar");
		btnAdicionarVacina.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAdicionarVacina.setBounds(417, 179, 105, 30);
		panelVacina.add(btnAdicionarVacina);
		panelVacina.setLayout(null);

		JPanel telaMedicamentos = new JPanel();
		telaRegistrar.add(telaMedicamentos, "telaMedicamentos");
		telaMedicamentos.setBackground(new Color(240, 240, 240));
		telaMedicamentos.setLayout(null);

		JScrollPane scrollPaneSelecionarAnimal = new JScrollPane();
		scrollPaneSelecionarAnimal.setBounds(150, 40, 210, 24);
		telaMedicamentos.add(scrollPaneSelecionarAnimal);

		JComboBox comboBoxSelecionarAnimal = new JComboBox();

		JScrollPane scrollPaneSelecionarVacina = new JScrollPane();
		scrollPaneSelecionarVacina.setBounds(150, 96, 210, 24);
		telaMedicamentos.add(scrollPaneSelecionarVacina);

		JComboBox comboBoxSelecionarVacina = new JComboBox();
		scrollPaneSelecionarVacina.setViewportView(comboBoxSelecionarVacina);

		JScrollPane scrollPaneSelecionarMedicamento = new JScrollPane();
		scrollPaneSelecionarMedicamento.setBounds(150, 151, 210, 24);
		telaMedicamentos.add(scrollPaneSelecionarMedicamento);

		JComboBox comboBoxSelecionarMedicamento = new JComboBox();
		scrollPaneSelecionarMedicamento.setViewportView(comboBoxSelecionarMedicamento);

		scrollPaneSelecionarAnimal.setViewportView(comboBoxSelecionarAnimal);
		// Carrega os ComboBox da tela de adicionar Vacina/Medicamento no Animal
		btnMedicamentos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl_telaRegistrar.show(telaRegistrar, "telaMedicamentos");
				try {
					RecursosService service = new RecursosService();
					comboBoxSelecionarMedicamento.removeAllItems();
					List<Medicamentos> listaMedicamentos = service.retornarTodosMedicamentos();
					comboBoxSelecionarMedicamento.addItem("Nenhum");
					for (Medicamentos medicamento : listaMedicamentos) {
						comboBoxSelecionarMedicamento.addItem(medicamento);
					}
					comboBoxSelecionarVacina.removeAllItems();
					List<Vacinas> listaVacinas = service.retornarTodasVacinas();
					comboBoxSelecionarVacina.addItem("Nenhum");
					for (Vacinas vacina : listaVacinas) {
						comboBoxSelecionarVacina.addItem(vacina);
					}
					AnimaisService serviceAnimais = new AnimaisService();
					comboBoxSelecionarAnimal.removeAllItems();
					List<Animais> listaAnimais = serviceAnimais.retornarAnimal();
					for (Animais animal : listaAnimais) {
						comboBoxSelecionarAnimal.addItem(animal);
					}
				} catch (BusinessException | SQLException e1) {
					JOptionPane.showMessageDialog(null, "Não foi possível carregar opções", "Erro", JOptionPane.ERROR_MESSAGE);
				}

			}
		});

		JButton btnRegistrarNoAnimal = new JButton("Registrar");
		btnRegistrarNoAnimal.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnRegistrarNoAnimal.setBounds(418, 231, 105, 30);
		telaMedicamentos.add(btnRegistrarNoAnimal);

		// Registra um novo medicamento no banco de dados

		btnRegistrarMedicamentoNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = textFieldNomeMedicamentoNovo.getText();
				int quantidade;
				float valor;
				if (textFieldQuantidadeMedicamentoNovo.getText().trim().equals("")) {
					quantidade = 0;
				} else {
					quantidade = Integer.parseInt(textFieldQuantidadeMedicamentoNovo.getText());
				}
				if (textFieldValorMedicamentoNovo.getText().trim().equals("")) {
					valor = 0;
				} else {
					valor = Float.parseFloat(textFieldValorMedicamentoNovo.getText());
				}
				Medicamentos medicamento = new Medicamentos(nome, quantidade, valor);
				RecursosService registrar = new RecursosService();
				try {
					registrar.criarMedicamento(medicamento);
					JOptionPane.showMessageDialog(null, "Medicamento registrado com sucesso!!");
					recursosWindow.atualizarGrafico();
					dispose();
				} catch (SQLException e1) {					
					JOptionPane.showMessageDialog(null,  "Não foi possível registrar medicamento", "Erro", JOptionPane.ERROR_MESSAGE);
				} catch (BusinessException e2) {
					JOptionPane.showMessageDialog(null,  e2.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		// Registra uma nova ração no banco de dados

		btnRegistrarRacaoNova.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = textFieldMarcaRacaoNova.getText();
				float quantidade;
				float valor;
				if (textFieldQuantidadeRacaoNova.getText().trim().equals("")) {
					quantidade = 0;
				} else {
					quantidade = Float.parseFloat(textFieldQuantidadeRacaoNova.getText());
				}
				if (textFieldValorRacaoNova.getText().trim().equals("")) {
					valor = 0;
				} else {
					valor = Float.parseFloat(textFieldValorRacaoNova.getText());
				}
				Racoes racao = new Racoes(nome, quantidade, valor);
				RecursosService registrar = new RecursosService();
				try {
					registrar.criarRacao(racao);
					JOptionPane.showMessageDialog(null, "Ração registrada com sucesso!!");
					recursosWindow.atualizarGrafico();
					dispose();
				} catch (SQLException e1) {					
					JOptionPane.showMessageDialog(null, "Não foi possível registrar ração", "Erro", JOptionPane.ERROR_MESSAGE);																					
				} catch(BusinessException e2) {
					JOptionPane.showMessageDialog(null, e2.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
				}
        	}
        	}
        );
        
		// Registra uma nova vacina no banco de dados

		btnRegistrarVacinaNova.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = textFieldVacinaNova.getText();
				int quantidade;
				float valor;
				if (textFieldQuantidadeVacinaNova.getText().trim().equals("")) {
					quantidade = 0;
				} else {
					quantidade = Integer.parseInt(textFieldQuantidadeVacinaNova.getText());
				}
				if (textFieldValorVacinaNova.getText().trim().equals("")) {
					valor = 0;
				} else {
					valor = Float.parseFloat(textFieldValorVacinaNova.getText());
				}
				Vacinas vacina = new Vacinas(nome, quantidade, valor);
				RecursosService registrar = new RecursosService();
				try {
					registrar.criarVacina(vacina);
					JOptionPane.showMessageDialog(null, "Vacina registrada com sucesso!!");
					recursosWindow.atualizarGrafico();
					dispose();
				} catch (SQLException | BusinessException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Não foi possível registrar a vacina", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		// Carrega os ComboBox quando selecionar um item na tela Estoque
		comboBoxEstoque.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				String selecionado = (String) comboBoxEstoque.getSelectedItem();
				cl_panelMudar.show(panelMudar, selecionado);
				RecursosService service = new RecursosService();
				switch (selecionado) {

				case "Medicamentos":
					try {
						comboBoxMedicamento.removeAllItems();
						comboBoxMedicamento.addItem("Nenhum");
						List<Medicamentos> listaMedicamentos = service.retornarTodosMedicamentos();
						for (Medicamentos medicamento : listaMedicamentos) {
							comboBoxMedicamento.addItem(medicamento);
						}
					} catch (BusinessException | SQLException e1) {
						e1.printStackTrace();
					}
					break;
				case "Rações":
					try {
						comboBoxRacao.removeAllItems();
						comboBoxRacao.addItem("Nenhum");
						List<Racoes> listaRacoes = service.retornarTodasRacoes();
						for (Racoes racao : listaRacoes) {
							comboBoxRacao.addItem(racao);
						}
					} catch (BusinessException | SQLException e1) {
						e1.printStackTrace();
					}
					break;
				case "Vacinas":
					try {
						comboBoxVacina.removeAllItems();
						comboBoxVacina.addItem("Nenhum");
						List<Vacinas> listaVacinas = service.retornarTodasVacinas();
						for (Vacinas vacina : listaVacinas) {
							comboBoxVacina.addItem(vacina);
						}
					} catch (BusinessException | SQLException e1) {
						e1.printStackTrace();
					}
				}
				textFieldNomeMedicamentoNovo.setText("");
				textFieldQuantidadeMedicamentoNovo.setText("");
				textFieldValorMedicamentoNovo.setText("");
				textFieldNomeMedicamento.setText("");
				textFieldQuantidadeMedicamento.setText("");
				textFieldValorMedicamento.setText("");
				textFieldMarcaRacaoNova.setText("");
				textFieldQuantidadeRacaoNova.setText("");
				textFieldValorRacaoNova.setText("");
				textFieldNomeMarcaRacao.setText("");
				textFieldQuantidadeRacao.setText("");
				textFieldValorRacao.setText("");
				textFieldVacinaNova.setText("");
				textFieldQuantidadeVacinaNova.setText("");
				textFieldValorVacinaNova.setText("");
				textFieldNomeVacina.setText("");
				textFieldQuantidadeVacina.setText("");
				textFieldValorVacina.setText("");
			}
		});
		// Seta os valores do medicamento nos TextFields
		comboBoxMedicamento.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (String.valueOf(comboBoxMedicamento.getSelectedItem()).trim().equals("Nenhum")) {
					textFieldNomeMedicamento.setText("");
					textFieldQuantidadeMedicamento.setText("");
					textFieldValorMedicamento.setText("");
					btnAdicionarMedicamento.setEnabled(false);
				} else {
					btnAdicionarMedicamento.setEnabled(true);
					Medicamentos medicamento = (Medicamentos) comboBoxMedicamento.getSelectedItem();
					if (medicamento != null) {
						String nome = medicamento.getNomeMedicamento();
						int quantidade = medicamento.getQuantidadeMedicamento();
						double valor = medicamento.getValorMedicamento();
						textFieldNomeMedicamento.setText(nome);
						textFieldQuantidadeMedicamento.setText(String.valueOf(quantidade));
						textFieldValorMedicamento.setText(String.valueOf(valor));
					}
				}

			}
		});
		// Seta os valores da Ração nos TextFields
		comboBoxRacao.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (String.valueOf(comboBoxRacao.getSelectedItem()).trim().equals("Nenhum")) {
					textFieldNomeMarcaRacao.setText("");
					textFieldQuantidadeRacao.setText("");
					textFieldValorRacao.setText("");
					btnAdicionarRacao.setEnabled(false);
				} else {
					btnAdicionarRacao.setEnabled(true);
					Racoes racao = (Racoes) comboBoxRacao.getSelectedItem();
					if (racao != null) {
						String nome = racao.getMarcaRacao();
						double quantidade = racao.getQuantidadeRacao();
						double valor = racao.getValorRacao();
						textFieldNomeMarcaRacao.setText(nome);
						textFieldQuantidadeRacao.setText(String.valueOf(quantidade));
						textFieldValorRacao.setText(String.valueOf(valor));
					}
				}
			}
		});
		// Seta os valores da Vacina nos TextFields
		comboBoxVacina.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (String.valueOf(comboBoxVacina.getSelectedItem()).trim().equals("Nenhum")) {
					textFieldNomeVacina.setText("");
					textFieldQuantidadeVacina.setText("");
					textFieldValorVacina.setText("");
					btnAdicionarVacina.setEnabled(false);
				} else {
					btnAdicionarVacina.setEnabled(true);
					Vacinas vacina = (Vacinas) comboBoxVacina.getSelectedItem();
					if (vacina != null) {
						String nome = vacina.getNomeVacina();
						int quantidade = vacina.getQuantidadeVacina();
						double valor = vacina.getValorVacina();
						textFieldNomeVacina.setText(nome);
						textFieldQuantidadeVacina.setText(String.valueOf(quantidade));
						textFieldValorVacina.setText(String.valueOf(valor));
					}
				}

			}
		});
		// Atualiza os dados do medicamento no Banco de dados
		btnAdicionarMedicamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RecursosService service = new RecursosService();
				Medicamentos medicamento = (Medicamentos) comboBoxMedicamento.getSelectedItem();
				String novoNome = textFieldNomeMedicamento.getText();
				int novaQuantidade;
				float novoValor;
				if (textFieldQuantidadeMedicamento.getText().trim().equals("")) {
					novaQuantidade = 0;
				} else {
					novaQuantidade = Integer.parseInt(textFieldQuantidadeMedicamento.getText());
				}
				if (textFieldValorMedicamento.getText().trim().equals("")) {
					novoValor = 0;
				} else {
					novoValor = Float.parseFloat(textFieldValorMedicamento.getText());
				}
				try {
					service.atualizarMedicamento(novoNome, novaQuantidade, novoValor, medicamento.getId());
					JOptionPane.showMessageDialog(null, "Medicamento atualizado com sucesso!!");
					recursosWindow.atualizarGrafico();
					dispose();
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "Não foi possível atualizar medicamento", "Erro",
							JOptionPane.ERROR_MESSAGE);
				} catch (BusinessException e2) {
					JOptionPane.showMessageDialog(null, e2.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		// Atualiza os dados da Ração no Banco de dados
		btnAdicionarRacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RecursosService service = new RecursosService();
				Racoes racao = (Racoes) comboBoxRacao.getSelectedItem();
				String novoNome = textFieldNomeMarcaRacao.getText();
				float novaQuantidade;
				float novoValor;
				if (textFieldQuantidadeRacao.getText().trim().equals("")) {
					novaQuantidade = 0;
				} else {
					novaQuantidade = Float.parseFloat(textFieldQuantidadeRacao.getText());
				}
				if (textFieldValorRacao.getText().trim().equals("")) {
					novoValor = 0;
				} else {
					novoValor = Float.parseFloat(textFieldValorRacao.getText());
				}
				try {
					service.atualizarRacao(novoNome, novaQuantidade, novoValor, racao.getId());
					JOptionPane.showMessageDialog(null, "Ração atualizada com sucesso!!");
					recursosWindow.atualizarGrafico();
					dispose();
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "Não foi possível atualizar ração", "Erro",
							JOptionPane.ERROR_MESSAGE);
				} catch (BusinessException e2) {
					JOptionPane.showMessageDialog(null, e2.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		// Atualiza os dados da Vacina no Banco de dados
		btnAdicionarVacina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RecursosService service = new RecursosService();
				Vacinas vacina = (Vacinas) comboBoxVacina.getSelectedItem();
				String novoNome = textFieldNomeVacina.getText();
				int novaQuantidade;
				float novoValor;
				if (textFieldQuantidadeVacina.getText().trim().equals("")) {
					novaQuantidade = 0;
				} else {
					novaQuantidade = Integer.parseInt(textFieldQuantidadeVacina.getText());
				}
				if (textFieldValorVacina.getText().trim().equals("")) {
					novoValor = 0;
				} else {
					novoValor = Float.parseFloat(textFieldValorVacina.getText());
				}
				try {
					service.atualizarVacina(novoNome, novaQuantidade, novoValor, vacina.getId());
					JOptionPane.showMessageDialog(null, "Vacina atulizada com sucesso!!");
					dispose();
				} catch (SQLException  e1) {
					JOptionPane.showMessageDialog(null, "Não foi possível atualizar vacina", "Erro", JOptionPane.ERROR_MESSAGE);
				} catch (BusinessException e2) {
					JOptionPane.showMessageDialog(null, e2.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnRegistrarNoAnimal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Animais animal = (Animais) comboBoxSelecionarAnimal.getSelectedItem();
				try {
					// Bloco a ser executado caso ambos comboBox SelecionarVacina e Selecionar
					// Medicamento sejam "Nenhum"
					if (comboBoxSelecionarMedicamento.getSelectedItem() == "Nenhum"
							&& comboBoxSelecionarVacina.getSelectedItem() == "Nenhum") {
						throw new BusinessException("Selecione um Medicamento ou Vacina para registrar no animal!");
					}
					// Bloco a ser executado caso apenas comboBox SelecionarVacina seja "Nenhum"
					else if (comboBoxSelecionarVacina.getSelectedItem() == "Nenhum") {
						Medicamentos medicamento = (Medicamentos) comboBoxSelecionarMedicamento.getSelectedItem();
						RecursosService service = new RecursosService();
						try {
							// Verifica se o estoque possui medicamento selecionado
							if (medicamento.getQuantidadeMedicamento() == 0) {
								throw new BusinessException("Estoque de Medicamento está zerado!");
							}
							// Insere o medicamento no animal selecionado
							service.inserirMedicamentoAnimal(animal, medicamento);
							int novaQuantidade = medicamento.getQuantidadeMedicamento() - 1;
							service.diminuirQuantidadeMedicamento(medicamento.getId(), novaQuantidade);
							JOptionPane.showMessageDialog(null, "Medicamento atribuido com sucesso!!");
							dispose();

						} catch (SQLException e1) {
							JOptionPane.showMessageDialog(null, "Não foi possível inserir medicamento", "Erro",
									JOptionPane.ERROR_MESSAGE);
						} catch (BusinessException e2) {
							JOptionPane.showMessageDialog(null, e2.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
						}
					}
					// Bloco a ser executado caso apenas comboBox SelecionarMedicamento seja
					// "Nenhum"
					else if (comboBoxSelecionarMedicamento.getSelectedItem() == "Nenhum") {
						Vacinas vacina = (Vacinas) comboBoxSelecionarVacina.getSelectedItem();
						// Verifica se o estoque possui vacina selecionada
						if (vacina.getQuantidadeVacina() == 0) {
							throw new BusinessException("Estoque de Vacina está zerado!");
						}
						RecursosService service = new RecursosService();
						try {
							// Insere a vacina no animal selecionado
							service.inserirVacinaAnimal(animal, vacina);
							int novaQuantidade = vacina.getQuantidadeVacina() - 1;
							service.diminuirQuantidadeVacina(vacina.getId(), novaQuantidade);
							JOptionPane.showMessageDialog(null, "Vacina atribuida com sucesso!!");
							dispose();

						} catch (SQLException e1) {
							JOptionPane.showMessageDialog(null, "Não foi possível inserir vacina", "Erro",
									JOptionPane.ERROR_MESSAGE);
						} catch (BusinessException e2) {
							JOptionPane.showMessageDialog(null, e2.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
						}
					}
					// Bloco a ser executado caso ambos comboBox SelecionarMedicamento e
					// SelecionarVacina estejam selecionados
					else {
						Medicamentos medicamento = (Medicamentos) comboBoxSelecionarMedicamento.getSelectedItem();
						Vacinas vacina = (Vacinas) comboBoxSelecionarVacina.getSelectedItem();
						// Verifica se o estoque possui o medicamento selecionado
						if (medicamento.getQuantidadeMedicamento() == 0) {
							throw new BusinessException("Estoque de Medicamento está zerado!");
						}
						// Verifica se o estoque possui a vacina selecionada
						if (vacina.getQuantidadeVacina() == 0) {
							throw new BusinessException("Estoque de Vacina está zerado!");
						}
						RecursosService service = new RecursosService();
						try {
							// Insere ambos medicamento e vacinas selecionadas no animal
							service.inserirMedicamentoAnimal(animal, medicamento);
							int novaQuantidadeMedicamento = medicamento.getQuantidadeMedicamento() - 1;
							service.diminuirQuantidadeMedicamento(medicamento.getId(), novaQuantidadeMedicamento);
							service.inserirVacinaAnimal(animal, vacina);
							int novaQuantidadeVacina = vacina.getQuantidadeVacina() - 1;
							service.diminuirQuantidadeMedicamento(vacina.getId(), novaQuantidadeVacina);
							JOptionPane.showMessageDialog(null, "Vacina e Medicamento atribuidos com sucesso!!");
							dispose();
						} catch (SQLException e1) {

							JOptionPane.showMessageDialog(null,
									"Não foi possível inserir medicamentos e vacinas / atualizar no estoque", "Erro",
									JOptionPane.ERROR_MESSAGE);
						} catch (BusinessException e2) {
							JOptionPane.showMessageDialog(null, e2.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
						}
					}
				} catch (BusinessException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
				}
				if (recursosWindow.retornarComboBoxFiltro().getSelectedItem() == "Todos") {
					recursosWindow.recarregarTabelaGastos();
				} else {
					recursosWindow.recarregarTabelaGastosPorTipo();
				}
			}

		});

		JLabel lblPetLifeNome = new JLabel("PetLife");
		lblPetLifeNome.setEnabled(false);
		lblPetLifeNome.setBackground(new Color(255, 255, 255));
		lblPetLifeNome.setFont(new Font("Tahoma", Font.PLAIN, 54));
		lblPetLifeNome.setBounds(192, 66, 160, 78);
		homeTelaRegistrar.add(lblPetLifeNome);

		JLabel lblGerenciandoNome = new JLabel("Gerenciando a vida dos pets");
		lblGerenciandoNome.setEnabled(false);
		lblGerenciandoNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGerenciandoNome.setBounds(186, 130, 248, 14);
		homeTelaRegistrar.add(lblGerenciandoNome);
	}
}
