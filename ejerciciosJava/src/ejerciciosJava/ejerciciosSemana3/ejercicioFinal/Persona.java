package ejerciciosJava.ejerciciosSemana3.ejercicioFinal;

import java.io.Serializable;

public class Persona implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1715506517706389829L;
	private String nombre;
	private int edad;
	private String ocupacion;
	
	public Persona() {
		super();
	}
	
	public Persona(String nombre, int edad, String ocupacion) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.ocupacion = ocupacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getOcupacion() {
		return ocupacion;
	}

	public void setOcupacion(String ocupacion) {
		this.ocupacion = ocupacion;
	}
}
