package ejerciciosJava.ejerciciosSemana2.colecciones;

import java.util.ArrayList;

import ejerciciosJava.ejerciciosSemana1.Conejo;
import ejerciciosJava.ejerciciosSemana1.Gato;
import ejerciciosJava.ejerciciosSemana1.Mascota;
import ejerciciosJava.ejerciciosSemana1.Perro;
import ejerciciosJava.ejerciciosSemana1.Pez;

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
