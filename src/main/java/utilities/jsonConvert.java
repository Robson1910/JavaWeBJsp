package utilities;

import com.google.gson.Gson;

import model.EntitiesUsuario;

// TODO: Auto-generated Javadoc
/**
 * The Class jsonConvert.
 */
public class jsonConvert {

	/**
	 * Json.
	 *
	 * @param usuario the usuario
	 * @return the string
	 */
	public String json(EntitiesUsuario usuario) {
		Gson gson = new Gson();
		return gson.toJson(usuario);
	}
}
