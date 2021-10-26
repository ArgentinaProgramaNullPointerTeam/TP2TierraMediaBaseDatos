package tierraMedia;

/**
 * Clase que modela a la atraccion Tiene un constructor con los
 * 
 * @param nombre, costoDeVisita, tiempoDeVisita, cupo y tipoAtraccion Tiene los
 * getter para nombre, costoDeVisita, tiempoDeVisita, cupo y
 * tipoAtraccion Tiene un metodo restarCupo, que resta 1 cupo
 * cuando se acepta una compra y hayCupo que indica si la
 * Atraccion tiene cupo o no.
 */

public class Atraccion extends Producto {
	private String nombre;
	private int costoDeVisita;
	private double tiempoDeVisita;
	private int cupo;
	private TipoAtraccion tipoAtraccion;

	public Atraccion(String nombre, int costoDeVisita, double tiempoDeVisita, int cupo, TipoAtraccion tipoAtraccion) {
		this.nombre = nombre;
		this.costoDeVisita = costoDeVisita;
		this.tiempoDeVisita = tiempoDeVisita;
		this.cupo = cupo;
		this.tipoAtraccion = tipoAtraccion;
	}

	@Override
	public String getNombre() {
		return nombre;
	}

	@Override
	public int getCostoDeVisita() {
		return costoDeVisita;
	}

	@Override
	public double getTiempoDeVisita() {
		return tiempoDeVisita;
	}

	@Override
	public int getCupo() {
		return cupo;
	}

	@Override
	public TipoAtraccion getTipo() {
		return tipoAtraccion;
	}

	public void restarCupo() throws Exception {
		if (this.cupo > 0) {
			this.cupo -= 1;
		} else {
			throw new Exception("No hay más cupo");
		}
	}

	@Override
	public boolean hayCupo() {
		return this.cupo > 0;
	}

}
