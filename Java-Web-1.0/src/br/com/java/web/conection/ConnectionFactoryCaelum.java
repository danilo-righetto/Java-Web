package br.com.java.web.conection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * @author danilo
 * Classe ConnectionFactoryCaelum() para conectar no Banco de Dados MySQL
 */
public class ConnectionFactoryCaelum {
		public Connection getConnection(){
			try {
				return DriverManager.getConnection("jdbc:mysql://localhost/fj21","root","root");
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
}
