package model;

import java.util.List;

public class PromocionPorcentual extends Promocion {

	private String nombre;
	private int cantAtracciones;
	private List<Atraccion> atracciones;
	private String tipoPromocion;
	private double descuento;
	private int costoDeVisita;
	private double tiempoDeVisita;

	public PromocionPorcentual(String nombre, int cantAtracciones, List<Atraccion> atracciones, String tipoPromocion,
			String descuento) {
		this.nombre = nombre;
		this.cantAtracciones = cantAtracciones;
		this.atracciones = atracciones;
		this.tipoPromocion = tipoPromocion;
		this.descuento = Double.parseDouble(descuento);
	}

	@Override
	public String getNombre() {
		return this.nombre;
	}

	@Override
	public String getTipoPromocion() {
		return this.tipoPromocion;
	}

	@Override
	public String toString() {
		return this.nombre + " con  " + this.cantAtracciones + " atracciones " + this.atracciones;
	}

	@Override
	public boolean hayCupo() {
		boolean cupo = true;
		for (Atraccion cadaAtraccion : atracciones) {
			if (!cadaAtraccion.hayCupo()) {
				cupo = false;
				break;
			}
		}
		return cupo;
	}

	@Override
	public double getTiempoDeVisita() {
		for (Atraccion cadaAtraccion : atracciones) {
			tiempoDeVisita += cadaAtraccion.getTiempoDeVisita();
		}
		return tiempoDeVisita;
	}

	@Override
	public TipoAtraccion getTipoAtracciones() {
		return this.atracciones.get(0).getTipoAtracciones();
	}

	@Override
	public void restarCupo() {
		for (Atraccion cadaAtraccion : atracciones) {
			cadaAtraccion.restarCupo();
		}
	}

	@Override
	public boolean esPromocion() {
		return true;
	}

	@Override
	public String ofertas() {
		String ofertaAtracciones = "";
		for (Atraccion cadaAtraccion : this.atracciones) {
			ofertaAtracciones = ofertaAtracciones + " " + cadaAtraccion.getNombre()+ ". ";
		}
		return "Promoción disponible para adquirir: " + this.nombre +
				"\nAtracciones que contiene:"+ofertaAtracciones+"\n"
				+"Costo total: " + this.getCostoDeVisita()+ " monedas"+"\n"+
				"Tiempo total: " + this.getTiempoDeVisita()+ " horas";
		
	}

	@Override
	public int getCostoDeVisita() {
		for (Atraccion atraccion : this.atracciones) {
			costoDeVisita = costoDeVisita + atraccion.getCostoDeVisita();
		}
		costoDeVisita = (int) (costoDeVisita - (costoDeVisita * descuento));
		return costoDeVisita;
	}

	@Override
	public boolean esOContiene(Producto otro) {
		for (Atraccion a : this.atracciones) {
			  if(otro.esOContiene(a)) return true;
		}
		return false;
	}
	
	@Override
	public int getCupo () {
		int cupo=this.atracciones.get(0).getCupo();
		for (Atraccion cadaAtraccion : this.atracciones) {
			if(cadaAtraccion.getCupo()<cupo) {
				cupo=cadaAtraccion.getCupo();
			}
		}
		return cupo;
	}
	
}