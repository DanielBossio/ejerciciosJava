package ejerciciosJava;

public class Gato extends Mascota{
	
	Gato (String nombre, String raza, int edad){
		super(nombre, raza, edad);
	}
	
	public Gato (String nombre){
		super(nombre);
	}
	
	public void comer(String comida) {
		System.out.println("Soy el gato "+nombre+" y estoy comiendo " +comida);
	}
	
	void jugar(String juego) {
		System.out.println("Soy el gato "+nombre+" y estoy " +juego);
	}
	
	void cazar (String presa) {
		System.out.println("Soy el gato "+nombre+" y estoy cazando "+presa);
	}
	
	void morder() {
		System.out.println("Soy el gato "+nombre+" y muerdo con mis colmillos");
	}
	
	void arañar() {
		System.out.println("Soy el gato "+nombre+" y araño con mis garras");
	}
}