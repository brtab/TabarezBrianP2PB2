package ar.edu.unlam.pb2.parcial2;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.TreeSet;

import org.junit.Test;

import ar.edu.unlam.pb2.parcial2.enumeradores.Posicion;
import ar.edu.unlam.pb2.parcial2.excepciones.GolNoEncontradoException;
import ar.edu.unlam.pb2.parcial2.excepciones.JugadorNoEncontradoException;

public class EquipoTest {

	@Test
	public void testQueSePuedaCrearUnJugador() {
		String nombre = "Gonzalo Montiel";
		Posicion posicion = Posicion.DEF;
		String equipo = "Argentina";
		Integer dni = 123;
		Integer numeroDeCamiseta = 4;
		
		Jugador nuevo = new Jugador(nombre, equipo, dni, posicion, numeroDeCamiseta);
		assertEquals(nuevo.getNombre(), nombre);
		assertEquals(nuevo.getEquipo(), equipo);
		assertEquals(nuevo.getDni(), dni);
		assertEquals(nuevo.getPosicion(), posicion);
	
	}
	
	@Test
	public void testQueSePuedanIngresarLosMiembros() {
		
		
		Torneo actual = new Torneo();
		actual.ingresarMiembro(new Jugador("Gonzalo Montial", "Argentina", 123, Posicion.DEF, 4));
		actual.ingresarMiembro(new Dt("Lionel Scaloni", "Argentina", 234, 45));
		actual.ingresarMiembro(new Jugador("Guillermo Maripan", "Chile", 767, Posicion.DEF, 5));
		
		assertEquals(actual.miembrosDisponibles(), 3, 0.1);
	}

	@Test
	public void testQueSePuedaArmarElEquipo() {
		Torneo actual = new Torneo();
		actual.ingresarMiembro(new Jugador("Gonzalo Montial", "Argentina", 123, Posicion.DEF, 4));
		actual.ingresarMiembro(new Dt("Lionel Scaloni", "Argentina", 234, 45));
		actual.ingresarMiembro(new Jugador("Guillermo Maripan", "Chile", 767, Posicion.DEF, 5));
		actual.ingresarMiembro(new Jugador("Jean Meneses", "Chile", 625, Posicion.DEL, 9));
		actual.ingresarMiembro(new Jugador("Jose Maria Jimenez", "Uruguay", 736, Posicion.DEF, 3));
		actual.ingresarMiembro(new Dt("Martin Lasarte", "Chile", 7278, 50));
		
		//no deberia contar los dt
		
		Partido nuevo = new Partido("Argentina", "Chile");
		nuevo.cargarListadoJugadores(actual);
		assertEquals(nuevo.cantidadJugadoresEquipo1(), 1, 0.1);
		assertEquals(nuevo.cantidadJugadoresEquipo2(), 2, 0.1);
		
		
	}
	
	@Test
	public void testQueSePuedaRegistrarUnGol() throws JugadorNoEncontradoException, GolNoEncontradoException{
		Torneo actual = new Torneo();
		actual.ingresarMiembro(new Jugador("Gonzalo Montial", "Argentina", 123, Posicion.DEF, 4));
		actual.ingresarMiembro(new Dt("Lionel Scaloni", "Argentina", 234, 45));
		actual.ingresarMiembro(new Jugador("Guillermo Maripan", "Chile", 767, Posicion.DEF, 5));
		actual.ingresarMiembro(new Jugador("Jean Meneses", "Chile", 625, Posicion.DEL, 9));
		actual.ingresarMiembro(new Jugador("Jose Maria Jimenez", "Uruguay", 736, Posicion.DEF, 3));
		actual.ingresarMiembro(new Dt("Martin Lasarte", "Chile", 7278, 50));
		
		//no deberia contar los dt
		
		Partido nuevo = new Partido("Argentina", "Chile");
		nuevo.cargarListadoJugadores(actual);
		nuevo.registrarGol(4, "Argentina", 33);
		Gol ultimo = new Gol(new Jugador("Gonzalo Montial", "Argentina", 123, Posicion.DEF, 4), 33);
		
		assertEquals(nuevo.getGol(33), ultimo);
	}
	
	@Test(expected = JugadorNoEncontradoException.class)
	public void testJugadorNoEncontrado() throws JugadorNoEncontradoException{
		Torneo actual = new Torneo();
		actual.ingresarMiembro(new Jugador("Gonzalo Montial", "Argentina", 123, Posicion.DEF, 4));
		actual.ingresarMiembro(new Dt("Lionel Scaloni", "Argentina", 234, 45));
		actual.ingresarMiembro(new Jugador("Guillermo Maripan", "Chile", 767, Posicion.DEF, 5));
		actual.ingresarMiembro(new Jugador("Jean Meneses", "Chile", 625, Posicion.DEL, 9));
		actual.ingresarMiembro(new Jugador("Jose Maria Jimenez", "Uruguay", 736, Posicion.DEF, 3));
		actual.ingresarMiembro(new Dt("Martin Lasarte", "Chile", 7278, 50));
		
		
		Partido nuevo = new Partido("Argentina", "Chile");
		nuevo.cargarListadoJugadores(actual);
		nuevo.registrarGol(3, "Argentina", 33);
	}
	
	@Test
	public void testGolesOrdenados() throws JugadorNoEncontradoException {
		Torneo actual = new Torneo();
		actual.ingresarMiembro(new Jugador("Gonzalo Montial", "Argentina", 123, Posicion.DEF, 4));
		actual.ingresarMiembro(new Dt("Lionel Scaloni", "Argentina", 234, 45));
		actual.ingresarMiembro(new Jugador("Guillermo Maripan", "Chile", 767, Posicion.DEF, 5));
		actual.ingresarMiembro(new Jugador("Jean Meneses", "Chile", 625, Posicion.DEL, 9));
		actual.ingresarMiembro(new Jugador("Jose Maria Jimenez", "Uruguay", 736, Posicion.DEF, 3));
		actual.ingresarMiembro(new Dt("Martin Lasarte", "Chile", 7278, 50));
		
		Partido nuevo = new Partido("Argentina", "Chile");
		nuevo.cargarListadoJugadores(actual);
		nuevo.registrarGol(4, "Argentina", 33);
		nuevo.registrarGol(9, "Chile", 30);
		nuevo.registrarGol(9, "Chile", 50);
		
		ArrayList<Gol> goles = nuevo.getGolesCronologicamente();
		
		assertEquals(goles.get(0).getMinuto(), 30, 0.1);
		assertEquals(goles.get(2).getMinuto(), 50, 0.1);
	}
	
	
}
