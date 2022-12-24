package utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class Data.
 */
public class Data {
	
	/** The data. */
	private static Date data = new Date();
	
	/**
	 * Data atual.
	 *
	 * @return the string
	 */
	public static String dataAtual() {
		SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
		return formatador.format(data);
	}
	
	/**
	 * Hora atual.
	 *
	 * @return the string
	 */
	public static String horaAtual() {
		SimpleDateFormat formatador = new SimpleDateFormat("HH:mm:ss");
		return formatador.format(data);
	}
}
