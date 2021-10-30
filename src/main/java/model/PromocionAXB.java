package model;

import java.util.List;

public class PromocionAXB extends Promocion {
	private String nombre;
	private int cantAtracciones;
	private int id;
	private List<Atraccion> atracciones;
	private String tipoPromocion;
	private int idAtraccionGratuita;
	private int costoDeVisita;
	private double tiempoDeVisita;

	public PromocionAXB(int id, String nombre, int cantAtracciones, List<Atraccion> atracciones, String tipoPromocion,
			int descuento) {
		this.id= id;
		this.nombre = nombre;
		this.cantAtracciones = cantAtracciones;
		this.atracciones = atracciones;
		this.tipoPromocion = tipoPromocion;
		this.idAtraccionGratuita = descuento;
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
		return this.nombre + " con  " + this.cantAtracciones + " atracciones\n"
				+ " " + this.atracciones;
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
	public String getTipoAtracciones() {
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
		Atraccion atraccionGratuita = this.atracciones.get(atracciones.size() - 1);
		String ofertaAtracciones = "";
		for (Atraccion cadaAtraccion : this.atracciones) {
			ofertaAtracciones = ofertaAtracciones + " " + cadaAtraccion.getNombre()+ ". ";
		}
		return "Promoción disponible para adquirir: " + this.nombre +
				"\nAtracciones que contiene:"+ofertaAtracciones+"\n¡"
				+ atraccionGratuita.getNombre() + " es gratuita!"+"\n"
				+"Costo total: " + this.getCostoDeVisita()+ " monedas"+"\n"+
				"Tiempo total: " + this.getTiempoDeVisita()+ " horas";
		
	}

	@Override
	public int getCostoDeVisita() {
		costoDeVisita = 0;
		Atraccion atraccionGratuita = this.atracciones.get(atracciones.size() - 1);
		for (Atraccion cadaAtraccion : this.atracciones) {
			costoDeVisita = costoDeVisita + cadaAtraccion.getCostoDeVisita();
		}
		costoDeVisita = costoDeVisita - atraccionGratuita.getCostoDeVisita();
		return costoDeVisita;
	}

	
	public int getidAtraccionGratuita() {
		return this.idAtraccionGratuita;
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

	@Override
	public int getId() {
		return id;
	}
	
}
