package paquetenotas;

public class Alumno {
private String nombre;
private float nota;
private int asignatura;//1-Mates; 2-Lengua
public Alumno(String nombre, float nota, int asignatura) {
	super();
	this.nombre = nombre;
	this.nota = nota;
	this.asignatura = asignatura;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public float getNota() {
	return nota;
}
public void setNota(float nota) {
	this.nota = nota;
}
public int getAsignatura() {
	return asignatura;
}
public void setAsignatura(int asignatura) {
	this.asignatura = asignatura;
}

}
