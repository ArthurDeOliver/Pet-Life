package Telas;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class Main {

	private JFrame frame;
	private CardLayout cardLayout;
	private JPanel mainPanel;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
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
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		//carregar imagem
        
        frame = new JFrame();
        frame.getContentPane().setBackground(new Color(84, 97, 207));
        frame.setTitle("PetLife");       
        frame.setResizable(false);
        frame.setBounds(100, 100, 940, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
		//botões header
		JButton btnPets = new JButton("Pets");
		btnPets.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(mainPanel, "pets");
			}
		});
		btnPets.setFont(new Font("JetBrains Mono", Font.PLAIN, 14));
		btnPets.setBounds(397, 30, 99, 41);
		frame.getContentPane().add(btnPets);
		
		JButton btnAdocao = new JButton("Adoção");
		btnAdocao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(mainPanel, "adocao");
			}
		});
		btnAdocao.setFont(new Font("JetBrains Mono", Font.PLAIN, 14));
		btnAdocao.setBounds(597, 30, 99, 41);
		frame.getContentPane().add(btnAdocao);
		
		JButton btnRecursos = new JButton("Recursos");
		btnRecursos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(mainPanel, "recursos");
			}
		});
		btnRecursos.setFont(new Font("JetBrains Mono", Font.PLAIN, 14));
		btnRecursos.setBounds(797, 30, 99, 41);
		frame.getContentPane().add(btnRecursos);
		
		//painel de mudança de layout
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        mainPanel.setBounds(10, 100, 904, 450);
        frame.getContentPane().add(mainPanel);
        
        //adicionando paineis no frame mainpainel
        Home home = new Home();
        mainPanel.add(home, "home");
        mainPanel.add(new Pets(), "pets");
        mainPanel.add(new Adocao(), "adocao");
        mainPanel.add(new Recursos(), "recursos");
        
        JButton titlePetLife = new JButton("PetLife");
        titlePetLife.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		cardLayout.show(mainPanel,"home");
        	}
        });
        
        //botao título petLife
        titlePetLife.setForeground(new Color(0, 0, 0));
        titlePetLife.setBackground(new Color(255, 255, 255));
        titlePetLife.setBorderPainted(false);
        titlePetLife.setMargin(new Insets(0, 0, 0, 0));
        titlePetLife.setContentAreaFilled(false); 
        titlePetLife.setFocusPainted(false);
        titlePetLife.setFont(new Font("JetBrains Mono", Font.PLAIN, 30));
        titlePetLife.setBounds(89, 30, 149, 41);
        frame.getContentPane().add(titlePetLife);
        

        
        //carregar a imagem
        URL imgURL = getClass().getResource("/Imagens/veterinario (2).png");
        ImageIcon icon = new ImageIcon(imgURL);
        JLabel imagemLabel = new JLabel(icon);
        imagemLabel.setBounds(10, 11, 85, 78);
        frame.getContentPane().add(imagemLabel);
        
        
        
	}
}
