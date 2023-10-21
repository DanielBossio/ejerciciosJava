package ejerciciosJava.ejerciciosSemana1;

class Vehiculo{
	String identificador;
	String marca;
	
	Vehiculo(String identificador, String marca) {
		this.identificador = identificador;
		this.marca = marca;
	}
}

class VehiculoTerrestre extends Vehiculo{
	String via;
	String tipoCombustible;
	
	VehiculoTerrestre(String identificador, String marca, String via, String tipoCombustible) {
		super(identificador, marca);
		this.via = via;
		this.tipoCombustible = tipoCombustible;
	}
}

class Automovil extends VehiculoTerrestre{
	String noRuedas;
	String color;
	
	Automovil(String identificador, String marca, String via, String tipoCombustible, String noRuedas, String color) {
		super(identificador, marca, via, tipoCombustible);
		this.noRuedas = noRuedas;
		this.color = color;
	}
}

public class Automoviles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
