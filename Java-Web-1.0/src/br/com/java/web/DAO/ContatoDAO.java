package br.com.java.web.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.java.web.bean.Contato;
import br.com.java.web.conection.ConnectionFactoryCaelum;

public class ContatoDAO {
	
	//Conexao com o Banco
	private Connection connection;
	
	//Construtor
	public ContatoDAO(){
		this.connection = new ConnectionFactoryCaelum().getConnection();
	}
	
	//Metodo Adiciona
	public void adiciona(Contato contato){
		String sql = "insert into contatos"+
						"(nome, email, endereco, dataNascimento)"+
						"values (?,?,?,?)";
		
		try {
			//PreparedStatement para a inserção 
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			//Setar os valores
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
			
			//Executa a inserção
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
