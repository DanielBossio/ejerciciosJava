package ejerciciosJava;

public class AreaFiguras {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Se van a utilizar los mismos valores para los cálculos
		int lado = 10;
		int lado2 = 4;
		int altura = 5;
		float areaCuadrado = lado*lado;
		float areaRectangulo = lado*lado2;
		double areaCirculo = 3.1416*lado2*lado2;
		float areaTriangulo = lado2*altura/2;
		
		System.out.println("Area de un cuadrado:");
		System.out.println("Lado del cuadrado: "+lado);
		System.out.println("Area: "+areaCuadrado);
		System.out.println();
		
		System.out.println("Area de un rectangulo:");
		System.out.println("Lados del rectangulo: "+lado+", "+lado2);
		System.out.println("Area: "+areaRectangulo);
		System.out.println();
		
		System.out.println("Area de un circulo:");
		System.out.println("Radio del circulo: "+lado2);
		System.out.println("Area: "+areaCirculo);
		System.out.println();
		
		System.out.println("Area de un triangulo:");
		System.out.println("Base del triangulo: "+lado2);
		System.out.println("Altura del triangulo: "+altura);
		System.out.println("Area: "+areaTriangulo);
		System.out.println();
	}
}
