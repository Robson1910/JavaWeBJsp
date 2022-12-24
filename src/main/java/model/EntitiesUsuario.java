package model;

// TODO: Auto-generated Javadoc
/**
 * The Class EntitiesUsuario.
 */
public class EntitiesUsuario {
	
	/** The usuario id. */
	private String usuarioId;
	
	/** The nome. */
	private String nome;
	
	/** The cpf. */
	private String cpf;
	
	/** The telefone. */
	private String telefone;
	
	/** The email. */
	private String email;
	
	/**
	 * Instantiates a new entities usuario.
	 */
	public EntitiesUsuario() {
		super();
	}

	/**
	 * Instantiates a new entities usuario.
	 *
	 * @param usuarioId the usuario id
	 * @param nome the nome
	 * @param cpf the cpf
	 * @param telefone the telefone
	 * @param email the email
	 */
	public EntitiesUsuario(String usuarioId, String nome, String cpf, String telefone, String email) {
		super();
		this.usuarioId = usuarioId;
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.email = email;
	}

	/**
	 * Gets the usuario id.
	 *
	 * @return the usuario id
	 */
	public String getUsuarioId() {
		return usuarioId;
	}

	/**
	 * Sets the usuario id.
	 *
	 * @param usuarioId the new usuario id
	 */
	public void setUsuarioId(String usuarioId) {
		this.usuarioId = usuarioId;
	}

	/**
	 * Gets the nome.
	 *
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Sets the nome.
	 *
	 * @param nome the new nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Gets the cpf.
	 *
	 * @return the cpf
	 */
	public String getCpf() {
		return cpf;
	}

	/**
	 * Sets the cpf.
	 *
	 * @param cpf the new cpf
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	/**
	 * Gets the telefone.
	 *
	 * @return the telefone
	 */
	public String getTelefone() {
		return telefone;
	}

	/**
	 * Sets the telefone.
	 *
	 * @param telefone the new telefone
	 */
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email.
	 *
	 * @param email the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
}
