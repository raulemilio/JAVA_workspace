package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.util.Duration;


public class SampleController implements Initializable{
    
    // Botores, etiquetas, progressBar, etc...
    @FXML
    private Label label;
    @FXML
    private Label labelServicio;
    @FXML
    private Button startScheduledService;
    @FXML
    private Label labelScheduledService;
    @FXML
    private ProgressBar progressBar;
    @FXML
    private Button btn;
    @FXML
    private Button startService;
    @FXML
    private LineChart<Number, Number> myChart;
    @FXML
    private TableView<Number> myTable;
    @FXML
    private TableColumn<String,Number> Colum1;
    @FXML
    private TableColumn<String,Number> Colum2;
    
	String datos= "";
    XYChart.Series<Number, Number> series = new XYChart.Series<>();
 
    
    // Inicializamos el gráfico de series temporales
    public void initialize(URL location, ResourceBundle rb) {
    	//defining a series to display data
        series.setName("Data Series");// le ponemos un nombre al gráfico
        // add series to chart
        myChart.getData().add(series); // agregamos los datos al gráfico
    }
    
    // Ejemplo de progress bar
    @FXML
    void accion(ActionEvent event) {
    	progressBar.progressProperty().bind(task.progressProperty());  
        label.textProperty().bind(task.messageProperty());
        datos=label.getText();
        th.setDaemon(true);
        th.start();
    }
    
    // servicio de única ejecución
    @FXML
    void startServiceAction(ActionEvent event) {
    	MyService service=new MyService();
    	service.start();
    	service.setOnSucceeded(disparo->{
    		labelServicio.setText(service.getValue());
    		//service.restart();// una forma de hacer cíclico el servicio
    	});
    }
    
    // servicio repetitivo
    @FXML
    void startScheduledServiceAction(ActionEvent event) {
    	MyScheduledService myScheduledService=new MyScheduledService();
    	myScheduledService.start();
    	
    	myScheduledService.setOnSucceeded(disparoScheduled ->{
    		labelScheduledService.setText(myScheduledService.getValue());
    	});
    	myScheduledService.setPeriod(Duration.seconds(5));	
    }
    
    // única taera
    Task<Long> task = new Task<Long>() {
    	long dato=0;
    	long i=0;
    	final int WINDOW_SIZE = 10;
    	@Override protected Long call() throws Exception {
            
            for (i = 0; i < 100; i++){
            	// Update the chart
            	Platform.runLater(() -> {   
                	series.getData().add(new XYChart.Data<>(dato,i));
                	if (series.getData().size() > WINDOW_SIZE)
                        series.getData().remove(0);
                });
                dato=dato+1;// simulamos algún proceso con datos
            	updateProgress(i,100);// agrega al progressBar el valor de i
                updateMessage("iteracion "+i);// mensaje que da la función task
                updateValue(dato);
                Thread.sleep(1000);// retardo de tiempo
            }
            return dato;
        }
    };
    Thread th = new Thread(task); // Se crea la tarea (recordar  )
}