package paquetenotas;

import java.io.IOException;
import java.util.ArrayList;

public class NotasAlumno {

	public static void main(String[] args) {
		int opcion=Consola.pedirOpciones();
		//Leer fichero
		ArrayList<Alumno> lista_alumnos=AccesoFichero.recuperarAlumnos();
		
		while(opcion!=3)
		{
				switch (opcion)
				{
				case 1:
					Alumno a=Consola.pedirDatosAlumno();
					lista_alumnos.add(a);
					//grabarlo
					break;
				case 2:
					Consola.listarAlumnos(lista_alumnos);
					break;
				case 4:
					//Exportar a MySQL
					DatosBD datos=Consola.pedirDatosBD();
					AccesoBD.insertarNotas(lista_alumnos, datos);
					System.out.println("Opcion4");
					break;
				}
			opcion=Consola.pedirOpciones();
		}
		AccesoFichero.grabarAlumnos(lista_alumnos);
	}

}
