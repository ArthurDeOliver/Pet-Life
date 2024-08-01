package Telas;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Label;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Home {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home window = new Home();
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
	public Home() {
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
		
		JButton btnPets = new JButton("Pets");
		btnPets.setBounds(310, 11, 99, 41);
		frame.getContentPane().add(btnPets);
		
		JButton btnAdocao = new JButton("Adoção");
		btnAdocao.setBounds(510, 11, 99, 41);
		frame.getContentPane().add(btnAdocao);
		
		JButton btnRecursos = new JButton("Recursos");
		btnRecursos.setBounds(710, 11, 99, 41);
		frame.getContentPane().add(btnRecursos);
		
		//labels textos
		JLabel label = new JLabel("PetLife");
		label.setFont(new Font("JetBrains Mono NL Medium", Font.PLAIN, 24));
		label.setBounds(39, 22, 107, 22);
		frame.getContentPane().add(label);
		
		JLabel lblNewLabel = new JLabel("PetLife");
		lblNewLabel.setFont(new Font("JetBrains Mono", Font.PLAIN, 50));
		lblNewLabel.setBounds(329, 255, 210, 66);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Cuidando das informações vitais dos pets");
		lblNewLabel_1.setFont(new Font("JetBrains Mono", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(332, 332, 360, 22);
		frame.getContentPane().add(lblNewLabel_1);
	}

}
