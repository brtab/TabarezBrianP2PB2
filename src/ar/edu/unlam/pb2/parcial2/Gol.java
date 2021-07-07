package ar.edu.unlam.pb2.parcial2;

import java.util.Comparator;

public class Gol implements Comparable<Gol>{

	private Jugador jugador;
	private Integer minuto;
	
	public Gol(Jugador jugador, Integer minuto) {
		this.jugador = jugador;
		this.minuto = minuto;
	}

	public Jugador getJugador() {
		return jugador;
	}

	public Integer getMinuto() {
		return minuto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((jugador == null) ? 0 : jugador.hashCode());
		result = prime * result + ((minuto == null) ? 0 : minuto.hashCode());
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
		Gol other = (Gol) obj;
		if (jugador == null) {
			if (other.jugador != null)
				return false;
		} else if (!jugador.equals(other.jugador))
			return false;
		if (minuto == null) {
			if (other.minuto != null)
				return false;
		} else if (!minuto.equals(other.minuto))
			return false;
		return true;
	}


	@Override
	public int compareTo(Gol o) {
		return this.minuto.compareTo(o.minuto);
	}
	
	
}
