package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

// TODO: Auto-generated Javadoc
/**
 * The Class LoginDAO.
 */
public class LoginDAO {

	/** The conexao DAO. */
	ConexaoDAO conexaoDAO = new ConexaoDAO();

	/**
	 * Login.
	 *
	 * @param login the login
	 * @return the boolean
	 */
	public Boolean login(EntitiesLogin login) {

		String select = "select * from login where usuario =? and senha=?";

		try {
			Connection con = conexaoDAO.conectar();
			PreparedStatement pst = con.prepareStatement(select);
			pst.setString(1, login.getUsuario());
			pst.setString(2, login.getSenha());
			ResultSet rs = pst.executeQuery();
			Boolean resultado = rs.isBeforeFirst();
			while (rs.next()) {
				login.setLoginId(rs.getString(1));
				login.setUsuario(rs.getString(2));
			}
			con.close();
			return resultado;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
}
