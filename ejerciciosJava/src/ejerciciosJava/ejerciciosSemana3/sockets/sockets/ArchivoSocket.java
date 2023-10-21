package ejerciciosJava.ejerciciosSemana3.sockets.sockets;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.Socket;

public class ArchivoSocket {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Socket s = new Socket("localhost", 8081);
			DataOutputStream dos = new DataOutputStream(
					s.getOutputStream());
			BufferedReader br = new BufferedReader
					(new FileReader(new File
					("C:\\Users\\bossi\\OneDrive\\Documentos\\Consiti"
					+ "\\PLSQL\\1Variables-Bloques-Funciones.sql")));
			br.lines().forEach(l -> {
				try {
					dos.writeUTF(l);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.out.println("Error al leer archivo");
				}
			});
			dos.writeUTF("Salir");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println("Error al abrir el socket");
		}
	}

}
