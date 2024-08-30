package br.edu.ifpe.discente.PetLife.ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import br.edu.ifpe.discente.PetLife.business.AnimaisService;
import br.edu.ifpe.discente.PetLife.ui.entities.Animais;
import br.edu.ifpe.discente.PetLife.ui.exception.BusinessException;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Window;

import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;

public class TelaCadastroPet extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldNomePet;
	private JTextField textFieldIdadePet;
	private JTextField textFieldRacaPet;
	private Pets mainWindow;

    /**
     * Create the frame.
     * @param mainWindowAdocao 
     */
    public TelaCadastroPet(Pets mainWindow) {
    	this.mainWindow = mainWindow;
    	setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 580, 455);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(6, 26, 53));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JPanel CadastroPetPainel = new JPanel();
        CadastroPetPainel.setBounds(10, 11, 544, 42);
        contentPane.add(CadastroPetPainel);
        
        JLabel lblNewLabel = new JLabel("Cadastro de Pet");
        lblNewLabel.setFont(new Font("DejaVu Sans", Font.BOLD, 16));
        lblNewLabel.setIcon(new ImageIcon(TelaCadastroPet.class.getResource("/Imagens/procurado.png")));
        CadastroPetPainel.add(lblNewLabel);
        
        JPanel CadastroPetCorpoPainel = new JPanel();
        CadastroPetCorpoPainel.setBounds(10, 68, 544, 337);
        contentPane.add(CadastroPetCorpoPainel);
        CadastroPetCorpoPainel.setLayout(null);
        
        JLabel labelNomePet = new JLabel("Nome");
        labelNomePet.setFont(new Font("DejaVu Sans", Font.BOLD, 14));
        labelNomePet.setBounds(170, 11, 67, 31);
        CadastroPetCorpoPainel.add(labelNomePet);
        
        JLabel labelIdadePet = new JLabel("Idade");
        labelIdadePet.setFont(new Font("DejaVu Sans", Font.BOLD, 14));
        labelIdadePet.setBounds(170, 87, 46, 14);
        CadastroPetCorpoPainel.add(labelIdadePet);
        
        JLabel labelTipoPet = new JLabel("Tipo");
        labelTipoPet.setFont(new Font("DejaVu Sans", Font.BOLD, 14));
        labelTipoPet.setBounds(170, 143, 46, 31);
        CadastroPetCorpoPainel.add(labelTipoPet);
        
        textFieldNomePet = new JTextField();
        textFieldNomePet.setBounds(170, 44, 208, 20);
        CadastroPetCorpoPainel.add(textFieldNomePet);
        textFieldNomePet.setColumns(10);
        textFieldNomePet.getInputMap().put(KeyStroke.getKeyStroke("control V"), "none");
        
        textFieldIdadePet = new JTextField();
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
       
        textFieldIdadePet.setBounds(170, 112, 208, 20);
        CadastroPetCorpoPainel.add(textFieldIdadePet);
        textFieldIdadePet.setColumns(10);
        textFieldIdadePet.getInputMap().put(KeyStroke.getKeyStroke("control V"), "none");
        
        
        JComboBox comboBoxTipoPet = new JComboBox();
        comboBoxTipoPet.setModel(new DefaultComboBoxModel(new String[] {"Cachorro", "Gato"}));
        comboBoxTipoPet.setBounds(170, 177, 208, 22);
        CadastroPetCorpoPainel.add(comboBoxTipoPet);
        
        
        JLabel labelRaçaPet = new JLabel("Raça");
        labelRaçaPet.setFont(new Font("DejaVu Sans", Font.BOLD, 14));
        labelRaçaPet.setBounds(170, 214, 46, 31);
        CadastroPetCorpoPainel.add(labelRaçaPet);
        
        
        JRadioButton RadioButtonSemRacaPet = new JRadioButton("Sem raça definida");
        RadioButtonSemRacaPet.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if (RadioButtonSemRacaPet.isSelected()) {
        			textFieldRacaPet.setText(null);
        			textFieldRacaPet.setEditable(false);
        		}
        	}
        });
        
        JRadioButton RadioButtonRacaDefinidaPet = new JRadioButton("Raça definida:");
        RadioButtonRacaDefinidaPet.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if (RadioButtonRacaDefinidaPet.isSelected()) {
        			textFieldRacaPet.setEditable(true);
        		} 
        	}
        });
        
        
        ButtonGroup grupoRadioButtons = new ButtonGroup();
        grupoRadioButtons.add(RadioButtonRacaDefinidaPet);
        grupoRadioButtons.add(RadioButtonSemRacaPet);
        
        RadioButtonSemRacaPet.setBounds(170, 247, 153, 23);
        CadastroPetCorpoPainel.add(RadioButtonSemRacaPet);
        
        RadioButtonRacaDefinidaPet.setBounds(170, 273, 109, 23);
        CadastroPetCorpoPainel.add(RadioButtonRacaDefinidaPet);
        
        
        textFieldRacaPet = new JTextField();
        textFieldRacaPet.setEditable(false);
        textFieldRacaPet.setBounds(285, 274, 107, 20);
        CadastroPetCorpoPainel.add(textFieldRacaPet);
        textFieldRacaPet.setColumns(10);
        textFieldRacaPet.getInputMap().put(KeyStroke.getKeyStroke("control V"), "none");
        
        
        //----------------------------------------------------------------------
        
        JButton ButtonCadastroPet = new JButton("Cadastrar");
        ButtonCadastroPet.addActionListener(new ActionListener() {
        	
            public void actionPerformed(ActionEvent e) {
            	 	
            		try {
	                     String nome = textFieldNomePet.getText();
	                     int idade = Integer.parseInt(textFieldIdadePet.getText());
	                     String tipo = (String) comboBoxTipoPet.getSelectedItem();
	                     String raca = textFieldRacaPet.getText();
	                     if (RadioButtonSemRacaPet.isSelected()) {
	                    	 raca = "";
	                     } 
	                     int racao = 0;
	                     String status = null;
	                     String vacina = null;
	                     String foto = null;
	                     
	                
	                     Animais animal = new Animais(nome, idade, tipo, raca, racao ,status, vacina);
	                     AnimaisService service = new AnimaisService();
                                       
                     
     					service.criarAnimal(animal);
     					 int resposta = JOptionPane.showConfirmDialog(null, "Animal criado com sucesso! Deseja cadastrar outro?", "Confirmação", JOptionPane.YES_NO_OPTION);
     					 
     					if (resposta == JOptionPane.YES_OPTION) {
     						mainWindow.recarregarTabela();
     		                textFieldNomePet.setText("");
     		                textFieldIdadePet.setText("");
     		                comboBoxTipoPet.setSelectedIndex(0);
     		                textFieldRacaPet.setText("");
     		            } else {
     		            	mainWindow.recarregarTabela();
     		            	Window window = SwingUtilities.getWindowAncestor(TelaCadastroPet.this);
     		            	dispose();   
     		            }			
     					
     				} catch (IllegalArgumentException ex) {
     		            JOptionPane.showMessageDialog(null,"Todos os campos de texto são obrigatórios.", "Erro",  JOptionPane.ERROR_MESSAGE);
     		        } catch (BusinessException | SQLException ex2) {
     					JOptionPane.showMessageDialog(null, "Erro ao cadastrar animal" , "Erro", JOptionPane.ERROR_MESSAGE);
     				
     		        }

                 }
             });

        ButtonCadastroPet.setBounds(427, 287, 104, 34);
        CadastroPetCorpoPainel.add(ButtonCadastroPet);
    }
    
    
}