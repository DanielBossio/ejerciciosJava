package ejerciciosJava.ejerciciosSemana3.ejercicioFinal;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class PersonasSocket {

	private static String entradaTeclado(String mensaje) {
		//Imprime un mensaje y retorna una respuesta
		try (DataInputStream dis = new DataInputStream(System.in);){
			System.out.println(mensaje);
			return dis.readUTF();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			return "";
		}
	}
	
	private static int opcion() {
		//Ingresar una operación a realizar
		try (DataInputStream dis = new DataInputStream(System.in);){
			System.out.println("Elija una opción:");
			System.out.println("1. Leer personas");
			System.out.println("2. Enviar persona nueva");
			System.out.println("3. Modificar datos de la persona");
			System.out.println("0. Salir");
			return dis.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			return -1;
		}
	}
	
	private static Persona persona() {
		System.out.println("Ingresando nueva persona");
		String nombre = entradaTeclado("Ingrese el nombre:");
		int edad = Integer.parseInt(entradaTeclado("Ingrese la edad:"));
		String profesion = entradaTeclado("Ingrese la ocupación:");
		return new Persona(nombre, edad, profesion);
	}
	
	private static PersonaMod personaMod() {
		System.out.println("Modificando persona");
		String nombre = entradaTeclado("Ingrese el nombre:");
		PersonaMod p = new PersonaMod(nombre);
		while (true) {
			int op = Integer.parseInt(entradaTeclado(
				"Seleccione que va a modificar:\n1. Nombre\n2. Edad\3. Profesion"));
			if (op >= 1 && op >= 3) {
				String mod = entradaTeclado("Ingrese la modificacion:");
				p.addModificacion((op == 1)? "Nombre" : 
					(op == 2)? "Edad" : "Profesión", mod);
				op = Integer.parseInt(entradaTeclado(
						"0. Salir, 1. Agregar otra modificacion:"));
				if (op == 0) break;
			}
		}
		return p;
	}
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try (Socket s = new Socket("localhost", 8081);
			ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
			ObjectInputStream ois = new ObjectInputStream(s.getInputStream())){
			while (true) {
				int res;
				int op = opcion();
				oos.write(op);
				switch (op) {
				case 1:
					oos.writeUTF("Leer");
					ArrayList<Persona> lista = (ArrayList<Persona>) ois.readObject();
					if (lista.isEmpty())
						System.out.println("No hay personas para mostrar");
					else
						lista.forEach(p -> System.out.println(p.toString()));
					break;
					
				case 2:
					oos.writeUTF("Nuevo");
					Persona p = persona();
					oos.writeObject(p);
					res = ois.read();
					switch (res) {
					case 1:
						System.out.println("Persona agregada con éxito");
						break;
						
					case 0:
						System.out.println("Persona ya en el sistema");
						break;
						
					default:
						System.out.println("Error al agregar la persona");
						break;
					}
					break;
					
				case 3:
					oos.writeUTF("Modificar");
					PersonaMod pm = personaMod();
					oos.writeObject(pm);
					res = ois.read();
					switch (res) {
					case 1:
						System.out.println("Persona modificada con éxito");
						break;
						
					case 0:
						System.out.println("Persona no encontrada");
						break;
						
					default:
						System.out.println("Error al modificar la persona");
						break;
					}
					break;
					
				case 0:
					oos.writeUTF("Salir");
					break;
					
				case -1:
					System.err.println("Error al leer del teclado");
					break;
					
				default:
					System.out.println("Opción no válida");
					break;
				}
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			System.err.println("Host inalcanzable");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Error al conectar con el servidor");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
