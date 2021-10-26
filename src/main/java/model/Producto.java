package tierraMedia;

//Clase abstracta y métodos abstractos
//Hereda a las clases Atraccion y Promocion
public abstract class Producto {
	
	
	//Devuelve si hay cupos
	public abstract boolean hayCupo();
	
	//Devuelve el costo	de la visita
	public abstract int getCostoDeVisita();
	
	//Devuelve el tipo de atracción
	public abstract TipoAtraccion getTipo();
	
	//Devuelve el tiempo de la visita
	public abstract double getTiempoDeVisita();
	
	
	
	
	

}
