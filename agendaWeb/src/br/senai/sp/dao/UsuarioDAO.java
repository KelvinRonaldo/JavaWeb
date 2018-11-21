package br.senai.sp.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.senai.sp.model.Usuario;

public class UsuarioDAO {
	
	private Usuario usuario;
	private PreparedStatement stm;
	private ResultSet rs;
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public boolean gravar() {
		String sql = "INSERT INTO tbl_usuario "
				+ "(nome, email, sexo, senha, dtNascimento) "
				+ "VALUE (?, ?, ?, ?, ?)";
		
		try {
			stm = Conexao.getConexao().prepareStatement(sql);
			stm.setString(1, this.usuario.getNome());
			stm.setString(2, this.usuario.getEmail());
			stm.setString(3, this.usuario.getSexo().substring(0, 1));
			stm.setString(4, this.usuario.getSenha());
			stm.setString(5, this.usuario.getDtNascimento());
			stm.execute();
			
			return true;
		}catch(Exception erro) {
			erro.printStackTrace();
			return false;
		}
	}
	public boolean atualizar() {
		String sql = "UPDATE tbl_usuario "
				+ "SET nome = ?, "
				+ "email = ?, "
				+ "sexo = ?, "
				+ "senha = ?, "
				+ "dtNascimento = ? "
				+ "WHERE codigo = ?";
		
		try {
			stm = Conexao.getConexao().prepareStatement(sql);
			stm.setString(1, this.usuario.getNome());
			stm.setString(2, this.usuario.getEmail());
			stm.setString(3, this.usuario.getSexo().substring(0, 1));
			stm.setString(4, this.usuario.getSenha());
			stm.setString(5, this.usuario.getDtNascimento());
			stm.setInt(6, this.usuario.getCodUsuario());
			stm.execute();
			
			return true;
		}catch(Exception erro) {
			erro.printStackTrace();
			return false;
		}
	}
	
	public Usuario autenticar(String email, String senha) {
		String sql = "SELECT * FROM tbl_usuario WHERE email = ? AND senha = ?";
		
		try {
			stm = Conexao.getConexao().prepareStatement(sql);
			stm.setString(1, email);
			stm.setString(2, senha);
			rs = stm.executeQuery();

			usuario = new Usuario();
			
			if(rs.next()) {
				usuario.setCodUsuario(rs.getInt("codigo"));
				usuario.setDtNascimento(rs.getString("dtNascimento"));
				usuario.setEmail(rs.getString("email"));
				usuario.setNome(rs.getString("nome"));
				usuario.setSexo(rs.getString("sexo"));
				usuario.setSenha(rs.getString("senha"));
			}
			return usuario;
		}catch(Exception erro){
			erro.printStackTrace();
			return usuario;
		}
		
	}
	
}









