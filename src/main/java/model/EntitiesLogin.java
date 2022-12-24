package model;

// TODO: Auto-generated Javadoc
/**
 * The Class EntitiesLogin.
 */
public class EntitiesLogin {

	/** The login id. */
	private String loginId;
	
	/** The usuario. */
	private String usuario;
	
	/** The senha. */
	private String senha;

	/**
	 * Instantiates a new entities login.
	 */
	public EntitiesLogin() {
		super();
	}

	/**
	 * Instantiates a new entities login.
	 *
	 * @param loginId the login id
	 * @param usuario the usuario
	 * @param senha the senha
	 */
	public EntitiesLogin(String loginId, String usuario, String senha) {
		super();
		this.loginId = loginId;
		this.usuario = usuario;
		this.senha = senha;
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
	 * Sets the login id.
	 *
	 * @param loginId the new login id
	 */
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	/**
	 * Gets the usuario.
	 *
	 * @return the usuario
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * Sets the usuario.
	 *
	 * @param usuario the new usuario
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	/**
	 * Gets the senha.
	 *
	 * @return the senha
	 */
	public String getSenha() {
		return senha;
	}

	/**
	 * Sets the senha.
	 *
	 * @param senha the new senha
	 */
	public void setSenha(String senha) {
		this.senha = senha;
	}
}