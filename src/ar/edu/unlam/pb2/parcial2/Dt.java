package ar.edu.unlam.pb2.parcial2;

public class Dt extends Miembro {

	private Integer edad;

	public Dt(String nombre, String equipo, Integer dni, Integer edad) {
		super(nombre, equipo, dni);
		this.edad = edad;
	}

	@Override
	String getTipo() {
		return "DT";
	}

}
