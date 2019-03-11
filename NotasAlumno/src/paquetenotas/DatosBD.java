package paquetenotas;

public class DatosBD {
private String usuario_bd, pwd_bd, nombre_bd;

public DatosBD(String usuario_bd, String pwd_bd, String nombre_bd) {
	super();
	this.usuario_bd = usuario_bd;
	this.pwd_bd = pwd_bd;
	this.nombre_bd = nombre_bd;
}

public String getUsuario_bd() {
	return usuario_bd;
}

public String getPwd_bd() {
	return pwd_bd;
}

public String getNombre_bd() {
	return nombre_bd;
}

}
