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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
		result = prime * result + ((equipo == null) ? 0 : equipo.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Miembro other = (Miembro) obj;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		if (equipo == null) {
			if (other.equipo != null)
				return false;
		} else if (!equipo.equals(other.equipo))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	
	

}
