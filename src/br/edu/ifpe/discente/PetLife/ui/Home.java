package br.edu.ifpe.discente.PetLife.ui;

import java.awt.Font;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.edu.ifpe.discente.PetLife.business.HomeService;
import br.edu.ifpe.discente.PetLife.ui.entities.Animais;
import br.edu.ifpe.discente.PetLife.ui.entities.Adocoes;
import br.edu.ifpe.discente.PetLife.ui.entities.Medicamentos;
import br.edu.ifpe.discente.PetLife.ui.entities.Racoes;
import br.edu.ifpe.discente.PetLife.ui.entities.Vacinas;

public class Home extends JPanel {

    private static final long serialVersionUID = 1L;
    private JTable tblPets;
    private JTable tblAdotados;
    private JTable tblRecursos;
    private List<Animais> listaAnimais;
    private List<Adocoes> listaAdotados;
    private List<Object> listaDeRecursos;
    private List<Vacinas> listaVacina;
    private List<Medicamentos> listaMedicamento;
    private List<Racoes> listaRacao;

    /**
     * Create the panel.
     */
    public Home() {
        setLayout(null);

        JLabel lblNewLabel = new JLabel("Home");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
        lblNewLabel.setBounds(10, 11, 62, 27);
        add(lblNewLabel);

        URL imgURL = getClass().getResource("/Imagens/casa.png");
        ImageIcon icon = new ImageIcon(imgURL);
        JLabel casaIcon = new JLabel(icon);
        casaIcon.setBounds(70, 6, 46, 37);
        add(casaIcon);

        JLabel petsHome = new JLabel("Últimos PETS cadastrados");
        petsHome.setFont(new Font("Tahoma", Font.BOLD, 14));
        petsHome.setBounds(65, 151, 192, 14);
        add(petsHome);

        JLabel adotadosHome = new JLabel("Últimos pets ADOTADOS");
        adotadosHome.setFont(new Font("Tahoma", Font.BOLD, 14));
        adotadosHome.setBounds(355, 145, 169, 27);
        add(adotadosHome);

        JLabel recursosHome = new JLabel("Últimos RECURSOS adicionados");
        recursosHome.setFont(new Font("Tahoma", Font.BOLD, 14));
        recursosHome.setBounds(617, 151, 231, 14);
        add(recursosHome);

        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon(Home.class.getResource("/Imagens/bicho-de-estimacao.png")));
        lblNewLabel_1.setBounds(145, 103, 32, 37);
        add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setIcon(new ImageIcon(Home.class.getResource("/Imagens/clinica-de-cuidado-de-animais-domesticos.png")));
        lblNewLabel_2.setBounds(423, 103, 32, 37);
        add(lblNewLabel_2);

        JLabel lblNewLabel_3 = new JLabel("");
        lblNewLabel_3.setIcon(new ImageIcon(Home.class.getResource("/Imagens/racao-para-animais-de-estimacao1.png")));
        lblNewLabel_3.setBounds(713, 103, 39, 37);
        add(lblNewLabel_3);

        tblPets = new JTable();
        tblPets.setBounds(77, 198, 169, 186);
        add(tblPets);

        tblAdotados = new JTable();
        tblAdotados.setBounds(355, 198, 169, 186);
        add(tblAdotados);

        tblRecursos = new JTable();
        tblRecursos.setBounds(648, 198, 169, 186);
        add(tblRecursos);

        try {
            HomeService homeService = new HomeService();

            listaAnimais = homeService.retornarAnimal();
            listaAdotados = homeService.listarAdocoes();

            listaRacao = homeService.retornarTodasRacoes();
            listaMedicamento = homeService.retornarTodosMedicamentos();
            listaVacina = homeService.retornarTodasVacinas();

            listaDeRecursos = new ArrayList<>();
            listaDeRecursos.addAll(listaRacao);
            listaDeRecursos.addAll(listaMedicamento);
            listaDeRecursos.addAll(listaVacina);

            // Método para configurar a JTable com os nomes dos últimos 4 animais cadastrados
            configurarTabelaPets();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void configurarTabelaPets() {
        // Cria um modelo de tabela com uma coluna "Nome"
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Nome");

        // Adiciona os nomes dos últimos 4 animais à tabela
        int totalAnimais = listaAnimais.size();
        for (int i = totalAnimais - 1; i > totalAnimais - 5; i--) {
            model.addRow(new Object[]{listaAnimais.get(i).getNome()});
        }

        // Define o modelo da tabela
        tblPets.setModel(model);
    }
}
