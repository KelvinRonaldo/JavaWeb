package br.senai.sp.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
	
	private static Connection con;
	
	public static Connection getConexao() {
		
		try {
			//caminha para o arquivo do drive do MySQL 
			Class.forName("com.mysql.cj.jdbc.Driver");
			//variavel que armazena o caminha para o banco de dados
			String dbURL = "jdbc:mysql://10.107.134.129/db_inf2tb?useTimezone=true&serverTimezone=UTC";
			//nome de usuario do banco MYSQL
			String user = "inf2tb1";
			//senha de usuario do banco MYSQL
			String password = "123";
			
			con = DriverManager.getConnection(dbURL, user, password);
			
		}catch(Exception erro) {
			erro.printStackTrace();
		}
		return con;
	}
	
}
