package HOTEL;

import java.util.ArrayList;

import HABITACION.Habitacion;
import RESERVA.GestorDeReservas;

public class Gerente extends GestorDeReservas implements IGestionarCliente{
	private int id;
	private static int idSig;
	
	public Gerente() {}
	
	public int getId() {
		return id;
	}
	
	public void publicarHabitacion() {
		//completar
	}
	
	
	public ArrayList<Habitacion> buscarHabitaciones(){
		
		//completar
		//verificar como implementar con el chain of responsability
		return null;
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
