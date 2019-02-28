package paqueteclima;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.xml.sax.InputSource;


public class Parseador {

	public static ArrayList<DatoHorario> parsear(String xml_contaminacion) {
		
		ArrayList<DatoHorario> lista=new ArrayList();
		SAXBuilder constructor=new SAXBuilder();
		try {
			InputSource entrada = new InputSource(new ByteArrayInputStream(xml_contaminacion.getBytes("utf-8")));
			//Document documento_xml=constructor.build(new File("D:\\XML\\xml.xml"));
			Document documento_xml=constructor.build(entrada);
			Element raiz=documento_xml.getRootElement();//Datos
			List<Element> datos_horarios=raiz.getChildren();//¿Porqué no vale si pongo el nombre de Dato_Horario?
			
			for (Element element : datos_horarios) {
				List<Element> elementos=element.getChildren();
				for (Element element2 : elementos) {
					String nombre=element2.getName();
				}
				Element elemento_estacion=element.getChild("estacion");
				int estacion=Integer.parseInt(elemento_estacion.getValue());
				Element elemento_magnitud=element.getChild("magnitud");
				int magnitud=Integer.parseInt(elemento_magnitud.getValue());
				Element elemento_dia=element.getChild("dia");
				Element elemento_mes=element.getChild("mes");
				Element elemento_ano=element.getChild("ano");
				String fecha=elemento_dia.getValue()+"/"+elemento_mes.getValue()+"/"+elemento_ano.getValue();
				ArrayList<Float> cantidades=sacarCantidades(element);
				DatoHorario d=new DatoHorario(magnitud, fecha, estacion, cantidades);
				lista.add(d);
			}
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JDOMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lista;
	}

	private static ArrayList<Float> sacarCantidades(Element element) {
		ArrayList<Float> lista_cantidades=new ArrayList<>();
		for (int i=1; i<25;i++)
		{
			String nombre_etiqueta="";
			nombre_etiqueta=(i<10)?"0"+i:String.valueOf(i);
			//IF(condicion;si_se_cumple;si_no__se_cumple)
			Element elemento_horario=element.getChild("H"+nombre_etiqueta);
			float a=Float.parseFloat(elemento_horario.getValue());
			lista_cantidades.add(a);
		}
		return lista_cantidades;
	}

}
