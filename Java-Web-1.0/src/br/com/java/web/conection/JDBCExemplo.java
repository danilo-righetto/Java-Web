package br.com.java.web.conection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * @author danilo
 * @version 1.0
 */
public class JDBCExemplo {
	public static void main(String[] args) {
		Connection conexao2 = null;
		try {
			conexao2 = DriverManager.getConnection("jdbc:mysql://localhost/fj21", "root", "root");
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		System.out.println("Conectado!");
		try {
			conexao2.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
