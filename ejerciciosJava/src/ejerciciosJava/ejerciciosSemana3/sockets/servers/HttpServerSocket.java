package ejerciciosJava.ejerciciosSemana3.sockets.servers;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import ejerciciosJava.ejerciciosSemana3.sockets.HttpRequest;
import ejerciciosJava.ejerciciosSemana3.sockets.HttpResponse;

public class HttpServerSocket {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try (ServerSocket servidor = new ServerSocket(8081);
			Socket cliente = servidor.accept();){			
			System.out.println("Aceptado cliente "+
					cliente.getInetAddress().getHostName());
			ObjectInputStream ois = new ObjectInputStream
					(cliente.getInputStream());
			ObjectOutputStream oos = new ObjectOutputStream
					(cliente.getOutputStream());
			HttpRequest request = (HttpRequest) ois.readObject();
			switch (request.getBody()) {
			case "Concatenar":
				StringBuilder sb = new StringBuilder();
				request.getHeaders().entrySet().forEach(x -> {
					sb.append(x.getValue());
				});
				System.out.println("Mensaje obtenido: "+sb.toString());
				oos.writeObject(new HttpResponse(request.getBody(),
						request.getHeaders(), 1));
				break;
				
			default:
				System.err.println("Comando desconocido");
				oos.writeObject(new HttpResponse(request.getBody(),
						request.getHeaders(), 0));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println("Error al conectar el servidor");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.err.println("Error al recibir el request");
		}
	}

}
