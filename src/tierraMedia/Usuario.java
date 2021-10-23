package tierraMedia;

/**
 * Clase que modela al usuario. Tiene un constructor con los parametros nombre,
 * atraccionPreferida, dineroDisponible, tiempoDisponible. Tiene los getter para
 * atraccionPreferida. Tiene un metodo comprar que recibe un
 * producto y lo guarda en el itinerario. Tiene un metodo restarTiempo y
 * restarDinero que resta el tiempo y el dinero respectivamente. Tiene un metodo
 * puedeComprar que retorna un boolean si tiene tiempo y dinero disponible.
 */
public class Usuario {
	private String nombre;
	private TipoAtraccion atraccionPreferida;
	private int dineroDisponible;
	private double tiempoDisponible;
	private Itinerario itinerario;

	public Usuario(String nombre, TipoAtraccion atraccionPreferida, int dineroDisponible, double tiempoDisponible) {
		this.nombre = nombre;
		this.atraccionPreferida = atraccionPreferida;
		this.dineroDisponible = dineroDisponible;
		this.tiempoDisponible = tiempoDisponible;
		this.itinerario = new Itinerario();
	}

	public String getNombre() {
		return this.nombre;
	}

	public TipoAtraccion getAtraccionPreferida() {
		return atraccionPreferida;
	}

	public int getDineroDisponible() {
		return dineroDisponible;
	}

	public double getTiempoDisponible() {
		return tiempoDisponible;
	}
	public Itinerario getItinerario() {
		return this.itinerario;
	}
	public void comprar(Producto producto) {
		this.restarDinero(producto.getCostoDeVisita());
		this.restarTiempo(producto.getTiempoDeVisita());
		this.itinerario.agregarAItinerario(producto);
	}

	public void restarDinero(int dinero) {
		this.dineroDisponible -= dinero;
	}

	public void restarTiempo(double tiempo) {
		this.tiempoDisponible -= tiempo;
	}

	public boolean puedeComprar(Producto producto) {
		// Verifica que el usuario tenga tiempo, dinero y no haya comprado el mismo
		// producto.
		return this.dineroDisponible >= producto.getCostoDeVisita()
				&& this.tiempoDisponible >= producto.getTiempoDeVisita() && !itinerario.yaCompro(producto);
	}

	@Override
	public String toString() {
		return "Nombre de usuario= " + nombre + ", Atraccion preferida= " + atraccionPreferida + ", Dinero disponible= "
				+ dineroDisponible + ", Tiempo disponible= " + tiempoDisponible;
	}
}
