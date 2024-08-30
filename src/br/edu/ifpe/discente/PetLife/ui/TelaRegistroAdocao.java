package br.edu.ifpe.discente.PetLife.ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import br.edu.ifpe.discente.PetLife.business.AdocaoService;
import br.edu.ifpe.discente.PetLife.ui.entities.Adocoes;
import br.edu.ifpe.discente.PetLife.ui.exception.BusinessException;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaRegistroAdocao extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JFormattedTextField textFieldNomeTutor;
	private JFormattedTextField textFieldCpfTutor;
	private JFormattedTextField textFieldEnderecoTutor;
	private JFormattedTextField textFieldTelefoneTutor;
	static int idPet;
	static String nomePet;
	static String tipoPet;
	private static Adocao mainWindow;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 * 
	 */
	// Abrir tela selecionando Pet
	public TelaRegistroAdocao(Adocao mainWindow, int idPet, String nomePet, String tipoPet) {
		TelaRegistroAdocao.idPet = idPet;
		TelaRegistroAdocao.nomePet = nomePet;
		TelaRegistroAdocao.tipoPet = tipoPet;
		this.mainWindow = mainWindow;

		getContentPane().setLayout(null);
		initialize();
	}

	// Get e set para parâmetros recebidos dos Pets
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

		// Label de Registro de adoção
		JLabel lblRegistroAdocao = new JLabel("Registro de adoção");
		lblRegistroAdocao.setFont(new Font("DejaVu Sans", Font.BOLD, 16));
		lblRegistroAdocao.setIcon(new ImageIcon(
				TelaRegistroAdocao.class.getResource("/Imagens/clinica-de-cuidado-de-animais-domesticos.png")));
		panel.add(lblRegistroAdocao);

		JPanel RegistroAdocaoPainel = new JPanel();
		RegistroAdocaoPainel.setBounds(10, 68, 544, 337);
		contentPane.add(RegistroAdocaoPainel);
		RegistroAdocaoPainel.setLayout(null);

		JLabel labelNomeTutor = new JLabel("Nome do tutor");
		labelNomeTutor.setFont(new Font("DejaVu Sans", Font.BOLD, 14));
		labelNomeTutor.setBounds(170, 11, 118, 31);
		RegistroAdocaoPainel.add(labelNomeTutor);

		JLabel labelCpfTutor = new JLabel("CPF do tutor");
		labelCpfTutor.setFont(new Font("DejaVu Sans", Font.BOLD, 14));
		labelCpfTutor.setBounds(170, 75, 95, 31);
		RegistroAdocaoPainel.add(labelCpfTutor);

		JLabel labelEnderecoTutor = new JLabel("Endereço do tutor");
		labelEnderecoTutor.setFont(new Font("DejaVu Sans", Font.BOLD, 14));
		labelEnderecoTutor.setBounds(170, 139, 148, 31);
		RegistroAdocaoPainel.add(labelEnderecoTutor);

		JLabel labelTelefoneTutor = new JLabel("Telefone do tutor");
		labelTelefoneTutor.setFont(new Font("DejaVu Sans", Font.BOLD, 14));
		labelTelefoneTutor.setBounds(170, 200, 148, 31);
		RegistroAdocaoPainel.add(labelTelefoneTutor);

		// Adicionando textField com nome do tutor com no máximo 60 caracteres
		textFieldNomeTutor = new JFormattedTextField();
		textFieldNomeTutor.setBounds(170, 44, 208, 20);
		textFieldNomeTutor.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				if (textFieldNomeTutor.getText().length() >= 60) {
					e.consume();
				}
			}
		});
		RegistroAdocaoPainel.add(textFieldNomeTutor);
		textFieldNomeTutor.setColumns(10);
		textFieldNomeTutor.getInputMap().put(KeyStroke.getKeyStroke("control V"), "none");

		// Adicionando textField para cpf do tutor com máscara
		textFieldCpfTutor = new JFormattedTextField();
		try {
			MaskFormatter cpfMask = new MaskFormatter("###.###.###-##");
			cpfMask.setPlaceholderCharacter('_');
			textFieldCpfTutor = new JFormattedTextField(cpfMask);
		} catch (Exception e) {
			e.printStackTrace();
		}

		textFieldCpfTutor.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				String caracteres = "0123456789";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}

			}
		});
		textFieldCpfTutor.setBounds(170, 109, 208, 20);
		RegistroAdocaoPainel.add(textFieldCpfTutor);
		textFieldCpfTutor.setColumns(10);

		// Adicionando textField com endereço do tutor com 100 caracteres
		textFieldEnderecoTutor = new JFormattedTextField();
		textFieldEnderecoTutor.setBounds(170, 169, 208, 20);
		textFieldEnderecoTutor.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				if (textFieldNomeTutor.getText().length() >= 100) {
					e.consume();
				}
			}
		});

		RegistroAdocaoPainel.add(textFieldEnderecoTutor);
		textFieldEnderecoTutor.setColumns(10);
		textFieldEnderecoTutor.getInputMap().put(KeyStroke.getKeyStroke("control V"), "none");

		// Adicionando textField para telefone do tutor com máscara
		textFieldTelefoneTutor = new JFormattedTextField();
		try {
			MaskFormatter telefoneMask = new MaskFormatter("(##) #####-####");
			telefoneMask.setPlaceholderCharacter('_');
			textFieldTelefoneTutor = new JFormattedTextField(telefoneMask);
		} catch (Exception e) {
			e.printStackTrace();
		}

		textFieldTelefoneTutor.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				String caracteres = "0123456789";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}
		});
		textFieldTelefoneTutor.setBounds(170, 232, 208, 20);
		RegistroAdocaoPainel.add(textFieldTelefoneTutor);
		textFieldTelefoneTutor.setColumns(10);

		// Botão para registrar a adoção
		JButton btnAdotar = new JButton("Adotar");
		btnAdotar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainWindow.btnDesabilitarRegistrarAdocao();
				int idPet = getIdPet();
				String nomePet = getNomePet();
				String tipoPet = getTipoPet();
				String nomeTutor = textFieldNomeTutor.getText();
				String cpf = textFieldCpfTutor.getText();
				String telefone = textFieldTelefoneTutor.getText();
				String endereco = textFieldEnderecoTutor.getText();

				if (nomeTutor == null || nomeTutor.trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "É necessário inserir o nome do tutor para adotar pet!");
				} else if (cpf == null || cpf.equals("___.___.___-__")) {
					JOptionPane.showMessageDialog(null, "É necessário inserir o cpf do tutor para adotar pet!");
				} else if (telefone == null || telefone.equals("(__) _____-____")) {
					JOptionPane.showMessageDialog(null, "É necessário inserir o telefone do tutor para adotar pet!");
				} else if (endereco == null || endereco.trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "É necessário inserir o endereço do tutor para adotar pet!");
				} else {
					Adocoes adocao = new Adocoes(idPet, nomePet, tipoPet, nomeTutor, cpf, telefone, endereco);
					AdocaoService service = new AdocaoService();

					try {
						service.adotar(adocao);
						JOptionPane.showMessageDialog(null, "Animal adotado com sucesso!");
						mainWindow.recarregarTabelaAptos();
						mainWindow.recarregarTabelaAdocoes();
						Window window = SwingUtilities.getWindowAncestor(TelaRegistroAdocao.this);
						dispose();

					} catch (BusinessException | SQLException e1) {
						JOptionPane.showMessageDialog(null, "Ocorreu um erro ao tentar adotar esse animal.", "Erro", JOptionPane.ERROR_MESSAGE);

					}
				}
			}
		});
		btnAdotar.setBounds(424, 292, 104, 34);
		RegistroAdocaoPainel.add(btnAdotar);

	}
}
