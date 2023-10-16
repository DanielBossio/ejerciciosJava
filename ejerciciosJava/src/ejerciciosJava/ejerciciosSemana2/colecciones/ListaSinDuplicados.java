package ejerciciosJava.ejerciciosSemana2.colecciones;

public class ListaSinDuplicados<T> {
	//Se utilizará la lista del ejemplo anterior
	ListaLigada<T> lista;

	ListaSinDuplicados() {
		lista = null;
	}
	
	public boolean agregar(T valor) {
		//Si la lista ya tiene el valor
		//no se permitirá agregarlo nuevamente
		if (lista.buscar(valor)) return false;
		lista.agregar(valor);
		return true;
	}
	
	public boolean borrar(T valor) {
		return lista.borrar(valor);
	}
	
	public boolean buscar(T valor) {
		return lista.buscar(valor);
	}
}
