package br.com.java.web.test;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.java.web.conection.ConnectionFactoryCaelum;


/**
 * @author danilo
 * Classe para testar a conexao da Classe ConnectionFactoryCaelum()
 */
public class TestaConexao {
	public static void main(String[] args) {
		Connection con = new ConnectionFactoryCaelum().getConnection();
		System.out.println("Conexao Aberta!");
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
