package paqueteclima;

import java.util.ArrayList;

public class CreaHTML {
int a=9;
	public static String pintarTabla(ArrayList<DatoHorario> datos) {
		
		
		String tabla="<table><tr><th>Estacion</th><th>Magnitud</th><th>Fecha</th>"+horas()+"</tr>";
		// TODO Auto-generated method stub
		for (DatoHorario datoHorario : datos) {
			tabla+="<tr><td>"+datoHorario.getEstacion()+"</td><td>"+datoHorario.getMagnitud()+
					"</td><td>"+datoHorario.getFecha()+"</td><td>"+datos(datoHorario.getCantidades())+"</tr>";
		}
		tabla+="</table>";
		return tabla;
	}
	private static String datos(ArrayList<Float> cantidades) {
		String aux="";
		for (Float float1 : cantidades) {
			aux+="<td>"+float1+"</td>";
		}
		return aux;
	}
	private static String horas()
	{String aux="";
		for(int i=0; i<23; i++)
		{
			aux+="<th>"+i+"-"+(i+1)+"</th>";
		}
		return aux;
	}
}
