package br.edu.ifpe.discente.PetLife.ui;

import java.awt.Font;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import br.edu.ifpe.discente.PetLife.business.AnimaisService;
import br.edu.ifpe.discente.PetLife.ui.entities.Animais;
import javax.swing.JScrollPane;
import br.edu.ifpe.discente.PetLife.ui.TabelaAdotaveis;

public class Adocao extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable tableAdotaveis;
	private JTable tableAdotados;
    private TabelaAdotaveis tabelaAnimaisAptos;
    private List<Animais> listaPetsAdotaveis;
    private JTextField textFieldNomePet;
    private JTextField textFieldTipoPet;
    private JTextField textFieldIdadePet;
    private JTextField textFieldRacaPet;
    private JTextField textFieldStatusPet;
    private JLabel labelFotoPet;
    

	/**
	 * Create the panel.
	 */
	public Adocao() {
		setLayout(null);
		
        URL imgURL = getClass().getResource("/Imagens/coracaom.png");
        ImageIcon icon = new ImageIcon(imgURL);
		JLabel adocaoIcon = new JLabel(icon);
		adocaoIcon.setBounds(90, 6, 46, 37);
		add(adocaoIcon);
		
		
		JLabel lblNewLabel = new JLabel("Adoção");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBounds(10, 14, 84, 20);
		add(lblNewLabel);
		
		JButton btnRegistrarAdocao = new JButton("");
		btnRegistrarAdocao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaRegistroAdocao telaAdocao = new TelaRegistroAdocao();
				telaAdocao.setVisible(true);
			}
		});
		URL imgURL1 = getClass().getResource("/Imagens/mais.png");
        URL imgURL2 = getClass().getResource("/Imagens/pawprint2.png");
        ImageIcon imgMais = new ImageIcon(imgURL1);
        ImageIcon imgPata = new ImageIcon(imgURL2);
		
        //Adicionar ícones ao botão
        JLabel iconMais = new JLabel(imgMais);
        JLabel iconPata = new JLabel(imgPata);
        
        iconMais.setBounds(5, 5, 32, 32);
        iconPata.setBounds(45, 5, 32, 32);

        btnRegistrarAdocao.setLayout(null);
        btnRegistrarAdocao.add(iconMais);
        btnRegistrarAdocao.add(iconPata);
		
		
		btnRegistrarAdocao.setBounds(812, 11, 82, 46);;
		add(btnRegistrarAdocao);
		
		//Label para tabela de Pets para adoção
		JLabel lblPetsParaAdocao = new JLabel("Pets para adoção");
		lblPetsParaAdocao.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPetsParaAdocao.setBounds(32, 53, 182, 70);
		add(lblPetsParaAdocao);
		
		//Criação da tabela de animais aptos
		 try {
	        	AnimaisService servico = new AnimaisService();
	            List<Animais> listaDeAnimaisAptos= servico.retornarAnimaisAptos();
	            tabelaAnimaisAptos = new TabelaAdotaveis(listaDeAnimaisAptos); // adicionando a lista de animais aptos na tabela
	            
	        } catch (SQLException e) {
	            e.printStackTrace();
	            tabelaAnimaisAptos = new TabelaAdotaveis(List.of()); // Cria uma tabela vazia se houver erro -- coloquei pra nao ficar vazio
	        }
		
		
		JScrollPane scrollPanePetsAdotaveis = new JScrollPane(tabelaAnimaisAptos.getTabelaAdotaveis());
        scrollPanePetsAdotaveis.addMouseListener(new MouseAdapter() {
        	
        	public void mouseClicked(MouseEvent e) {
        		int linhaSelecionada = tabelaAnimaisAptos.getTabelaAdotaveis().getSelectedRow();
        		if (linhaSelecionada >= 0) {
        			String nomeAnimal = (String) tabelaAnimaisAptos.getTabelaAdotaveis().getValueAt(linhaSelecionada, 1);
        			
        			Animais animalSelecionado = null;
        			for (Animais animal : listaPetsAdotaveis) {
        			    if (animal.getNome().equals(nomeAnimal)) {
        			        animalSelecionado = animal;
        			        break;
        			    }
        			}
        			
        			if (animalSelecionado != null) {
        				textFieldNomePet.setText("Nome: " + animalSelecionado.getNome());
        				textFieldTipoPet.setText("Tipo: " + animalSelecionado.getTipo());
        				textFieldRacaPet.setText("Raça: " + animalSelecionado.getRaca());
                        textFieldIdadePet.setText("Idade: " + animalSelecionado.getIdade());
                        textFieldStatusPet.setText("Status: " + animalSelecionado.getStatus());
                        
                        ImageIcon foto = new ImageIcon(animalSelecionado.getFoto());
                        labelFotoPet.setIcon(foto);
                        
                    }
        		}
        		
        	}
        });
		scrollPanePetsAdotaveis.setBounds(32, 128, 342, 288);
		add(scrollPanePetsAdotaveis);
		

		
		//Label para tabela de Pets adotados
		JLabel lblPetsAdotados = new JLabel("Pets adotados");
		lblPetsAdotados.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPetsAdotados.setBounds(516, 58, 234, 60);
		add(lblPetsAdotados);
		
		JScrollPane scrollPanePetsAdotados = new JScrollPane();
		scrollPanePetsAdotados.setBounds(516, 133, 342, 281);
		add(scrollPanePetsAdotados);
		
		tableAdotados = new JTable();
		scrollPanePetsAdotados.setViewportView(tableAdotados);
		tableAdotados.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nome", "Tipo", "Raça", "Idade", "Tutor"
			}
		));
	}
}
