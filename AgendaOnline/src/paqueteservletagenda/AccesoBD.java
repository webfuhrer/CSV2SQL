package paqueteservletagenda;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AccesoBD {
	static void insertarContacto(Contacto c) {
        //crearTabla();
    
       try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
            Connection conexion=null;
			try {
				//"jdbc:mysql://localhost:3306/bd_agenda";
				conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/agenda?serverTimezone=UTC", "root", "");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            Statement stmt=null;
			try {
				stmt = conexion.createStatement();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            String query="INSERT INTO agenda VALUES('"+c.getNombre()+"', '"+c.getTelefono()+"')";
            
            try {
				stmt.executeUpdate(query);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            try {
				stmt.close();
				conexion.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
        
    }

    static ArrayList<Contacto> listarContactos() {
        ArrayList<Contacto> lista_contactos=new ArrayList();
       
        try {
    		Class.forName("com.mysql.jdbc.Driver");
    	} catch (ClassNotFoundException e1) {
    		// TODO Auto-generated catch block
    		e1.printStackTrace();
    	}
        
            //Si nombre buscado está vacío realmente hay que ñistar todos
           
            try {
            	Connection conexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/agenda?serverTimezone=UTC", "root", "");
                Statement stmt=conexion.createStatement();
                String query ="SELECT * FROM agenda ";
             
                
                ResultSet rs=stmt.executeQuery(query);
                while(rs.next())
                {
                    String nombre=rs.getString("nombre");
                    String telefono=rs.getString("telefono");
                    
                    Contacto c=new Contacto(nombre, telefono);
                    lista_contactos.add(c);
                }
            } catch (SQLException ex) {
                Logger.getLogger(AccesoBD.class.getName()).log(Level.SEVERE, null, ex);
            }
            return lista_contactos;
    }
}
