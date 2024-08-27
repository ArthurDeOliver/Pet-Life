package br.edu.ifpe.discente.PetLife.ui;

import java.awt.Component;
import java.awt.Font;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
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

            
            criarTabelaPetsHome();
            

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void atualizarTabela() {
        // Verifica se a tabela já foi criada
        if (tblPets != null) {
            Component[] components = getComponents();
            for (Component component : components) {
                if (component instanceof JScrollPane && ((JScrollPane) component).getViewport().getView() == tblPets) {
                    remove(component);
                    break;
                }
            }

            // Recria a tabela
            tblPets = new JTable();
        } 

        // Configura uma nova tabela
        criarTabelaPetsHome();
    }
    
    public void criarTabelaPetsHome() {
    	
    	System.out.println("entrou na criação da tabela");
    	
        // Cria um modelo de tabela com as colunas "Nome" e "Tipo"
        DefaultTableModel tabelaPetHome = new DefaultTableModel();
        tabelaPetHome.addColumn("Nome");
        tabelaPetHome.addColumn("Tipo");

        // Atualiza a lista de animais antes de preencher a tabela
        try {
            HomeService homeService = new HomeService();
            listaAnimais = homeService.retornarAnimal();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        int totalAnimais = listaAnimais.size();
//        System.out.println("Total de Animais: " + totalAnimais);

        if (totalAnimais > 0) {
            for (Animais pet : listaAnimais) {
                String nome = pet.getNome();
                String raca = pet.getRaca();
                String status = pet.getStatus();

                if ("Não apto".equals(status)) {
                    tabelaPetHome.addRow(new Object[]{nome, raca});
                }
            }
        } else {
            // Adiciona uma linha indicando que não há registros
            tabelaPetHome.addRow(new Object[]{"Sem ", "cadastros!"});
        }

        // Define o modelo da tabela
        tblPets.setModel(tabelaPetHome);

        // Se o scroll pane ainda não foi adicionado, adicione-o
        JScrollPane scrollPanePets = new JScrollPane(tblPets);
        scrollPanePets.setBounds(77, 198, 169, 186);
        this.add(scrollPanePets);
    }

  //mandar pro repositorio
}

    

