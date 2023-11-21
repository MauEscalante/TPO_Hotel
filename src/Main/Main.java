package Main;
import HOTEL.*;
import HABITACION.*;

import java.time.LocalDate;
import java.util.ArrayList;

import FACTURA.*;
import RESERVA.*;

public class Main {

	public static void main(String[] args) {
		//creamos un gerente
		Gerente gerente=new Gerente();
		
		//gerente agrega clientes
		gerente.agregarCliente("Javier", "Milei", "17.031.333", 1126595374, "javier@gmail.com", ViaContacto.EMAIL);
		gerente.agregarCliente("Victoria", "Villaruel", "19.301.555", 11234565, "victoria@gmail.com", ViaContacto.WHATSAPP);
		Cliente cliente=Hotel.getInstance().getCliente("17.031.333");
		
		//publicamos habitaciones
		gerente.publicarHabitacion(4, 50000.0, EtipoHabitacion.ESTANDAR);
		gerente.publicarHabitacion(4, 100000.0, EtipoHabitacion.SUITE);
		
		//buscar habitacion segun criterio
		System.out.println();
		System.out.println("Habitaciones segun criterio: ");
		ArrayList<Habitacion> busqueda=gerente.buscarHabitaciones(TipoPeticion.CAPACIDAD, "4");
		for(Habitacion h:busqueda) {
			System.out.println(h.toString());
		}
		
		//reservar y cancelar habitaciones
		gerente.generarReserva(LocalDate.of(2023,12, 15),LocalDate.of(2023,12, 31), "17.031.333",new ArrayList<>() , Hotel.getInstance().getHabitacion(1));
		
		//chequear que la factura funcione correctamente
		System.out.println();
		System.out.println("Funciona correctamente el cambio de estado en factura: ");
		
		System.out.println(cliente.getFacturas().get(0).getEstadoFactura());
		
		cliente.pagarFactura(1, new Transferencia());
		
		System.out.println(cliente.getFacturas().get(0).getEstadoFactura());
		
		//muestra de cambio de estado de una habitacion al ser reservada
		System.out.println();
		System.out.println("Cambio de estado en una habitacion");
		System.out.println(Hotel.getInstance().getHabitacion(1).getEstado());
		Hotel.getInstance().getHabitacion(1).reservar();
		System.out.println(Hotel.getInstance().getHabitacion(1).getEstado());
	}

}
