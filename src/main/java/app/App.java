package tierraMedia;


import java.util.List;

public class App {
	private static List<Usuario> usuarios;
	private static List<Atraccion> atraccion;
	private static List<Promocion> promociones;
	
	public static void main(String[] args) {		
		System.out.println("Leer\n");
		usuarios = AdministradorDeArchivos.leerUsuarios(); //Tiene q devolver un array de usuarios
		
		System.out.println("Leer\n");
		atraccion = AdministradorDeArchivos.leerAtracciones(); //Tiene q devolver un array de atracciones
		
		
	}
}