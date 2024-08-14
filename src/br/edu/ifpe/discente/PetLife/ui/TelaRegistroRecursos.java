package br.edu.ifpe.discente.PetLife.ui;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;

public class TelaRegistroRecursos extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private CardLayout cl_telaRegistrar; 
	private JTextField textFieldNomeMedicamento;
	private JTextField textFieldMarcaRacao;
	private JTextField textFieldVacina;
	private JTextField textFieldQuantidade;
	private JTextField textFieldQuantidadeRacao;
	private JTextField textFieldQuantidadeVacina;
	private JTextField textFieldValor;
	private JTextField textFieldValorRacao;
	private JTextField textFieldValorVacina;
    private CardLayout cl_panelMudar;
    private JLabel lblVacina;
    private JLabel lblQuantidadeVacina;
    private JLabel lblValorVacina;
    private JButton btnRegistrarVacina;
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
        telaEstoque.setBackground(new Color(240, 240, 240));
        telaEstoque.setLayout(null);
        
        JComboBox comboBox = new JComboBox();
        comboBox.setFont(new Font("Tahoma", Font.BOLD, 14));
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"Medicamentos", "Ração", "Vacinas"}));
        comboBox.setBounds(196, 27, 128, 22);
        telaEstoque.add(comboBox);
    
        
        cl_panelMudar = new CardLayout();
        
        
        JPanel panelMudar = new JPanel(cl_panelMudar);
        panelMudar.setLocation(0, 59);
        panelMudar.setSize(544, 229);
        telaEstoque.add(panelMudar);
        panelMudar.setLayout(cl_panelMudar);
        
        
        JPanel panelMedicamentos = new JPanel();
        panelMedicamentos.setBounds(0, 0, 544, 229);
        panelMudar.add(panelMedicamentos, "Medicamentos");
        panelMedicamentos.setLayout(null);
        
        JLabel lblNomeMedicamento = new JLabel("Nome Medicamento");
        lblNomeMedicamento.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNomeMedicamento.setBounds(48, 25, 138, 21);
        panelMedicamentos.add(lblNomeMedicamento);
        
        textFieldNomeMedicamento = new JTextField();
        textFieldNomeMedicamento.setBounds(33, 50, 173, 20);
        panelMedicamentos.add(textFieldNomeMedicamento);
        textFieldNomeMedicamento.setColumns(10);
        
        JLabel lblQuantidadeMedicamento = new JLabel("Quantidade");
        lblQuantidadeMedicamento.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblQuantidadeMedicamento.setBounds(353, 27, 86, 17);
        panelMedicamentos.add(lblQuantidadeMedicamento);
        
        textFieldQuantidade = new JTextField();
        textFieldQuantidade.setBounds(308, 50, 173, 20);
        panelMedicamentos.add(textFieldQuantidade);
        textFieldQuantidade.setColumns(10);
        
        JLabel lblValorMedicamento = new JLabel("Valor");
        lblValorMedicamento.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblValorMedicamento.setBounds(238, 98, 46, 14);
        panelMedicamentos.add(lblValorMedicamento);
        
        textFieldValor = new JTextField();
        textFieldValor.setBounds(168, 117, 173, 20);
        panelMedicamentos.add(textFieldValor);
        textFieldValor.setColumns(10);
        
        JButton btnRegistrarMedicamento = new JButton("Registrar");
        btnRegistrarMedicamento.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnRegistrarMedicamento.setBounds(417, 179, 105, 30);
        panelMedicamentos.add(btnRegistrarMedicamento);
        
        JPanel panelRacao = new JPanel();
        panelRacao.setBounds(0, 0, 544, 229);
        panelMudar.add(panelRacao, "Ração");
        panelRacao.setLayout(null);
        
        JLabel lblMarcaRacao = new JLabel("Marca da Ração");
        lblMarcaRacao.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblMarcaRacao.setBounds(60, 25, 108, 21);
        panelRacao.add(lblMarcaRacao);
        
        textFieldMarcaRacao = new JTextField();
        textFieldMarcaRacao.setBounds(33, 50, 173, 20);
        panelRacao.add(textFieldMarcaRacao);
        textFieldMarcaRacao.setColumns(10);
        
        JLabel lblQuantidadeRacao = new JLabel("Quantidade (KG)");
        lblQuantidadeRacao.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblQuantidadeRacao.setBounds(339, 27, 116, 17);
        panelRacao.add(lblQuantidadeRacao);
        
        textFieldQuantidadeRacao = new JTextField();
        textFieldQuantidadeRacao.setBounds(308, 50, 173, 20);
        panelRacao.add(textFieldQuantidadeRacao);
        textFieldQuantidadeRacao.setColumns(10);
        
        JLabel lblValorRacao = new JLabel("Valor");
        lblValorRacao.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblValorRacao.setBounds(238, 98, 41, 14);
        panelRacao.add(lblValorRacao);
        
        textFieldValorRacao = new JTextField();
        textFieldValorRacao.setBounds(168, 117, 173, 20);
        panelRacao.add(textFieldValorRacao);
        textFieldValorRacao.setColumns(10);
        
        JButton btnRegistrarRacao = new JButton("Registrar");
        btnRegistrarRacao.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnRegistrarRacao.setBounds(417, 179, 105, 30);
        panelRacao.add(btnRegistrarRacao);
        
        
        JPanel panelVacinas = new JPanel();
        panelVacinas.setBounds(0, 0, 544, 229);
        panelMudar.add(panelVacinas, "Vacinas");
        panelVacinas.setLayout(null);
        
        JLabel lblVacina = new JLabel("Vacina");
        lblVacina.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblVacina.setBounds(93, 25, 45, 21);
        panelVacinas.add(lblVacina);
        
        
        textFieldVacina = new JTextField();
        textFieldVacina.setBounds(33, 50, 173, 20);
        panelVacinas.add(textFieldVacina);
        textFieldVacina.setColumns(10);
        
        JLabel lblQuantidadeVacina = new JLabel("Quantidade");
        lblQuantidadeVacina.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblQuantidadeVacina.setBounds(355, 27, 80, 17);
        panelVacinas.add(lblQuantidadeVacina);
        
        textFieldQuantidadeVacina = new JTextField();
        textFieldQuantidadeVacina.setBounds(308, 50, 173, 20);
        panelVacinas.add(textFieldQuantidadeVacina);
        textFieldQuantidadeVacina.setColumns(10);
        
        JLabel lblValorVacina = new JLabel("Valor");
        lblValorVacina.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblValorVacina.setBounds(238, 98, 41, 14);
        panelVacinas.add(lblValorVacina);
        
        textFieldValorVacina = new JTextField();
        textFieldValorVacina.setBounds(168, 117, 173, 20);
        panelVacinas.add(textFieldValorVacina);
        textFieldValorVacina.setColumns(10);
        
        JButton btnRegistrarVacina = new JButton("Registrar");
        btnRegistrarVacina.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnRegistrarVacina.setBounds(417, 179, 105, 30);
        panelVacinas.add(btnRegistrarVacina);
        
        
  
        
        
        comboBox.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String selecionado = (String) comboBox.getSelectedItem();
        		cl_panelMudar.show(panelMudar, selecionado);
        		
        	}
        });
        
        
        JPanel telaMedicamentos = new JPanel();
        telaRegistrar.add(telaMedicamentos, "telaMedicamentos");
        telaMedicamentos.setBackground(new Color(240, 240, 240));
        telaMedicamentos.setLayout(null);
        
        
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