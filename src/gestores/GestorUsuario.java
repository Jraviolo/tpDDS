package gestores;

public class GestorUsuario {
	
	public GestorBaseDeDatos gbd=new GestorBaseDeDatos();

	public GestorUsuario() {
		
	}
	
	public int login(String usuario,String contraseņa){
		//int idUsuario= gbd.login(usuario,contraseņa);
		int idUsuario=1;
		return idUsuario;
	}
	public int getgrupo(int idusuario){
		//int idUsuario= gbd.login(usuario,contraseņa);
		int idUsuario=1;
		return idUsuario;
	}
}
