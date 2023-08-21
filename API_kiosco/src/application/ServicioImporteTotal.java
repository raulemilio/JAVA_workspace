package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ServicioImporteTotal {
	
	//Atributos
	private int importeTotal;
	Conexion conexion = new Conexion();
	Connection cn = null;
	Statement stm = null;
	ResultSet rs = null;
	
	//Constructor
	void ServicioImporteTotal() {
		//vacio
	}

	//Servicios -get y set
	public int getImporteTotal() {
		return importeTotal;
	}
	
	void conectarDB() {
	try {
		cn = conexion.conectar();
		stm = cn.createStatement();
		rs = stm.executeQuery("SELECT SUM(importe_venta) FROM mydbKiosco.venta");
				
			while (rs.next()) {
				importeTotal= rs.getInt(1);
				System.out.println("el importe total es"+importeTotal);
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

}
