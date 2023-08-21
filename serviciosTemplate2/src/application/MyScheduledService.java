package application;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javafx.concurrent.ScheduledService;
import javafx.concurrent.Task;

public class MyScheduledService extends ScheduledService<String>{

	@Override
	protected Task<String> createTask() {
		// TODO Auto-generated method stub
		return new Task<String>() {

			@Override
			protected String call() throws Exception {
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
				String mensaje=dtf.format(LocalDateTime.now());
				return mensaje;
			}
		};
	}
}
