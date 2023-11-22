package HOTEL;

import javax.swing.JOptionPane;

import HABITACION.*;
import RESERVA.Reserva;
import java.util.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Hotel implements IGestionarCliente {
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
	
	
	
	public void agregarReserva(Reserva reserva) {
		this.reservas.add(reserva);
	}
	
	
	public ArrayList<Reserva> getReservas(){
		return this.reservas;
	}
	
	public ArrayList<String> generarReporteHabitaciones(){
		ArrayList<String> lista=new ArrayList<>();
		for(Habitacion h: habitaciones) {
			String valor= "Habitacion "+h.getNroHabitacion()+" esta "+h.getEstado();
			lista.add(valor);
		}
		return lista;
	}
	
	
	public static Hotel getInstance() {
		if (instance == null) {
			instance = new Hotel();
		}
		return instance;
	}
	
	public Habitacion getHabitacion(int id) {
		for(Habitacion h:habitaciones) {
			if(id==h.getNroHabitacion()) {
				return h;
			}
		}
		return null;
	}
	
	public ArrayList<Habitacion> getHabitaciones(){
		return this.habitaciones;
	}
	
	public boolean habitacionDisponible(Habitacion hab,LocalDate nCheckIn,LocalDate nCheckOut) {
		if(calendarioReser.containsKey(hab)) {
			List<LocalDate> calendario=calendarioReser.get(hab);
			
			for (LocalDate fecha = nCheckIn; fecha.isBefore(nCheckOut.plusDays(1)); fecha = fecha.plusDays(1)) {
	            if (calendario.contains(fecha)) {
	                return false;
	            }
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
	
	public void clearReserva(Reserva reserva) {
		this.reservas.remove(reserva);
		Habitacion hab=reserva.getHabitacion();
		List<LocalDate> lista=calendarioReser.get(hab);
		for(LocalDate fecha:lista) {
			if(fecha.isAfter(reserva.getCheckIN()) && fecha.isBefore(reserva.getCheckOUT())) {
				lista.remove(fecha);
			}
		}
	}

	public void setReserva(Reserva reserva) {
		this.reservas.add(reserva) ;
		Habitacion hab=reserva.getHabitacion();
		List<LocalDate> lista=new ArrayList<>();
		if(calendarioReser.containsKey(hab)) {
			lista=calendarioReser.get(hab);
		}
		lista=cargarFechas(reserva.getCheckIN(),reserva.getCheckOUT(),lista);
		calendarioReser.put(hab, lista);
	}
	
	private List<LocalDate> cargarFechas(LocalDate checkIn,LocalDate checkOut,List<LocalDate> lista){
		for(LocalDate date=checkIn;!date.isAfter(checkOut);date=date.plus(1, ChronoUnit.DAYS)  ) {
			lista.add(date);
		}
		return lista;
		
	}
	

	public void setHabitacion(Habitacion habitacion) {
		this.habitaciones.add(habitacion);
	}


	public void setCliente(Cliente cliente) {
		this.clientes.add(cliente);
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
