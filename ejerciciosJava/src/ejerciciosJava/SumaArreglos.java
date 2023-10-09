package ejerciciosJava;

public class SumaArreglos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arreglo1[][] = {{20, 40, 32, 23},{50, -23, -100, 4}};
		int arreglo2[][] = {{-3, 901, 29, 15},{-2, -2, 2, 2000}};
		int suma[][] = new int[2][4];
		
		for (int i = 0; i<2; i++) {
			for (int j = 0; j<4; j++) {
				suma[i][j] = arreglo1[i][j] + arreglo2[i][j];
				System.out.print(suma[i][j]+" ");
			}
			System.out.println();
		}
	}
}
