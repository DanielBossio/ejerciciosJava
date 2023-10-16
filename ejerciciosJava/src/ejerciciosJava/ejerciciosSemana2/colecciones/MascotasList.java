package ejerciciosJava.ejerciciosSemana2.colecciones;

import java.util.ArrayList;

import ejerciciosJava.Conejo;
import ejerciciosJava.Gato;
import ejerciciosJava.Mascota;
import ejerciciosJava.Perro;
import ejerciciosJava.Pez;

public class MascotasList {
	static ArrayList<Mascota> mascotas = new ArrayList<>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		mascotas.add(new Gato("Pelusa"));
		mascotas.add(new Perro("Algodon"));
		mascotas.add(new Gato("Choco"));
		mascotas.add(new Conejo("Bunny"));
		
		for (Mascota m : mascotas) m.comer("croquetas");
		
		mascotas.add(new Pez("Burbujas"));
		System.out.println("Cantidad de mascotas: "+mascotas.size());
	}

}
