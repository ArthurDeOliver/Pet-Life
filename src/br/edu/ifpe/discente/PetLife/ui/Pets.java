package br.edu.ifpe.discente.PetLife.ui;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import br.edu.ifpe.discente.PetLife.business.AnimaisService;
import br.edu.ifpe.discente.PetLife.ui.entities.Animais;
import br.edu.ifpe.discente.PetLife.ui.exception.BusinessException;
import br.edu.ifpe.discente.PetLife.ui.entities.Adocoes;
import br.edu.ifpe.discente.PetLife.ui.Adocao;
import javax.swing.JTable;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

public class Pets extends JPanel {

	private static final long serialVersionUID = 1L;

	private Adocao adocao;

	private JTextField textFieldNomePet;
	private JTextField textFieldTipoPet;
	private JTextField textFieldIdadePet;
	private JTextField textFieldRacaPet;
	private JTextField textFieldStatusPet;
	private List<Animais> listaDeAnimais;
	private JLabel labelFotoPet;
	private TabelaAnimal tabelaAnimal;
	private JButton btnEditarPets;
	private JButton btnExcluirPets;
	private Animais animalSelecionado;

	public Pets() {
		setLayout(null);

		// Carregar imagem no JPanel
		JLabel petsIcon = new JLabel(new ImageIcon(Pets.class.getResource("/Imagens/bicho-de-estimacao.png")));
		petsIcon.setBounds(63, 6, 46, 37);
		add(petsIcon);

		// Ação do botão para abrir a tela de cadastro
		JButton btnCadastroPet = new JButton("");
		btnCadastroPet.setHorizontalAlignment(SwingConstants.LEFT);
		btnCadastroPet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastroPet telaCadastroPet = new TelaCadastroPet(Pets.this);
				telaCadastroPet.setVisible(true);
			}
		});
		btnCadastroPet.setBounds(812, 11, 82, 46);

		// Carregar imagem
		URL imgURL1 = getClass().getResource("/Imagens/mais.png");
		URL imgURL2 = getClass().getResource("/Imagens/cachorrop.png");
		ImageIcon imgMais = new ImageIcon(imgURL1);
		ImageIcon imgPata = new ImageIcon(imgURL2);

		// Adicionar ícones ao botão
		JLabel iconMais = new JLabel(imgMais);
		JLabel iconPata = new JLabel(imgPata);

		iconMais.setBounds(5, 5, 32, 32);
		iconPata.setBounds(45, 5, 32, 32);

		btnCadastroPet.setLayout(null);
		btnCadastroPet.add(iconMais);
		btnCadastroPet.add(iconPata);

		add(btnCadastroPet);

		// Label escrito Pets
		JLabel petsLabel = new JLabel("Pets");
		petsLabel.setFont(new Font("JetBrains Mono", Font.PLAIN, 24));
		petsLabel.setBounds(10, 11, 56, 27);
		add(petsLabel);

		// Iniciar tabela de animais
		try {
			AnimaisService servico = new AnimaisService();
			listaDeAnimais = servico.retornarAnimal();
			tabelaAnimal = new TabelaAnimal(listaDeAnimais);

			JTable tabela = tabelaAnimal.getTabela();
			tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

			tabela.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {

					int linhaSelecionada = tabela.getSelectedRow();

					if (linhaSelecionada >= 0) {
						int idAnimal = (int) tabela.getValueAt(linhaSelecionada, 0);

						animalSelecionado = null;
						for (Animais animal : listaDeAnimais) {
							if (animal.getID() == idAnimal) {
								animalSelecionado = animal;
								animalSelecionado.setFoto(animal.getFoto());
								break;
							}
						}

						if (animalSelecionado != null) {
							textFieldNomePet.setText(animalSelecionado.getNome());
							textFieldTipoPet.setText(animalSelecionado.getTipo());
							textFieldRacaPet.setText(animalSelecionado.getRaca());
							textFieldIdadePet.setText(String.valueOf(animalSelecionado.getIdade()) + " anos");
							textFieldStatusPet.setText(animalSelecionado.getStatus());

							String fileName = "foto" + animalSelecionado.getID();
							String appDataPath = System.getenv("APPDATA");
							File appDataDir = new File(appDataPath, "Petlife/Imagens");
							File file = new File(appDataDir, fileName);

							if (file.exists()) {
								ImageIcon originalIcon = new ImageIcon(file.getAbsolutePath());
								Image originalImage = originalIcon.getImage();

								int labelLargura = labelFotoPet.getWidth();
								int labelAltura = labelFotoPet.getHeight();

								Image imagemAjustada = originalImage.getScaledInstance(labelLargura, labelAltura,
										Image.SCALE_SMOOTH);

								ImageIcon resizedIcon = new ImageIcon(imagemAjustada);
								labelFotoPet.setIcon(resizedIcon);
							} else {
								labelFotoPet.setIcon(null);
							}

							btnEditarPets.setEnabled(true);
							btnExcluirPets.setEnabled(true);

						} else {

							btnEditarPets.setEnabled(false);
							btnExcluirPets.setEnabled(false);
						}
					}
				}
			});

			JScrollPane scrollPaneAnimal = new JScrollPane(tabela);
			scrollPaneAnimal.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
			scrollPaneAnimal.setBounds(76, 131, 309, 280);
			add(scrollPaneAnimal);

			// Filtro de animais
			JComboBox<String> comboBoxFiltro = new JComboBox<>();
			comboBoxFiltro.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					List<Animais> listaFiltrada = new ArrayList<>();
					String tipoSelecionado = (String) comboBoxFiltro.getSelectedItem();
					DefaultTableModel modelo = tabelaAnimal.getModelo();
					modelo.setRowCount(0);

					for (Animais animalLista : listaDeAnimais) {
						if (tipoSelecionado.equals("Todos")) {
							listaFiltrada.addAll(listaDeAnimais);
							break;
						} else if (animalLista.getTipo().equals(tipoSelecionado)) {
							listaFiltrada.add(animalLista);
						}
					}

					for (Animais animalFiltrado : listaFiltrada) {
						modelo.addRow(new Object[] { // colocndo anmais filtrados
								animalFiltrado.getID(), animalFiltrado.getNome(), animalFiltrado.getTipo(),
								animalFiltrado.getIdade(), animalFiltrado.getRaca(), animalFiltrado.getRacao(),
								animalFiltrado.getStatus(), animalFiltrado.getVacina() });
					}

				}
			});

			comboBoxFiltro.setModel(new DefaultComboBoxModel<>(new String[] { "Todos", "Cachorro", "Gato" }));
			comboBoxFiltro.setBounds(270, 105, 115, 16);
			add(comboBoxFiltro);

		} catch (BusinessException | SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Erro iniciar tabela de pets",
					JOptionPane.ERROR_MESSAGE);
			tabelaAnimal = new TabelaAnimal(List.of());
		}

		// botão editar
		btnEditarPets = new JButton("Editar");
		btnEditarPets.setEnabled(false);
		btnEditarPets.setBounds(519, 393, 85, 21);
		btnEditarPets.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (animalSelecionado != null) {
					TelaEdicaoPet telaEdicaoPet = new TelaEdicaoPet(Pets.this, adocao);
					telaEdicaoPet.informacoesEditaveis(animalSelecionado);
					telaEdicaoPet.setVisible(true);
				}
			}
		});
		add(btnEditarPets);

		// botão excluir
		btnExcluirPets = new JButton("Excluir");
		btnExcluirPets.setEnabled(false);
		btnExcluirPets.setBounds(648, 393, 85, 21);

		btnExcluirPets.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (animalSelecionado != null) {

					try {

						AnimaisService servico = new AnimaisService();
						servico.deletarAnimal(animalSelecionado.getID());

						recarregarTabela();

						// limpando os campos da parte direita da tabela
						textFieldNomePet.setText("");
						textFieldTipoPet.setText("");
						textFieldIdadePet.setText("");
						textFieldRacaPet.setText("");
						textFieldStatusPet.setText("");
						labelFotoPet.setIcon(null);

						tabelaAnimal.getTabela().clearSelection(); // limpando linha da tabela

					} catch (BusinessException | SQLException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage(), "Erro ao excluir pet",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		add(btnExcluirPets);

		JLabel labelImagemPet = new JLabel("Foto");
		labelImagemPet.setFont(new Font("Tahoma", Font.BOLD, 11));
		labelImagemPet.setBounds(616, 105, 46, 14);
		add(labelImagemPet);

		JLabel labelIdadePet = new JLabel("Idade");
		labelIdadePet.setFont(new Font("Tahoma", Font.BOLD, 11));
		labelIdadePet.setBounds(651, 255, 33, 27);
		add(labelIdadePet);

		JLabel labelNomePet = new JLabel("Nome");
		labelNomePet.setFont(new Font("Tahoma", Font.BOLD, 11));
		labelNomePet.setBounds(444, 255, 33, 27);
		add(labelNomePet);

		JLabel labelTipoPet = new JLabel("Tipo");
		labelTipoPet.setFont(new Font("Tahoma", Font.BOLD, 11));
		labelTipoPet.setBounds(444, 305, 33, 27);
		add(labelTipoPet);

		JLabel labelRacaPet = new JLabel("Raça");
		labelRacaPet.setFont(new Font("Tahoma", Font.BOLD, 11));
		labelRacaPet.setBounds(651, 308, 33, 27);
		add(labelRacaPet);

		JLabel labelStatusPet = new JLabel("Status");
		labelStatusPet.setFont(new Font("Tahoma", Font.BOLD, 11));
		labelStatusPet.setBounds(522, 351, 37, 27);
		add(labelStatusPet);

		textFieldNomePet = new JTextField();
		textFieldNomePet.setEditable(false);
		textFieldNomePet.setBounds(483, 255, 105, 27);
		add(textFieldNomePet);
		textFieldNomePet.setColumns(10);

		textFieldTipoPet = new JTextField();
		textFieldTipoPet.setEditable(false);
		textFieldTipoPet.setColumns(10);
		textFieldTipoPet.setBounds(483, 305, 105, 27);
		add(textFieldTipoPet);

		textFieldIdadePet = new JTextField();
		textFieldIdadePet.setEditable(false);
		textFieldIdadePet.setColumns(10);
		textFieldIdadePet.setBounds(690, 255, 105, 27);
		add(textFieldIdadePet);

		textFieldRacaPet = new JTextField();
		textFieldRacaPet.setEditable(false);
		textFieldRacaPet.setColumns(10);
		textFieldRacaPet.setBounds(690, 308, 105, 27);
		add(textFieldRacaPet);

		textFieldStatusPet = new JTextField();
		textFieldStatusPet.setEditable(false);
		textFieldStatusPet.setColumns(10);
		textFieldStatusPet.setBounds(569, 351, 105, 27);
		add(textFieldStatusPet);

		labelFotoPet = new JLabel("");
		labelFotoPet.setBounds(557, 125, 140, 119);
		add(labelFotoPet);

	}

	public void recarregarTabela() {
		try {
			AnimaisService servico = new AnimaisService();
			List<Animais> listaAtualizada = servico.retornarAnimal();

			// Atualizar a lista de animais
			listaDeAnimais.clear();
			listaDeAnimais.addAll(listaAtualizada);

			// Atualizar o modelo da tabela
			DefaultTableModel modelo = tabelaAnimal.getModelo();
			modelo.setRowCount(0); // Limpar o modelo atual

			for (Animais animal : listaDeAnimais) {
				modelo.addRow(new Object[] { animal.getID(), animal.getNome(), animal.getTipo(), animal.getIdade(),
						animal.getRaca(), animal.getRacao(), animal.getStatus(), animal.getVacina() });
			}

			tabelaAnimal.getTabela().clearSelection();

		} catch (BusinessException | SQLException ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro ao atualizar a tabela",
					JOptionPane.ERROR_MESSAGE);
		}

	}

	public void recarregarTabelaAptos() {
		try {
			AnimaisService servico = new AnimaisService();
			List<Animais> listaPetsAdotaveis = servico.retornarAnimaisAptos();
			List<Animais> listaAtualizada = servico.retornarAnimaisAptos();

			// Atualizar a lista de animais

			listaPetsAdotaveis.clear();
			listaPetsAdotaveis.addAll(listaAtualizada);

			// Atualizar o modelo da tabela
			DefaultTableModel modelo = TabelaAdotaveis.getModelo();
			modelo.setRowCount(0); // Limpar o modelo atual

			for (Animais animal : listaPetsAdotaveis) {
				modelo.addRow(new Object[] { animal.getID(), animal.getNome(), animal.getTipo(), animal.getIdade(),
						animal.getRaca(), animal.getRacao(), animal.getStatus(), animal.getVacina() });
			}

			TabelaAdotaveis.getTabela().clearSelection();

		} catch (BusinessException | SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Erro ao recarregar a tabela de animais aptos",
					JOptionPane.ERROR_MESSAGE);
		}
	}
}