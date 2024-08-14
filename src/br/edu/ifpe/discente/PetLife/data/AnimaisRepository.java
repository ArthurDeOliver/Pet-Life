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
    private static final String USER = "root";      //editável
    private static final String PASSWORD = "duda"; //editável
    

    
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
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {
            String sql = "CREATE TABLE IF NOT EXISTS animais (" +
                         "id INT AUTO_INCREMENT PRIMARY KEY NOT NULL, " +
                         "nome VARCHAR(255), " +
                         "idade INT, " +
                         "tipo VARCHAR(255), " +
                         "raca VARCHAR(255), " +
                         "racao INT, " +
                         "status VARCHAR(50), " +
                         "vacina VARCHAR(255), " +
                         "foto VARCHAR(255))";
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
        String sql = "INSERT INTO animais (nome, idade, tipo, raca, racao, status, vacina, foto) VALUES (?, ?, ?, ?, ?, ?, ?, ?)"; //editável
        try (Connection connection = getConnection();
        		
            PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, animal.getNome());
            statement.setInt(2, animal.getIdade());
            statement.setString(3, animal.getTipo());
            statement.setString(4, animal.getRaca());
            statement.setInt(5, animal.getRacao());
            statement.setString(6, animal.getStatus());
            statement.setString(7, animal.getVacina());
            statement.setString(8, animal.getFoto());
            statement.execute();            
        }
        
    }
        
    
    //retornar animais
    
        public List<Animais> listarTodosAnimais() throws SQLException {
        	
            String sql = "SELECT * FROM animais"; //script sql para selecionar todos os dados do bd
            
            List<Animais> listaDeAnimais = new ArrayList<>();

            try (Connection connection = getConnection();
            		
                 PreparedStatement statement = connection.prepareStatement(sql); // prepara as consultas no bd
                 ResultSet rs = statement.executeQuery()) { //executa as consultas
            	
                while (rs.next()) {
                	
                	Animais anima1 = new Animais(
         
                    rs.getString("nome"),
                    rs.getInt("idade"),
                    rs.getString("tipo"),
                    rs.getString("raca"),
                    rs.getInt("racao"),
                    rs.getString("status"),
                    rs.getString("vacina"),
                    rs.getString("foto")
                );
                    listaDeAnimais.add(anima1);
                }
            } return listaDeAnimais;
            
        }
        
        //retornar animais aptos a adoção
        public List<Animais> listarAnimaisAptos() throws SQLException {
        	
            String sql = "SELECT * FROM animais WHERE status = 'apto'"; //script sql para selecionar todos os dados do bd onde status for "apto"
            
            List<Animais> listaDeAnimaisAptos = new ArrayList<>();

            try (Connection connection = getConnection();
            		
                 PreparedStatement statement = connection.prepareStatement(sql); // prepara as consultas no bd
                 ResultSet rs = statement.executeQuery()) { //executa as consultas
            	
                while (rs.next()) {
                	
                	Animais animal = new Animais(
         
                    rs.getString("nome"),
                    rs.getInt("idade"),
                    rs.getString("tipo"),
                    rs.getString("raca"),
                    rs.getInt("racao"),
                    rs.getString("status"),
                    rs.getString("vacina"),
                    rs.getString("foto")
                );
                    listaDeAnimaisAptos.add(animal);
                }
            } return listaDeAnimaisAptos;
            
        }
        
    }

