package br.senai.sp.dao;

import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.util.ArrayList;

import br.senai.sp.model.Contato;
import br.senai.sp.model.Usuario;

public class ContatoDAO {

	private Contato contato;
	private PreparedStatement stm;
	private ResultSet rs;
	
	public void setContato(Contato contato) {
		this.contato = contato;
	}
	
	public ArrayList<Contato> getContatos(int codUsuario){
		String consulta = "SELECT * FROM tbl_contato WHERE cod_usuario = ?";
		
		ArrayList<Contato> contatos = new ArrayList<>();
		
		try {
			stm = Conexao.getConexao().prepareStatement(consulta);
			stm.setInt(1, codUsuario);
			rs = stm.executeQuery();
			
			while(rs.next()){
				contato = new Contato();
				contato.setCodigo(rs.getInt("codigo"));
				contato.setNome(rs.getString("nome"));
				contato.setEmail(rs.getString("email"));
				contato.setTelefone(rs.getString("telefone"));
				contatos.add(contato);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return contatos;
	}
	
	public Contato getContato(int codContato){
		String consulta = "SELECT * FROM tbl_contato WHERE codigo = ?";

		try {
			stm = Conexao.getConexao().prepareStatement(consulta);
			stm.setInt(1, codContato);
			rs = stm.executeQuery();
			
			if(rs.next()){
				this.contato = new Contato();
				this.contato.setCodigo(rs.getInt("codigo"));
				this.contato.setNome(rs.getString("nome"));
				this.contato.setEmail(rs.getString("email"));
				this.contato.setTelefone(rs.getString("telefone"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return this.contato;
	}
	
	public boolean gravar() {
		String consulta = "INSERT INTO tbl_contato (nome, email, telefone, cod_usuario)"
				+ "VALUES (?, ?, ?, ?)";
		try {
			stm = Conexao.getConexao().prepareStatement(consulta);
			stm.setString(1, contato.getNome());
			stm.setString(2, contato.getEmail());
			stm.setString(3, contato.getTelefone());
			stm.setInt(4, contato.getUsuario().getCodUsuario());
			stm.execute();
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean atualizar() {
		String consulta ="UPDATE tbl_contato "
				+ "SET nome = ?, "
				+ "email = ?, "
				+ "telefone = ? "
				+ "WHERE codigo = ?";
		try {
			stm = Conexao.getConexao().prepareStatement(consulta);
			stm.setString(1, contato.getNome());
			stm.setString(2, contato.getEmail());
			stm.setString(3, contato.getTelefone());
			stm.setInt(4, contato.getCodigo());
			stm.execute();
			
			return true;
			
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
}
