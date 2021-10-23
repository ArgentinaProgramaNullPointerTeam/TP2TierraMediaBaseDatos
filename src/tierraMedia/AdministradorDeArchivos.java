package tierraMedia;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdministradorDeArchivos {
	public static void main(String[] args) {

	}

	public static List<Usuario> leerUsuarios() {
		File f = new File("./archivosDeEntrada/usuarios.txt"); // creo el archivo con la ruta
		Scanner sc; // abro el scanner
		List<Usuario> usuarios = new ArrayList<Usuario>(); // creo el arraylist
		String[] line; // aca guardo linea spliteada

		try {
			sc = new Scanner(f); // abrir el archivo con el scanner

			while (sc.hasNext()) {
				line = sc.nextLine().split("-"); // SEPARA LOS ATRIBUTOS - el split cada vez que encuentra un guion,
													// devuelve un array
				usuarios.add(new Usuario(line[0], // nombre de usuario nose parsea
						TipoAtraccion.valueOf(line[1]), // parseo el enum tipo de atraccion para q lo pase a string
						Integer.parseInt(line[2]), // presupuesto
						Double.parseDouble(line[3])) // tiempo
				);

				line = null; // no dejar basura en line
			}

			sc.close();// cierro el scaner

			// Tiramos este catch cuando no encuentra el archivo
		} catch (FileNotFoundException e1) {
			System.err.println(e1.getMessage());
		} catch (NumberFormatException e2) {
			System.err.println(e2.getMessage());
		}
		return usuarios;
	}

//LEER ARCHIVO DE ATRACCIONES

	public static List<Atraccion> leerAtracciones() {
		File f = new File("./archivosDeEntrada/atracciones.txt"); // creo el archivo con la ruta
		Scanner sc; // abro el scanner
		List<Atraccion> atracciones = new ArrayList<Atraccion>();
		String[] line; // aca guardo linea spliteada

		try {
			sc = new Scanner(f); // abrir el archivo con el scanner

			while (sc.hasNext()) {
				line = sc.nextLine().split("-"); // SEPARA LOS ATRIBUTOS - el split cada vez que encuentra un guion,
													// devuelve un array

				atracciones.add(new Atraccion(line[0], // primer atraccion ya string
						Integer.parseInt(line[1]), // convierta en entero precio
						Double.parseDouble(line[2]), // convierta en double las horas
						Integer.parseInt(line[3]), // entero para cupos
						TipoAtraccion.valueOf(line[4]) // parseo el enum tipo de atraccion para q lo pase a string desde
														// el enum

				));

				line = null;
			}

			sc.close();

			// Tiramos este catch cuando no encuentra el archivo
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
		} catch (NumberFormatException e) {
			System.err.println(e.getMessage());
		}

		return atracciones;
	}

	@SuppressWarnings("resource")
	public static List<Promocion> leerPromociones(List<Atraccion> atracciones) {
		File f = new File("./archivosDeEntrada/promociones.txt");
		Scanner sc;
		List<Promocion> promociones = new ArrayList<Promocion>();
		String[] line;

		try {
			sc = new Scanner(f);

			while (sc.hasNext()) {
				line = sc.nextLine().split("-"); // SEPARA LOS ATRIBUTOS - el split cada vez que encuentra un guion,
													// devuelve un array

				List<Atraccion> atraccionesEnPromo = new ArrayList<Atraccion>();
				int cantAtracciones = 0;
				for (int i = 4; i < line.length - 1; i++) {
					for (Atraccion atraccion : atracciones) {
						if (atraccion.getNombre().equals(line[i])) {
							atraccionesEnPromo.add(atraccion);
						}
					}if(atraccionesEnPromo.isEmpty()) {
						throw new Error("La atracción no está en el listado de atracciones");
					}

				}
				for (Atraccion atraccion : atracciones) {
					if (atraccion.getNombre().equals(line[6])) {
						atraccionesEnPromo.add(atraccion);
						cantAtracciones = Integer.parseInt(line[3]) + 1;
					} else {
						cantAtracciones = Integer.parseInt(line[3]);
					}
				}
				if(line[1].equals("Porcentual")) {
					Promocion promocionPorcentual = new PromocionPorcentual(line[0], cantAtracciones, atraccionesEnPromo, line[1], line[6]);
					promociones.add(promocionPorcentual);
				}else if(line[1].equals("Absoluta")) {
					Promocion promocionAbsoluta = new PromocionAbsoluta(line[0], cantAtracciones, atraccionesEnPromo, line[1], line[6]);
					promociones.add(promocionAbsoluta);
				}else if(line[1].equals("AXB")){
					Promocion promocionAXB = new PromocionAXB(line[0], cantAtracciones, atraccionesEnPromo, line[1], line[6]);
					promociones.add(promocionAXB);
				}
				

			}

			sc.close();

		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
		} catch (NumberFormatException e) {
			System.err.println(e.getMessage());
		}

		return promociones;
	}

	public static void guardarArchivo(ArrayList<String> datosAGuardar, String ruta) {
		PrintWriter salida = null;

		try {
			salida = new PrintWriter(new FileWriter("archivosDeSalida/" + ruta + ".txt"));

			for (String dato : datosAGuardar) {
				salida.print(dato);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (salida != null) {
					salida.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
