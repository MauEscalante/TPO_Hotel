package HOTEL;

import java.util.ArrayList;
import java.util.List;

import HABITACION.*;
import RESERVA.GestorDeReservas;

public class Gerente extends GestorDeReservas implements IGestionarCliente{
	private int id;
	private static int idSig;
	AsignadorFiltros f=new AsignadorFiltros();
	
	public Gerente() {}
	
	public int getId() {
		return id;
	}
	
	public void publicarHabitacion(int capacidad,double precio,EtipoHabitacion tipo) {
		Habitacion hab=null;
		if(tipo.equals(EtipoHabitacion.ESTANDAR)) {
			 hab=new Habitacion(new Estandar(),capacidad, precio, new ArrayList<String>());	
			
		}else {
			hab=new Habitacion(new Suite(),capacidad, precio, new ArrayList<String>());	
		}
		Hotel.getInstance().setHabitacion(hab);
	}
	
	
	
	public ArrayList<Habitacion> buscarHabitaciones(TipoPeticion tipo,String valor){
		return f.asignarTarea(new Peticion(tipo,valor));
	}

	@Override
	public void agregarCliente(String nombre, String apellido, String DNI, int telefono, String email,
			ViaContacto preferenciaContacto) {
		Cliente cliente=new Cliente(nombre,apellido,DNI,telefono,email,preferenciaContacto);
		Hotel.getInstance().setCliente(cliente);
	}

	@Override
	public void eliminarCliente(String dni) {
		Hotel.getInstance().eliminarCliente(dni);
		
		
	}


}
