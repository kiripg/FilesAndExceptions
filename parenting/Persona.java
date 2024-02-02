package ejercicio2;

public class Persona {

	private String nombreCompleto;
	private String dni;
	private int edad;
	private Parentesco parentesco;
	
	public Persona(String nombreCompleto, String dni, int edad, Parentesco parentesco) {
		super();
		this.nombreCompleto = nombreCompleto;
		this.dni = dni;
		this.edad = edad;
		this.parentesco = parentesco;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public Parentesco getParentesco() {
		return parentesco;
	}

	public void setParentesco(Parentesco parentesco) {
		this.parentesco = parentesco;
	}

	@Override
	public String toString() {
		return "Persona [nombreCompleto=" + nombreCompleto + ", dni=" + dni + ", edad=" + edad + ", parentesco="
				+ parentesco + "]";
	}
	
	
	
}
