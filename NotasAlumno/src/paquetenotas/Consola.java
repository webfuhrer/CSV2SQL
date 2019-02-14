package paquetenotas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class Consola {
	
public static int pedirOpciones()
		{
			int respuesta=0;
			while(respuesta==0)
			{
					System.out.println("1-Insertar alumno");
					System.out.println("2-Listar alumnos");
					System.out.println("3-SALIR");
					System.out.println("4-Exportar a MySQL");
					Scanner sc=new Scanner(System.in);
					try {
							respuesta=sc.nextInt();
							if (respuesta <1 || respuesta>4)
							{respuesta=0;
							System.out.println("Por favor, escriba un número del 1 al 4");}
					}
					catch(InputMismatchException e)
					{
						System.out.println("Por favor, escriba un número");
					}
			}
			return respuesta;
		}

public static Alumno pedirDatosAlumno() {
	boolean nota_ok=false;//Verifica si ha metido un float
	float nota=0;
	Scanner sc=new Scanner(System.in);
	System.out.println("Escriba el nombre");
	String nombre=sc.nextLine();
	while(nota_ok==false)
	{
		System.out.println("escriba la nota");
		try {
		nota=sc.nextFloat();
		nota_ok=true;
		}catch(InputMismatchException e)
		{
			System.out.println("La nota es numérica");
			sc.nextLine();
		}
	}
	int asignatura=pedirAsignatura();
	Alumno a=new Alumno(nombre, nota, asignatura);
	return a;
	
}

private static int pedirAsignatura() {
	Scanner sc=new Scanner(System.in);
	int asignatura=0;
	while(asignatura==0)
	{
		System.out.println("Introduzca la asignatura");
		System.out.println("1-Matemáticas");
		System.out.println("2-Lengua");
		try {
		asignatura=sc.nextInt();
		if (asignatura<1 || asignatura>2)
			{
			asignatura=0;
				System.out.println("Le asignatura debe ser un número entre 1 y 2");
			}
		}
		catch(InputMismatchException e)
		{
			System.out.println("Por favor, introduzca un número");
			sc.nextLine();
		}
	}
	return asignatura;
	
}

public static void listarAlumnos(ArrayList<Alumno> lista_alumnos) {
	for (Alumno alumno : lista_alumnos) {
		System.out.println(alumno.getNombre()+"tuvo "+alumno.getNota()+
				" en "+devolverAsignaturaPorNumero(alumno.getAsignatura()));
	}
	
}
public static String devolverAsignaturaPorNumero(int numero)
	{
		Map<Integer, String> mapa=new HashMap<Integer, String>();
		mapa.put(1,"Matemáticas");
		mapa.put(2,"Lengua");
		String aux=mapa.get(numero);
		return aux;
	}
}
