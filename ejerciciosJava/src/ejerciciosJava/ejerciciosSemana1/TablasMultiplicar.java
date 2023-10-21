package ejerciciosJava.ejerciciosSemana1;

public class TablasMultiplicar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 1; i <= 20; i++) {
			System.out.println("Tabla del "+i+":");
			for (int j = 0; j <= 10; j++) {
				System.out.println(i+" * "+j+" = "+i*j);
			}
			System.out.println();
		}
	}

}
