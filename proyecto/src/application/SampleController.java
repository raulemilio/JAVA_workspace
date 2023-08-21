package application;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
//import mySQL.Conexion;
import javafx.scene.control.ListView;

public class SampleController {

    @FXML
    private Button btn;

    @FXML
    private Label lb;
    @FXML
    private Label lb2;
    
    @FXML
    private ListView<String> lista;
    
    
    
    @FXML
    void action_btn(ActionEvent event){
    	// creamos un servicio
    	ServicioConsultaBD myServicio=new ServicioConsultaBD();
    	// hacemos la consulta
    	myServicio.getDatosDB();
    	
    	// cargamos el nombre del último usuario en una etiqueta
    	String nombreConsulta=myServicio.getNombre();
    	lb.setText(nombreConsulta);
    	
    	// cargar en un ListView la lista de usuario
    	List<String> listaDesdeServicio=myServicio.getListaNombre();
    	
    	for(int i=0;i<listaDesdeServicio.size();i++) {
    		String usuario_i=listaDesdeServicio.get(i);
    		lista.getItems().add(usuario_i);
    	}
    	
    	
    }

}
    

