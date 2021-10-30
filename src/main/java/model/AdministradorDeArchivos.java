package model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dao.AtraccionDAO;
import dao.DAOFactory;
import dao.PromocionDAO;
import dao.UsuarioDAO;

public class AdministradorDeArchivos {
	public static void main(String[] args) {

	}

	public static List<Usuario> leerUsuarios() {
		UsuarioDAO usuarioDAO = DAOFactory.getUsuarioDAO();
		return usuarioDAO.findAll();
	}


	public static List<Atraccion> leerAtracciones() {
		AtraccionDAO atraccionDAO = DAOFactory.getAtraccionDAO();
		return atraccionDAO.findAll();
	}

	
	public static List<Promocion> leerPromociones(List<Atraccion> atracciones) {
		PromocionDAO promocionDAO = DAOFactory.getPromocionDAO();
		return promocionDAO.findAll(atracciones);
		
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
