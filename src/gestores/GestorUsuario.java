package gestores;

import java.util.ArrayList;
import java.util.List;

import clases.CambioClasificacion;
import clases.CambioEstado;
import clases.Empleado;
import clases.Ticket;
import clasesAuxiliares.CambioEstadoAux;
import clasesAuxiliares.EmpleadoAux;

public class GestorUsuario {
	
	public GestorBaseDeDatos gbd=new GestorBaseDeDatos();

	public GestorUsuario() {
		
	}
	
	public int login(String usuario,String contraseña){
		//int idUsuario= gbd.login(usuario,contraseña);
		int idUsuario=1;
		return idUsuario;
	}
	public int getgrupo(int idusuario){
		//int idUsuario= gbd.login(usuario,contraseña);
		int idUsuario=1;
		return idUsuario;
	}
	
	public EmpleadoAux getEmpleadoAux(int legajo) {
		Empleado empleado=gbd.buscarEmpleado(legajo);
		EmpleadoAux e=new EmpleadoAux();
		
		e.setApellido(empleado.getApellido());
		e.setDescripcionDeCargo(empleado.getDescripcionDeCargo());
		e.setLegajo(empleado.getLegajo());
		e.setNombre(empleado.getNombre());
		e.setTelefonoDirecto(empleado.getTelefonoDirecto());
		e.setTelefonoInterno(empleado.getTelefonoInterno());
		e.setUbicacion(empleado.getUbicacion());
		return e;
	}
	
	
}
