package br.edu.ifpe.discente.PetLife.ui;

import java.awt.Component;
import java.awt.Font;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
import br.edu.ifpe.discente.PetLife.ui.exception.BusinessException;

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
        lblNewLabel.setFont(new Font("DejaVu Sans", Font.PLAIN, 24));
        lblNewLabel.setBounds(10, 11, 77, 27);
        add(lblNewLabel);

        URL imgURL = getClass().getResource("/Imagens/casa.png");
        ImageIcon icon = new ImageIcon(imgURL);
        JLabel casaIcon = new JLabel(icon);
        casaIcon.setBounds(85, 6, 46, 37);
        add(casaIcon);

        JLabel petsHome = new JLabel("Últimos PETS cadastrados");
        petsHome.setFont(new Font("DejaVu Sans", Font.BOLD, 14));
        petsHome.setBounds(29, 151, 196, 14);
        add(petsHome);

        JLabel adotadosHome = new JLabel("Últimos pets ADOTADOS");
        adotadosHome.setFont(new Font("DejaVu Sans", Font.BOLD, 14));
        adotadosHome.setBounds(306, 151, 185, 14);
        add(adotadosHome);

        JLabel recursosHome = new JLabel("Últimos RECURSOS adicionados");
        recursosHome.setFont(new Font("DejaVu Sans", Font.BOLD, 14));
        recursosHome.setBounds(599, 151, 249, 14);
        add(recursosHome);

        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon(Home.class.getResource("/Imagens/bicho-de-estimacao.png")));
        lblNewLabel_1.setBounds(111, 103, 32, 37);
        add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setIcon(new ImageIcon(Home.class.getResource("/Imagens/coracaom.png")));
        lblNewLabel_2.setBounds(382, 103, 32, 37);
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

            criarTabelasHome();
            

        } catch (BusinessException | SQLException e) {
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
        
        if (tblAdotados != null) {
            Component[] components = getComponents();
            for (Component component : components) {
                if (component instanceof JScrollPane && ((JScrollPane) component).getViewport().getView() == tblAdotados) {
                    remove(component);
                    break;
                }
            }

            // Recria a tabela
            tblAdotados = new JTable();
        } 

        // Configura uma nova tabela
        criarTabelasHome();
    }
    
    public void criarTabelasHome() {

        // TABELA PETS
        DefaultTableModel tabelaPetHome = new DefaultTableModel();
        tabelaPetHome.addColumn("Nome");
        tabelaPetHome.addColumn("Espécie");

        // TABELA ADOCAO
        DefaultTableModel tabelaAdocaoHome = new DefaultTableModel();
        tabelaAdocaoHome.addColumn("Nome");
        tabelaAdocaoHome.addColumn("Espécie");
        tabelaAdocaoHome.addColumn("Tutor");
//        tabelaAdocaoHome.addColumn("Telefone");

        try {
            HomeService homeService = new HomeService();
            listaAnimais = homeService.retornarAnimal();
            listaAdotados = homeService.listarAdocoes();

        } catch (BusinessException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro ao criar tabelas da home", JOptionPane.ERROR_MESSAGE);
        }

        int totalAnimais = listaAnimais.size();
        int totalAdotados = listaAdotados.size();

        if (totalAnimais > 0) {
            // Preenche a tabela de pets
            for (Animais pet : listaAnimais) {
                String nome = pet.getNome();
                String tipo = pet.getTipo();
                String status = pet.getStatus();

                if ("Não apto".equals(status)) {
                    tabelaPetHome.addRow(new Object[]{nome, tipo});
                }
            }
        } else {
            tabelaPetHome.addRow(new Object[]{"Sem ", "cadastros!"});
        }

        if (totalAdotados > 0) {
            // Preenche a tabela de adoções
            for (Adocoes petAdotado : listaAdotados) {
                String nomePet = petAdotado.getNomePet();
                String tipo = petAdotado.getTipoPet();
                String nomeTutor = petAdotado.getNomeTutor();
//                String telTutor = petAdotado.getEndereco();

                tabelaAdocaoHome.addRow(new Object[]{nomePet, tipo, nomeTutor});
            }
        }

        // Configura a tabela de pets
        tblPets.setModel(tabelaPetHome);
        JScrollPane scrollPanePets = new JScrollPane(tblPets);
        scrollPanePets.setBounds(28, 197, 198, 186);
        this.add(scrollPanePets);

        // Configura a tabela de adoções
        tblAdotados.setModel(tabelaAdocaoHome);
        JScrollPane scrollPaneAdotados = new JScrollPane(tblAdotados);
        scrollPaneAdotados.setBounds(265, 197, 266, 186);
        this.add(scrollPaneAdotados);
    }
  
}

    

