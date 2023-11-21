package RESERVA;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import HABITACION.Extras;
import HABITACION.Habitacion;
import HOTEL.Hotel;

public abstract class GestorDeReservas {
	Hotel h=Hotel.getInstance();
	private ArrayList<Reserva> reservas=new ArrayList<>();
	
	public void generarReserva(LocalDate checkIN,LocalDate checkOUT,String dniCliente,ArrayList<Huesped> huesped,Habitacion habitacion) {	
		if(h.habitacionDisponible(habitacion,checkIN,checkOUT)) {
			Reserva reserva1=new Reserva(checkIN, checkOUT, h.getCliente(dniCliente), huesped, habitacion);
			h.agregarReserva(reserva1);
		}
		
	}
	
	public void confirmarReserva(Reserva reservaAConfirmar) {
		reservaAConfirmar.cambiarEstado();
		h.setReserva(reservaAConfirmar);
	}
	
	public void cancelarReserva(Reserva reservaACancelar) {
		reservaACancelar.cambiarEstado();
		h.clearReserva(reservaACancelar);
	}
	
}
