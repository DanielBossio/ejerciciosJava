package ejerciciosJava;

public class Conejo extends Mascota{
	
	Conejo (String nombre, String raza, int edad){
		super(nombre, raza, edad);
	}
	
	public Conejo (String nombre){
		super(nombre);
	}
	
	public void comer(String comida) {
		System.out.println("Soy el conejo "+nombre+" y estoy comiendo " +comida);
	}
	
	void jugar(String juego) {
		System.out.println("Soy el conejo "+nombre+" y estoy " +juego);
	}
	
	void esconderse (String escondite) {
		System.out.println("Soy el perro "+nombre+" y me estoy escondiendo en "+escondite);
	}
	
	void morder() {
		System.out.println("Soy el conejo "+nombre+" y muerdo con mis incisivos");
	}
}