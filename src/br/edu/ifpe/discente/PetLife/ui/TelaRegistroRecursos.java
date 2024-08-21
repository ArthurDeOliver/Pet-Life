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

import br.edu.ifpe.discente.PetLife.business.RecursosService;
import br.edu.ifpe.discente.PetLife.ui.entities.Vacinas;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.Box;

public class TelaRegistroRecursos extends JFrame{

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
    private JLabel lblVacina;
    private JLabel lblQuantidadeVacina;
    private JLabel lblValorVacina;
    private JButton btnRegistrarVacina;
    private JLabel lblValorMedicamento;
    private JLabel lblQuantidadeMedicamente;
    private JButton btnRegistrarMedicamentoNovo;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaRegistroRecursos window = new TelaRegistroRecursos();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaRegistroRecursos() {
		initialize();
	}

	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
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
        labelRegistroRecursos.setIcon(new ImageIcon(TelaRegistroAdocao.class.getResource("/Imagens/racao-para-animais-de-estimacao.png")));
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
        btnMedicamentos.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		cl_telaRegistrar.show(telaRegistrar, "telaMedicamentos");
        	}
        });
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
        
        JComboBox comboBoxEstoque = new JComboBox();
        comboBoxEstoque.setFont(new Font("Tahoma", Font.BOLD, 14));
        comboBoxEstoque.setModel(new DefaultComboBoxModel(new String[] {"Novo Medicamento", "Nova Ração", "Nova Vacina", "Medicamentos", "Rações", "Vacinas"}));
        comboBoxEstoque.setBounds(188, 11, 128, 22);
        telaEstoque.add(comboBoxEstoque);
    
        
        cl_panelMudar = new CardLayout();
        
        
        JPanel panelMudar = new JPanel(cl_panelMudar);
        panelMudar.setLocation(0, 59);
        panelMudar.setSize(544, 229);
        telaEstoque.add(panelMudar);
        panelMudar.setLayout(cl_panelMudar);
        
        
        JPanel panelNovoMedicamento = new JPanel();
        panelNovoMedicamento.setBounds(0, 0, 544, 229);
        panelMudar.add(panelNovoMedicamento, "Novo Medicamento");
        panelNovoMedicamento.setLayout(null);
        
        JLabel lblNomeMedicamentoNovo = new JLabel("Nome Medicamento");
        lblNomeMedicamentoNovo.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNomeMedicamentoNovo.setBounds(188, 25, 138, 21);
        panelNovoMedicamento.add(lblNomeMedicamentoNovo);
        
        textFieldNomeMedicamentoNovo = new JTextField();
        textFieldNomeMedicamentoNovo.setBounds(169, 50, 173, 20);
        panelNovoMedicamento.add(textFieldNomeMedicamentoNovo);
        textFieldNomeMedicamentoNovo.setColumns(10);
        
        JLabel lblQuantidadeMedicamentoNovo = new JLabel("Quantidade");
        lblQuantidadeMedicamentoNovo.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblQuantidadeMedicamentoNovo.setBounds(211, 80, 86, 17);
        panelNovoMedicamento.add(lblQuantidadeMedicamentoNovo);
        
        textFieldQuantidadeMedicamentoNovo = new JTextField();
        textFieldQuantidadeMedicamentoNovo.setBounds(169, 108, 173, 20);
        panelNovoMedicamento.add(textFieldQuantidadeMedicamentoNovo);
        textFieldQuantidadeMedicamentoNovo.setColumns(10);
        
        JLabel lblValorMedicamentoNovo = new JLabel("Valor");
        lblValorMedicamentoNovo.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblValorMedicamentoNovo.setBounds(232, 139, 42, 14);
        panelNovoMedicamento.add(lblValorMedicamentoNovo);
        
        textFieldValorMedicamentoNovo = new JTextField();
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
        textFieldMarcaRacaoNova.setBounds(169, 50, 173, 20);
        panelNovaRacao.add(textFieldMarcaRacaoNova);
        textFieldMarcaRacaoNova.setColumns(10);
        
        JLabel lblQuantidadeRacaoNova = new JLabel("Quantidade (KG)");
        lblQuantidadeRacaoNova.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblQuantidadeRacaoNova.setBounds(188, 80, 131, 17);
        panelNovaRacao.add(lblQuantidadeRacaoNova);
        
        JTextField textFieldQuantidadeRacaoNova = new JTextField();
        textFieldQuantidadeRacaoNova.setBounds(169, 108, 173, 20);
        panelNovaRacao.add(textFieldQuantidadeRacaoNova);
        textFieldQuantidadeRacaoNova.setColumns(10);
        
        JLabel lblValorRacaoNova = new JLabel("Valor");
        lblValorRacaoNova.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblValorRacaoNova.setBounds(232, 139, 42, 14);
        panelNovaRacao.add(lblValorRacaoNova);
        
        JTextField textFieldValorRacaoNova = new JTextField();
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
        textFieldVacinaNova.setBounds(169, 50, 173, 20);
        panelNovaVacina.add(textFieldVacinaNova);
        textFieldVacinaNova.setColumns(10);
        
        JLabel lblQuantidadeVacinaNova = new JLabel("Quantidade");
        lblQuantidadeVacinaNova.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblQuantidadeVacinaNova.setBounds(211, 80, 86, 17);
        panelNovaVacina.add(lblQuantidadeVacinaNova);
        
        JTextField textFieldQuantidadeVacinaNova = new JTextField();
        textFieldQuantidadeVacinaNova.setBounds(169, 108, 173, 20);
        panelNovaVacina.add(textFieldQuantidadeVacinaNova);
        textFieldQuantidadeVacinaNova.setColumns(10);
        
        JLabel lblValorVacinaNova = new JLabel("Valor");
        lblValorVacinaNova.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblValorVacinaNova.setBounds(232, 139, 42, 14);
        panelNovaVacina.add(lblValorVacinaNova);
        
        JTextField textFieldValorVacinaNova = new JTextField();
        textFieldValorVacinaNova.setBounds(169, 164, 173, 20);
        panelNovaVacina.add(textFieldValorVacinaNova);
        textFieldValorVacinaNova.setColumns(10);
        
        JButton btnRegistrarVacinaNova = new JButton("Registrar");
        btnRegistrarVacinaNova.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String nome = textFieldVacinaNova.getText();
        		int quantidade = Integer.parseInt(textFieldQuantidadeVacinaNova.getText());
        		float valor = Float.parseFloat(textFieldValorVacinaNova.getText());
        		Vacinas vacina = new Vacinas(nome, quantidade, valor);
        		RecursosService registrar = new RecursosService();
        		try {
					registrar.criarVacina(vacina);
					JOptionPane.showMessageDialog(null, "Vacina registrada com sucesso!!");
				} catch (SQLException e1) {					
					e1.printStackTrace();
									
										
				}
        	}
        	}
        );
        btnRegistrarVacinaNova.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnRegistrarVacinaNova.setBounds(417, 179, 105, 30);
        panelNovaVacina.add(btnRegistrarVacinaNova);
        
        JPanel panelMedicamento = new JPanel();
        panelMudar.add(panelMedicamento, "Medicamentos");
       
        JScrollPane scrollPaneMedicamento = new JScrollPane();
        scrollPaneMedicamento.setBounds(169, 33, 173, 24);
        panelMedicamento.add(scrollPaneMedicamento);
        
        JComboBox comboBoxMedicamento = new JComboBox();
        comboBoxMedicamento.setModel(new DefaultComboBoxModel(new String[] {","}));
        scrollPaneMedicamento.setViewportView(comboBoxMedicamento);
        
        JLabel lblQuantidadeMedicamento = new JLabel("Quantidade");
        lblQuantidadeMedicamento.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblQuantidadeMedicamento.setBounds(211, 80, 86, 17);
        panelMedicamento.add(lblQuantidadeMedicamento);
        
        JTextField textFieldQuantidadeMedicamento = new JTextField();
        textFieldQuantidadeMedicamento.setBounds(169, 108, 173, 20);
        panelMedicamento.add(textFieldQuantidadeMedicamento);
        textFieldQuantidadeMedicamento.setColumns(10);
        
        JLabel lblValorMedicamento = new JLabel("Valor");
        lblValorMedicamento.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblValorMedicamento.setBounds(232, 139, 42, 14);
        panelMedicamento.add(lblValorMedicamento);
        
        JTextField textFieldValorMedicamento = new JTextField();
        textFieldValorMedicamento.setBounds(169, 164, 173, 20);
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
        scrollPaneRacao.setBounds(169, 33, 173, 24);
        panelRacao.add(scrollPaneRacao);
        
        JComboBox comboBoxRacao = new JComboBox();
        comboBoxRacao.setModel(new DefaultComboBoxModel(new String[] {"."}));
        comboBoxMedicamento.setModel(new DefaultComboBoxModel(new String[] {","}));
        scrollPaneRacao.setViewportView(comboBoxRacao);
        
        JLabel lblQuantidadeRacao = new JLabel("Quantidade");
        lblQuantidadeRacao.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblQuantidadeRacao.setBounds(211, 80, 86, 17);
        panelRacao.add(lblQuantidadeRacao);
        
        JTextField textFieldQuantidadeRacao = new JTextField();
        textFieldQuantidadeRacao.setBounds(169, 108, 173, 20);
        panelRacao.add(textFieldQuantidadeRacao);
        textFieldQuantidadeRacao.setColumns(10);
        
        JLabel lblValorRacao = new JLabel("Valor");
        lblValorRacao.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblValorRacao.setBounds(232, 139, 42, 14);
        panelRacao.add(lblValorRacao);
        
        JTextField textFieldValorRacao = new JTextField();
        textFieldValorRacao.setBounds(169, 164, 173, 20);
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
        scrollPaneVacina.setBounds(169, 33, 173, 24);
        panelVacina.add(scrollPaneVacina);
        
        JComboBox comboBoxVacina = new JComboBox();
        comboBoxVacina.setModel(new DefaultComboBoxModel(new String[] {"."}));
        comboBoxVacina.setModel(new DefaultComboBoxModel(new String[] {","}));
        scrollPaneVacina.setViewportView(comboBoxVacina);
        
        JLabel lblQuantidadeVacina = new JLabel("Quantidade");
        lblQuantidadeVacina.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblQuantidadeVacina.setBounds(211, 80, 86, 17);
        panelVacina.add(lblQuantidadeVacina);
        
        JTextField textFieldQuantidadeVacina = new JTextField();
        textFieldQuantidadeVacina.setBounds(169, 108, 173, 20);
        panelVacina.add(textFieldQuantidadeVacina);
        textFieldQuantidadeVacina.setColumns(10);
        
        JLabel lblValorVacina = new JLabel("Valor");
        lblValorVacina.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblValorVacina.setBounds(232, 139, 42, 14);
        panelVacina.add(lblValorVacina);
        
        JTextField textFieldValorVacina= new JTextField();
        textFieldValorVacina.setBounds(169, 164, 173, 20);
        panelVacina.add(textFieldValorVacina);
        textFieldValorVacina.setColumns(10);
        
        JButton btnAdicionarVacina = new JButton("Adicionar");
        btnAdicionarVacina.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnAdicionarVacina.setBounds(417, 179, 105, 30);
        panelVacina.add(btnAdicionarVacina);
        panelVacina.setLayout(null);
        
        
  
        
        
        comboBoxEstoque.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String selecionado = (String) comboBoxEstoque.getSelectedItem();
        		cl_panelMudar.show(panelMudar, selecionado);
        		
        	}
        });
        
        
        JPanel telaMedicamentos = new JPanel();
        telaRegistrar.add(telaMedicamentos, "telaMedicamentos");
        telaMedicamentos.setBackground(new Color(240, 240, 240));
        telaMedicamentos.setLayout(null);
        
        JScrollPane scrollPaneSelecionarAnimal = new JScrollPane();
        scrollPaneSelecionarAnimal.setBounds(170, 40, 174, 28);
        telaMedicamentos.add(scrollPaneSelecionarAnimal);
        
        JComboBox comboBoxSelecionarAnimal = new JComboBox();
        scrollPaneSelecionarAnimal.setViewportView(comboBoxSelecionarAnimal);
        
        JScrollPane scrollPaneSelecionarVacina = new JScrollPane();
        scrollPaneSelecionarVacina.setBounds(170, 124, 174, 28);
        telaMedicamentos.add(scrollPaneSelecionarVacina);
        
        JComboBox comboBoxSelecionarVacina = new JComboBox();
        scrollPaneSelecionarVacina.setViewportView(comboBoxSelecionarVacina);
        
        
        JLabel lblPetLifeNome = new JLabel("PetLife");
        lblPetLifeNome.setEnabled(false);
        lblPetLifeNome.setBackground(new Color(255, 255, 255));
        lblPetLifeNome.setFont(new Font("Tahoma", Font.PLAIN, 54));
        lblPetLifeNome.setBounds(192, 66, 160, 78);
        homeTelaRegistrar.add(lblPetLifeNome);
        
        
        JLabel lblGerenciandoNome = new JLabel("Gerenciando a vida dos pets");
        lblGerenciandoNome.setEnabled(false);
        lblGerenciandoNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblGerenciandoNome.setBounds(186,130,248,14);
        homeTelaRegistrar.add(lblGerenciandoNome);
	}
}