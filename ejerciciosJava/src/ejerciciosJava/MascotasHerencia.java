package ejerciciosJava;

class Mascota{
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
	
	void comer(String comida) {
		System.out.println("Soy la mascota "+nombre+" y estoy comiendo "+comida);
	}
}

class Perro extends Mascota{
	
	Perro (String nombre, String raza, int edad){
		super(nombre, raza, edad);
	}
	
	Perro (String nombre){
		super(nombre);
	}
	
	void comer(String comida) {
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

class Gato extends Mascota{
	
	Gato (String nombre, String raza, int edad){
		super(nombre, raza, edad);
	}
	
	Gato (String nombre){
		super(nombre);
	}
	
	void comer(String comida) {
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

class Conejo extends Mascota{
	
	Conejo (String nombre, String raza, int edad){
		super(nombre, raza, edad);
	}
	
	Conejo (String nombre){
		super(nombre);
	}
	
	void comer(String comida) {
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

class Pez extends Mascota{
	
	Pez (String nombre, String raza, int edad){
		super(nombre, raza, edad);
	}
	
	Pez (String nombre){
		super(nombre);
	}
	
	void comer(String comida) {
		System.out.println("Soy el pez "+nombre+" y estoy comiendo " +comida);
	}
	
	void nadar() {
		System.out.println("Soy el pez "+nombre+" y nado con mis aletas y cola");
	}
}

public class MascotasHerencia {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Perro p = new Perro("Toby");
		Gato g = new Gato("Tini");
		Conejo c = new Conejo("Nieve");
		Pez pz = new Pez("Goldy");
		
		p.comer("croquetas");
		g.comer("pescado");
		c.comer("zanahoria");
		pz.comer("alga");
	}

}
