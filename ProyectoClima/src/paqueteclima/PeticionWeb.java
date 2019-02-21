package paqueteclima;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class PeticionWeb {

	public static String pedirWeb(String direccion_web) {
		// TODO Auto-generated method stub
		String aux="";
		try {
			URL url=new URL(direccion_web);
			URLConnection conexion_web=url.openConnection();
			BufferedReader lector=new BufferedReader(new InputStreamReader(conexion_web.getInputStream()));
			String linea=lector.readLine();
			while(linea!=null)
			{
				aux+=linea;
				linea=lector.readLine();
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		aux=aux.replace("xmlns=\"http://bdca\"", "");
		return aux;
	}

}
