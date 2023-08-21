package application;

import javafx.concurrent.Service;
import javafx.concurrent.Task;

public class MyService extends Service<String>{

	@Override
	protected Task<String> createTask() {
		// TODO Auto-generated method stub
		return new Task<String>() {

			@Override
			protected String call() throws Exception {
				System.out.println("Comienza de tarea desde servicio de ejecución única");
				String sendMensaje="estamos en el servicio de ejecución única";
				Thread.sleep(5000); // simulamos que el servicio realiza alguna tarea que demora 1 segundo
				System.out.println("Termina la tarea desde servicio de ejecución única");
				return sendMensaje;
			}
		};
	}

}
