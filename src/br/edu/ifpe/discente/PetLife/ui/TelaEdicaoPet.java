package br.edu.ifpe.discente.PetLife.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.net.URL;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class TelaEdicaoPet extends JFrame{
	
	private JPanel contentPane;
	private JTextField nomeTextField;
	private JTextField textFieldNomePet;
	private JTextField textFieldIdadePet;
	private JTextField textFieldRacaPet;
	private JTextField TextFieldRacao;
	private JTextField textFieldVacinasPet;
	private JFrame frame;
	
	public TelaEdicaoPet() {
		
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
        
      
   
	}
}
