package ejercicio2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class Familia {

	private int identificador;
	private HashMap<String, Persona> libroFamilia;
	/*
	 * libroFamilia identifica a cada persona de la Familia, utilizando el dni como
	 * clave y el objeto Persona como valor.
	 */

	public Familia(int identificador, HashMap<String, Persona> libroFamilia) {
		super();
		this.identificador = identificador;
		this.libroFamilia = libroFamilia;
	}

	public int getIdentificador() {
		return identificador;
	}

	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}

	public HashMap<String, Persona> getLibroFamilia() {
		return libroFamilia;
	}

	public void setLibroFamilia(HashMap<String, Persona> libroFamilia) {
		this.libroFamilia = libroFamilia;
	}

	/**
	 * M�todo que comprueba si una familia es numerosa, escribiendo un fichero de
	 * texto con los datos de la familia (Identificador de familia + n�mero de
	 * personas) en caso afirmativo. Este m�todo debe comprobar que en la familia
	 * haya al menos 5 personas, de las cuales 3 deben ser HIJO. Si la familia no es
	 * numerosa debe saltar una FamiliaException con el mensaje �La familia +
	 * identificador no es numerosa�. (2,5 puntos)
	 * 
	 * @param nomFich
	 * @throws FamiliaException
	 * @throws IOException 
	 */
	public void escribeFamiliaNumerosa(String nomFich) throws FamiliaException, IOException {
		
		File out = new File(nomFich);
		int cont= 0;
		
		
		try(FileWriter escritor = new FileWriter(out);
				PrintWriter filtro = new PrintWriter(escritor)){
			
			if(libroFamilia.size()>=5) {
				
				for (Persona familiar : libroFamilia.values()) {
					
					if(familiar.getParentesco() == Parentesco.HIJO) {
						cont++;
					}
					if(cont >= 3) {
						filtro.println(identificador + " +  " + cont + " personas");
					}	
				}
				
				
				
			}else {
				throw new FamiliaException("La familia " + identificador + " no es numerosa");
			}
		}

		
		
		
	}

	/**
	 * M�todo que escriba un fichero de texto con la informaci�n de cada persona de
	 * la familia en cada l�nea. El orden de aparici�n debe realizarse ordenado por
	 * edad y se mostrar� DNI + Parentesco + Edad. Si la familia no tiene personas
	 * escribiremos �identificador de Familia - vacia� en el fichero. (2,5 puntos)
	 * 
	 * @param nomFich
	 * @throws IOException
	 */
	public void escribeFamilia(String nomFich) throws IOException {

		File salida = new File(nomFich);

		try (FileWriter escritor = new FileWriter(salida); PrintWriter filtro = new PrintWriter(escritor)) {

			ArrayList<Persona> listado = new ArrayList<>();

			listado.addAll(libroFamilia.values());

			Comparator<Persona> comparador = new Comparator<Persona>() {

				@Override
				public int compare(Persona o1, Persona o2) {
					if (o1.getEdad() < o2.getEdad()) {
						return 1;
					} else if (o1.getEdad() == o2.getEdad()) {
						return 0;
					} else {
						return -1;
					}
}};

		if(listado.size()> 0) {
			for (Persona persona : listado) {
				
				filtro.println(persona.getDni() + " " + persona.getParentesco() + " " + persona.getEdad());
				
			}
		}else {
			filtro.println(identificador + "- vacia");
		}

		} catch (FileNotFoundException e) {
			System.out.println("Archivo no encontrado");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}

}
