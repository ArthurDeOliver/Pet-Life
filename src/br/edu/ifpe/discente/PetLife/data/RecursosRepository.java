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
	private static final String PASSWORD = "1234567"; // editável

	private Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL + DB_NAME, USER, PASSWORD);
	}
	
	public void createTableMedicamento() throws SQLException {
		try (Connection connection = getConnection(); Statement statement = connection.createStatement()) {
			String sql = "CREATE TABLE IF NOT EXISTS medicamentos (" + "Nome_medicamento VARCHAR(45), "
					+ "Quantidade_Medicamento INT, " + "Valor_Medicamento DECIMAL (10,2), " + "Primary key Nome_Medicamento) ";
			statement.executeUpdate(sql);
		}
	}
	public void createTableRacao() throws SQLException {
		try (Connection connection = getConnection(); Statement statement = connection.createStatement()) {
			String sql = "CREATE TABLE IF NOT EXISTS racoes (" + "Marca_Racao VARCHAT(45), "
					+ "Quantidade_Racao INT, " + "Valor_Racao DECIMAL (10,2), " + "Primary key Marca_Racao) ";
			statement.executeUpdate(sql);
		}
	}
	public void createTableVacina() throws SQLException {
		try (Connection connection = getConnection(); Statement statement = connection.createStatement()) {
			String sql = "CREATE TABLE IF NOT EXISTS vacinas (" + "Nome_Vacina VARCHAR(45), "
					+ "Quantidade_Vacina INT, " + "Valor_Vacina DECIMAL (10,2), " + "Primary key Nome_Vacina) ";
			statement.executeUpdate(sql);
		}
	}

	
	
	
	
}