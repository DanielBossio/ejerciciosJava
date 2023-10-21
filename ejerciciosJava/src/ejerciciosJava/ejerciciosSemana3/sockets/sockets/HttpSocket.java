package ejerciciosJava.ejerciciosSemana3.sockets.sockets;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashMap;

import ejerciciosJava.ejerciciosSemana3.sockets.HttpRequest;
import ejerciciosJava.ejerciciosSemana3.sockets.HttpResponse;

public class HttpSocket {

	public static void main(String []args) {
		// TODO Auto-generated method stub
		try (Socket s = new Socket("localhost", 8081);){
			ObjectOutputStream oos = new ObjectOutputStream(
					s.getOutputStream());
			HashMap<String, String> m = new HashMap<>();
			m.put("Palabra1", "Probando");
			m.put("Palabra2", "Sockets");
			m.put("Palabra3", "Java");
			HttpRequest request = new HttpRequest("Concatenar",m);
			oos.writeObject(request);
			ObjectInputStream ois = new ObjectInputStream
					(s.getInputStream());
			HttpResponse response = (HttpResponse) ois.readObject();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println("Error al abrir el socket");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.err.println("Error al recibir la respuesta");
		}
	}
}
