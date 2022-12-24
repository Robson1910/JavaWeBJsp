package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class UsuarioDAO.
 */
public class UsuarioDAO {

	/** The conexao DAO. */
	ConexaoDAO conexaoDAO = new ConexaoDAO();

	/**
	 * Insert.
	 *
	 * @param usuario the usuario
	 */
	public void insert(EntitiesUsuario usuario) {

		String create = "INSERT INTO usuario(nome, cpf, telefone, email) VALUES (?,?,?,?);";

		try {
			Connection con = conexaoDAO.conectar();
			PreparedStatement pst = con.prepareStatement(create);
			pst.setString(1, usuario.getNome());
			pst.setString(2, usuario.getCpf());
			pst.setString(3, usuario.getTelefone());
			pst.setString(4, usuario.getEmail());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * Lista usuario.
	 *
	 * @return the array list
	 */
	public ArrayList<EntitiesUsuario> ListaUsuario() {

		String select = "select * from usuario;";
		ArrayList<EntitiesUsuario> lista = new ArrayList<>();

		try {
			Connection con = conexaoDAO.conectar();
			PreparedStatement pst = con.prepareStatement(select);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String id = rs.getString(1);
				String nome = rs.getString(2);
				String cpf = rs.getString(3);
				String telefone = rs.getString(4);
				String email = rs.getString(5);
				lista.add(new EntitiesUsuario(id, nome, cpf, telefone, email));
			}
			con.close();
			return lista;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	/**
	 * Selecionar contato.
	 *
	 * @param usuario the usuario
	 */
	public void selecionarContato(EntitiesUsuario usuario) {

		String select = "select * from usuario where usuarioid = ?::integer";

		try {
			Connection con = conexaoDAO.conectar();
			PreparedStatement pst = con.prepareStatement(select);
			pst.setString(1, usuario.getUsuarioId());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				usuario.setUsuarioId(rs.getString(1));
				usuario.setNome(rs.getString(2));
				usuario.setCpf(rs.getString(3));
				usuario.setTelefone(rs.getString(4));
				usuario.setEmail(rs.getString(5));
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * Editar contato.
	 *
	 * @param usuario the usuario
	 */
	public void editarContato(EntitiesUsuario usuario) {

		String update = "update usuario set nome = ?, cpf = ?, telefone = ?, email = ? where usuarioid = ?::integer";

		try {
			Connection con = conexaoDAO.conectar();
			PreparedStatement pst = con.prepareStatement(update);
			pst.setString(1, usuario.getNome());
			pst.setString(2, usuario.getCpf());
			pst.setString(3, usuario.getTelefone());
			pst.setString(4, usuario.getEmail());
			pst.setString(5, usuario.getUsuarioId());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * Delete usuario.
	 *
	 * @param usuario the usuario
	 */
	public void deleteUsuario(EntitiesUsuario usuario) {

		String delete = "delete from usuario where usuarioid = ?::integer";

		try {
			Connection con = conexaoDAO.conectar();
			PreparedStatement pst = con.prepareStatement(delete);
			pst.setString(1, usuario.getUsuarioId());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
