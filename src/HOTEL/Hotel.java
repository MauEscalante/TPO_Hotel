package HOTEL;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import HABITACION.*;
import RESERVA.Reserva;


public class Hotel {
	private static Hotel instance;
	
	private ArrayList<Reserva> reservas;
	private ArrayList<Habitacion> habitaciones;
	private ArrayList<Cliente> clientes;
	
	private Hotel() {
		this.reservas=new ArrayList<>();
		this.habitaciones=new ArrayList<>();
		this.clientes=new ArrayList<>();
	}
	
	
	public static Hotel getInstance() {
		if (instance == null) {
			instance = new Hotel();
		}
		return instance;
	}
	
	public Cliente getCliente(String dni) {
		for(Cliente c: clientes) {
			if(c.getDNI()==dni	) {
				return c;
			}
		}

		JOptionPane.showMessageDialog(null, "Cliente no registrado.",
				"Error", JOptionPane.ERROR_MESSAGE);
		return null;
	}


	public void setReserva(Reserva reserva) {
		this.reservas.add(reserva) ;
	}
	

	public void setHabitacion(Habitacion habitacion) {
		this.habitaciones.add(habitacion);
	}


	public void setCliente(Cliente cliente) {
		this.clientes.add(cliente);
	}
	
	public void eliminarCliente(String dni) {
		Cliente c=getCliente(dni);
		this.clientes.remove(c);
	}
	
	
}
