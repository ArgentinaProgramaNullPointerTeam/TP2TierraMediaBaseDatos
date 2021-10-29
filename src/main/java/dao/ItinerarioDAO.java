package dao;

import java.awt.List;

import model.Itinerario;

public interface ItinerarioDAO extends GenericDAO<Itinerario> {

	public abstract int findById(int id);
	
	public abstract List insert();
}
