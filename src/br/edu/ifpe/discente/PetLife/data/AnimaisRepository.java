package br.edu.ifpe.discente.PetLife.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.xdevapi.Statement;

import br.edu.ifpe.discente.PetLife.ui.entities.Animais;

public class AnimaisRepository {
	
	private static final String URL = "jdbc:mysql://localhost:3306/petlife"; //editável
    private static final String USER = "root";      //editável
    private static final String PASSWORD = "admin"; //editável

    
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
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
                    listaDeAnimaisAptos.add(anima1);
                }
            } return listaDeAnimaisAptos;
            
        }
        
    }


