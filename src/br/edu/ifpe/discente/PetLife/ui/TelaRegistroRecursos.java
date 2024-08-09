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

public class TelaRegistroRecursos extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private CardLayout cl_telaRegistrar; 

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
        
        telaRegistrar.setBounds(10, 129, 544, 276);
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
        
        JPanel telaMedicamentos = new JPanel();
        telaRegistrar.add(telaMedicamentos, "telaMedicamentos");
        telaMedicamentos.setBackground(new Color(6, 26, 53));
        telaMedicamentos.setLayout(null);
        
	}
}
