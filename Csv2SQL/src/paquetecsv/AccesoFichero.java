package paquetecsv;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class AccesoFichero {
private static String nombre_tabla="t_contactos";
	public static ArrayList<Contacto> leerContactos() {
		File fichero=new File("D:\\agenda.csv");
		ArrayList<Contacto> lista=new ArrayList();
		try {
			
			FileReader fr=new FileReader(fichero);
			BufferedReader br=new BufferedReader(fr);
			String linea=br.readLine();
			while(linea!=null)
			{
				
				//System.out.println(linea);
				//pepe,perez,42,pepe@mail.com
				String[] valores;
				valores=linea.split(",");
				// Contacto(String nombre, String email, String apellido, int edad) 
				Contacto c=new Contacto(valores[0], valores[3], valores[1], Integer.parseInt(valores[2]));
				lista.add(c);
				linea=br.readLine();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}

	public static void crearSQL(ArrayList<Contacto> lista_contactos) {
		String creacion="CREATE TABLE IF NOT EXISTS "+nombre_tabla+" (nombre VARCHAR(50), apellido VARCHAR(50),edad INTEGER, email VARCHAR(50));";
		File fichero_salida=new File("D:\\agenda.sql");
		FileWriter fw=null;
		try {
			fw = new FileWriter(fichero_salida, false);
			fw.write(creacion+"\n");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for (Contacto contacto : lista_contactos) {
			String linea_insert=crearInsert(contacto);
			try {
				fw.write(linea_insert+"\n");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		try {
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static String crearInsert(Contacto contacto) {
		//teresa,perez,42,tere@mail.com
		String insert="INSERT INTO "+nombre_tabla+" VALUES('"+contacto.getNombre()+"', '"+contacto.getApellido()+
				"', "+contacto.getEdad()+", '"+contacto.getEmail()+"');";
		
		//insert into t_contactos values(teresa, perez..contacto.)
		return insert;
	}

}
