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

public class TelaRegistroRecursos extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private CardLayout cl_telaRegistrar; 
	private JTextField textFieldNomeMedicamento;

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
        
        JLabel lblNomeMedicamento = new JLabel("Nome do medicamento");
        lblNomeMedicamento.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNomeMedicamento.setBounds(194, 11, 160, 24);
        telaEstoque.add(lblNomeMedicamento);
        
        textFieldNomeMedicamento = new JTextField();
        textFieldNomeMedicamento.setColumns(10);
        textFieldNomeMedicamento.setBounds(170, 44, 208, 20);
        telaEstoque.add(textFieldNomeMedicamento);
        
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
