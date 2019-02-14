package paquetenotas;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class AccesoFichero {
private static String ruta="alumnos.csv";
private static String separador=",";
	public static ArrayList<Alumno> recuperarAlumnos()  {
		// TODO Auto-generated method stub
		ArrayList<Alumno> lista_alumnos=new ArrayList();
		try {
			String linea="";
			FileReader fr=new FileReader(ruta);
			BufferedReader br=new BufferedReader(fr);
			linea=br.readLine();
			while(linea!=null)
			{
				String[] campos=linea.split(separador);
				String nombre=campos[0];
				float nota=Float.parseFloat(campos[1]);
				int asignatura=Integer.parseInt(campos[2]);
				Alumno a=new Alumno(nombre, nota, asignatura);
				lista_alumnos.add(a);
				linea=br.readLine();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return lista_alumnos;
	}
	public static void grabarAlumnos(ArrayList<Alumno> lista_alumnos) {
		try {
			FileWriter fw=new FileWriter(ruta);
			for (Alumno alumno : lista_alumnos) {
				String aux=alumno.getNombre()+separador+alumno.getNota()+separador+alumno.getAsignatura();
				fw.write(aux);
				fw.write("\n");
			}
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
