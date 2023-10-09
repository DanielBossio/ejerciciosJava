package ejerciciosJava;

public class Factorial {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 0;
		int fact = 1;
		for (int i = 1; i <= num; i++)
			fact *= i;
		System.out.println("Factorial de "+num+" = "+fact);
	}
}
