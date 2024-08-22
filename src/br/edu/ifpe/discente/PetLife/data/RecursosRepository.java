package br.edu.ifpe.discente.PetLife.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.edu.ifpe.discente.PetLife.ui.entities.Animais;
import br.edu.ifpe.discente.PetLife.ui.entities.Medicamentos;
import br.edu.ifpe.discente.PetLife.ui.entities.Vacinas;
import br.edu.ifpe.discente.PetLife.ui.exception.DataAccessException;

public class RecursosRepository {

	private static final String URL = "jdbc:mysql://localhost:3306/";
	private static final String DB_NAME = "petlife";
	private static final String USER = "root"; // editável
	private static final String PASSWORD = "root1"; // editável

	private Connection getConnection() throws DataAccessException {
		try {
			return DriverManager.getConnection(URL + DB_NAME, USER, PASSWORD);

		} catch (SQLException e) {
			throw new DataAccessException("Erro ao criar conexão com o banco de dados", e);
		}
	}

	// cria o bd if not exists
	private void createDatabase() throws DataAccessException {
		try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
				Statement statement = connection.createStatement()) {
			String sql = "CREATE DATABASE IF NOT EXISTS " + DB_NAME;
			statement.executeUpdate(sql);

		} catch (SQLException e) {
			throw new DataAccessException("Erro ao criar banco de dados", e);
		}
	}

	// Criar tabela medicamento

	private void createTableMedicamento() throws DataAccessException {
		try (Connection connection = getConnection(); Statement statement = connection.createStatement()) {
			String sql = "CREATE TABLE IF NOT EXISTS medicamentos (" + "nomeMedicamento VARCHAR(45), "
					+ "quantidadeMedicamento INT, " + "valorMedicamento DECIMAL (10,2), "
					+ "Primary key (nomeMedicamento)) ";
			statement.executeUpdate(sql);

		} catch (SQLException e) {
			throw new DataAccessException("Erro ao criar tabela medicamentos", e);
		}
	}

	// Criar tabela ração

	private void createTableRacao() throws DataAccessException {
		try (Connection connection = getConnection(); Statement statement = connection.createStatement()) {
			String sql = "CREATE TABLE IF NOT EXISTS racoes (" + "marcaRacao VARCHAR(45), " + "quantidadeRacao INT, "
					+ "valorRacao DECIMAL (10,2), " + "Primary key (marcaRacao)) ";
			statement.executeUpdate(sql);

		} catch (SQLException e) {
			throw new DataAccessException("Erro ao criar tabela racoes", e);
		}
	}

	// Criar tabela vacina

	private void createTableVacina() throws DataAccessException {
		try (Connection connection = getConnection(); Statement statement = connection.createStatement()) {
			String sql = "CREATE TABLE IF NOT EXISTS vacinas (" + "nomeVacina VARCHAR(45), " + "quantidadeVacina INT, "
					+ "valorVacina DECIMAL (10,2), " + "primary key (Nome_Vacina)) ";
			statement.executeUpdate(sql);

		} catch (SQLException e) {
			throw new DataAccessException("Erro ao criar tabela vacinas", e);
		}
	}

	// Criar tabela de animais medicados

	private void createTableAnimaisMedicados() throws DataAccessException {
		try (Connection connection = getConnection(); Statement statement = connection.createStatement()) {
			String sql = "CREATE TABLE IF NOT EXISTS animais_medicados (" + "id_animal int, "
					+ "nomeAnimal VARCHAR(45), " + "nomeMedicamento VARCHAR(45), "
					+ "FOREIGN KEY (id_animal) references animais (id), "
					+ "FOREIGN KEY (nomeMedicamento) references medicamentos (nomeMedicamento))";
			statement.executeUpdate(sql);

		} catch (SQLException e) {
			throw new DataAccessException("Erro ao criar tabela animais_medicados", e);
		}
	}

	// Criar tabela de animais vacinados

	private void createTableAnimaisVacinados() throws DataAccessException {
		try (Connection connection = getConnection(); Statement statement = connection.createStatement()) {
			String sql = "CREATE TABLE IF NOT EXISTS animais_vacinados (" + "id_animal int, "
					+ "nomeAnimal VARCHAR(45), " + "vacinaAnimal VARCHAR(45), "
					+ "FOREIGN KEY (id_animal) references animais (id), "
					+ "FOREIGN KEY (vacinaAnimal) references vacinas (nomeVacina))";
			statement.executeUpdate(sql);

		} catch (SQLException e) {
			throw new DataAccessException("Erro ao criar tabela animais_vacinados", e);

		}
	}

	// inicia a tabela e o bd
	public void iniciarBdRecursos() throws DataAccessException {
		createDatabase();
		createTableMedicamento();
		createTableRacao();
		createTableVacina();
		createTableAnimaisMedicados();
		createTableAnimaisVacinados();
	}

	// Inserir vacina no banco de dados

	public void criarVacina(Vacinas vacina) throws DataAccessException {
		String sql = "INSERT INTO vacinas (nomeVacina, quantidadeVacina, valorVacina) VALUES (?, ?, ?)";
		try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setString(1, vacina.getNomeVacina());
			statement.setInt(2, vacina.getQuantidadeVacina());
			statement.setDouble(3, vacina.getValorVacina());
			statement.execute();

		} catch (SQLException e) {
			throw new DataAccessException("Erro ao inserir vacinas", e);
		}
	}

	public void criarMedicamento(Medicamentos medicamento) throws DataAccessException {
		String sql = "INSERT INTO medicamentos (nomeMedicamento, quantidadeMedicamento, valorMedicamento) VALUES (?, ?, ?)";
		try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setString(1, medicamento.getNomeMedicamento());
			statement.setInt(2, medicamento.getQuantidadeMedicamento());
			statement.setDouble(3, medicamento.getValorMedicamento());
			statement.execute();

		} catch (SQLException e) {
			throw new DataAccessException("Erro ao inserir medicamentos", e);

		}
	}
}
