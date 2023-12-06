package br.org.sesisp.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;

import br.org.sesisp.controller.Conexao;

import br.org.sesisp.model.Usuario;

public class CrudDAO {
	//crud C-creat	 R-update    D-delete
	
	//creat (inserir dados)
	public void create(Usuario usuario) {
		String sql = "INSERT INTO agendar(rm, nome, idade, reuniao, data) VALUES (?, ?, ?, ?, ?)";
		Connection conn = null;
		PreparedStatement p = null;
		try {
			conn = (Connection) Conexao.criandoConexao();
			p = (PreparedStatement) conn.prepareStatement(sql); //cast
			p.setInt(1, usuario.getRm());
			p.setString(2, usuario.getNome());
			p.setInt(3, usuario.getIdade());
			p.setString(4, usuario.getReuniao());
			p.setString(5, usuario.getData());
			p.execute();
		}catch(Exception e) {
			JOptionPane.showConfirmDialog(null, "ERRO ao incerir dados! \nERRO: " + e);
		}finally {
			try {
				if(p != null);
				p.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
	}  //fim create
	
	
	//matodo U-update
		public void update(Usuario usuario) {
			String sql = "UPDATE agendar SET nome = ?, idade = ? WHERE ra = ?";
			Connection conn = null;
			PreparedStatement p = null;
			try {
				conn = (Connection) Conexao.criandoConexao();
				p = (PreparedStatement) conn.prepareStatement(sql); //cast
				p.setString(1, usuario.getNome());
				p.setInt(2, usuario.getIdade());
				p.setInt(3, usuario.getRm());
				p.execute();
				JOptionPane.showConfirmDialog(null, "ERRO ao incerir dados! \nERRO: ");
				System.out.println("dados atualizados com sucesso");
			}catch (Exception e) {
				JOptionPane.showConfirmDialog(null, "ERRO ao incerir dados! \nERRO: " + e);
			} finally {
				try {
					if(p != null);
					p.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}//fim UPEDATE
		//***************************************************************************************
		
		//R-read
		public List<Usuario> read() {
			String sql = "SELECT * FROM agendar";
			List<Usuario> alunos = new ArrayList<Usuario>();
			Connection conn = null;
			PreparedStatement p = null;
			ResultSet resultado = null;
			try {
				conn = (Connection) Conexao.criandoConexao();
				p = (PreparedStatement) conn.prepareStatement(sql);
				resultado = p.executeQuery();
				while(resultado.next()) {
					Usuario ver_aluno = new Usuario();
					//recuperar RA
					ver_aluno.setRm(resultado.getInt("ra"));
					//recuperar nome
					ver_aluno.setNome(resultado.getString("nome"));
					//recuperar idade
					ver_aluno.setIdade(resultado.getInt("idade"));
					//adicionar nalista
					alunos.add(ver_aluno);
				}
			} catch (Exception e) {
				JOptionPane.showConfirmDialog(null, "ERRO ao incerir dados! \nERRO: " + e);
			} finally {
				try {
					if(p != null);
					p.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return alunos;
			
		}//fim READ
		//inicio delete
		
		public boolean delete(int ra) {
			String sql = "DELETE FROM agendar WHERE ra = ?";
			Connection conn = null;
			PreparedStatement p = null;
			try {
				conn = (Connection) Conexao.criandoConexao();
				p = (PreparedStatement) conn.prepareStatement(sql);
				p.setInt(1, ra);
				p.execute();
				System.out.println("Dados excluidos com secesso!");
			}catch (Exception e) {
					JOptionPane.showConfirmDialog(null, "ERRO ao excluir dados dados! \nERRO: ");
				} finally {
					try {
						if(p != null);
						p.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			return false;
		}//fim delete
	
	
	
}//fim class crud
