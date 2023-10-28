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

	
	public void reservar(LocalDateTime CheckIn,LocalDateTime CheckOut ) {
		//desarrollar
	}
	
	public void cambiarEstado() {
		estado.cambiarEstado();
	}
	
	public double getPrecio() {
		return this.precio;
	}
}
