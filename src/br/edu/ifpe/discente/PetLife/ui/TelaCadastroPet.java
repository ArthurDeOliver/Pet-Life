package br.edu.ifpe.discente.PetLife.ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;

public class TelaCadastroPet extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

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
        
        JPanel panel = new JPanel();
        panel.setBounds(10, 11, 538, 42);
        contentPane.add(panel);
        
        JLabel lblNewLabel = new JLabel("Cadastro de Pet");
        lblNewLabel.setFont(new Font("JetBrains Mono", Font.PLAIN, 16));
        lblNewLabel.setIcon(new ImageIcon(TelaCadastroPet.class.getResource("/Imagens/procurado.png")));
        panel.add(lblNewLabel);

        // Adicione componentes ao contentPane, como campos de texto, rótulos, etc.
    }
}