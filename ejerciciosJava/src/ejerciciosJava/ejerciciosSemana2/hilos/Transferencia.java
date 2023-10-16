package ejerciciosJava.ejerciciosSemana2.hilos;

import java.util.ArrayList;
import java.util.Random;

class Cuenta{
	int monto;
	
	Cuenta(){
		monto = 2000000;
	}
	
	public synchronized boolean retirar(int val) {
		if (val > monto) return false;
		monto -= val;
		return true;
	}
}

class Usuario implements Runnable{

	int numero;
	Random r;
	int monto;
	Cuenta c;
	
	Usuario(int numero, Cuenta c) {
		this.numero = numero;
		this.c = c;
		r = new Random();
		monto = 0;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		int retiro;
		while (c.monto > 0) {
			retiro = r.nextInt(20000);
			if (c.retirar(retiro)) {
				monto += retiro;
				System.out.println("El usuario "+this.numero
						+" ha retirado "+retiro);
			}else {
				System.out.println("Monto insuficiente. El usuario "
						+this.numero+" no puede retirar");
			}
		}
		System.out.println("Monto final del usuario "
				+this.numero+": "+this.monto);
	}
	
}

public class Transferencia {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cuenta c = new Cuenta();
		ArrayList<Thread> usuarios = new ArrayList<>();
		for (int i = 1; i<=5; i++) {
			usuarios.add(new Thread(new Usuario(i, c)));
		}
		for (Thread u : usuarios)
			u.start();
	}

}
