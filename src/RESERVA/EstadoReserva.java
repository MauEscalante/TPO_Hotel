package RESERVA;



public abstract class EstadoReserva {
	protected String estadoDetalle;
	protected EstadoReserva estado;
	protected Reserva reserva;
	
	public  String getEstado() {
		return estadoDetalle;
	}
	public abstract void cambiarEstado();
}
