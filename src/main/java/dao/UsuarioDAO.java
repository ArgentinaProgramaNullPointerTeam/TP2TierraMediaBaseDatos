package dao;

import java.util.List;

import model.Usuario;

public interface UsuarioDAO extends GenericDAO<Usuario>{
	public List<Usuario> findAll();
		
}
