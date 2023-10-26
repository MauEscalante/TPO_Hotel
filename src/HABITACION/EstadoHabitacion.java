package HABITACION;

public abstract class EstadoHabitacion {
	protected String estadoDetalle;
	protected EstadoHabitacion estado;
	protected Habitacion habitacion;


	public String getEstado() {
		return this.estadoDetalle;
	}
	
}
