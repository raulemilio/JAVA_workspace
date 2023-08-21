package application;
import java.util.ArrayList;
import java.util.List;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.input.MouseEvent;

public class SampleController {

    @FXML
    private Button btn;

    @FXML
    private Label lb;
    @FXML
    private Label lb2;
    private Button BUTTON;
    
    @FXML
    private ListView<String> lista;
    
    List<String> lista2 = new ArrayList<>();
   
    @FXML
    void action_btn(ActionEvent event){
    	servicio serv=new servicio();
    	serv.conectar();
    	lista2=serv.getNombre();
    	for(int i=0;i<lista2.size();i++) {
        	String dato=lista2.get(i);
        	System.out.println("un dato"+dato);
        	lista.getItems().add(dato);
        	lb2.setText(dato);
    	}
    }
    
    //ejemplo de observables
    @FXML
    void action_select(MouseEvent event) {	 
    	//Listado de index
    	 ObservableList selectedIndices = lista.getSelectionModel().getSelectedIndices();
    	 lista.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE); // múltiples lineas
         for(Object o : selectedIndices){
             System.out.println(o);
         }
         //Busqueda por contenido
         String selectedIndices2 = lista.getSelectionModel().getSelectedItem();
         System.out.println(selectedIndices2);
    }
    
    @FXML
    void ACTION_BUTTON(ActionEvent event) {

    }
}
