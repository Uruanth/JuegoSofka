package retoSofka.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import retoSofka.driver.IngresoBaseData;

public class UsuarioDAO {
	
	//Crear usuario en la Base de datos 
	public void cear(UsuarioDTO udto) {
		String query = "INSERT INTO usuarios (id, nombre, username, email) VALUES (?,?,?,?)";
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con=IngresoBaseData.getConexion();
			ps=con.prepareStatement(query);
			ps.setInt(1, udto.getId());
			ps.setString(2, udto.getNombre());
			ps.setString(3, udto.getUsername());
			ps.setString(4, udto.getEmail());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			try {
				IngresoBaseData.close(ps);
				IngresoBaseData.close(con);
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	//Leer usuario por su Id
	public UsuarioDTO leerById(UsuarioDTO udto) {
		String query = "SELECT * FROM usuarios WHERE id=?";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = IngresoBaseData.getConexion();
			ps = con.prepareStatement(query);
			ps.setInt(1, udto.getId());
			rs=ps.executeQuery();
			rs.next();
			try {
				
				udto.setNombre(rs.getString("nombre"));
				udto.setUsername(rs.getString("username"));
				udto.setEmail(rs.getString("email"));
			} catch (Exception e) {
				udto = null;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			try {
				IngresoBaseData.close(rs);
				IngresoBaseData.close(ps);
				IngresoBaseData.close(con);
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return udto;
	}

	
	//Leer usuario por estado
	public int leerByEstado(int a) {
		String query = "SELECT id FROM usuarios WHERE activ=?";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int a2=0;
		try {
			con = IngresoBaseData.getConexion();
			ps = con.prepareStatement(query);
			ps.setInt(1, a);
			rs=ps.executeQuery();
			rs.next();
			try {
				
				a2=rs.getInt(1);
			} catch (Exception e) {
				System.out.println("error rs");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("error consulta");
			
		} finally {
			try {
				IngresoBaseData.close(rs);
				IngresoBaseData.close(ps);
				IngresoBaseData.close(con);
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return a2;
	}
	
	
	//Actualizar estado de usuario
	public void cambiarEstado(int id, int act) {
		String query="UPDATE usuarios SET activ=? WHERE id=?";
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = IngresoBaseData.getConexion();
			ps = con.prepareStatement(query);
			ps.setInt(1, act);
			ps.setInt(2, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			try {
				IngresoBaseData.close(ps);
				IngresoBaseData.close(con);
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
