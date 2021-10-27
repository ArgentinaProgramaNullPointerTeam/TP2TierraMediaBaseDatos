package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import jdbc.ConnectionProvider;
import model.Usuario;

public class UsuarioDAOImpl implements UsuarioDAO {

	public List<Usuario> findAll() {
		try {
			String sql = "SELECT * FROM 'usuario'";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultados = statement.executeQuery();

			List<Usuario> usuarios = new LinkedList<Usuario>();
			while (resultados.next()) {
				usuarios.add(toUsuario(resultados));
			}

			return usuarios;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}
	public int update(Usuario usuario) {
		String sql = "UPDATE usuario SET dinero_disp = ?, tiempo_disp = ? WHERE id = ?";
		int filasModificadas = 0;

		try {
			Connection conexion = ConnectionProvider.getConnection();
			PreparedStatement declaracion = conexion.prepareStatement(sql);

			declaracion.setInt(1, usuario.getDineroDisponible());
			declaracion.setDouble(2, usuario.getTiempoDisponible());
			declaracion.setInt(3, usuario.getId());

			filasModificadas = declaracion.executeUpdate();
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
		return filasModificadas;
	}
	private Usuario toUsuario(ResultSet resultados) {
		try {
			return new Usuario(resultados.getInt(1), resultados.getString(2), resultados.getString(5), resultados.getInt(3), resultados.getDouble(4));			
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}
}
