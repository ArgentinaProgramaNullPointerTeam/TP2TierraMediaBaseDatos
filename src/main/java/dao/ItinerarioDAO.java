package dao;

import model.Itinerario;

public interface ItinerarioDAO extends GenericDAO<Itinerario> {

	public abstract Itinerario findById(int id);
}
