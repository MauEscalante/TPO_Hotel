package HABITACION;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public abstract class Habitacion {
	protected String tipoHabitacion;
	protected int capacidad;
	protected double precio;
	protected EstadoHabitacion estado;
	protected int nroHabitacion;
	protected static int nroSig;
	protected List<String> agregados= new ArrayList<>();
	
	public Habitacion(int capacidad, double precio,String tipo,List<String> agregado) {
		this.tipoHabitacion=tipo;
		this.capacidad=capacidad;
		this.precio=precio;
		this.estado=new Disponible();
		this.nroHabitacion=this.nroSig;
		this.nroSig++;
		this.agregados.addAll(agregado);
	}
	
	public List<String> getExtras(){
		return this.agregados;
	}
	
	public void agregar(String agregado) {
		agregados.add(agregado);
	}

	public String getEstado() {
		return this.estado.getEstado();
	}
	
	public int getCapacidad() {
		return capacidad;
	}

	public int getNroHabitacion() {
		return nroHabitacion;
	}

	
	public void reservar() {
		cambiarEstado();
	}
	
	public void cambiarEstado() {
		estado.cambiarEstado();
	}
	
	public abstract double getPrecio();
}
