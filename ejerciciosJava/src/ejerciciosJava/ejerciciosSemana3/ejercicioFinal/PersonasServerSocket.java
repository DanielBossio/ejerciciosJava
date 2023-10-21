package ejerciciosJava.ejerciciosSemana3.ejercicioFinal;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Map;

class ListaPersonas{
	//Lista de personas. Recurso sincrónico.
	ArrayList<Persona> personas;

	public ListaPersonas() {
		this.personas = new ArrayList<>();
	}

	public ListaPersonas(ArrayList<Persona> personas) {
		this.personas = personas;
	}
	
	public synchronized ArrayList<Persona> getPersonas() {
		return personas;
	}

	public synchronized void setPersonas(ArrayList<Persona> personas) {
		this.personas = personas;
	}
	
	public synchronized boolean buscar(String nombre) {
		for (Persona p : this.personas)
			if (nombre.equals(p.getNombre())) return true;
		return false;
	}

	public synchronized void add(Persona p) {
		this.personas.add(p);
	}
	
	public synchronized void edit(String nombre, Map<String, String> mods) {
		//Se recibe un map con las modificaciones a realizar
		mods.forEach((mod, val)-> {
			switch (mod) {
			case "Nombre":
				this.personas.stream().filter(p -> nombre.equals(p.getNombre()))
						.forEach(p -> p.setNombre(val));
				break;
				
			case "Edad":
				this.personas.stream().filter(p -> nombre.equals(p.getNombre()))
						.forEach(p -> p.setEdad(Integer.parseInt(val)));
				break;
				
			case "Ocupacion":
				this.personas.stream().filter(p -> nombre.equals(p.getNombre()))
						.forEach(p -> p.setOcupacion(val));
				break;
			}
		});
	}
}

class PersonasWorkerSocket extends Thread{
	//Cada conexión a un usuario será un hilo
	//Compartirán la lista de personas
	
	private Socket s;
	private ListaPersonas lista;

	public PersonasWorkerSocket(Socket s, ListaPersonas lista) {
		super();
		this.s = s;
		this.lista = lista;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		ciclo:
		while (true) {
			//Se intenta iniciar el transporte de datos con streams
			try (ObjectInputStream ois = new ObjectInputStream
					(s.getInputStream());
				ObjectOutputStream oos = new ObjectOutputStream
					(s.getOutputStream())){
				//Se lee y selecciona la operación a realizar
				String op = ois.readUTF();
				switch (op) {
				case "Leer":
					//Leer la lista de personas
					//Se retorna un ArrayList con las personas
					oos.writeObject(lista.getPersonas());
					break;
					
				case "Nuevo":
					//Agregar una persona nueva
					//Si el nombre no se repite se agrega la persona
					Persona p = (Persona) ois.readObject();
					if (lista.buscar(p.getNombre())) oos.write(0);
					else {
						lista.add(p);
						oos.write(1);
					}
					break;
					
				case "Modificar":
					//Modificar una persona
					//Si no se encuentra el nombre se retorna error
					PersonaMod pm = (PersonaMod) ois.readObject();
					if (!lista.buscar(pm.getNombre())) oos.write(0);
					else {
						lista.edit(pm.getNombre(), pm.getModificaciones());
						oos.write(1);
					}
					break;
					
				case "Salir":
					//Terminar la conexión
					break ciclo;
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

public class PersonasServerSocket {
	
	private static void leer(ListaPersonas lp, ObjectInputStream ois) {
		try {
			while (true) 
				lp.add((Persona) ois.readObject());
		} catch (IOException | ClassNotFoundException e) {
			return;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListaPersonas personas = new ListaPersonas();
		File registro = new File("personas.dat");
		ArrayList<PersonasWorkerSocket> hilos = new ArrayList<>();
		try (ServerSocket sv = new ServerSocket(8081);
			ObjectInputStream lector = new ObjectInputStream
					(new FileInputStream(registro))){
			leer (personas, lector);
			while (true) {
				Socket s = sv.accept();
				hilos.add(new PersonasWorkerSocket(s, personas));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try (ObjectOutputStream escritor = new ObjectOutputStream
						(new FileOutputStream(registro))){
				personas.getPersonas().forEach
					(p -> {
						try {
							escritor.writeObject(p);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					});
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
