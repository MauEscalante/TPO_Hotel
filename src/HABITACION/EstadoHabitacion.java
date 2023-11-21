package HABITACION;

public abstract class EstadoHabitacion {
	protected Habitacion hab;
	protected String estadoDetalle;
	protected EstadoHabitacion estado;
	
	
	public EstadoHabitacion(Habitacion hab) {
		this.hab=hab;
	}

	public String getEstado() {
		return this.estadoDetalle;
	}
	
	public abstract void cambiarEstado();
	
}
