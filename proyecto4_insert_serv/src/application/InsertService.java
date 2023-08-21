package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class InsertService {

		//conexión
		Conexion conexion = new Conexion();
		Connection cn = null;
		// consultas del tipo select
		Statement stm = null;
		ResultSet rs = null;
		// insert
		PreparedStatement ps;
		private String usuarioName;
		private String usuarioClave;

		public void conecta() {
		try {
			cn = conexion.conectar();
			
			// Insert
			ps = cn.prepareStatement("INSERT INTO usuario(idusuario,usuario_name,usuario_clave) VALUES (default,?,?)");
			ps.setString(1,usuarioName);
			ps.setString(2,usuarioClave);
			ps.executeUpdate();
	        
			int retorno = ps.executeUpdate();
	        if(retorno>1) {
	        	System.out.println("insert correcto");  
	        }else
	        {
	        	System.out.println("Fallo el insert");
	        }
	        
	        //Consulta
			stm = cn.createStatement();
			rs = stm.executeQuery("SELECT * FROM usuario");
			
			while (rs.next()) {
				int idusuario = rs.getInt(1);
				String usuario_name = rs.getString(2);
				String usuario_clave = rs.getString(3);
				
				System.out.println(idusuario + " - " + usuario_name + " - " + usuario_clave);
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
		public void set_usuarioName(String cargar_usuario_name) {
			this.usuarioName=cargar_usuario_name;
		}
		public void set_usuarioClave(String cargar_usuario_clave) {
			this.usuarioClave=cargar_usuario_clave;
		}
}
