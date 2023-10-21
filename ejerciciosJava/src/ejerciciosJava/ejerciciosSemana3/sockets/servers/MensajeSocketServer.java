package ejerciciosJava.ejerciciosSemana3.sockets.servers;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MensajeSocketServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ServerSocket servidor = new ServerSocket(8081);
			Socket cliente = servidor.accept();
			System.out.println("Aceptado cliente "+
					cliente.getInetAddress().getHostName());
			DataInputStream dis = new DataInputStream
					(cliente.getInputStream());
			ciclo:
			while (true) {
				String mensaje = dis.readUTF();
				switch(mensaje) {
				case "Iniciar":
					System.out.println("Iniciando...");
					break;
					
				case "Reiniciar":
					System.out.println("Reiniciando...");
					break;
					
				case "Apagar":
					System.out.println("Apagando...");
					break;
					
				case "Salir":
					break ciclo;
					
				default:
					System.out.println("Comando no reconocido");
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println("Error al conectar el servidor");
		}
	}

}
