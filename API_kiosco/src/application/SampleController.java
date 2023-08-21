package application;

import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;

public class SampleController {

    @FXML
    private Button btn_importeTotal;

    @FXML
    private Label lb_importeTotal;
    
    @FXML
    private Button btn_lista_desc_proc;

    @FXML
    private ListView<String> list_descrp_prod;
   
    List<String> myLista_desc_prod = new ArrayList<>();

    @FXML
    void action_importeTotal(ActionEvent event) {
    	ServicioImporteTotal myServImporteTotal=new ServicioImporteTotal();
    	myServImporteTotal.conectarDB();
    	int ImporteTotal=myServImporteTotal.getImporteTotal();
    	lb_importeTotal.setText(Integer.toString(ImporteTotal));
    }
    
    @FXML
    void action_lista_desc_proc(ActionEvent event) {
    	Servicio_lista_desc_proc myServicio_lista_desc_proc=new Servicio_lista_desc_proc();
    	myServicio_lista_desc_proc.conectar();
    	myLista_desc_prod=myServicio_lista_desc_proc.get_lista_desc_prod();
       	
    	for(int i=0;i<myLista_desc_prod.size();i++) {
        	String descripcion_p=myLista_desc_prod.get(i);
        	list_descrp_prod.getItems().add(descripcion_p);
    	}
    	
    }
    

}