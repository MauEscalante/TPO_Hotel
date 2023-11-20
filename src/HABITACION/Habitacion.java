package HABITACION;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public  class Habitacion {

	private TipoHabitacion tipo;
	private int capacidad;
	private double precio;
	private EstadoHabitacion estado;
	private int nroHabitacion;
	private static int nroSig;
	private List<String> agregados= new ArrayList<>();
	
	public Habitacion(TipoHabitacion tipo,int capacidad, double precio,List<String> agregado) {
		this.tipo=tipo;
		this.capacidad=capacidad;
		this.precio=precio;
		this.estado=new Disponible();
		this.nroHabitacion=this.nroSig;
		this.nroSig++;
		this.agregados.addAll(agregado);
	}
	
	public TipoHabitacion getTipoInstacia() {
		return this.tipo;
	}
	
	public String getTipoHabitacion() {
		return tipo.getTipo();
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
	
	public  double getPrecio() {
		return this.precio;
	}
}
