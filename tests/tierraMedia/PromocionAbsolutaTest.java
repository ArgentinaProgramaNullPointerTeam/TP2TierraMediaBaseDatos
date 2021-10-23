package tierraMedia;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class PromocionAbsolutaTest {

	Atraccion atraccion1;
	Atraccion atraccion2;

	List<Atraccion> pack = new ArrayList<Atraccion>();
	Promocion promo;

	@Before
	public void setup() {
		atraccion1 = new Atraccion("Rivendel", 10, 2, 6, TipoAtraccion.AVENTURA);
		atraccion2 = new Atraccion("Hobbiton", 15, 3.5, 8, TipoAtraccion.AVENTURA);

		pack.add(atraccion1);
		pack.add(atraccion2);

		promo = new PromocionAbsoluta("Pack 1", 2, pack, "Absoluta", "25");
	}

	@Test
	public void crearPromocionTest() {
		assertNotNull(promo);
	}

	@Test
	public void precioDePromocionTest() {
		int precioObtenido = promo.getCostoDeVisita();
		int precioEsperado = 25;

		assertEquals(precioEsperado, precioObtenido);
	}

	@Test
	public void cupoDePromocionTest() {
		// El cupo de la promocion es el menor cupo de la atraccion que lo compone
		int cupoObtenido = promo.getCupo();
		int cupoEsperado = 6;

		assertEquals(cupoEsperado, cupoObtenido);
	}

	@Test
	public void restarCupoTest() {
		// El cupo de la promocion es el menor cupo de la atraccion que lo compone
		promo.restarCupo();

		int cupoObtenido = promo.getCupo();
		int cupoEsperado = 5;

		assertEquals(cupoEsperado, cupoObtenido);
	}

	@Test
	public void duracionDePromocionTest() {
		double duracionObtenida = promo.getTiempoDeVisita();
		double duracionEsperada = 5.5;

		assertEquals(duracionEsperada, duracionObtenida, 0);
	}

	@Test
	public void noEstaIncluidaTest() {
		Producto atraccionIncluida = new Atraccion("Rivendel", 10, 2, 6, TipoAtraccion.AVENTURA);
		assertTrue(promo.esOContiene(atraccionIncluida));
	}
	@Test
	public void noEstaIncluidaTest2() {
		Producto atraccionNoIncluida = new Atraccion("Isengard", 10, 2.5, 23, TipoAtraccion.AVENTURA);
		assertFalse(promo.esOContiene(atraccionNoIncluida));
	}
	@Test
	public void hayCupoTest () {
		promo.restarCupo();
		promo.restarCupo();
		promo.restarCupo();
		promo.restarCupo();
		promo.restarCupo();		
		assertTrue(promo.hayCupo());
	}
	@Test
	public void noHayCupoTest() {
		promo.restarCupo();
		promo.restarCupo();
		promo.restarCupo();
		promo.restarCupo();
		promo.restarCupo();
		promo.restarCupo();
		assertFalse(promo.hayCupo());
	}
	@Test
	public void esPromocionTest() {
		assertTrue(promo.esPromocion());
	}
}
