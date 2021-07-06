package ar.edu.unlam.pb2.parcial2;

import ar.edu.unlam.pb2.parcial2.enumeradores.Posicion;

public class Jugador extends Miembro {

	private Posicion posicion;
	private Integer numeroDeCamiseta;

	public Jugador(String nombre, String equipo, Integer dni, Posicion posicion, Integer numeroDeCamiseta) {
		super(nombre, equipo, dni);
		this.posicion = posicion;
		this.numeroDeCamiseta = numeroDeCamiseta;
	}

	@Override
	String getTipo() {
		return "Jugador";
	}

	public Posicion getPosicion() {
		return posicion;
	}

	public Integer getNumeroDeCamiseta() {
		return numeroDeCamiseta;
	}
	
	

	
}
