package ejerciciosJava.ejerciciosSemana2.hilos;

import java.util.ArrayList;
import java.util.Random;

class Stock{
	Random r;
	ArrayList<Integer> papel;
	ArrayList<Integer> tabaco;
	ArrayList<Integer> cerillos;
	
	Stock(){
		this.r = new Random();
		this.papel = new ArrayList<>();
		this.tabaco = new ArrayList<>();
		this.cerillos = new ArrayList<>();
	}
	
	public synchronized int[] consume() {
		while (papel.isEmpty() || tabaco.isEmpty() 
				|| cerillos.isEmpty())
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.out.println("No se pudo esperar");
			}
		int[] materiales = new int[3];
		materiales[0] = papel.remove(r.nextInt(papel.size()));
		materiales[1] = tabaco.remove(r.nextInt(tabaco.size()));
		materiales[2] = cerillos.remove(r.nextInt(cerillos.size()));
		return materiales;
	}
	
	public synchronized void produce(String material, int val) {
		switch (material) {
		case "PAPEL":
			papel.add(val);
			break;
			
		case "TABACO":
			tabaco.add(val);
			break;
			
		case "CERILLOS":
			cerillos.add(val);
			break;
			
		default:
			return;
		}
		if (!papel.isEmpty() && !tabaco.isEmpty() 
				&& !cerillos.isEmpty()) notifyAll();
	}
}

class Productor extends Thread{
	String material;
	Random r;
	Stock s;
	int count;

	Productor(String material, Stock s) {
		super();
		this.material = material;
		this.s = s;
		r = new Random();
		count = 0;
	}
	
	public void run() {
		while (true) {
			s.produce(material, count++);
			try {
				sleep(r.nextLong(300));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.out.println("El productor de "
				+material+" no pudo dormir");
			}
		}
	}
}

class Fumador extends Thread{
	int num;
	Stock s;
	int count;

	Fumador(int num, Stock s) {
		super();
		this.num = num;
		this.s = s;
		this.count = 1;
	}
	
	public void run() {
		while (true) {
			int[] materiales = s.consume();
			System.out.println("El fumador "+num
					+" ha adquirido el papel "+materiales[0]);
			System.out.println("El fumador "+num
					+" ha adquirido el tabaco  "+materiales[1]);
			System.out.println("El fumador "+num
					+" ha adquirido los cerillos  "+materiales[2]);
			System.out.println("El fumador "+num
					+" ha fumado con el papel "+materiales[0]+" , el tabaco "
					+materiales[1]+" y los cerillos "+ materiales[2]);
		}
	}
}

public class ProblemaFumadores {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stock s = new Stock();
		ArrayList<Productor> productores = new ArrayList<>();
		productores.add(new Productor("PAPEL", s));
		productores.add(new Productor("TABACO", s));
		productores.add(new Productor("CERILLOS", s));
		ArrayList<Fumador> fumadores = new ArrayList<>();
		for (int i = 1; i<=3; i++)
			fumadores.add(new Fumador(i, s));
		for (Productor p : productores)
			p.start();
		for (Fumador f : fumadores)
			f.start();
	}

}
