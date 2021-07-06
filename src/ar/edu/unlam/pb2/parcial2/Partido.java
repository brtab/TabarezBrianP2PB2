package ar.edu.unlam.pb2.parcial2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import ar.edu.unlam.pb2.parcial2.excepciones.GolNoEncontradoException;
import ar.edu.unlam.pb2.parcial2.excepciones.JugadorNoEncontradoException;

public class Partido {

	private static Integer CONTADOR = 1;
	private String equipo1;
	private String equipo2;
	private Set<Jugador> jugadoresDelEquipo1;
	private Set<Jugador> jugadoresDelEquipo2;
	private List<Gol> goles;
	private Integer id;

	public Partido(String equipo1, String equipo2) {
		this.equipo1 = equipo1;
		this.equipo2 = equipo2;
		this.jugadoresDelEquipo1 = new HashSet<Jugador>();
		this.jugadoresDelEquipo2 = new HashSet<Jugador>();
		this.goles = new ArrayList<Gol>();
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

	public Jugador buscarJugadorPorCamiseta(Integer numeroDeCamiseta, String equipo) throws JugadorNoEncontradoException {
		Iterator it;
		if (equipo.equals(equipo1)) {
			it = jugadoresDelEquipo1.iterator();
		} else {
			it = jugadoresDelEquipo2.iterator();
		}
		while(it.hasNext()) {
			Jugador actual = (Jugador) it.next();
			if(actual.getNumeroDeCamiseta().equals(numeroDeCamiseta)) {
				return actual;
			}
		}
		throw new JugadorNoEncontradoException();
	}

	public void registrarGol(Integer numeroDeCamiseta, String equipo, Integer minuto) throws JugadorNoEncontradoException {
		Jugador goleador = buscarJugadorPorCamiseta(numeroDeCamiseta, equipo);
		
		Gol actual = new Gol(goleador, minuto);
		goles.add(actual);
	}
	
	public Gol getGol(Integer minuto) throws GolNoEncontradoException {
		Iterator it = goles.iterator();
		while(it.hasNext()) {
			Gol actual = (Gol) it.next();
			if(actual.getMinuto().equals(minuto)) {
				return actual;
			}
		}
		throw new GolNoEncontradoException();
	}

}
