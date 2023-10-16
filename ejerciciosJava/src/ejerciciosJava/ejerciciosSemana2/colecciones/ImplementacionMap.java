package ejerciciosJava.ejerciciosSemana2.colecciones;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ImplementacionMap<K, V> implements Map<K, V> {

	ListaLigada<K> indices;
	ListaLigada<V> valores;
	
	@SuppressWarnings("unchecked")
	private int pos(K key) {
		int size = 0;
		Nodo<K> actual = indices.primero;
		while (!actual.equals(null)) {
			if (key.equals(actual.valor))
				return size;
			actual = (Nodo<K>) actual.siguiente;
			size++;
		}
		return size;
	}
	
	@Override
	public int size() {
		// TODO Auto-generated method stub
		int size = 0;
		Nodo<K> actual = indices.primero;
		while (!actual.equals(null)) {
			actual = (Nodo<K>) actual.siguiente;
			size++;
		}
		return size;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return indices.primero.equals(null);
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean containsKey(Object key) {
		// TODO Auto-generated method stub
		return indices.buscar((K) key);
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean containsValue(Object value) {
		// TODO Auto-generated method stub
		return valores.buscar((V) value);
	}

	@SuppressWarnings("unchecked")
	@Override
	public V get(Object key) {
		// TODO Auto-generated method stub
		//Si la lista está vacía se retorna null
		if (size()==0)return null;
		Nodo<V> valor = valores.primero;
		//Se obtiene la posición del índice
		int posicion = pos((K) key);
		//Se busca el valor en la posición obtenida
		for (int i = 0; i<posicion; i++)
			valor = (Nodo<V>) valor.siguiente;
		return valor.valor;
	}

	@Override
	public V put(K key, V value) {
		// TODO Auto-generated method stub
		indices.agregar(key);
		valores.agregar(value);
		return value;
	}

	@SuppressWarnings("unchecked")
	@Override
	public V remove(Object key) {
		// TODO Auto-generated method stub
		if (size()==0)return null;
		Nodo<V> valor = valores.primero;
		//Se obtiene la posición del índice
		int posicion = pos((K) key);
		//Se busca el valor en la posición obtenida
		for (int i = 0; i<posicion; i++)
			valor = (Nodo<V>) valor.siguiente;
		indices.borrar((K) key);
		valores.borrar(valor.valor);
		return valor.valor;
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> m) {
		// TODO Auto-generated method stub
		//Se utilizan clases anónimas para las entradas
		for (Entry<? extends K, ? extends V> 
					entrada : m.entrySet()) {
			indices.agregar(entrada.getKey());
			valores.agregar(entrada.getValue());
		}
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		indices.primero = null;
		valores.primero = null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Set<K> keySet() {
		// TODO Auto-generated method stub
		HashSet<K> set = new HashSet<>();
		Nodo<K> n = indices.primero;
		while (!n.equals(null)) {
			set.add(n.valor);
			n = (Nodo<K>) n.siguiente;
		}
		return set;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<V> values() {
		// TODO Auto-generated method stub
		ArrayList<V> lista = new ArrayList<>();
		Nodo<V> n = valores.primero;
		while (!n.equals(null)) {
			lista.add(n.valor);
			n = (Nodo<V>) n.siguiente;
		}
		return lista;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Set<Entry<K, V>> entrySet() {
		// TODO Auto-generated method stub
		HashSet<Entry<K, V>> entradas = new HashSet<Entry<K, V>>();
		Nodo<K> ind = indices.primero;
		Nodo<V> val = valores.primero;
		while (!ind.equals(null)) {
			entradas.add((Entry<K, V>) 
					new SimpleEntry<Nodo<K>, Nodo<V>>(ind, val));
		}
		return entradas;
	}

}
