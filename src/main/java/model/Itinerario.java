package model;

import java.util.ArrayList;
import java.util.List;
/*
 * Tiene un metodo llamado
 * yaCompro que retorna un booleano y verifica que el producto comprado no haya
 * sido comprado anteriormente.
 * Tiene dos metodos que retorna las monedas gastadas y el tiempo gastado en las
 * compras que realizo el usuario respectivamente. 
 */
public class Itinerario {
	private List<Producto> listaCompra = new ArrayList<Producto>();
	private int costoItinerario = 0;
	private double duracionItinerario = 0;
	private int idUsuario;
	private int idItinerario;
	
	
	public String getItinerario() {
		String listaArchivo = "";
		for (Producto producto : listaCompra) {
			listaArchivo = listaArchivo + "\n" + producto.ofertas() + " \n";
		}
		return listaArchivo;
	}
	
	public int getIdUsuario() {
		return this.idUsuario;
	}
	
	public int getIdItinerario() {
		return this.idItinerario;
	}
	
	public int getCostoItinerario() {
		return this.costoItinerario;
	}

	public double getDuracionItinerario() {
		return this.duracionItinerario;
	}
	public void agregarAItinerario(Producto producto) {
		this.listaCompra.add(producto);
		this.costoItinerario += producto.getCostoDeVisita();
		this.duracionItinerario += producto.getTiempoDeVisita();
	}

	public boolean yaCompro(Producto otro) {
		// Verifica que el producto no haya sido comprado anteriormente
		for (Producto cadaProductoItinerario : listaCompra) {
			if (otro.esOContiene(cadaProductoItinerario) || cadaProductoItinerario.esOContiene(otro))
				return true;
		}
		return false;
	}
}
