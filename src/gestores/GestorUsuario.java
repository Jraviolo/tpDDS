package gestores;

public class GestorUsuario {
	
	public GestorBaseDeDatos gbd=new GestorBaseDeDatos();

	public GestorUsuario() {
		
	}
	
	public int login(String usuario,String contrase�a){
		//int idUsuario= gbd.login(usuario,contrase�a);
		int idUsuario=1;
		return idUsuario;
	}
}
