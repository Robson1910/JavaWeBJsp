package model;

import java.sql.Connection;
import java.sql.PreparedStatement;

// TODO: Auto-generated Javadoc
/**
 * The Class AuditoriaDAO.
 */
public class AuditoriaDAO {

	/** The conexao DAO. */
	ConexaoDAO conexaoDAO = new ConexaoDAO();

	/**
	 * Insert.
	 *
	 * @param auditoria the auditoria
	 */
	public void insert(EntitiesAuditoria auditoria) {

		String create = "INSERT INTO auditoria(evento,body,dataevento,horarioevento,loginid) VALUES (?,?::jsonb,?,?,?::integer);";
		
		try {
			Connection con = conexaoDAO.conectar();
			PreparedStatement pst = con.prepareStatement(create);
			pst.setString(1, auditoria.getEvento().toString());
			pst.setString(2, auditoria.getBody());
			pst.setString(3, auditoria.getDataEvento());
			pst.setString(4, auditoria.getHorarioEvento());
			pst.setString(5, auditoria.getLoginId());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
