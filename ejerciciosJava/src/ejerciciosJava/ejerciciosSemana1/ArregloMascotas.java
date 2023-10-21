package ejerciciosJava.ejerciciosSemana1;

public class ArregloMascotas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Mascota mascotas[] = {
				new Gato("Pelusa"), new Perro("Algodon"),
				new Gato("Choco"), new Conejo("Bunny"), new Pez("Burbujas")
		};
		for (Mascota m : mascotas) System.out.print(m.nombre+" ");
	}

}
