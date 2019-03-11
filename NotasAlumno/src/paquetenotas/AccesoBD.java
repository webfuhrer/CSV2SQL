package paquetenotas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;



public class AccesoBD {
private static String nombre_tabla="t_calificaciones";
private static Connection conexion=null;
private static Statement stmt=null;
	private static void crearTabla(DatosBD datos) 
	{
		try {
			
			//Class.forName("com.mysql.jdbc.Driver");
			conexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/"+datos.getNombre_bd(), datos.getUsuario_bd(), datos.getPwd_bd());
			String sql="CREATE TABLE IF NOT EXISTS "+nombre_tabla+" (nombre VARCHAR(25), nota FLOAT(3,2), asignatura INTEGER)";
			stmt=conexion.createStatement();
			stmt.executeUpdate(sql);
			
			
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void insertarNotas(ArrayList<Alumno> lista_alumnos, DatosBD datos) throws SQLException {
		// TODO Auto-generated method stub
		crearTabla(datos);
		for (Alumno alumno : lista_alumnos) {			
			// insert into t_notas values('pepe', 8.9, 2)
			String sql="INSERT INTO "+nombre_tabla+" VALUES('"+alumno.getNombre()+"', "+alumno.getNota()+", "+alumno.getAsignatura()+");";
			stmt.executeUpdate(sql);
		}
	}
	
}