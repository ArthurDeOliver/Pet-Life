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

public class RecursosRepository{
	
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
	      
		
	
	private void createTableMedicamento() throws SQLException {
		try (Connection connection = getConnection(); Statement statement = connection.createStatement()) {
			String sql = "CREATE TABLE IF NOT EXISTS medicamentos (" + "Nome_medicamento VARCHAR(45), "
					+ "Quantidade_Medicamento INT, " + "Valor_Medicamento DECIMAL (10,2), " + "Primary key (Nome_Medicamento)) ";
			statement.executeUpdate(sql);
		}
	}
	private void createTableRacao() throws SQLException {
		try (Connection connection = getConnection(); Statement statement = connection.createStatement()) {
			String sql = "CREATE TABLE IF NOT EXISTS racoes (" + "Marca_Racao VARCHAR(45), "
					+ "Quantidade_Racao INT, " + "Valor_Racao DECIMAL (10,2), " + "Primary key (Marca_Racao)) ";
			statement.executeUpdate(sql);
		}
	}
	private void createTableVacina() throws SQLException {
		try (Connection connection = getConnection(); Statement statement = connection.createStatement()) {
			String sql = "CREATE TABLE IF NOT EXISTS vacinas (" + "Nome_Vacina VARCHAR(45), "
					+ "Quantidade_Vacina INT, " + "Valor_Vacina DECIMAL (10,2), " + "Primary key (Nome_Vacina)) ";
			statement.executeUpdate(sql);
		}
	}
	
	
//	private void createTableAnimaisMedicados() throws SQLException {
//		try (Connection connection = getConnection(); Statement statement = connection.createStatement()) {
//			String sql = "CREATE TABLE IF NOT EXISTS animais_medicados (" + "id_animal int, "
//					+ "nome_animal VARCHAR(45), " + "nome_medicamento VARCHAR(45), " + "FOREIGN KEY (id_animal) references animais (id), " + 
//					" FOREIGN KEY (nome_animal) references animais (nome), "+ "FOREIGN KEY (nome_medicamento) references medicamentos (Nome_medicamento)";
//			statement.executeUpdate(sql);
//		}
//	}
//	
//	private void createTableAnimaisVacinados() throws SQLException {
//		try (Connection connection = getConnection(); Statement statement = connection.createStatement()) {
//			String sql = "CREATE TABLE IF NOT EXISTS animais_vacinados (" + "id_animal int, "
//					+ "nome_animal VARCHAR(45), " + "vacina_animal VARCHAR(45), " + "FOREIGN KEY (id_animal) references animais (id), " + 
//					" FOREIGN KEY (nome_animal) references animais (nome), "+ "FOREIGN KEY (vacina_animal) references vacinas (Nome_Vacina)";
//			statement.executeUpdate(sql);
//		}
//	}
	
	
	// inicia a tabela e o bd
		public void iniciarBdRecursos() throws SQLException {
			createDatabase();
			createTableMedicamento();
			createTableRacao();
			createTableVacina();
//			createTableAnimaisMedicados();
//			createTableAnimaisVacinados();
		}
}
