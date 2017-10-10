package br.com.java.web.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.java.web.bean.Funcionario;
import br.com.java.web.conection.ConnectionFactoryCaelum;

public class FuncionarioDAO {
	//Conexao com o Banco
	private Connection connection;
	
	//Construtor
	public FuncionarioDAO(){
		this.connection = new ConnectionFactoryCaelum().getConnection();
	}
	
	//Metodo Adiciona
		public void adiciona(Funcionario funcionario){
			String sql = "insert into funcionarios"+
							"(nome, usuario, senha)"+
							"values (?,?,?)";
			
			try {
				//PreparedStatement para a inserção 
				PreparedStatement stmt = connection.prepareStatement(sql);
				
				//Setar os valores
				stmt.setString(1, funcionario.getNome());
				stmt.setString(2, funcionario.getUsuario());
				stmt.setString(3, funcionario.getSenha());
				
				//Executa a inserção
				stmt.execute();
				stmt.close();
				
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		
		//Metodo Consulta
		public void consulta(String tabela){
			Connection con = new ConnectionFactoryCaelum().getConnection();
			PreparedStatement stmt = null;
			try {
				stmt = con.prepareStatement("select * from "+tabela);
				ResultSet rs = stmt.executeQuery();
				
				while(rs.next()){
					String nome = rs.getString("nome");
					String usuario = rs.getString("usuario");
					
					System.out.println("O nome é: "+nome+" \nE o usuario é: "+usuario);
				}
				
				rs.close();
				stmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		//Usando o getLista()
		public List<Funcionario> getLista(){
			List<Funcionario> funcionarios = new ArrayList<Funcionario>();
			try {
				PreparedStatement stmt = this.connection.prepareStatement("select * from funcionarios");
				ResultSet rs = stmt.executeQuery();
				
				while(rs.next()){
					//Criando o Objeto Contato
					Funcionario funcionario = new Funcionario();
					
					//Setando os valores
					funcionario.setId(rs.getLong("id"));
					funcionario.setNome(rs.getString("nome"));
					funcionario.setUsuario(rs.getString("usuario"));
					funcionario.setSenha(rs.getString("senha"));
					
					//Adicionando Objetos na Lista
					funcionarios.add(funcionario);
					
				}
				rs.close();
				stmt.close();
				return funcionarios;
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		
		public void altera(Funcionario funcionario){
			//Query para fazer o UPDATE na tabela
			String sql = "update funcionarios set nome=?, usuario=?, senha=? "+
			"where id=?";
			
			try {
				PreparedStatement stmt = connection.prepareStatement(sql);
				
				stmt.setString(1, funcionario.getNome());
				stmt.setString(2, funcionario.getUsuario());
				stmt.setString(3, funcionario.getSenha());
				
				//Executa o UPDATE
				stmt.execute();
				stmt.close();
				
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		
		public void remove(Funcionario funcionario){
			try {
				PreparedStatement stmt = connection.prepareStatement("delete from funcionarios where id=?");
				stmt.setLong(1, funcionario.getId());
				stmt.execute();
				stmt.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
}
