package Telas;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Recursos {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Recursos window = new Recursos();
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
	public Recursos() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("PetLife");
		frame.setResizable(false); //permite que a tela não seja aumentada
		//tamanho padrão telas (940, 600)
		frame.setBounds(100, 100, 940, 600); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//botões navegação
		JButton btnPets = new JButton("Pets");
		btnPets.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPets.setBounds(307, 31, 99, 41);
		frame.getContentPane().add(btnPets);
		
		JButton btnAdocao = new JButton("Adoção");
		btnAdocao.setBounds(507, 31, 99, 41);
		frame.getContentPane().add(btnAdocao);
		
		JButton btnRecursos = new JButton("Recursos");
		btnRecursos.setBounds(707, 31, 99, 41);
		frame.getContentPane().add(btnRecursos);
		
		//labels textos
		JLabel label = new JLabel("PetLife");
		label.setFont(new Font("JetBrains Mono NL Medium", Font.PLAIN, 38));
		label.setBounds(39, 21, 161, 61);
		frame.getContentPane().add(label);
		
		JLabel petsTxt = new JLabel("Recursos");
		petsTxt.setFont(new Font("JetBrains Mono NL Medium", Font.PLAIN, 24));
		petsTxt.setBounds(39, 114, 117, 22);
		frame.getContentPane().add(petsTxt);
		
		JLabel iconeEstatisica = new JLabel("");
		iconeEstatisica.setIcon(new ImageIcon("C:\\Users\\Arthur.Angelo\\Downloads\\estatisticas (1).png"));
		iconeEstatisica.setBounds(166, 114, 24, 24);
		frame.getContentPane().add(iconeEstatisica);
	}

}
