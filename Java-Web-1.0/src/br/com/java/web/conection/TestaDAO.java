package br.com.java.web.conection;

import java.util.Calendar;

import br.com.java.web.DAO.ContatoDAO;
import br.com.java.web.bean.Contato;


/**
 * @author danilo
 *
 */
public class TestaDAO {
	public static void main(String[] args) {
		System.out.println("Inserindo no Banco de Dados ...");
		Contato contato = new Contato();
		
		contato.setNome("danilo");
		contato.setEmail("danilo@caelum.com.br");
		contato.setEndereco("R. Vergueiro 3185 cj57");
		contato.setDataNascimento(Calendar.getInstance());
		
		ContatoDAO dao = new ContatoDAO();
		dao.adiciona(contato);
		
		System.out.println("Contato Gravado com Sucesso.");
		
		System.out.println("Consultando os registro do Banco de dados ...");
		
		
	}
}
