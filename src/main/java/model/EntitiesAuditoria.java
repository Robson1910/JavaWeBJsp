package model;

import utilities.Data;
import utilities.Evento;
import utilities.jsonConvert;

// TODO: Auto-generated Javadoc
/**
 * The Class EntitiesAuditoria.
 */
public class EntitiesAuditoria {
	
	/** The auditoria id. */
	private String auditoriaId;
	
	/** The evento. */
	private Evento evento;
	
	/** The login id. */
	private String loginId;
	
	/** The data evento. */
	private String dataEvento = Data.dataAtual();
	
	/** The horario evento. */
	private String horarioEvento = Data.horaAtual();
	
	/** The body. */
	private String body;
	
	/**
	 * Instantiates a new entities auditoria.
	 *
	 * @param evento the evento
	 * @param usuario the usuario
	 * @param loginId the login id
	 */
	public EntitiesAuditoria(Evento evento, EntitiesUsuario usuario, String loginId) {
		super();
		this.evento = evento;
		jsonConvert json = new jsonConvert();
		body = json.json(usuario);
		this.loginId = loginId;
	}

	/**
	 * Gets the auditoria id.
	 *
	 * @return the auditoria id
	 */
	public String getAuditoriaId() {
		return auditoriaId;
	}

	/**
	 * Gets the evento.
	 *
	 * @return the evento
	 */
	public Evento getEvento() {
		return evento;
	}

	/**
	 * Gets the login id.
	 *
	 * @return the login id
	 */
	public String getLoginId() {
		return loginId;
	}

	/**
	 * Gets the data evento.
	 *
	 * @return the data evento
	 */
	public String getDataEvento() {
		return dataEvento;
	}

	/**
	 * Gets the horario evento.
	 *
	 * @return the horario evento
	 */
	public String getHorarioEvento() {
		return horarioEvento;
	}

	/**
	 * Gets the body.
	 *
	 * @return the body
	 */
	public String getBody() {
		return body;
	}
}
