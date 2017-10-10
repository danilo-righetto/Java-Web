package br.com.java.web.conection;

import java.util.Calendar;
import java.util.List;

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
		
		dao.consulta("contatos");
		
		System.out.println("Consultando os registro do Banco de dados via getLista() ...");
		
		ContatoDAO dao2 = new ContatoDAO();
		List<Contato> contatos = dao2.getLista();
		
		for (Contato contato2 : contatos) {
			System.out.println("Nome: " + contato2.getNome());
			System.out.println("Email: " + contato2.getEmail());
			System.out.println("Endereço: " + contato2.getEndereco());
			System.out.println("Data de Nascimento: " + contato2.getDataNascimento().getTime() + "\n");
		}
	}
}
