package ejerciciosJava.ejerciciosSemana1;

public class Mascota{
	String nombre;
	String raza;
	int edad;
	
	Mascota(String nombre, String raza, int edad) {
		this.nombre = nombre;
		this.raza = raza;
		this.edad = edad;
	}

	Mascota(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public void comer(String comida) {
		System.out.println("Soy la mascota "+nombre+" y estoy comiendo "+comida);
	}
}
