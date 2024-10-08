package br.edu.ifpe.discente.PetLife.ui;

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
import javax.swing.JLabel;
import javax.swing.JPanel;

import br.edu.ifpe.discente.PetLife.business.BDService;

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
        frame.getContentPane().setBackground(new Color(7, 69, 114));
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
        Pets pets = new Pets();
        Adocao adocao = new Adocao();
        Recursos recursos = new Recursos();
        mainPanel.add(home, "home");
        mainPanel.add(pets, "pets");
        mainPanel.add(adocao, "adocao");
        mainPanel.add(recursos, "recursos");
        
		//HEADER BOTÕES DE NAVEGAÇÃO
        
        //botão abrir tela de Pets
		JButton btnAbrirTelaPets = new JButton("Pets");
		btnAbrirTelaPets.setIcon(new ImageIcon(Main.class.getResource("/Imagens/bicho-de-estimacao.png")));
		btnAbrirTelaPets.setForeground(new Color(0, 0, 0));
		
		btnAbrirTelaPets.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(mainPanel, "pets");
			}
		});
		btnAbrirTelaPets.setFont(new Font("DejaVu Sans", Font.PLAIN, 14));
		btnAbrirTelaPets.setBounds(385, 23, 113, 49);
		frame.getContentPane().add(btnAbrirTelaPets);
		
		//botão abrir tela de Adoção
		JButton btnAbrirTelaAdocao = new JButton("Adoção");
		btnAbrirTelaAdocao.setIcon(new ImageIcon(Main.class.getResource("/Imagens/coracaom.png")));
		btnAbrirTelaAdocao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(mainPanel, "adocao");
				adocao.recarregarTabelaAptos();
				adocao.btnDesabilitarRegistrarAdocao();
			}
		});
		btnAbrirTelaAdocao.setFont(new Font("DejaVu Sans", Font.PLAIN, 14));
		btnAbrirTelaAdocao.setBounds(553, 23, 129, 49);
		frame.getContentPane().add(btnAbrirTelaAdocao);
		
		//botão abrir tela de Recursos
		JButton btnAbrirTelaRecursos = new JButton("Recursos");
		btnAbrirTelaRecursos.setIcon(new ImageIcon(Main.class.getResource("/Imagens/estatisticas2.png")));
		btnAbrirTelaRecursos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(mainPanel, "recursos");
				if (recursos.retornarComboBoxFiltro().getSelectedItem() == "Todos") {
					recursos.recarregarTabelaGastos();
				} else {
					recursos.recarregarTabelaGastosPorTipo();
				}
			}
		});
		btnAbrirTelaRecursos.setFont(new Font("DejaVu Sans", Font.PLAIN, 14));
		btnAbrirTelaRecursos.setBounds(748, 23, 134, 49);
		frame.getContentPane().add(btnAbrirTelaRecursos);
		
		//botão abrir tela Home
		JButton btnAbrirTelaHome = new JButton("    PetLife");
		btnAbrirTelaHome.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        home.atualizarTabela();
		        cardLayout.show(mainPanel, "home");
		    }
		});

        //botao título petLife
        btnAbrirTelaHome.setForeground(new Color(255, 255, 255));
        btnAbrirTelaHome.setBorderPainted(false);
        btnAbrirTelaHome.setMargin(new Insets(0, 0, 0, 0));
        btnAbrirTelaHome.setContentAreaFilled(false); 
        btnAbrirTelaHome.setFocusPainted(false);
        btnAbrirTelaHome.setFont(new Font("DejaVu Sans", Font.PLAIN, 30));
        btnAbrirTelaHome.setBounds(10, 23, 241, 58);
        frame.getContentPane().add(btnAbrirTelaHome);

        URL imgURL = getClass().getResource("/Imagens/veterinario.png");
        ImageIcon icon = new ImageIcon(imgURL);
        JLabel imagemLabel = new JLabel(icon);
        imagemLabel.setBounds(10, 11, 85, 78);
        frame.getContentPane().add(imagemLabel);
        
        
        
	}
}

