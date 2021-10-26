package tierraMedia;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que modela al usuario Tiene un constructor con los
 * @param nombre, atraccionPreferida, dineroDisponible, tiempoDisponible Tiene
 * los getter para tiempoDisponible, dineroDisponible,
 * atraccionPreferida y listaCompra Tiene un metodo
 * guardarSugerencia que recibe un producto y lo guarda en
 * listaCompra Tiene un metodo restarTiempo y restarDinero que
 * resta el tiempo y el dinero respectivamente.
 */
public class Usuario {
	private String nombre;
	private TipoAtraccion atraccionPreferida;
	private double dineroDisponible;
	private double tiempoDisponible;
	private List<Producto> listaCompra = new ArrayList<Producto>();

	public Usuario(String nombre, TipoAtraccion atraccionPreferida, 
			double dineroDisponible, double tiempoDisponible) {
		this.nombre = nombre;
		this.atraccionPreferida = atraccionPreferida;
		this.dineroDisponible = dineroDisponible;
		this.tiempoDisponible = tiempoDisponible;
	}

	public double getTiempoDisponible() {
		return tiempoDisponible;
	}

	public double getDineroDisponible() {
		return dineroDisponible;
	}

	public TipoAtraccion getAtraccionPreferida() {
		return atraccionPreferida;
	}

	public List<Producto> getListaCompra() {
		return listaCompra;
	}

	public void guardarSugerencia(Producto producto) throws Exception {
		this.restarDinero(producto.getCostoDeVisita());
		this.restarTiempo(producto.getTiempoDeVisita());
		listaCompra.add(producto);
	}

	public void restarDinero(double dinero) throws Exception {
		if (this.dineroDisponible >= dinero) {
			this.dineroDisponible -= dinero;
		} else {
			throw new Exception("Dinero insuficiente");
		}
	}

	public void restarTiempo(double tiempo) throws Exception {
		if (this.tiempoDisponible >= tiempo) {
			this.tiempoDisponible -= tiempo;
		} else {
			throw new Exception("Tiempo insuficiente");
		}
	}

	@Override
	public String toString() {
		return "Nombre de usuario= " + nombre + ", Atraccion preferida= " 
				+ atraccionPreferida + ", Dinero disponible= "
				+ dineroDisponible + ", Tiempo disponible= " + tiempoDisponible;
	}

}
