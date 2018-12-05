package br.senai.sp.dao;

import java.sql.PreparedStatement;



import java.sql.ResultSet;
import java.util.ArrayList;

import br.senai.sp.model.Compromisso;
import br.senai.sp.model.Usuario;

public class CompromissoDAO {

	private Compromisso compromisso;
	private PreparedStatement stm;
	private ResultSet rs;
	
	public void setCompromisso(Compromisso compromisso) {
		this.compromisso = compromisso;
	}
	
	public ArrayList<Compromisso> getCompromissos(int codUsuario, int status){
		String consulta = "SELECT * FROM tbl_compromisso WHERE cod_usuario = ? AND status = ?";
		
		ArrayList<Compromisso> compromissos = new ArrayList<>();
		
		try {
			stm = Conexao.getConexao().prepareStatement(consulta);
			stm.setInt(1, codUsuario);
			stm.setInt(2, status);
			rs = stm.executeQuery();
			
			while(rs.next()){
				this.compromisso = new Compromisso();
				this.compromisso.setCod_compromisso(rs.getInt("cod_compromisso"));
				this.compromisso.setTitulo(rs.getString("titulo"));
				this.compromisso.setData(rs.getString("data"));
				this.compromisso.setHora_inicio(rs.getString("hora_inicio"));
				this.compromisso.setHora_fim(rs.getString("hora_fim"));
				this.compromisso.setDescricao(rs.getString("descricao"));
				this.compromisso.setPrioridade(rs.getInt("prioridade"));
				this.compromisso.setStatus(rs.getInt("status"));
				compromissos.add(this.compromisso);				
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return compromissos;
	}
	
	public Compromisso getCompromisso(int codCompromisso){
		String consulta = "SELECT * FROM tbl_compromisso WHERE cod_compromisso = ?";

		try {
			stm = Conexao.getConexao().prepareStatement(consulta);
			stm.setInt(1, codCompromisso);
			rs = stm.executeQuery();
			
			if(rs.next()){
				compromisso = new Compromisso();
				this.compromisso.setCod_compromisso(rs.getInt("cod_compromisso"));
				this.compromisso.setTitulo(rs.getString("titulo"));
				this.compromisso.setData(rs.getString("data"));
				this.compromisso.setHora_inicio(rs.getString("hora_inicio"));
				this.compromisso.setHora_fim(rs.getString("hora_fim"));
				this.compromisso.setDescricao(rs.getString("descricao"));
				this.compromisso.setPrioridade(rs.getInt("prioridade"));
				this.compromisso.setStatus(rs.getInt("status"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return this.compromisso;
	}
	
	public boolean gravar() {
		String consulta = "INSERT INTO tbl_compromisso (cod_usuario, titulo, data, "
				+ "hora_inicio, hora_fim, descricao, "
				+ "prioridade, status)"
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			stm = Conexao.getConexao().prepareStatement(consulta);
			stm.setInt(1, compromisso.getUsuario().getCodUsuario());
			stm.setString(2, compromisso.getTitulo());
			stm.setString(3, compromisso.getData());
			stm.setString(4, compromisso.getHora_inicio());
			stm.setString(5, compromisso.getHora_fim());
			stm.setString(6, compromisso.getDescricao());
			stm.setInt(7, compromisso.getPrioridade());
			stm.setInt(8, compromisso.getStatus());
			stm.execute();
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean atualizar() {
		String consulta ="UPDATE tbl_compromisso "
				+ "SET titulo = ?, "
				+ "data = ?, "
				+ "hora_inicio = ?, "
				+ "hora_fim = ?, "
				+ "descricao = ?, "
				+ "prioridade = ?, "
				+ "status = ? "
				+ "WHERE cod_compromisso = ?";
		try {
			stm = Conexao.getConexao().prepareStatement(consulta);
			stm.setString(1, compromisso.getTitulo());
			stm.setString(2, compromisso.getData());
			stm.setString(3, compromisso.getHora_inicio());
			stm.setString(4, compromisso.getHora_fim());
			stm.setString(5, compromisso.getDescricao());
			stm.setInt(6, compromisso.getPrioridade());
			stm.setInt(7, compromisso.getStatus());
			stm.setInt(8, compromisso.getCod_compromisso());
			stm.execute();

			return true;
			
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean alterarStatus() {
		String consulta ="UPDATE tbl_compromisso "
				+ "SET status = ? "
				+ "WHERE cod_compromisso = ?";
		try {
			stm = Conexao.getConexao().prepareStatement(consulta);
			stm.setInt(1, compromisso.getStatus());
			stm.setInt(2, compromisso.getCod_compromisso());
			stm.execute();

			return true;
			
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
