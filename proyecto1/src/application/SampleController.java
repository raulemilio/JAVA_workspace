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
import javafx.scene.control.ListView;
//import mySQL.Conexion;

public class SampleController {

    @FXML
    private Button btn;

    @FXML
    private Label lb;
    @FXML
    private Label lb2;
    
    @FXML
    private ListView<String> lista;
    
    List<String> lista2 = new ArrayList<>();
    
    @FXML
    void action_btn(ActionEvent event){
    	ServicioConsultaBD myServicio=new ServicioConsultaBD();
    	myServicio.getDatosDB();
    	String nombreConsulta=myServicio.getNombre();
    	lb.setText(nombreConsulta);
    }

}
    

