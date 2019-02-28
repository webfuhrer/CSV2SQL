package paqueteclima;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class AccesoBD {
	static Connection c;
	static Statement stmt;
	private static void crearTabla()
	{
		String sql="CREATE TABLE IF NOT EXISTS contaminacion("
				+ "magnitud INTEGER,"
				+ "fecha VARCHAR(15),"
				+ "estacion INTEGER, "
				+
				datosHorarios()
				+ ")";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			c=DriverManager.getConnection("jdbc:mysql://localhost:3306/contaminacion", "root", "");
			stmt=c.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	
	}

	private static String datosHorarios() {
	//FLOAT (10, 4),,
		String aux="";
		for(int i=1; i<25; i++)
		{
			String nombre_etiqueta=(i<10)?"0"+i:String.valueOf(i);
			aux+="H"+nombre_etiqueta+" FLOAT (10, 4),";
		}
		aux=aux.substring(0, aux.length()-1);
		return aux;
	}
	public static void grabarDatos(ArrayList<DatoHorario> datos)
	{
		crearTabla();
		for (DatoHorario datoHorario : datos) {
			
			String sql_insert="INSERT INTO contaminacion VALUES("+datoHorario.getMagnitud()
			+", '"+datoHorario.getFecha()+"', "+datoHorario.getEstacion()+", "+datosCantidades(datoHorario.getCantidades())+")";
			try {
				stmt.executeUpdate(sql_insert);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	private static String datosCantidades(ArrayList<Float> cantidades) {
		String aux="";
		for (Float float1 : cantidades) {
			aux+=float1+",";
		}
		aux=aux.substring(0, aux.length()-1);
		return aux;
	}
}
