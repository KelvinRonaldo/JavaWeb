package br.com.kelvin.conexao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
	
	private static Connection conexao;

	public static Connection getConexao() {
		try {
			//driver do access
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			//conexao até o banco de dados
			conexao = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/kelvi/Documents/teste.accdb");
		}catch(Exception erro) {
			erro.printStackTrace();
		}
		return conexao;
	}	
}
