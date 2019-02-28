package paquetecsv;

import java.util.ArrayList;

public class ClasePrincipal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Contacto> lista_contactos=AccesoFichero.leerContactos();
		AccesoFichero.crearSQL(lista_contactos);
		
		System.out.println(lista_contactos);
	}

}
