package dao;

import java.util.List;

import model.Atraccion;
import model.Promocion;

public interface PromocionDAO extends GenericDAO<Promocion> {

	public List<Promocion> findAll(List<Atraccion> atracciones);

}
