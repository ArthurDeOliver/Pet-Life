package br.edu.ifpe.discente.PetLife.ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.edu.ifpe.discente.PetLife.business.AdocaoService;
import br.edu.ifpe.discente.PetLife.ui.entities.Adocoes;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaRegistroAdocao extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JTextField textFieldNomeTutor;
	private JTextField textFieldCpfTutor;
	private JTextField textFieldEnderecoTutor;
	private JTextField textFieldTelefoneTutor;
	static int idPet;
	static String nomePet;
	static String tipoPet;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					TelaRegistroAdocao window = new TelaRegistroAdocao(idPet, nomePet, tipoPet);
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
	//Abrir tela selecionando Pet
	public TelaRegistroAdocao(int idPet, String nomePet, String tipoPet) {
		getContentPane().setLayout(null);
		initialize();
	}
	
	//	//Abrir tela sem selecionar Pet
	public TelaRegistroAdocao() {
		getContentPane().setLayout(null);
		initialize();
	}

	
	//Get e set para parâmetros recebidos dos Pets
	public static int getIdPet() {
		return idPet;
	}

	public static void setIdPet(int idPet) {
		TelaRegistroAdocao.idPet = idPet;
	}

	public static String getNomePet() {
		return nomePet;
	}

	public static void setNomePet(String nomePet) {
		TelaRegistroAdocao.nomePet = nomePet;
	}

	public static String getTipoPet() {
		return tipoPet;
	}

	public static void setTipoPet(String tipoPet) {
		TelaRegistroAdocao.tipoPet = tipoPet;
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
        panel.setBounds(10, 11, 544, 42);
        contentPane.add(panel);
        
        //Label de Registro de adoção
        JLabel lblRegistroAdocao = new JLabel("Registro de adoção");
        lblRegistroAdocao.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblRegistroAdocao.setIcon(new ImageIcon(TelaRegistroAdocao.class.getResource("/Imagens/clinica-de-cuidado-de-animais-domesticos.png")));
        panel.add(lblRegistroAdocao);
        
        
        JPanel RegistroAdocaoPainel = new JPanel();
        RegistroAdocaoPainel.setBounds(10, 68, 544, 337);
        contentPane.add(RegistroAdocaoPainel);
        RegistroAdocaoPainel.setLayout(null);
        
        JLabel labelNomeTutor = new JLabel("Nome do tutor");
        labelNomeTutor.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelNomeTutor.setBounds(170, 11, 118, 31);
        RegistroAdocaoPainel.add(labelNomeTutor);
        
        JLabel labelCpfTutor = new JLabel("CPF do tutor");
        labelCpfTutor.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelCpfTutor.setBounds(170, 75, 95, 31);
        RegistroAdocaoPainel.add(labelCpfTutor);
        
        JLabel labelEnderecoTutor = new JLabel("Endereço do tutor");
        labelEnderecoTutor.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelEnderecoTutor.setBounds(170, 139, 148, 31);
        RegistroAdocaoPainel.add(labelEnderecoTutor);

        JLabel labelTelefoneTutor = new JLabel("Telefone do tutor");
        labelTelefoneTutor.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelTelefoneTutor.setBounds(170, 200, 125, 31);
        RegistroAdocaoPainel.add(labelTelefoneTutor);
        
        //Adicionando textField com nome do tutor
        textFieldNomeTutor = new JTextField();
        textFieldNomeTutor.setBounds(170, 44, 208, 20);
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
        textFieldCpfTutor.setBounds(170, 233, 208, 20);
        RegistroAdocaoPainel.add(textFieldCpfTutor);
        textFieldCpfTutor.setColumns(10);
        
      //Adicionando textField com endereço do tutor
        textFieldEnderecoTutor = new JTextField();
        textFieldEnderecoTutor.setBounds(170, 169, 208, 20);
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
        textFieldTelefoneTutor.setBounds(170, 108, 208, 20);
        RegistroAdocaoPainel.add(textFieldTelefoneTutor);
        textFieldTelefoneTutor.setColumns(10);
        

        
        //Botão para registrar a adoção
        JButton btnAdotar = new JButton("Adotar");
        btnAdotar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		String nomeTutor = textFieldNomeTutor.getText();
        		String cpf = textFieldCpfTutor.getText();
        		String telefone = textFieldTelefoneTutor.getText();
        		String endereco = textFieldEnderecoTutor.getText();
        		int idPet = getIdPet();
        		String nomePet = getNomePet();
        		String tipoPet = getTipoPet();
        		
        		Adocoes adocao = new Adocoes (idPet, nomePet, tipoPet, nomeTutor, cpf, telefone, endereco);
        		AdocaoService service = new AdocaoService();
        		try {
					service.adotar(adocao);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        		
        		//Criar lógica de cadastrar tutor
        		
        		
        	}
        });
        btnAdotar.setBounds(424, 292, 104, 34);
        RegistroAdocaoPainel.add(btnAdotar);
        


	}
}
