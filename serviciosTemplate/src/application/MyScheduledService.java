package application;

import javafx.concurrent.ScheduledService;
import javafx.concurrent.Task;

public class MyScheduledService extends ScheduledService<String>{

	@Override
	protected Task<String> createTask() {
		// TODO Auto-generated method stub
		return new Task<String>() {

			@Override
			protected String call() throws Exception {
                
				System.out.println("Empezó servicio cíclico");
				String mensaje="Saludamos desde servicio cíclico";
				Thread.sleep(1000);// simulamos que el servicio realiza alguna tarea que se demora 1 segundo
				System.out.println("Terminó servicio cíclico");
				return mensaje;
			}
		};
	}
}
