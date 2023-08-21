package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ServicioConsultaBD {
    // variables/atributos para el manejo de la BD
	Conexion conexion = new Conexion();
	Connection cn = null;
	Statement stm = null;
	ResultSet rs = null;
	// variables/atributos de la clase
	private String nombre;
	
	private List<String> listaBD= new ArrayList<>();
	
	// Constructor
	public ServicioConsultaBD() {
		//Constructor vacio
	}
	
	// Interfaz
	public void getDatosDB() {
		try {
			cn = conexion.conectar();
			stm = cn.createStatement();
			rs = stm.executeQuery("SELECT * FROM usuarios");
			
			while (rs.next()) {
				int idUsuarios = rs.getInt(1);
				this.nombre=rs.getString(2);
				listaBD.add(nombre);
				String clave = rs.getString(3);
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
	// Servicios de interfaz
	public String getNombre() {
		return this.nombre;
	}
	
	public List<String> getListaNombre(){
		return this.listaBD;
	}
}
	

