package ar.edu.unlam.pb2.parcial2;

import java.util.HashSet;
import java.util.Set;

public class Partido {
	
	
	
	private static Integer CONTADOR = 1;
	private String equipo1;
	private String equipo2;
	private Set<Jugador> jugadoresDelEquipo1;
	private Set<Jugador> jugadoresDelEquipo2;
	private Integer id;

	public Partido(String equipo1, String equipo2) {
		this.equipo1 = equipo1;
		this.equipo2 = equipo2;
		this.jugadoresDelEquipo1 = new HashSet<Jugador>();
		this.jugadoresDelEquipo2 = new HashSet<Jugador>();
		this.id = this.CONTADOR;
		CONTADOR++;
	}
	
	public void cargarListadoJugadores(Torneo actual) {
		jugadoresDelEquipo1 = actual.getJugadoresPorEquipo(equipo1);
		jugadoresDelEquipo2 = actual.getJugadoresPorEquipo(equipo2);
	}
	
	public Integer cantidadJugadoresEquipo1() {
		return this.jugadoresDelEquipo1.size();
	}
	
	public Integer cantidadJugadoresEquipo2() {
		return this.jugadoresDelEquipo2.size();
	}

}
