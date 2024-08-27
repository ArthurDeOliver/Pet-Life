package br.edu.ifpe.discente.PetLife.ui;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import br.edu.ifpe.discente.PetLife.business.BDService;
import javax.swing.JLabel;

public class Main {

	private JFrame frame;
	private CardLayout cardLayout;
	private JPanel mainPanel;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		
		
        try {

    		BDService bdservice = new BDService();
            bdservice.iniciarBD(); //inicializando bd e tabela
        } catch (Exception e) {
            e.printStackTrace();
        }
        
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
		
        frame = new JFrame();
        frame.getContentPane().setBackground(new Color(24, 107, 220));
        frame.setTitle("PetLife");       
        frame.setResizable(false);
        frame.setBounds(100, 100, 940, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
		//MAIN PAINEL
		
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
        
		//HEADER BOTÕES DE NAVEGAÇÃO
        
        //botão abrir tela de Pets
		JButton btnAbrirTelaPets = new JButton("Pets");
		btnAbrirTelaPets.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(mainPanel, "pets");
			}
		});
		btnAbrirTelaPets.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAbrirTelaPets.setBounds(382, 23, 113, 49);
		frame.getContentPane().add(btnAbrirTelaPets);
		
		//botão abrir tela de Adoção
		JButton btnAbrirTelaAdocao = new JButton("Adoção");
		btnAbrirTelaAdocao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(mainPanel, "adocao");
				
			}
		});
		btnAbrirTelaAdocao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAbrirTelaAdocao.setBounds(596, 23, 113, 49);
		frame.getContentPane().add(btnAbrirTelaAdocao);
		
		//botão abrir tela de Recursos
		JButton btnAbrirTelaRecursos = new JButton("Recursos");
		btnAbrirTelaRecursos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(mainPanel, "recursos");
			}
		});
		btnAbrirTelaRecursos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAbrirTelaRecursos.setBounds(796, 23, 113, 49);
		frame.getContentPane().add(btnAbrirTelaRecursos);
		
		//botão abrir tela Home
		JButton btnAbrirTelaHome = new JButton("      PetLife");
		btnAbrirTelaHome.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        home.atualizarTabela();
		        cardLayout.show(mainPanel, "home");
		    }
		});

        //botao título petLife
        btnAbrirTelaHome.setForeground(new Color(0, 0, 0));
        btnAbrirTelaHome.setBackground(new Color(255, 255, 255));
        btnAbrirTelaHome.setBorderPainted(false);
        btnAbrirTelaHome.setMargin(new Insets(0, 0, 0, 0));
        btnAbrirTelaHome.setContentAreaFilled(false); 
        btnAbrirTelaHome.setFocusPainted(false);
        btnAbrirTelaHome.setFont(new Font("Tahoma", Font.PLAIN, 30));
        btnAbrirTelaHome.setBounds(10, 23, 228, 58);
        frame.getContentPane().add(btnAbrirTelaHome);
        //mandar pro repositorio
        //carregar a imagem
        URL imgURL = getClass().getResource("/Imagens/veterinario.png");
        ImageIcon icon = new ImageIcon(imgURL);
        JLabel imagemLabel = new JLabel(icon);
        imagemLabel.setBounds(10, 11, 85, 78);
        frame.getContentPane().add(imagemLabel);
        
        
        
	}
}
