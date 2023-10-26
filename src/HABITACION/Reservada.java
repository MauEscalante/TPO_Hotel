package HABITACION;

public class Reservada extends EstadoHabitacion{
	public Reservada() {
		this.estadoDetalle = "Reservada";
	}

	
	@Override
	public void cambiarEstado() {
		this.estado = new Disponible();
		
	}
}
