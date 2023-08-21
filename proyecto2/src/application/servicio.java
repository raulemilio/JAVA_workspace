package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;

public class servicio {
	
	Conexion conexion = new Conexion();
	Connection cn = null;
	Statement stm = null;
	ResultSet rs = null;
	
	List<String> lista = new ArrayList<>();
	
	public void conectar() {
	try {
		cn = conexion.conectar();
		stm = cn.createStatement();
		rs = stm.executeQuery("SELECT * FROM usuarios");
		
		while (rs.next()) {
			int idUsuarios = rs.getInt(1);
			String nombre=rs.getString(2);
			String clave = rs.getString(3);
			lista.add(nombre);
			System.out.println("dfgdfgdfgd");
			System.out.println(nombre);
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
		
	} finally {
		try {
			if (rs!= null) {
				rs.close();
			}
			
			if (stm != null) {
				stm.close();
			}
			
			if (cn != null) {
				cn.close();
			}
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}
	
	}
    public List<String> getNombre() {
    	return lista;
    }
}
