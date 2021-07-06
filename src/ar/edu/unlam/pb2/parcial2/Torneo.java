package ar.edu.unlam.pb2.parcial2;

import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;

public class Torneo {
	
	Set<Miembro> miembros;
	
	public Torneo() {
		this.miembros = new HashSet<Miembro>();
	}
	
	public Boolean ingresarMiembro(Miembro nuevo) {
		return this.miembros.add(nuevo);
	}

	public Integer miembrosDisponibles() {
		
		return this.miembros.size();
	}
	
	public HashSet<Jugador> getJugadoresPorEquipo(String equipo) {
		Iterator it = miembros.iterator();
		HashSet<Jugador> JugadoresAlPartido = new HashSet<Jugador>();
		while(it.hasNext()) {
			Miembro actual = (Miembro) it.next();
			if(actual.getClass().equals(Jugador.class)&&actual.getEquipo().equals(equipo)) {
				JugadoresAlPartido.add((Jugador) actual);
			}
		}
		return JugadoresAlPartido;
	}

}
