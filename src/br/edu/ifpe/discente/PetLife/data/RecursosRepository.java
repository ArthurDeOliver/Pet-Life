package br.edu.ifpe.discente.PetLife.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import br.edu.ifpe.discente.PetLife.ui.entities.Animais;
import br.edu.ifpe.discente.PetLife.ui.entities.Medicamentos;
import br.edu.ifpe.discente.PetLife.ui.entities.Racoes;
import br.edu.ifpe.discente.PetLife.ui.entities.Vacinas;

public class RecursosRepository {

	private static final String URL = "jdbc:mysql://localhost:3306/";
	private static final String DB_NAME = "petlife";
	private static final String USER = "root"; // editável
	private static final String PASSWORD = "5972"; // editável

	private Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL + DB_NAME, USER, PASSWORD);
	}

	// cria o bd if not exists
	private void createDatabase() throws SQLException {
		try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
				Statement statement = connection.createStatement()) {
			String sql = "CREATE DATABASE IF NOT EXISTS " + DB_NAME;
			statement.executeUpdate(sql);
		}
	}

	// Criar tabela medicamento

	private void createTableMedicamento() throws SQLException {
		try (Connection connection = getConnection(); Statement statement = connection.createStatement()) {
			String sql = "CREATE TABLE IF NOT EXISTS medicamentos ("+ "id_Medicamento INT AUTO_INCREMENT," + "Nome_Medicamento VARCHAR(45), "
					+ "Quantidade_Medicamento INT, " + "Valor_Medicamento DECIMAL (10,2), "
					+ "Primary key (id_Medicamento)) ";
			statement.executeUpdate(sql);
		}
	}

	// Criar tabela ração

	private void createTableRacao() throws SQLException {
		try (Connection connection = getConnection(); Statement statement = connection.createStatement()) {
			String sql = "CREATE TABLE IF NOT EXISTS racoes (" + "id_Racao INT AUTO_INCREMENT,"+ "Marca_Racao VARCHAR(45), " + "Quantidade_Racao DECIMAL (10,2), "
					+ "Valor_Racao DECIMAL (10,2), " + "Primary key (id_Racao)) ";
			statement.executeUpdate(sql);
		}
	}

	// Criar tabela vacina

	private void createTableVacina() throws SQLException {
		try (Connection connection = getConnection(); Statement statement = connection.createStatement()) {
			String sql = "CREATE TABLE IF NOT EXISTS vacinas (" + "id_Vacina INT AUTO_INCREMENT,"+ "Nome_Vacina VARCHAR(45), "
					+ "Quantidade_Vacina INT, " + "Valor_Vacina DECIMAL (10,2), " + "Primary key (id_Vacina)) ";
			statement.executeUpdate(sql);
		}
	}

	// Criar tabela de animais medicados

	private void createTableAnimaisMedicados() throws SQLException {
		try (Connection connection = getConnection(); Statement statement = connection.createStatement()) {
			String sql = "CREATE TABLE IF NOT EXISTS animais_medicados (" + "id_animal int, "
					+ "nome_animal VARCHAR(45), " + "id_Medicamento int, " + "nome_medicamento VARCHAR(45),"
					+ "FOREIGN KEY (id_animal) references animais (id), "
					+ "FOREIGN KEY (id_Medicamento) references medicamentos (id_Medicamento))";
			statement.executeUpdate(sql);
		}
	}

	// Criar tabela de animais vacinados

	private void createTableAnimaisVacinados() throws SQLException {
		try (Connection connection = getConnection(); Statement statement = connection.createStatement()) {
			String sql = "CREATE TABLE IF NOT EXISTS animais_vacinados (" + "id_animal int, "
					+ "nome_animal VARCHAR(45), " + "id_vacina int, "+ "nome_vacina VARCHAR(45),"
					+ "FOREIGN KEY (id_animal) references animais (id), "
					+ "FOREIGN KEY (id_Vacina) references vacinas (id_Vacina))";
			statement.executeUpdate(sql);
		}
	}

	// inicia a tabela e o bd
	public void iniciarBdRecursos() throws SQLException {
		createDatabase();
		createTableMedicamento();
		createTableRacao();
		createTableVacina();
		createTableAnimaisMedicados();
		createTableAnimaisVacinados();
	}

	// Inserir vacina no banco de dados

	public void criarVacina(Vacinas vacina) throws SQLException {
		String sql = "INSERT INTO vacinas (Nome_Vacina, Quantidade_Vacina, Valor_Vacina) VALUES (?, ?, ?)";
		try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setString(1, vacina.getNomeVacina());
			statement.setInt(2, vacina.getQuantidadeVacina());
			statement.setDouble(3, vacina.getValorVacina());
			statement.execute();
		}
	}

	// Inserir medicamento no banco de dados

	public void criarMedicamento(Medicamentos medicamento) throws SQLException {
		String sql = "INSERT INTO medicamentos (Nome_Medicamento, Quantidade_Medicamento, Valor_Medicamento) VALUES (?, ?, ?)";
		try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setString(1, medicamento.getNomeMedicamento());
			statement.setInt(2, medicamento.getQuantidadeMedicamento());
			statement.setDouble(3, medicamento.getValorMedicamento());
			statement.execute();

		}
	}

	// Inserir ração no banco de dados

	public void criarRacao(Racoes racao) throws SQLException {
		String sql = "INSERT INTO racoes (Marca_Racao, Quantidade_Racao, Valor_Racao) VALUES (?, ?, ?)";
		try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setString(1, racao.getMarcaRacao());
			statement.setDouble(2, racao.getQuantidadeRacao());
			statement.setDouble(3, racao.getValorRacao());
			statement.execute();

		}
	}

	// Listar Medicamentos
	
	public List<Medicamentos> listarTodosMedicamentos() throws SQLException {
		String sql = "SELECT * FROM medicamentos";

		List<Medicamentos> listaDeMedicamentos = new LinkedList<>();

		try (Connection connection = getConnection();

				PreparedStatement statement = connection.prepareStatement(sql); // prepara as consultas no bd
				ResultSet rs = statement.executeQuery()) { // executa as consultas

			while (rs.next()) {

				Medicamentos medicamento = new Medicamentos(rs.getInt("id_Medicamento"),rs.getString("Nome_Medicamento"),
						rs.getInt("Quantidade_Medicamento"), rs.getDouble("Valor_Medicamento"));
				listaDeMedicamentos.add(medicamento);				
			}

			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaDeMedicamentos;

	}

	// Listar Rações
	
	public List<Racoes> listarTodasRacoes() throws SQLException {
		String sql = "SELECT * FROM racoes";

		List<Racoes> listaDeRacoes = new LinkedList<>();

		try (Connection connection = getConnection();

				PreparedStatement statement = connection.prepareStatement(sql); // prepara as consultas no bd
				ResultSet rs = statement.executeQuery()) { // executa as consultas

			while (rs.next()) {

				Racoes racao = new Racoes(rs.getInt("id_Racao"),rs.getString("Marca_Racao"), rs.getDouble("Quantidade_Racao"),
						rs.getDouble("Valor_Racao"));
				listaDeRacoes.add(racao);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaDeRacoes;

	}

	
	// Listar Vacinas
	
	public List<Vacinas> listarTodasVacinas() throws SQLException {
		String sql = "SELECT * FROM vacinas";

		List<Vacinas> listaDeVacinas = new LinkedList<>();

		try (Connection connection = getConnection();

				PreparedStatement statement = connection.prepareStatement(sql); // prepara as consultas no bd
				ResultSet rs = statement.executeQuery()) { // executa as consultas

			while (rs.next()) {

				Vacinas vacina = new Vacinas(rs.getInt("id_Vacina"),rs.getString("Nome_Vacina"), rs.getInt("Quantidade_Vacina"),
						rs.getDouble("Valor_Vacina"));
				listaDeVacinas.add(vacina);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaDeVacinas;

	}
	// Atualizar Medicamento
	public void atualizarMedicamento(String novoNome, int novaQuantidade, double novoValor, int id) throws SQLException  {
		
	    String sql = "UPDATE medicamentos SET Nome_Medicamento = ?, Quantidade_Medicamento = ?, Valor_Medicamento = ? WHERE id_Medicamento = ?";

	    try (Connection connection = getConnection(); 
	         PreparedStatement statement = connection.prepareStatement(sql)) {

	        statement.setString(1, novoNome);
	        statement.setInt(2, novaQuantidade);
	        statement.setDouble(3, novoValor);
	        statement.setInt(4, id);  
	        statement.executeUpdate();

	    } catch (SQLException e) {
	        e.printStackTrace();
	        }
	    	
	}
	// Atualizar Ração
	    public void atualizarRacao(String novoNome, Double novaQuantidade, double novoValor, int id) throws SQLException {
			
		    String sql = "UPDATE racoes SET Marca_Racao = ?, Quantidade_Racao = ?, Valor_Racao = ? WHERE id_Racao = ?";

		    try (Connection connection = getConnection(); 
		         PreparedStatement statement = connection.prepareStatement(sql)) {

		        statement.setString(1, novoNome);
		        statement.setDouble(2, novaQuantidade);
		        statement.setDouble(3, novoValor);
		        statement.setInt(4, id);  
		        statement.executeUpdate();

		    } catch (SQLException e) {
		        e.printStackTrace();
		        }
		    	
		}
	    //Atualizar Vacina
		public void atualizarVacina(String novoNome, int novaQuantidade, double novoValor, int id) throws SQLException {
				
			    String sql = "UPDATE vacinas SET Nome_Vacina = ?, Quantidade_Vacina = ?, Valor_Vacina = ? WHERE id_Vacina = ?";

			    try (Connection connection = getConnection(); 
			         PreparedStatement statement = connection.prepareStatement(sql)) {

			        statement.setString(1, novoNome);
			        statement.setInt(2, novaQuantidade);
			        statement.setDouble(3, novoValor);
			        statement.setInt(4, id);  
			        statement.executeUpdate();

			    } catch (SQLException e) {
			        e.printStackTrace();
			    }	
			}
		public void inserirMedicamentoAnimal(Animais animal, Medicamentos medicamento) throws SQLException {
				String sql = "INSERT INTO animais_medicados (id_animal, nome_animal, id_Medicamento, nome_medicamento) VALUES (?, ?, ?, ?)";
				try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
					statement.setInt(1, animal.getID());
					statement.setString(2, animal.getNome());
					statement.setInt(3, medicamento.getId());
					statement.setString(4, medicamento.getNomeMedicamento());
					statement.execute();
					}
				}
		public void inserirVacinaAnimal(Animais animal, Vacinas vacina) throws SQLException {
			String sql = "INSERT INTO animais_vacinados (id_animal, nome_animal, id_Vacina, nome_Vacina) VALUES (?, ?, ?, ?)";
			try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
				statement.setInt(1, animal.getID());
				statement.setString(2, animal.getNome());
				statement.setInt(3, vacina.getId());
				statement.setString(4, vacina.getNomeVacina());
				statement.execute();
				}
			}
		//Verifica se o animal ja esta vacinado com Vacina Selecionada
		public boolean animalJaVacinado(Animais animal, Vacinas vacina) throws SQLException {
		    String sql = "SELECT * FROM animais_vacinados WHERE id_animal = ? AND id_vacina = ?";
		    
		    try (Connection connection = getConnection();
		         PreparedStatement statement = connection.prepareStatement(sql)) {
		        
		        // Definindo os parâmetros antes de executar a consulta
		        statement.setInt(1, animal.getID());
		        statement.setInt(2, vacina.getId());
		        
		        // Executando a consulta
		        try (ResultSet rs = statement.executeQuery()) {
		            // Verificando se há algum resultado
		            if (rs.next()) {
		                return true; // O animal já está vacinado com essa vacina
		            }
		            return false; // O animal não está vacinado com essa vacina
		        }
		    }
		}
		public boolean animalJaMedicado(Animais animal, Medicamentos medicamento) throws SQLException {
		    String sql = "SELECT * FROM animais_medicados WHERE id_animal = ? AND id_medicamento = ?";
		    
		    try (Connection connection = getConnection();
		         PreparedStatement statement = connection.prepareStatement(sql)) {
		        
		        // Definindo os parâmetros antes de executar a consulta
		        statement.setInt(1, animal.getID());
		        statement.setInt(2, medicamento.getId());
		        
		        // Executando a consulta
		        try (ResultSet rs = statement.executeQuery()) {
		            // Verificando se há algum resultado
		            if (rs.next()) {
		                return true; // O animal já está vacinado com essa vacina
		            }
		            return false; // O animal não está vacinado com essa vacina
		        }
		    }
		}
		public void diminuirQuantidadeMedicamento(int id_Medicamento, int quantidadeNova) {
			 String sql = "UPDATE medicamentos SET  Quantidade_Medicamento = ? WHERE id_Medicamento = ?";

			    try (Connection connection = getConnection(); 
			         PreparedStatement statement = connection.prepareStatement(sql)) {

			        statement.setInt(1, quantidadeNova);
			        statement.setInt(2, id_Medicamento);
			        statement.executeUpdate();

			    } catch (SQLException e) {
			        e.printStackTrace();
			    }	
		}
		public void diminuirQuantidadeVacina(int id_Vacina, int quantidadeNova) {
			 String sql = "UPDATE vacinas SET  Quantidade_Vacina = ? WHERE id_Vacina = ?";

			    try (Connection connection = getConnection(); 
			         PreparedStatement statement = connection.prepareStatement(sql)) {

			        statement.setInt(1, quantidadeNova);
			        statement.setInt(2, id_Vacina);
			        statement.executeUpdate();

			    } catch (SQLException e) {
			        e.printStackTrace();
			    }	
		}
	
		}
