package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;

public class Servicio_lista_desc_proc {
	
	Conexion conexion = new Conexion();
	Connection cn = null;
	Statement stm = null;
	ResultSet rs = null;

	List<String> lista_desc_prod = new ArrayList<>();
	
	public void conectar() {
	try {
		cn = conexion.conectar();
		stm = cn.createStatement();
		rs = stm.executeQuery("SELECT descripcion_producto FROM mydbKiosco.producto");
		//System.out.println(rs);
		
		while (rs.next()) {
			String desc_prod=rs.getString(1);
			lista_desc_prod.add(desc_prod);
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
    public List<String> get_lista_desc_prod() {
    	return lista_desc_prod;
    }
}

