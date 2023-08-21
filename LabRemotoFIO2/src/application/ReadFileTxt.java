package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class ReadFileTxt {
	
	//Atributos
	private String fileName;
	private ArrayList<String> datosXY= new ArrayList<String>();
	
	
	public void readFile(String fileName) throws Exception {

		File file = new File(fileName);
	    BufferedReader reader = null;
	    reader = new BufferedReader(new FileReader(file));
	    String text = null;

	    // repeat until all lines is read
	    while ((text = reader.readLine()) != null) {
	      datosXY.add(text);
	    }
	    reader.close();
	  }
	
	//get and Set
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	public String getFileName() {
		return fileName;
	}
	public ArrayList<String> getDatosXY() {
		return datosXY;
	}

	}