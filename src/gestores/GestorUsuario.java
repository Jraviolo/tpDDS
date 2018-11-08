package gestores;

public class GestorUsuario {
	
	public GestorBaseDeDatos gbd=new GestorBaseDeDatos();

	public GestorUsuario() {
		
	}
	
	public int login(String usuario,String contraseña){
		//int idUsuario= gbd.login(usuario,contraseña);
		int idUsuario=1;
		return idUsuario;
	}
}
