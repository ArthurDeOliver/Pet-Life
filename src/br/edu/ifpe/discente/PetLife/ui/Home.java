package br.edu.ifpe.discente.PetLife.ui;

import java.awt.Component;
import java.awt.Font;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.edu.ifpe.discente.PetLife.business.HomeService;
import br.edu.ifpe.discente.PetLife.ui.entities.Adocoes;
import br.edu.ifpe.discente.PetLife.ui.entities.Animais;
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
    private List<Vacinas> listaVacina;
    private List<Medicamentos> listaMedicamento;
    private List<Racoes> listaRacao;

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
        petsHome.setBounds(39, 151, 196, 14);
        add(petsHome);

        JLabel adotadosHome = new JLabel("Últimos pets ADOTADOS");
        adotadosHome.setFont(new Font("DejaVu Sans", Font.BOLD, 14));
        adotadosHome.setBounds(315, 151, 185, 14);
        add(adotadosHome);

        JLabel recursosHome = new JLabel("Últimos RECURSOS adicionados");
        recursosHome.setFont(new Font("DejaVu Sans", Font.BOLD, 14));
        recursosHome.setBounds(598, 151, 249, 14);
        add(recursosHome);

        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon(Home.class.getResource("/Imagens/bicho-de-estimacao.png")));
        lblNewLabel_1.setBounds(121, 103, 32, 37);
        add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setIcon(new ImageIcon(Home.class.getResource("/Imagens/coracaom.png")));
        lblNewLabel_2.setBounds(391, 103, 32, 37);
        add(lblNewLabel_2);

        JLabel lblNewLabel_3 = new JLabel("");
        lblNewLabel_3.setIcon(new ImageIcon(Home.class.getResource("/Imagens/estatisticas2.png")));
        lblNewLabel_3.setBounds(703, 103, 24, 37);
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

            criarTabelasHome();

        } catch (BusinessException | SQLException e1) {
//            JOptionPane.showMessageDialog(null, "Erro ao recuperar dados", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void atualizarTabela() {
        // Verifica e remove as tabelas existentes, recriando-as em seguida
        removerTabelaExistente(tblPets);
        removerTabelaExistente(tblAdotados);
        removerTabelaExistente(tblRecursos);

        criarTabelasHome();
    }

    private void removerTabelaExistente(JTable tabela) {
        if (tabela != null) {
            Component[] components = getComponents();
            for (Component component : components) {
                if (component instanceof JScrollPane && ((JScrollPane) component).getViewport().getView() == tabela) {
                    remove(component);
                    break;
                }
            }
            tabela = new JTable();
        }
    }

    public void criarTabelasHome() {
        // Criação e configuração das tabelas
        DefaultTableModel tabelaPetHome = criarTabelaModelo(new String[]{"Nome", "Espécie"});
        DefaultTableModel tabelaAdocaoHome = criarTabelaModelo(new String[]{"Nome", "Espécie", "Tutor"});
        DefaultTableModel tabelaRecHome = criarTabelaModelo(new String[]{"Nome", "Tipo", "Custo"});

        try {
            HomeService homeService = new HomeService();
            listaAnimais = homeService.retornarAnimal();
            listaAdotados = homeService.listarAdocoes();
            listaRacao = homeService.retornarTodasRacoes();
            listaMedicamento = homeService.retornarTodosMedicamentos();
            listaVacina = homeService.retornarTodasVacinas();

        } catch (BusinessException | SQLException e) {
//            JOptionPane.showMessageDialog(null, " ao criar tabelas da home", "Erro", JOptionPane.ERROR_MESSAGE);
        }

        preencherTabelaPets(tabelaPetHome);
        preencherTabelaAdocao(tabelaAdocaoHome);
        preencherTabelaRecursos(tabelaRecHome);

        configurarTabela(tblPets, tabelaPetHome, 38, 197, 198, 186);
        configurarTabela(tblAdotados, tabelaAdocaoHome, 274, 197, 266, 186);
        configurarTabela(tblRecursos, tabelaRecHome, 578, 197, 288, 186);
    }

    private DefaultTableModel criarTabelaModelo(String[] colunas) {
        DefaultTableModel modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        for (String coluna : colunas) {
            modelo.addColumn(coluna);
        }
        return modelo;
    }

    private void preencherTabelaPets(DefaultTableModel modelo) {
        for (Animais pet : listaAnimais) {
            String status = pet.getStatus();
            if ("Não apto".equals(status)) {
                modelo.addRow(new Object[]{pet.getNome(), pet.getTipo()});
            }
        }
        if (modelo.getRowCount() == 0) {
            modelo.addRow(new Object[]{"Sem ", "cadastros!"});
        }
    }

    private void preencherTabelaAdocao(DefaultTableModel modelo) {
        for (Adocoes petAdotado : listaAdotados) {
            modelo.addRow(new Object[]{petAdotado.getNomePet(), petAdotado.getTipoPet(), petAdotado.getNomeTutor()});
        }
    }

    private void preencherTabelaRecursos(DefaultTableModel modelo) {
        for (Vacinas vacina : listaVacina) {
            modelo.addRow(new Object[]{vacina.getNomeVacina(), "Vacina", vacina.getValorVacina()});
        }
        for (Medicamentos medicamento : listaMedicamento) {
            modelo.addRow(new Object[]{medicamento.getNomeMedicamento(), "Medicamento", medicamento.getValorMedicamento()});
        }
        for (Racoes racao : listaRacao) {
            modelo.addRow(new Object[]{racao.getMarcaRacao(), "Ração", racao.getValorRacao()});
        }
    }

    private void configurarTabela(JTable tabela, DefaultTableModel modelo, int x, int y, int largura, int altura) {
        tabela.setModel(modelo);
        tabela.setRowSelectionAllowed(false);
        tabela.setColumnSelectionAllowed(false);
        JScrollPane scrollPane = new JScrollPane(tabela);
        scrollPane.setBounds(x, y, largura, altura);
        this.add(scrollPane);
    }
}
