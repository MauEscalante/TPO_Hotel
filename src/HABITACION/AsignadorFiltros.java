package HABITACION;

import java.util.ArrayList;

import HOTEL.Hotel;

public class AsignadorFiltros {
	private SistemaFiltrado cadena;
	
	public AsignadorFiltros() {
		SistemaFiltrado Hab=new FiltroCapacidad(null);
		SistemaFiltrado tipoHabitacion=new FiltroTipoHabitacion(Hab);
		SistemaFiltrado EstadoHabitacion=new FiltroEstado(tipoHabitacion);
		this.cadena=EstadoHabitacion;
	}
	
	
	
	public ArrayList<Habitacion> asignarTarea(Peticion peticion) {
		ArrayList<Habitacion> habs=new ArrayList<>();
		for(Habitacion h:Hotel.getInstance().getHabitaciones()) {
			
			habs=this.cadena.manejar(peticion,h);
		}
		return habs;
	
	}
}
