package ejerciciosJava;

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
