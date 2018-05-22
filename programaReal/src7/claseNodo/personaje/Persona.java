package claseNodo.personaje;

public abstract class Persona implements Propiedad{
	private String nombre;// Nombre de cada objeto persona
    private String apellidos;// Apellidos de cada objeto persona
    private int edad=0;// Edad de cada objeto persona
    private boolean casado;// Casado ( verdadero o falso (si/no)) de cada objeto persona
    private String dni;// DNI de cada objeto persona
    
    
	public Persona(String nombre, String apellidos, int edad, boolean casado, String dni) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.edad = edad;
		this.casado = casado;
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public boolean isCasado() {
		return casado;
	}

	public void setCasado(boolean casado) {
		this.casado = casado;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}
	

}
