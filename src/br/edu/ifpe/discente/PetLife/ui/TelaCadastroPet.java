package br.edu.ifpe.discente.PetLife.ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TelaCadastroPet extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldNomePet;
	private JTextField textFieldIdadePet;
	private JTextField textFieldRacaPet;

    /**
     * Create the frame.
     */
    public TelaCadastroPet() {
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
        lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 16));
        lblNewLabel.setIcon(new ImageIcon(TelaCadastroPet.class.getResource("/Imagens/procurado.png")));
        CadastroPetPainel.add(lblNewLabel);
        
        JPanel CadastroPetCorpoPainel = new JPanel();
        CadastroPetCorpoPainel.setBounds(10, 68, 544, 337);
        contentPane.add(CadastroPetCorpoPainel);
        CadastroPetCorpoPainel.setLayout(null);
        
        JLabel labelNomePet = new JLabel("Nome");
        labelNomePet.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelNomePet.setBounds(170, 11, 67, 31);
        CadastroPetCorpoPainel.add(labelNomePet);
        
        JLabel labelIdadePet = new JLabel("Idade");
        labelIdadePet.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelIdadePet.setBounds(170, 87, 46, 14);
        CadastroPetCorpoPainel.add(labelIdadePet);
        
        JLabel labelTipoPet = new JLabel("Tipo");
        labelTipoPet.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelTipoPet.setBounds(170, 143, 46, 31);
        CadastroPetCorpoPainel.add(labelTipoPet);
        
        textFieldNomePet = new JTextField();
        textFieldNomePet.setBounds(170, 44, 208, 20);
        CadastroPetCorpoPainel.add(textFieldNomePet);
        textFieldNomePet.setColumns(10);
        
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
        
        JComboBox comboBoxTipoPet = new JComboBox();
        comboBoxTipoPet.setModel(new DefaultComboBoxModel(new String[] {"Cachorro", "Gato"}));
        comboBoxTipoPet.setBounds(170, 177, 208, 22);
        CadastroPetCorpoPainel.add(comboBoxTipoPet);
        
        JLabel labelRaçaPet = new JLabel("Raça");
        labelRaçaPet.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelRaçaPet.setBounds(170, 214, 46, 31);
        CadastroPetCorpoPainel.add(labelRaçaPet);
        
        JRadioButton RadioButtonSemRacaPet = new JRadioButton("Sem raça definida");
        RadioButtonSemRacaPet.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if (RadioButtonSemRacaPet.isSelected()) {
        			textFieldRacaPet.setEditable(false);
        		}
        	}
        });
        RadioButtonSemRacaPet.setBounds(170, 247, 153, 23);
        CadastroPetCorpoPainel.add(RadioButtonSemRacaPet);
        
        JRadioButton RadioButtonRacaDefinidaPet = new JRadioButton("Raça definida:");
        RadioButtonRacaDefinidaPet.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if (RadioButtonRacaDefinidaPet.isSelected()) {
        			textFieldRacaPet.setEditable(true);
        		} 
        	}
        });
        RadioButtonRacaDefinidaPet.setBounds(170, 273, 95, 23);
        CadastroPetCorpoPainel.add(RadioButtonRacaDefinidaPet);
        
        ButtonGroup grupoRadioButtons = new ButtonGroup();
        grupoRadioButtons.add(RadioButtonRacaDefinidaPet);
        grupoRadioButtons.add(RadioButtonSemRacaPet);
        
        textFieldRacaPet = new JTextField();
        textFieldRacaPet.setEditable(false);
        textFieldRacaPet.setBounds(271, 274, 107, 20);
        CadastroPetCorpoPainel.add(textFieldRacaPet);
        textFieldRacaPet.setColumns(10);
        
        JButton ButtonCadastroPet = new JButton("Enviar");
        ButtonCadastroPet.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String nomePet = textFieldNomePet.getText();
        		int idadePet = Integer.parseInt(textFieldIdadePet.getText());
        		boolean temRacaPet;
        		if (RadioButtonSemRacaPet.isSelected()) {
        			temRacaPet = false;
        		} else if (RadioButtonRacaDefinidaPet.isSelected()) {
        			temRacaPet = true;
        		}
        		
        		//try {
        		//	PetController controller = new PetController();
        		//	controller.criarPet(nomePet, idadePet, temRacaPet);
        		//} catch (BusinessException e) {
        	//		e.printStackTrace();
        	//	}
        		
        		
        		
        	}
        });
        ButtonCadastroPet.setBounds(445, 303, 89, 23);
        CadastroPetCorpoPainel.add(ButtonCadastroPet);

        // Adicione componentes ao contentPane, como campos de texto, rótulos, etc.
    }
}