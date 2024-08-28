package br.edu.ifpe.discente.PetLife.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
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
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import br.edu.ifpe.discente.PetLife.business.AnimaisService;
import br.edu.ifpe.discente.PetLife.ui.entities.Animais;
import br.edu.ifpe.discente.PetLife.ui.exception.BusinessException;

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
	private Adocao mainWindowAdocao;
	private JRadioButton RadioButtonSemRacaPet;
	private JRadioButton RadioButtonRacaDefinidaPet;
	private FileInputStream fis;
	private int tamanho;
	private Map<Integer, String> fotoMap = new HashMap<>();

	
	public TelaEdicaoPet(Pets mainWindow, Adocao mainWindowAdocao) {
		this.mainWindow = mainWindow;
		this.mainWindowAdocao = mainWindowAdocao;
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
        labelRaçaPet.setBounds(62, 250, 46, 31);
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
        
        
        RadioButtonSemRacaPet.setBounds(62, 280, 153, 23);
        edicaoPetCorpoPainel.add(RadioButtonSemRacaPet);
        
        RadioButtonRacaDefinidaPet.setBounds(62, 300, 95, 23);
        edicaoPetCorpoPainel.add(RadioButtonRacaDefinidaPet);
        
        
        ButtonGroup grupoRadioButtons = new ButtonGroup();
        grupoRadioButtons.add(RadioButtonRacaDefinidaPet);
        grupoRadioButtons.add(RadioButtonSemRacaPet);
        
        textFieldRacaPet = new JFormattedTextField();
        textFieldRacaPet.setEditable(false);
        textFieldRacaPet.setBounds(158, 303, 80, 20);
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
        comboBoxStatusPet.setModel(new DefaultComboBoxModel(new String[] {"Apto", "Não apto"}));
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
        		JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                fileChooser.setFileFilter(new FileNameExtensionFilter("Arquivo de imagens (*.PNG, *.JPG, *.JPEG)", "png", "jpg", "jpeg"));
                int result = fileChooser.showOpenDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    fis = null;
                    try {
                        fis = new FileInputStream(file);
                        tamanho = (int) file.length();
                        labelFotoPet.setText(file.getName());
                        fotoMap.put(petID, file.getAbsolutePath());
                    } catch (FileNotFoundException ex) {
                    	JOptionPane.showMessageDialog(null, "Arquivo não encontrado: ", "Erro ao Abrir Arquivo", JOptionPane.ERROR_MESSAGE);
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
                try {
                    String nome = textFieldNomePet.getText();
                    int idade = Integer.parseInt(textFieldIdadePet.getText()); 
                    String tipo = comboBoxTipoPet.getSelectedItem().toString();
                    String raca = textFieldRacaPet.getText();
                    int racao = Integer.parseInt(textFieldRacao.getText()); 
                    String status = comboBoxStatusPet.getSelectedItem().toString();

                    if (fotoMap.containsKey(petID)) {
                        String appDataPath = System.getenv("APPDATA");
                        File appDataDir = new File(appDataPath, "Petlife/Imagens");
                        if (!appDataDir.exists()) {
                            appDataDir.mkdirs();
                        }

                        String originalPath = fotoMap.get(petID);

                        String fileName = "foto" + petID; 

                        File destFile = new File(appDataDir, fileName);

                        try {
							Files.copy(Paths.get(originalPath), destFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
						} catch (IOException e1) {
							 JOptionPane.showMessageDialog(null, "Erro ao copiar o arquivo de imagem: " + 
								        JOptionPane.ERROR_MESSAGE);
						}

                        animalSelecionado.setFoto(destFile.getAbsolutePath());
                    }

                    AnimaisService servico = new AnimaisService();
                    servico.atualizarAnimal(nome, idade, tipo, raca, racao, status, petID);

                    dispose();

                    mainWindow.recarregarTabela();
                    mainWindow.recarregarTabelaAptos();   
                    
                    JOptionPane.showMessageDialog(null, "Pet editado com sucesso");

                } catch (BusinessException | SQLException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Não foi possível", JOptionPane.ERROR_MESSAGE);
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