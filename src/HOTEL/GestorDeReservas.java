package HOTEL;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import HABITACION.Extras;
import HABITACION.Habitacion;
import RESERVA.Huesped;
import RESERVA.Reserva;

public abstract class GestorDeReservas {
	private ArrayList<Reserva> reservas=new ArrayList<>();
	
	public void generarReserva(LocalDate checkIN,LocalDate checkOUT,String dniCliente,ArrayList<Huesped> huesped,Habitacion habitacion,List<Extras> Listaextras) {
		
		//pasamos de la lista de extras que se desea a un ArrayList
		ArrayList<Extras> extras=new ArrayList<>();
		extras.addAll(extras);
		
		Hotel h=Hotel.getInstance();
		Reserva reserva1=new Reserva(checkIN, checkOUT, h.getCliente(dniCliente), huesped, habitacion, extras);
		
		h.setReserva(reserva1);
	}
	
	public void confirmarReserva(Reserva reservaAConfirmar) {
		reservaAConfirmar.cambiarEstado();
	}
	
	public void cancelarReserva(Reserva reservaACancelar) {
		reservaACancelar.cambiarEstado();
	}
	
}
