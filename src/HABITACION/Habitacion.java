package HABITACION;

import java.time.LocalDateTime;
import java.util.ArrayList;

public abstract class Habitacion {
	
	protected int capacidad;
	protected double precio;
	protected EstadoHabitacion estado;
	protected int nroHabitacion;
	protected static int nroSig;
	
	public String getEstado() {
		return this.estado.getEstado();
	}
	
	public int getCapacidad() {
		return capacidad;
	}

	public int getNroHabitacion() {
		return nroHabitacion;
	}

/*
	public String mostrarExtras() {
		StringBuilder agregados=new StringBuilder();
		for(Extras items: this.packExtras.getExtras()) {
			agregados.append(items.getAgregado()+","+items.getCosto()+"\n");
		}
		String packExtras=agregados.toString();
		return packExtras;
	}
	
	public double getPrecio() {
		return precio;
	}
	
	*/
	
	public void reservar(LocalDateTime CheckIn,LocalDateTime CheckOut ) {
		//desarrollar
	}
	
	public void cambiarEstado() {
		if (this.estado.getEstado() == "Disponible") {
			this.estado = new Reservada();
		} else {
			this.estado = new Disponible();
		}
	}
	
	public double getPrecio() {
		return this.precio;
	}
}
