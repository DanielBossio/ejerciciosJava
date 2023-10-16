package ejerciciosJava.ejerciciosSemana2.colecciones;

class Nodo<T>{
	T valor;
	Nodo<?> siguiente;
	Nodo<?> anterior;
	
	Nodo(T valor) {
		super();
		this.valor = valor;
		this.siguiente = null;
		this.anterior = null;
	}

	public T getValor() {
		return valor;
	}

	public void setValor(T valor) {
		this.valor = valor;
	}

	public Nodo<?> getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(Nodo<?> siguiente) {
		this.siguiente = siguiente;
	}

	
	public Nodo<?> getAnterior() {
		return anterior;
	}

	
	public void setAnterior(Nodo<?> anterior) {
		this.anterior = anterior;
	}
}

public class ListaLigada<T>{
	Nodo<T> primero;

	ListaLigada() {
		this.primero = null;
	}

	ListaLigada(Nodo<T> primero) {
		this.primero = primero;
	}
	
	@SuppressWarnings("unchecked")
	public void agregar(T valor) {
		//Se crea un nuevo nodo con el valor
		Nodo<T> nuevo = new Nodo<>(valor);
		//Si aún no hay ningún nodo se asigna al primero
		if (primero.equals(null))
			primero = nuevo;
		//Si la lista no está vacía se buscará el último nodo
		else {
			Nodo<T> sig = (Nodo<T>) primero.siguiente;
			while (!sig.siguiente.equals(null))
				sig = (Nodo<T>) sig.siguiente;
			sig.setSiguiente(nuevo);
			nuevo.setAnterior(sig);
		}
	}
	
	@SuppressWarnings("unchecked")
	public boolean borrar(T valor) {
		//Se recorre la lista buscando el valor ingresado
		Nodo<T> buscar = primero;
		while (!buscar.siguiente.equals(null)) {
			//Cuando se encuentra se actualizan las referencias
			//de los nodos anterior y siguiente
			if (buscar.valor.equals(valor)) {
				buscar.anterior.siguiente = buscar.siguiente;
				buscar.siguiente.anterior = buscar.anterior;
				return true;
			}
			buscar = (Nodo<T>) buscar.siguiente;
		}
		//Si no se encontró el nodo se retorna false
		return false;
	}
	
	@SuppressWarnings("unchecked")
	public boolean buscar(T valor) {
		//Se recorre la lista buscando el valor ingresado
		Nodo<T> buscar = primero;
		while (!buscar.siguiente.equals(null)) {
			//Cuando se encuentra se retorna true
			if (buscar.valor.equals(valor)) return true;
			buscar = (Nodo<T>) buscar.siguiente;
		}
		//Si no se encontró el nodo se retorna false
		return false;
	}
}
