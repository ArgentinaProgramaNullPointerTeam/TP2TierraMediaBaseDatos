package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;
import jdbc.ConnectionProvider;
import model.Atraccion;
import model.Promocion;

public class PromocionDAOImpl implements PromocionDAO {

	public List<Promocion> findAll(List<Atraccion> atracciones) {
		try {
			String sql = "SELECT * FROM 'promocion'";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultados = statement.executeQuery();

			List<Promocion> promociones = new LinkedList<Promocion>();
			while (resultados.next()) {
				promociones.add(toPromocion(resultados, atracciones));
			}
			return promociones;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	public int update(Promocion promocion) {
		int rows = 0;
		
		return rows;
	}

	private Promocion toPromocion(ResultSet resultados, List<Atraccion> atracciones) {
		try {
			List<Atraccion> atraccionesEnPromo = new LinkedList<Atraccion>();
			int[] idAtracciones = new int[] { resultados.getInt(8), resultados.getInt(9), resultados.getInt(10) };
			int cantAtracciones = 0;
			for (int i = 0; i < idAtracciones.length; i++)
				for (Atraccion atraccion : atracciones) {
					if (atraccion.getId() == (idAtracciones[i])) {
						atraccionesEnPromo.add(atraccion);
						cantAtracciones++;
					}
				}
			if (atraccionesEnPromo.isEmpty()) {
				throw new Error("La atracción no está en el listado de atracciones");
			}
            
			model.Promocion promocion = null; 
			if(resultados.getString(3).equals("Porcentual")) {
				promocion= new model.PromocionPorcentual(resultados.getInt(1), resultados.getString(2), cantAtracciones, atraccionesEnPromo,
						resultados.getString(3), resultados.getDouble(5));
			}else if(resultados.getString(3).equals("Absoluta")) {
				promocion= new  model.PromocionAbsoluta(resultados.getInt(1), resultados.getString(2), cantAtracciones, atraccionesEnPromo,
						resultados.getString(3), resultados.getInt(4));
			}else if(resultados.getString(3).equals("AXB")){
				promocion= new  model.PromocionAXB(resultados.getInt(1), resultados.getString(2), cantAtracciones, atraccionesEnPromo,
						resultados.getString(3), resultados.getInt(6));
			}
			return promocion;
			
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

}
