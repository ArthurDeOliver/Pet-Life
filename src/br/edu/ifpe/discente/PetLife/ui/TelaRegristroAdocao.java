package br.edu.ifpe.discente.PetLife.ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;

public class TelaRegristroAdocao extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JTextField textFieldNomeTutor;
	private JTextField textFieldCpfTutor;
	private JTextField textFieldEnderecoTutor;
	private JTextField textFieldTelefoneTutor;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaRegristroAdocao window = new TelaRegristroAdocao();
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
	public TelaRegristroAdocao() {
		getContentPane().setLayout(null);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 580, 455);
        JPanel contentPane = new JPanel();
        contentPane.setBackground(new Color(6, 26, 53));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JPanel panel = new JPanel();
        panel.setBounds(10, 11, 538, 42);
        contentPane.add(panel);
        
        //Label de Registro de adoção
        JLabel lblRegistroAdocao = new JLabel("Registro de adoção");
        lblRegistroAdocao.setFont(new Font("JetBrains Mono", Font.PLAIN, 16));
        lblRegistroAdocao.setIcon(new ImageIcon(TelaRegristroAdocao.class.getResource("/Imagens/clinica-de-cuidado-de-animais-domesticos.png")));
        panel.add(lblRegistroAdocao);
        
        
        JPanel RegistroAdocaoPainel = new JPanel();
        RegistroAdocaoPainel.setBounds(10, 68, 538, 337);
        contentPane.add(RegistroAdocaoPainel);
        RegistroAdocaoPainel.setLayout(null);
        
        JLabel labelNomeTutor = new JLabel("Nome do tutor");
        labelNomeTutor.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelNomeTutor.setBounds(224, 27, 104, 14);
        RegistroAdocaoPainel.add(labelNomeTutor);
        
        JLabel labelCpfTutor = new JLabel("CPF do tutor");
        labelCpfTutor.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelCpfTutor.setBounds(233, 86, 95, 14);
        RegistroAdocaoPainel.add(labelCpfTutor);
        
        JLabel labelEnderecoTutor = new JLabel("Endereço do tutor");
        labelEnderecoTutor.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelEnderecoTutor.setBounds(214, 140, 148, 20);
        RegistroAdocaoPainel.add(labelEnderecoTutor);

        JLabel labelTelefoneTutor = new JLabel("Telefone do tutor");
        labelTelefoneTutor.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelTelefoneTutor.setBounds(214, 200, 125, 20);
        RegistroAdocaoPainel.add(labelTelefoneTutor);
        
        //Adicionando textField com nome do tutor
        textFieldNomeTutor = new JTextField();
        textFieldNomeTutor.setBounds(112, 51, 325, 20);
        RegistroAdocaoPainel.add(textFieldNomeTutor);
        textFieldNomeTutor.setColumns(10);
        
        //Adicionando textField para cpf do tutor com 11 caracteres
        textFieldCpfTutor = new JTextField();
        textFieldCpfTutor.addKeyListener(new KeyAdapter() {	
        	public void keyTyped(KeyEvent e) {
        		String caracteres = "0123456789";
        		if (!caracteres.contains(e.getKeyChar()+"")) {
        			e.consume();
        		}
        		
        		if (textFieldCpfTutor.getText().length() > 11) {
        			e.consume();
        		}
        		
        	}
        });
        textFieldCpfTutor.setBounds(112, 230, 325, 20);
        RegistroAdocaoPainel.add(textFieldCpfTutor);
        textFieldCpfTutor.setColumns(10);
        
      //Adicionando textField com endereço do tutor
        textFieldEnderecoTutor = new JTextField();
        textFieldEnderecoTutor.setBounds(112, 168, 325, 20);
        RegistroAdocaoPainel.add(textFieldEnderecoTutor);
        textFieldEnderecoTutor.setColumns(10);
        
      //Adicionando textField para telefone do tutor com 11 caracteres
        textFieldTelefoneTutor = new JTextField();
        textFieldTelefoneTutor.addKeyListener(new KeyAdapter() {	
        	public void keyTyped(KeyEvent e) {
        		String caracteres = "0123456789";
        		if (!caracteres.contains(e.getKeyChar()+"")) {
        			e.consume();
        		}
        		
        		if (textFieldTelefoneTutor.getText().length() > 11) {
        			e.consume();
        		}
        		
        	}
        });
        textFieldTelefoneTutor.setBounds(112, 110, 325, 20);
        RegistroAdocaoPainel.add(textFieldTelefoneTutor);
        textFieldTelefoneTutor.setColumns(10);
        

        
        //Botão para registrar a adoção
        JButton btnAdotar = new JButton("Adotar");
        btnAdotar.setBounds(243, 276, 85, 21);
        RegistroAdocaoPainel.add(btnAdotar);
        


	}
}
