package mySQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
	public static void main(String[] args) {
		//conexión
		Conexion conexion = new Conexion();
		Connection cn = null;
		// consultas del tipo select
		Statement stm = null;
		ResultSet rs = null;
		// insert/delete/update
		PreparedStatement ps;
		
		try {
			cn = conexion.conectar();
			
			// Insert
			ps = cn.prepareStatement("INSERT INTO usuarios(idusuarios,nombre,clave) VALUES (default,?,?)");
			ps.setString(1,"usuarioX");
			ps.setString(2,"usrClaveX");
			ps.executeUpdate();
	        
			int retorno = ps.executeUpdate();
	        if(retorno>1) {
	        	System.out.println("insert correcto");  
	        }else
	        {
	        	System.out.println("Fallo el insert");
	        }
	        
	        //delete
	        String delete= "delete from usuarios where idUsuarios= ?";
	        ps = cn.prepareStatement(delete);
	        ps.setInt(1, 230);// borramos el usuario con id=230
	        ps.executeUpdate();
	        
	        //Consulta
			stm = cn.createStatement();
			rs = stm.executeQuery("SELECT * FROM usuarios");
			
			while (rs.next()) {
				int idUsuarios = rs.getInt(1);
				String usuario = rs.getString(2);
				String clave = rs.getString(3);
				
				System.out.println(idUsuarios + " - " + usuario + " - " + clave);
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