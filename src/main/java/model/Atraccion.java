package model;

import java.util.Objects;

/**
 * Clase que modela  la atraccion. Tiene un constructor con los @param nombre,
 * costoDeVisita, tiempoDeVisita, cupo y tipoAtraccion Tiene los getter
 * para nombre, costoDeVisita, tiempoDeVisita y tipoAtraccion.
 * Tiene un metodo hayCupo que indica si la Atraccion tiene cupo o no
 * y un metodo restarCupo que resta 1 cupo cuando se acepta una compra y
 * hay cupo .
 */

public class Atraccion extends Producto {
	private int id;
	private String nombre;
	private int costoDeVisita;
	private double tiempoDeVisita;
	private int cupo;
	private String tipoAtraccion;
	

	public Atraccion(int id, String nombre, int costoDeVisita, double tiempoDeVisita, int cupo, String tipoAtraccion) {
		this.id = id;
		this.nombre = nombre;
		this.costoDeVisita = costoDeVisita;
		this.tiempoDeVisita = tiempoDeVisita;
		this.cupo = cupo;
		this.tipoAtraccion = tipoAtraccion;
	}
	
	@Override
	public int getId() {
		return id;
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
	public String getTipoAtracciones() {
		return tipoAtraccion;
	}

	@Override
	public boolean hayCupo() {
		return this.cupo > 0;
	}

	@Override
	public void restarCupo() {
		if (this.cupo > 0) {
			this.cupo -= 1;
		}

	}
	
	@Override
	public boolean esPromocion () {
		return false;
	}
	
	public int getCupo () {
		return this.cupo;
	}

	@Override
	public String toString() {
		return "Atraccion [nombre=" + nombre + ", costoDeVisita=" + costoDeVisita + ", tiempoDeVisita=" + tiempoDeVisita
				+ ", cupo=" + cupo + ", tipoAtraccion=" + tipoAtraccion + "]";
	}

	@Override
	public String  ofertas() {
		return "Atracción disponible para adquirir: " + this.nombre +"\n"+
				"Costo total: " + this.getCostoDeVisita()+ " monedas."+"\n"+
				"Tiempo total: " + this.getTiempoDeVisita()+ " horas";
	}

	@Override
	public boolean esOContiene(Producto otro) {
		return this.equals(otro);
	}

	@Override
	public int hashCode() {
		return Objects.hash(costoDeVisita, cupo, nombre, tiempoDeVisita, tipoAtraccion);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Atraccion other = (Atraccion) obj;
		return costoDeVisita == other.costoDeVisita && cupo == other.cupo && Objects.equals(nombre, other.nombre)
				&& Double.doubleToLongBits(tiempoDeVisita) == Double.doubleToLongBits(other.tiempoDeVisita)
				&& tipoAtraccion == other.tipoAtraccion;
	}
}
