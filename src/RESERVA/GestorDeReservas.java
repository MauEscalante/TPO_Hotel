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
	
	public void generarReserva(LocalDate checkIN,LocalDate checkOUT,String dniCliente,ArrayList<Huesped> huesped,Habitacion habitacion,List<Extras> ListaExtras) {
		
		//pasamos de la lista de extras que se desea a un ArrayList
		ArrayList<Extras> extras=new ArrayList<>();
		extras.addAll(ListaExtras);
		
		
		Reserva reserva1=new Reserva(checkIN, checkOUT, h.getCliente(dniCliente), huesped, habitacion, extras);
		reserva1.cambiarEstado();
	}
	
	public void confirmarReserva(Reserva reservaAConfirmar) {
		reservaAConfirmar.cambiarEstado();
		h.setReserva(reservaAConfirmar);
	}
	
	public void cancelarReserva(Reserva reservaACancelar) {
		reservaACancelar.cambiarEstado();
	}
	
}
