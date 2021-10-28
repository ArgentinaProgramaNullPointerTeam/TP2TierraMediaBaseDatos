package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.Atraccion;
import model.Itinerario;
import model.Producto;
import model.Usuario;

public class ItinerarioTests {
	Usuario usuario;
	Producto sugerencia1, sugerencia2, sugerencia3;
	@Before
	public void setup() {
		usuario = new Usuario(1, "Sam", "Aventura", 50, 3);
		sugerencia1 = new Atraccion(1, "Edoras", 5, 0.5, 2, "Aventura");
		sugerencia2 = new Atraccion(1, "Isengard", 5, 1, 2, "Aventura");
		sugerencia3 = new Atraccion(3, "Rivendel", 10, 1, 2, "Aventura");
	}
	@After
	public void tearDown() {
		sugerencia1 = null;
		sugerencia2 = null;
		sugerencia3 = null;
	}
	@Test
	public void tiempoItinerario() {
		//Verifica el gasto correcto de tiempo
		Itinerario itinerario = usuario.getItinerario();
		usuario.comprar(sugerencia1);
		usuario.comprar(sugerencia2);
		usuario.comprar(sugerencia3);
		assertEquals(2.5, itinerario.getDuracionItinerario(), 0);
	}
	@Test
	public void monedasItinerario() {
		//Verifica el gasto correcto de dinero.
		Itinerario itinerario = usuario.getItinerario();
		usuario.comprar(sugerencia1);
		usuario.comprar(sugerencia2);
		usuario.comprar(sugerencia3);
		assertEquals(20, itinerario.getCostoItinerario());
	}

}
