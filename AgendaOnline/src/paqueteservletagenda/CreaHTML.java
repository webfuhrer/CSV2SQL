package paqueteservletagenda;

import java.util.ArrayList;

public class CreaHTML {
public static String crearTabla(ArrayList<Contacto> lista)
		{
			String aux="<table>";
			for (Contacto contacto : lista) {
				aux=aux+"<tr><td>"+contacto.getNombre()+"</td><td>"+contacto.getTelefono()+"</td></tr>";
			}
			//aux=aux+"</table>";
			aux+="<table>";
			return aux;
		}
}
