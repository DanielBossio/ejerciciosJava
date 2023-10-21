package ejerciciosJava.ejerciciosSemana3.ejercicioFinal;

import java.io.Serializable;
import java.util.HashMap;

public class PersonaMod implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2750822806743535317L;
	private String nombre;
	private HashMap<String, String> modificaciones;
	
	public PersonaMod(String nombre) {
		super();
		this.nombre = nombre;
		this.modificaciones = new HashMap<>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public HashMap<String, String> getModificaciones() {
		return modificaciones;
	}

	public void setModificaciones(HashMap<String, String> modificaciones) {
		this.modificaciones = modificaciones;
	}
	
	public void addModificacion(String key, String val) {
		this.modificaciones.put(key, val);
	}
}
