package paqueteservletagenda;

public class Contacto {
private String nombre, telefono;

public Contacto(String nombre, String telefono) {
	super();
	this.nombre = nombre;
	this.telefono = telefono;
}

public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

public String getTelefono() {
	return telefono;
}

public void setTelefono(String telefono) {
	this.telefono = telefono;
}

}
