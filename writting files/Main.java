package povedanoKirissaExamen22Mayo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;

public class Main {

	public static void main(String[] args) throws IOException {

	}

	// Este método crea un directorio a traves de mkdir(). Dpués, usamos un for para
	// crear los
	// cinco archivos consecutivos sin esfuerzo (marcando el nombre a traves de un
	// string)

	private static void creaDirectorioYArchivos(String ruta) throws IOException {

		File directorio = new File("C:\\archivos");

		if (directorio.mkdir()) {

			for (int i = 0; i < 5; i++) {
				String archivo = "C:\\archivos\\archivo" + (i + 1) + ".txt";
				File set = new File(archivo);
				set.createNewFile();
			}

		}

	}

	// Este método, coge el segundo caracter de la cadena a través del charAt, y nos
	// devuelve
	// su longitud a travées de .legnth() Los resultados se escribiran en un archivo
	// de texto
	// output.txt

	private static void escribeSegundoCaracter(String cadena) throws IOException {

		char caracter = cadena.charAt(1);
		int largo = cadena.length();

		try (FileWriter escritor = new FileWriter("C:\\archivos\\output.txt");
				PrintWriter filtro = new PrintWriter(escritor)) {

			filtro.println(caracter + " con un largo de " + largo + "caracteres.");

			filtro.close();
		} catch (FileNotFoundException e) {
			System.out.println("Archivo no encontrado");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}

	// Este método escribre a traves de los metodos de escritura binarios basados en
	// objetos
	// un objecto indefinido o.

	private static void escribeBinarioObjeto(Object o) throws FileNotFoundException, IOException {

		File binario = new File("C:\\archivos\\objetos.bin");

		try (FileOutputStream escritor = new FileOutputStream(binario);
				ObjectOutputStream filtro = new ObjectOutputStream(escritor)) {

			filtro.writeObject(o);
			filtro.close();

		} catch (FileNotFoundException e) {
			System.out.println("Archivo no encontrado");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}

	// Este metodo lee un archivo binario basado en objetos, para devolver el objeto
	// leido

	private static Object leeBinarioObjeto(String rutaFichero)
			throws FileNotFoundException, IOException, ClassNotFoundException {

		Object o = null;

		try (FileInputStream lector = new FileInputStream(rutaFichero);
				ObjectInputStream filtro = new ObjectInputStream(lector)) {

			o = filtro.readObject();

		} catch (FileNotFoundException e) {
			System.out.println("El archivo no se encuentra");
		} catch (IOException e) {
			System.out.println("No pudo encontrarse el objeto del archivo, reviselo");
		}

		return o;

	}
}
