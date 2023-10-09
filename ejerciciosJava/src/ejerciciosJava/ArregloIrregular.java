package ejerciciosJava;

public class ArregloIrregular {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arregloIrregular[][] = new int[5][];
		arregloIrregular[0] = new int[]{1};
		arregloIrregular[1] = new int[]{2, 3};
		arregloIrregular[2] = new int[]{4, 5, 6};
		arregloIrregular[3] = new int[]{7, 8, 9, 10};
		arregloIrregular[4] = new int[]{11, 12, 13, 14, 15};
		
		for (int[] i : arregloIrregular) {
			for (int j : i)
				System.out.print(j+" ");
			System.out.println();
		}
	}

}
