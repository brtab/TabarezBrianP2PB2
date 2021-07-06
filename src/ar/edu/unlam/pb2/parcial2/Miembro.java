package ar.edu.unlam.pb2.parcial2;

public abstract class Miembro {
	
	protected String equipo;
	protected String nombre;
	protected Integer dni;

	public Miembro(String nombre, String equipo, Integer dni) {
		this.nombre = nombre;
		this.equipo = equipo;
		this.dni = dni;
	}
	
	abstract String getTipo();

	public String getEquipo() {
		return equipo;
	}

	public String getNombre() {
		return nombre;
	}

	public Integer getDni() {
		return dni;
	}
	
	

}
