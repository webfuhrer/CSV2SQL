package paqueteservletagenda;

import java.util.ArrayList;

public class AccesoBD {
public static void insertarContacto(Contacto c)
		{
	
		}
public static ArrayList<Contacto> devolverContactos()
	{
		Contacto c1=new Contacto("Pepe", "956656457");
		Contacto c2=new Contacto("Ana", "916544578");
		Contacto c3=new Contacto("Teresa", "655569874");
		ArrayList<Contacto> lista=new ArrayList<>();
		lista.add(c1);
		lista.add(c2);
		lista.add(c3);
		return lista;
	}
}
