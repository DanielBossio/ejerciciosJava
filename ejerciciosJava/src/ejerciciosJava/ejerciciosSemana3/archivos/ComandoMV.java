package ejerciciosJava.ejerciciosSemana3.archivos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class ComandoMV {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String origen = "C:\\Users\\bossi\\OneDrive\\Documentos\\Consiti";
		String destino = "C:\\Users\\bossi\\OneDrive\\Documentos";
		String nombreArchivo = "Fumadores.txt";
		File dirDestino = new File(destino);
		File archivoOrigen = new File(origen+File.separator+nombreArchivo);
		File archivoDestino = new File(destino+File.separator+nombreArchivo);
		if (dirDestino.isDirectory()) {
			try{
				archivoDestino.createNewFile();
				try (BufferedReader br = new BufferedReader(new FileReader(archivoOrigen));
						PrintWriter pw = new PrintWriter(archivoDestino)){
					System.out.println("Moviendo archivo "+nombreArchivo
							+" de "+origen+" a "+destino);
					String linea;
					while ((linea = br.readLine()) != null) {
						System.out.println(linea);
						pw.println(linea);
					}
					archivoOrigen.deleteOnExit();
					System.out.println("Archivo movido con éxito");
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					System.err.println("Archivo no encontrado");
				} 
			} catch (IOException e) {
				System.err.println("No se pudo abrir o cerrar el archivo");
			} 
		}else {
			System.err.println(dirDestino+" no es un directorio");
		}
	}

}
