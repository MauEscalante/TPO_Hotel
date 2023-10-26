package HABITACION;

public abstract class EstadoHabitacion {
	protected String estadoDetalle;
	protected EstadoHabitacion estado;


	public String getEstado() {
		return this.estadoDetalle;
	}
	
	public abstract void cambiarEstado();
	
}
