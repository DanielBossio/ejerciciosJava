package ejerciciosJava;

public class Perro extends Mascota{
	
	Perro (String nombre, String raza, int edad){
		super(nombre, raza, edad);
	}
	
	public Perro (String nombre){
		super(nombre);
	}
	
	public void comer(String comida) {
		System.out.println("Soy el perro "+nombre+" y estoy comiendo " +comida);
	}
	
	void jugar(String juego) {
		System.out.println("Soy el perro "+nombre+" y estoy " +juego);
	}
	
	void perseguirCola (int minutos) {
		System.out.println("Soy el perro "+nombre+" y llevo"+minutos+"persiguiendo mi cola");
	}
	
	void morder() {
		System.out.println("Soy el perro "+nombre+" y muerdo con mis colmillos");
	}
}