package br.com.kelvin.dao;

import java.sql.PreparedStatement;


import java.sql.ResultSet;

import javax.swing.JOptionPane;

import br.com.kelvin.conexao.Conexao;
import br.com.kelvin.pessoas.Pessoa;

public class PessoaDao {
	
	private Pessoa pessoa;
	
	public PessoaDao(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	public PessoaDao(){
		
	}
	
	public Pessoa getPessoa(int id) {
		
		try {
			String consulta = "SELECT * FROM pessoas WHERE codigo = ?";
			PreparedStatement stm = Conexao.getConexao().prepareStatement(consulta);
			stm.setInt(1, id);
			ResultSet rs = stm.executeQuery();
			 
			if(rs.next()) {
				pessoa = new Pessoa();
				this.pessoa.setNome(rs.getString("nome"));
				this.pessoa.setCodigo(rs.getInt("codigo"));
			}else {
				JOptionPane.showMessageDialog(null, "Registro " + id + " não encontrado");
			}
			
		}catch(Exception e){
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return pessoa;
	}

	
//	public void gravar() {
//		try {
//			String consulta = "INSERT INTO pessoas(nome) VALUES (?)";
//			PreparedStatement stm = Conexao.getConexao().prepareStatement(consulta);
//			stm.setString(1, pessoa.getNome());
//			
//			if(stm.execute()) {
//				JOptionPane.showMessageDialog(null, "Ocorreu um erro na gravação.");
//			}else {
//				JOptionPane.showMessageDialog(null, "Pessoas cadastrada com sucesso.");
//			}
//		}catch (Exception erro) {
//			erro.printStackTrace();
//			System.out.println("*"+erro+"*");
//			JOptionPane.showMessageDialog(null, "Ocorreu um erro na gravação.");
//		}
//	}
//	
//
//	public void atualizar() {
//		try {
//			String consulta = "UPDATE pessoas SET nome = ? WHERE codigo = ?";
//			PreparedStatement stm = Conexao.getConexao().prepareStatement(consulta);
//
//			stm.setString(1, pessoa.getNome());
//			stm.setString(2, String.valueOf(pessoa.getCodigo()));
//			
//			if(stm.execute()) {
//				JOptionPane.showMessageDialog(null, "Ocorreu um erro na atualização.");
//			}else {
//				JOptionPane.showMessageDialog(null, "Pessoa atualizada com sucesso.");
//			}
//		}catch (Exception e) {
//			e.printStackTrace();
//			JOptionPane.showMessageDialog(null, "Ocorreu um erro na atualização.");
//		}
//	}
//	
//	
	public void excluir() {
		try {
			String consulta = "DELETE FROM pessoas WHERE codigo = ?";
			PreparedStatement stm = Conexao.getConexao().prepareStatement(consulta);

			stm.setString(1, String.valueOf(pessoa.getCodigo()));
			
			if(stm.execute()) {
				JOptionPane.showMessageDialog(null, "Ocorreu um erro na exclusão.");
			}else {
				JOptionPane.showMessageDialog(null, "Pessoa excluída com sucesso.");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
//	
//	
}
