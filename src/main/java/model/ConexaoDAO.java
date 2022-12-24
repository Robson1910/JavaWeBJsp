package model;

import java.sql.Connection;
import java.sql.DriverManager;

// TODO: Auto-generated Javadoc
/**
 * The Class ConexaoDAO.
 */
public class ConexaoDAO {

	/** The driver. */
	private String driver = "org.postgresql.Driver";
	
	/** The url. */
	private String url = "jdbc:postgresql://localhost:5432/agenda";
	
	/** The user. */
	private String user = "postgres";
	
	/** The password. */
	private String password = "Colocar o password do banco aqui";

	/**
	 * Conectar.
	 *
	 * @return the connection
	 */
	protected Connection conectar() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
}
