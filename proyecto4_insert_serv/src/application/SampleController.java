package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class SampleController {

    @FXML
    private Button btn_insert;

    @FXML
    private TextField tf_clave_usuario;

    @FXML
    private TextField tf_nombre_usuario;

    @FXML
    void action_btn_insert(ActionEvent event) {
    	// ojo primero tenemos que hacer la instancia
    	InsertService myInsertService=new InsertService();
    	// luego cargar los datos
    	myInsertService.set_usuarioName(tf_nombre_usuario.getText());
    	myInsertService.set_usuarioClave(tf_clave_usuario.getText());
    	// por último hacemos la carga en la BD
    	myInsertService.conecta();	
    }
}
