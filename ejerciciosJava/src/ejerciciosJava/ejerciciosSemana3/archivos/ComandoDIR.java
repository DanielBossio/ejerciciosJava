package ejerciciosJava.ejerciciosSemana3.archivos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class ComandoDIR {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path = "C:\\Users\\bossi\\OneDrive\\Documentos\\Consiti";
		File dir = new File(path);
		if (dir.isDirectory()) {
			try{
				File output = new File(path+File.separator+"ListadoArchivos.txt");
				output.createNewFile();
				try (PrintWriter pw = new PrintWriter(output)){
					System.out.println("Listando archivos en "+path);
					File[] contenido = dir.listFiles();
					for (File archivo : contenido) {
						//Se crea un objeto Calendar para obtener la fecha
						//de la última modificación del archivo
						GregorianCalendar c = new GregorianCalendar();
						c.setTime(new Date(archivo.lastModified()));
						String linea = archivo.getName()+
								"t"+(archivo.isDirectory()?"DIR":"")+
								"\t"+archivo.length()+"\t"+
								(archivo.isHidden()?"Oculto":"No Oculto")+"\t"+
								c.get(Calendar.YEAR)+"/"+c.get(Calendar.MONTH)+
								"/"+c.get(Calendar.DAY_OF_MONTH);
						System.out.println(linea);
						pw.println(linea);
					}
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					System.err.println("Archivo no encontrado");
				} 
			} catch (IOException e) {
				System.err.println("No se pudo abrir o cerrar el archivo");
			} 
		}else {
			System.err.println(path+" no es un directorio");
		}
	}

}
