package ejerciciosJava.ejerciciosSemana2.hilos;

import java.util.ArrayList;
import java.util.Random;

class Hilo extends Thread{
	private String nombre;
	private int numero;
	
	Hilo(String nombre) {
		super();
		this.nombre = nombre;
		this.numero = 10;
	}

	public void run() {
		while (numero >= 0) {
			try {
				if (numero == 0) 
					System.out.println("El hilo "+this.nombre+" ha terminado!");
				System.out.println("Valor de "+this.nombre+": "+this.numero);
				numero--;
			
				sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.out.println("El hilo "+this.nombre+" no pudo dormir");
			}
		}
	}
}

public class CuentaRegresiva {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Hilo> hilos = new ArrayList<>();
		Random r = new Random();
		int p;
		for (int i = 0; i<30; i++) 
			hilos.add(new Hilo("Denny "+i));
		for (Hilo h : hilos) {
			p = r.nextInt(10)+1;
			h.setPriority(p);
			System.out.println("Prioridad de "+h.getName()+": "+p);
		}
		for (Hilo h : hilos)
			h.start();
	}

}
