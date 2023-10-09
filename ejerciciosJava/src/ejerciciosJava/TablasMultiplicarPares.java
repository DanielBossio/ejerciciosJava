package ejerciciosJava;

public class TablasMultiplicarPares {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 1; i <= 20; i++) {
			if (i % 2 != 0) continue;
			System.out.println("Tabla del "+i+":");
			for (int j = 0; j <= 10; j++) {
				System.out.println(i+" * "+j+" = "+i*j);
			}
			System.out.println();
		}
	}

}
