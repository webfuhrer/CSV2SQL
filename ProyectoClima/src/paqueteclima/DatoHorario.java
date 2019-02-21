package paqueteclima;

import java.util.ArrayList;

public class DatoHorario {
private int magnitud;
private String fecha;
private int estacion;
private ArrayList<Float> cantidades;
public DatoHorario(int magnitud, String fecha, int estacion, ArrayList<Float> cantidades) {
	super();
	this.magnitud = magnitud;
	this.fecha = fecha;
	this.estacion = estacion;
	this.cantidades = cantidades;
}
public int getMagnitud() {
	return magnitud;
}
public void setMagnitud(int magnitud) {
	this.magnitud = magnitud;
}
public String getFecha() {
	return fecha;
}
public void setFecha(String fecha) {
	this.fecha = fecha;
}
public int getEstacion() {
	return estacion;
}
public void setEstacion(int estacion) {
	this.estacion = estacion;
}
public ArrayList<Float> getCantidades() {
	return cantidades;
}
public void setCantidades(ArrayList<Float> cantidades) {
	this.cantidades = cantidades;
}

}
