package br.edu.ifpe.discente.PetLife.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import br.edu.ifpe.discente.PetLife.business.AnimaisService;
import br.edu.ifpe.discente.PetLife.ui.entities.Animais;

import javax.swing.JButton;

public class TelaEdicaoPet extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JFormattedTextField textFieldNomePet;
	private JFormattedTextField textFieldIdadePet;
	private JFormattedTextField textFieldRacaPet;
	private JFormattedTextField textFieldRacao;
	private JFormattedTextField textFieldTipoPet;
	private JFormattedTextField textFieldStatusPet;
	private JComboBox<String> comboBoxTipoPet;
	private JComboBox<String> comboBoxStatusPet;
	private Animais animalSelecionado;
	private int petID;
	private Pets mainWindow;
	private JRadioButton RadioButtonSemRacaPet;
	private JRadioButton RadioButtonRacaDefinidaPet;
	private FileInputStream fis;
	private int tamanho;
	
	
	
	
	public TelaEdicaoPet(Pets mainWindow) {
		this.mainWindow = mainWindow;
		setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 580, 455);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(6, 26, 53));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JPanel edicaoPetPainel= new JPanel();
        edicaoPetPainel.setBounds(10, 11, 544, 42);
        contentPane.add(edicaoPetPainel);
        
        JLabel lblNewLabel = new JLabel("Edição de Pet");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblNewLabel.setIcon(new ImageIcon(TelaCadastroPet.class.getResource("/Imagens/procurado.png")));
        edicaoPetPainel.add(lblNewLabel);
        
        JPanel edicaoPetCorpoPainel = new JPanel();
        edicaoPetCorpoPainel.setBounds(10, 68, 544, 337);
        contentPane.add(edicaoPetCorpoPainel);
        edicaoPetCorpoPainel.setLayout(null);
        
        JLabel labelNomePet = new JLabel("Nome");
        labelNomePet.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelNomePet.setBounds(62, 25, 67, 31);
        edicaoPetCorpoPainel.add(labelNomePet);
        
        JLabel labelIdadePet = new JLabel("Idade");
        labelIdadePet.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelIdadePet.setBounds(61, 103, 46, 23);
        edicaoPetCorpoPainel.add(labelIdadePet);
        
        JLabel labelTipoPet = new JLabel("Tipo");
        labelTipoPet.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelTipoPet.setBounds(59, 170, 46, 31);
        edicaoPetCorpoPainel.add(labelTipoPet);
        
        textFieldNomePet = new JFormattedTextField();
        textFieldNomePet.setBounds(60, 57, 176, 20);
        edicaoPetCorpoPainel.add(textFieldNomePet);
        textFieldNomePet.setColumns(10);
        textFieldNomePet.getInputMap().put(KeyStroke.getKeyStroke("control V"), "none");
        
        textFieldIdadePet = new JFormattedTextField();
        textFieldIdadePet.addKeyListener(new KeyAdapter() {
        	
        	public void keyTyped(KeyEvent e) {
        		String caracteres = "0123456789";
        		if (!caracteres.contains(e.getKeyChar()+"")) {
        			e.consume();
        		}
        		
        		if (textFieldIdadePet.getText().length() > 1) {
        			e.consume();
        		}
        		
        	}
        });
       
        textFieldIdadePet.setBounds(59, 129, 177, 20);
        edicaoPetCorpoPainel.add(textFieldIdadePet);
        textFieldIdadePet.setColumns(10);
        textFieldIdadePet.getInputMap().put(KeyStroke.getKeyStroke("control V"), "none");
        
        
        comboBoxTipoPet = new JComboBox();
        comboBoxTipoPet.setModel(new DefaultComboBoxModel(new String[] {"Cachorro", "Gato"}));
        comboBoxTipoPet.setBounds(58, 200, 178, 22);
        edicaoPetCorpoPainel.add(comboBoxTipoPet);
        
        
        JLabel labelRaçaPet = new JLabel("Raça");
        labelRaçaPet.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelRaçaPet.setBounds(58, 238, 46, 31);
        edicaoPetCorpoPainel.add(labelRaçaPet);
        
        
        RadioButtonSemRacaPet = new JRadioButton("Sem raça definida");
        RadioButtonSemRacaPet.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if (RadioButtonSemRacaPet.isSelected()) {
        			textFieldRacaPet.setText("");
        			textFieldRacaPet.setEditable(false);
        		}
        	}
        });
        
        RadioButtonRacaDefinidaPet = new JRadioButton("Raça definida:");
        RadioButtonRacaDefinidaPet.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if (RadioButtonRacaDefinidaPet.isSelected()) {
        			textFieldRacaPet.setEditable(true);
        		} 
        	}
        });
        
        
        RadioButtonSemRacaPet.setBounds(55, 265, 153, 23);
        edicaoPetCorpoPainel.add(RadioButtonSemRacaPet);
        
        RadioButtonRacaDefinidaPet.setBounds(55, 285, 95, 23);
        edicaoPetCorpoPainel.add(RadioButtonRacaDefinidaPet);
        
        
        ButtonGroup grupoRadioButtons = new ButtonGroup();
        grupoRadioButtons.add(RadioButtonRacaDefinidaPet);
        grupoRadioButtons.add(RadioButtonSemRacaPet);
        
        textFieldRacaPet = new JFormattedTextField();
        textFieldRacaPet.setEditable(false);
        textFieldRacaPet.setBounds(151, 292, 86, 15);
        edicaoPetCorpoPainel.add(textFieldRacaPet);
        textFieldRacaPet.setColumns(10);
        textFieldRacaPet.getInputMap().put(KeyStroke.getKeyStroke("control V"), "none");
        
        JLabel labelRacaoPet = new JLabel("Ração");
        labelRacaoPet.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelRacaoPet.setBounds(305, 32, 45, 23);
        edicaoPetCorpoPainel.add(labelRacaoPet);
        
        textFieldRacao = new JFormattedTextField();
        textFieldRacao.setBounds(305, 58, 176, 19);
        edicaoPetCorpoPainel.add(textFieldRacao);
        textFieldRacao.setColumns(10);
        textFieldRacao.getInputMap().put(KeyStroke.getKeyStroke("control V"), "none");
        
        JLabel labelStatusPet = new JLabel("Status");
        labelStatusPet.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelStatusPet.setBounds(305, 100, 46, 31);
        edicaoPetCorpoPainel.add(labelStatusPet);
        
        comboBoxStatusPet = new JComboBox();
        comboBoxStatusPet.setModel(new DefaultComboBoxModel(new String[] {"Adotado", "Apto", "Não apto"}));
        comboBoxStatusPet.setBounds(305, 128, 177, 22);
        edicaoPetCorpoPainel.add(comboBoxStatusPet);
        
        JLabel labelFotoPet = new JLabel("Foto");
        labelFotoPet.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelFotoPet.setBounds(309, 170, 45, 13);
        edicaoPetCorpoPainel.add(labelFotoPet);
        
        JButton btnFotoPet = new JButton("");
        btnFotoPet.setIcon(new ImageIcon(TelaEdicaoPet.class.getResource("/Imagens/camera.png")));
        btnFotoPet.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		JFileChooser foto = new JFileChooser();
        		foto.setDialogTitle("Procurar foto");
        		foto.setFileFilter(new FileNameExtensionFilter("Arquivo de Imagens (*.PNG, *JPG, *JPEG)", "png", "jpg", "jpeg"));
        		int resultado = foto.showOpenDialog(null);
        		if (resultado == JFileChooser.APPROVE_OPTION) {
        			try {
						fis = new FileInputStream(foto.getSelectedFile());
						tamanho = (int) foto.getSelectedFile().length();
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					}

        		}
        	}
        });
        btnFotoPet.setBounds(305, 192, 67, 42);
        edicaoPetCorpoPainel.add(btnFotoPet);
        
        JButton btnEdicaoPet = new JButton("OK");
        btnEdicaoPet.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnEdicaoPet.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                if (animalSelecionado != null) {
                    try {

                        AnimaisService servico = new AnimaisService();
                        
                        String nome = textFieldNomePet.getText();
                        int idade = Integer.parseInt(textFieldIdadePet.getText()); 
                        String tipo = comboBoxTipoPet.getSelectedItem().toString();
                        String raca = textFieldRacaPet.getText();
                        int racao = Integer.parseInt(textFieldRacao.getText()); 
                        String status = comboBoxStatusPet.getSelectedItem().toString();
                        String foto = ""; 

                        servico.atualizarAnimal(nome, idade, tipo, raca, racao, status, foto, petID);

                        JOptionPane.showMessageDialog(null, "Animal atualizado com sucesso!");
                        mainWindow.recarregarTabela();
                        Window window = SwingUtilities.getWindowAncestor(TelaEdicaoPet.this);
                        dispose();    

                    } catch (IllegalArgumentException ex) {
     		            JOptionPane.showMessageDialog(null, "Todos os campos de texto são obrigatórios.");
     		        } catch (SQLException ex) {
     		            ex.printStackTrace();
     		        }
                } else {
                    JOptionPane.showMessageDialog(null, "Nenhum animal selecionado.");
                }
            }
        });
        btnEdicaoPet.setBounds(459, 292, 75, 31);
        edicaoPetCorpoPainel.add(btnEdicaoPet);
	}
	
	
	
	// pegando informações do objeto animal e setando nos campos de texto da tela de edição

	public void informacoesEditaveis(Animais animalSelecionado) {
		
		
		textFieldNomePet.setText(animalSelecionado.getNome());
		textFieldIdadePet.setText(String.valueOf(animalSelecionado.getIdade()));
		textFieldRacaPet.setText(animalSelecionado.getRaca());
		textFieldRacao.setText(String.valueOf(animalSelecionado.getRacao()));
		comboBoxTipoPet.setSelectedItem(animalSelecionado.getTipo());
		comboBoxStatusPet.setSelectedItem(animalSelecionado.getStatus());
		this.animalSelecionado = animalSelecionado;
		petID = animalSelecionado.getID();
		if (textFieldRacaPet == null) {
	        RadioButtonSemRacaPet.setSelected(true);
	        textFieldRacaPet.setEditable(false);
	    } else {
	        RadioButtonRacaDefinidaPet.setSelected(true);
	        textFieldRacaPet.setEditable(true);
	    }

	}
}