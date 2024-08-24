package br.edu.ifpe.discente.PetLife.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifpe.discente.PetLife.ui.entities.Animais;

public class AnimaisRepository {

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
			String sql = "CREATE TABLE IF NOT EXISTS animais (" + "id INT AUTO_INCREMENT PRIMARY KEY, "
					+ "nome VARCHAR(255), " + "idade INT, " + "tipo VARCHAR(255), " + "raca VARCHAR(255) NOT NULL, "
					+ "racao INT, " + "status VARCHAR(50) NOT NULL, " + "vacina VARCHAR(255), " + "foto VARCHAR(255))";
			statement.executeUpdate(sql);
		}
	}

	// inicia a tabela e o bd
	public void iniciarBd() throws SQLException {
		createDatabase();
		createTable();
	}

	// criar animais
	public void criarAnimal(Animais animal) throws SQLException {
		String sql = "INSERT INTO animais (nome, idade, tipo, raca, racao, status, vacina, foto) VALUES (?, ?, ?, ?, ?, ?, ?, ?)"; // editável
		try (Connection connection = getConnection();
				
				PreparedStatement statement = connection.prepareStatement(sql)) {
			String raca = animal.getRaca().length() > 0 ? animal.getRaca() : "SRD";
			statement.setString(1, animal.getNome());
			statement.setInt(2, animal.getIdade());
			statement.setString(3, animal.getTipo());
			statement.setString(4, raca);
			statement.setInt(5, animal.getRacao());
			statement.setString(6, "Não apto");
			statement.setString(7, animal.getVacina());
			statement.setString(8, animal.getFoto());
			statement.execute();
		}

	}
	
	// retornar animais

	public List<Animais> listarTodosAnimais() throws SQLException {

		String sql = "SELECT * FROM animais"; // script sql para selecionar todos os dados do bd

		List<Animais> listaDeAnimais = new ArrayList<>();

		try (Connection connection = getConnection();

				PreparedStatement statement = connection.prepareStatement(sql); // prepara as consultas no bd
				ResultSet rs = statement.executeQuery()) { // executa as consultas

			while (rs.next()) {

				Animais anima1 = new Animais(

						rs.getInt("id"), rs.getString("nome"), rs.getInt("idade"), rs.getString("tipo"), rs.getString("raca"),
						rs.getInt("racao"), rs.getString("status"), rs.getString("vacina"), rs.getString("foto"));
				listaDeAnimais.add(anima1);
			}
		}
		return listaDeAnimais;

	}
	
	// retornar animais aptos a adoção
	public List<Animais> listarAnimaisAptos() throws SQLException {

		String sql = "SELECT * FROM animais WHERE status = 'Apto'"; // script sql para selecionar todos os dados do bd
																	// onde status for "apto"

		List<Animais> listaDeAnimaisAptos = new ArrayList<>();

		try (Connection connection = getConnection();

				PreparedStatement statement = connection.prepareStatement(sql); // prepara as consultas no bd
				ResultSet rs = statement.executeQuery()) { // executa as consultas

			while (rs.next()) {

				Animais animal = new Animais(

						rs.getInt("id"), rs.getString("nome"), rs.getInt("idade"), rs.getString("tipo"), rs.getString("raca"),
						rs.getInt("racao"), rs.getString("status"), rs.getString("vacina"), rs.getString("foto"));
				listaDeAnimaisAptos.add(animal);
			} 
			
		} catch (SQLException e) {
				e.printStackTrace();
			}
		return listaDeAnimaisAptos;

	}
	
	public void atualizarAnimal(String nome, int idade, String tipo, String raca, int racao, String status, String foto, int id) throws SQLException {
		String sql = "UPDATE animais SET nome = ?, idade = ?, tipo = ?, raca = ?, racao = ?, status = ?, foto = ? WHERE id = ?";

        try (Connection connection = getConnection(); 
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, nome);
            statement.setInt(2, idade);
            statement.setString(3, tipo);
            statement.setString(4, raca);
            statement.setInt(5, racao);
            statement.setString(6, status);
            statement.setString(7, foto);
            statement.setInt(8, id);  


            statement.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	

	//deletar
	public void deletarAnimal(int id) throws SQLException {
		
	    String sql = "DELETE FROM animais WHERE id = ?";
	    
	    try (Connection connection = getConnection(); 
	         PreparedStatement statement = connection.prepareStatement(sql)) {
	        
	        statement.setInt(1, id);
	        statement.executeUpdate();
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	      //TODO
	    }
	}


}
	


