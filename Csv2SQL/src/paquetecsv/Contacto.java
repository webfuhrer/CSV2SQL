package paquetecsv;

public class Contacto {
private String nombre, email, apellido;
private int edad;
public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getApellido() {
	return apellido;
}

public void setApellido(String apellido) {
	this.apellido = apellido;
}

public Contacto(String nombre, String email, String apellido, int edad) {
	super();
	this.nombre = nombre;
	this.email = email;
	this.apellido = apellido;
	this.edad = edad;
}

public int getEdad() {
	return edad;
}

public void setEdad(int edad) {
	this.edad = edad;
}

@Override
public String toString() {
	return "Contacto [nombre=" + nombre + ", email=" + email + ", apellido=" + apellido + ", edad=" + edad + "]";
}



}
