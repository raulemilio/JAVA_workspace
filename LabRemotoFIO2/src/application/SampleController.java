package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;

public class SampleController implements Initializable{

    XYChart.Series<Number, Number> series = new XYChart.Series<>();
    private String mensajeInicioEnsayo="Configure los parámetros del ensayo y presione Iniciar...";
    private int tiempoRegistro=800;// milisegundos
    
    @FXML
    private Slider spinerBar;
//    @FXML
//    private TextField intensidadPorcentual;// para ver el valor de intensidad mientras avanza
    
    @FXML
    private LineChart<Number, Number> lineChart;
    @FXML
    private NumberAxis x;
    @FXML
    private NumberAxis y;
    //@FXML
    //private ListView<String> listViewY;
    //@FXML
    //private ListView<String> listViewX;
    
    @FXML
    private MenuButton setRanuraAlambre;
    @FXML
    private MenuButton setLaserColor;
    @FXML
    private Button sabeData;
    @FXML
    private Button btn_start;
    @FXML
    //private Label mensajeUsuario;
    //@FXML
    private TextField pathDatos;

    
    @Override
    public void initialize(URL location, ResourceBundle rb) {
    	lineChart.getData().add(series); 
    	//mensajeUsuario.setText(mensajeInicioEnsayo);
    	//defining a series to display data
        //series.setName("Data Series");
        // add series to chart
    }
  
    @FXML
    void experimetStart(ActionEvent event){

        Service<Long> service=new Service<Long>() {

    		@Override
    		protected  Task<Long> createTask() {
    			// TODO Auto-generated method stub
    			return new Task<Long>() {
					Integer datoXint;
					Integer datoYint;
			    	String datoX;
					String datoY;
					@Override
					protected Long call() throws Exception {
						// TODO Auto-generated method stub
				    	// estas variables deben ser cargadas acá para que todo funcione

						// cambio los estados de los botones del experimento
						
						sabeData.setDisable(true);
						setRanuraAlambre.setDisable(true);
						setLaserColor.setDisable(true);
						btn_start.setDisable(true);
			    		// esta variable es para almacenar los datos del archivo
			    		ArrayList<String> datosXY= new ArrayList<String>();
			        	String pathFile=pathDatos.getText();
			    		ReadFileTxt file=new ReadFileTxt();
				    	file.readFile(pathFile);					
				    	datosXY=file.getDatosXY();
						//System.out.println(datosXY);// muestro el array de datos
						int WINDOW_SIZE = datosXY.size();// cantidad de datos para el rango de datos


						String datoIndex;		
						int indexDatoXX=0;
						int indexComa=0;
						
						for(indexDatoXX=0;indexDatoXX<datosXY.size();indexDatoXX++){
			                
							// se saca el dato para luego separar en X e Y
							datoIndex=datosXY.get(indexDatoXX);
							indexComa=datoIndex.indexOf(",");
							
							datoX=datoIndex.substring(0, indexComa);
							datoXint=Integer.parseInt(datoX);
							//System.out.println(datoX);
							
							datoY=datoIndex.substring((indexComa+1), datoIndex.length());
							datoYint=Integer.parseInt(datoY);
							//System.out.println(datoY);

							//Estas lineas son sumamente importantes
							// se necesitan para que se pueda construir en tiempo real el gráfico
			                Platform.runLater(() -> {
			                	//
			    				//listViewX.getItems().add(datoY);
			    				//listViewY.getItems().add(datoX);
			                	//lineChart
			                	series.getData().add(new XYChart.Data<>(datoXint,datoYint));
//			                	Esto es para ir borrando datos del gráfico y no quede sobrecargado
//			                	if (series.getData().size() > WINDOW_SIZE)
//			                        series.getData().remove(0);
			                });

//			                //aquí se puede poner mensajes y estado de progreso
//			                updateProgress(indexDatoXX,100);
			                //updateMessage("Experimento en progreso... */Distancia recorrida: "+indexDatoXX+"mm");
			                updateMessage("Experimento en progreso...");
			                spinerBar.setValue(indexDatoXX);
			                //intensidadPorcentual.setText(datoY+"%");
			                // actualizo los estados de los botones del experimento
			                // es WINDOW_SIZE-1 porque arranca de cero
			                //System.out.println(indexDatoXX+"..."+WINDOW_SIZE);
			                if (indexDatoXX==(WINDOW_SIZE-1)) {
								sabeData.setDisable(false);
								setRanuraAlambre.setDisable(false);
								setLaserColor.setDisable(false);
								btn_start.setDisable(false);
								updateMessage(mensajeInicioEnsayo);
							}
			                
			                Thread.sleep(tiempoRegistro);
			            }
						return null;
					}
    			};		
    		}
        };
    	service.start();
    	//mensajeUsuario.textProperty().bind(service.messageProperty());
    }

	@FXML
    void saveData(ActionEvent event) {
    }
    
	@FXML
    void setLaserColor(ActionEvent event) {
    }
  
	@FXML
    void clearChartAction(ActionEvent event) {
    	series.getData().clear();
    }
}
