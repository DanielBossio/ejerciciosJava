package ejerciciosJava.ejerciciosSemana1;

public class Pez extends Mascota{
	
	Pez (String nombre, String raza, int edad){
		super(nombre, raza, edad);
	}
	
	public Pez (String nombre){
		super(nombre);
	}
	
	public void comer(String comida) {
		System.out.println("Soy el pez "+nombre+" y estoy comiendo " +comida);
	}
	
	void nadar() {
		System.out.println("Soy el pez "+nombre+" y nado con mis aletas y cola");
	}
}