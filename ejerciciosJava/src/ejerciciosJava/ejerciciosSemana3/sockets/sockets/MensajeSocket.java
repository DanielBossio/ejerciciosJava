package ejerciciosJava.ejerciciosSemana3.sockets.sockets;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class MensajeSocket {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Socket s = new Socket("localhost", 8081);
			DataOutputStream dos = new DataOutputStream(
					s.getOutputStream());
			dos.writeUTF("Iniciar");
			dos.writeUTF("Reiniciar");
			dos.writeUTF("Otro");
			dos.writeUTF("Apagar");
			dos.writeUTF("Salir");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println("Error al abrir el socket");
		}
	}

}
