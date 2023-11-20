package HOTEL;

import javax.swing.JOptionPane;

import HABITACION.*;
import RESERVA.Reserva;
import java.util.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Hotel {
	private static Hotel instance;
	private Map<Habitacion,List<LocalDate>> calendarioReser=new HashMap<>();
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
	
	public ArrayList<Habitacion> getHabitaciones(){
		return this.habitaciones;
	}
	
	public boolean habitacionDisponible(Habitacion hab,LocalDate nCheckIn,LocalDate nCheckOut) {
		List<LocalDate> calendario=calendarioReser.get(hab);
		 for (LocalDate fecha = nCheckIn; fecha.isBefore(nCheckOut.plusDays(1)); fecha = fecha.plusDays(1)) {
	            if (calendario.contains(fecha)) {
	                return false;
	            }
	        }
		 return true;
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
		Habitacion hab=reserva.getHabitacion();
		List<LocalDate> lista=calendarioReser.get(hab);
		for(LocalDate date=reserva.getCheckIN();!date.isAfter(reserva.getCheckOUT());date=date.plus(1, ChronoUnit.DAYS)  ) {
			lista.add(date);
		}
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
