package br.edu.ifpe.discente.PetLife.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifpe.discente.PetLife.ui.entities.Adocoes;



public class AdocaoRepository {
		

	private static final String URL = "jdbc:mysql://localhost:3306/";
	private static final String DB_NAME = "petlife";
	private static final String USER = "root"; // editável
	private static final String PASSWORD = "admin"; // editável

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

	// cria a tabela if not exists
	private void createTable() throws SQLException {
		try (Connection connection = getConnection(); Statement statement = connection.createStatement()) {
			String sql = "CREATE TABLE IF NOT EXISTS adocoes (" + "id_pet INT, " + "nome_pet VARCHAR(45), " +
					"tipo_pet VARCHAR(45), " + "nome_tutor VARCHAR(255), " + "cpf_tutor VARCHAR(45), " + 
					"endereco_tutor VARCHAR(255), " + "telefone_tutor VARCHAR(45), " + 
					"FOREIGN KEY (id_pet) REFERENCES animais(id), " + "PRIMARY KEY (id_pet)";
			statement.executeUpdate(sql);
		}
	}

	// inicia a tabela e o bd
	public void iniciarBd() throws SQLException {
		createDatabase();
		createTable();
	}
	
	//criar adocao
	public void adotar(Adocoes adocao) throws SQLException {
		String sql = "INSERT INTO adocoes (id_pet, nome_pet, tipo_pet, nome_tutor, cpf_tutor, endereco_tutor, telefone_tutor)"
				+ " VALUES (?, ?, ?, ?, ?, ?, ?)";
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(sql)) {

				statement.setInt(1, adocao.getIdPet());
				statement.setString(2, adocao.getNomePet());
				statement.setString(3, adocao.getTipoPet());
				statement.setString(4, adocao.getNomeTutor());
				statement.setString(5, adocao.getCpf());
				statement.setString(6, adocao.getEndereco());
				statement.setString(7, adocao.getTelefone());	
			statement.execute();
			
			//Mudar status do pet para adotado
			String sqlUpdate = "UPDATE animais SET status = 'Adotado' WHERE id = ?";
			
			try (Connection connectionUpdate = getConnection(); 
					PreparedStatement statementUpdate = connection.prepareStatement(sqlUpdate)) {

					statementUpdate.setInt(1, adocao.getIdPet());	
					statementUpdate.execute();
			}

	}
			}

	// retornar adocoes

		public List<Adocoes> listarAdocoes() throws SQLException {

			String sql = "SELECT * FROM adocoes"; // script sql para selecionar todos os dados do bd

			List<Adocoes> listaDeAdocoes = new ArrayList<>();

			try (Connection connection = getConnection();

					PreparedStatement statement = connection.prepareStatement(sql); // prepara as consultas no bd
					ResultSet rs = statement.executeQuery()) { // executa as consultas

				while (rs.next()) {

					Adocoes adocao = new Adocoes(

							rs.getInt("id_pet"), rs.getString("nome_pet"), rs.getString("tipo_pet"), rs.getString("nome_tutor"),
							rs.getString("cpf_tutor"), rs.getString("endereco_tutor"), rs.getString("telefone_tutor"));
					listaDeAdocoes.add(adocao);
				}
			}
			return listaDeAdocoes;
		}
		
}
