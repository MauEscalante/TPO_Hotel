package HABITACION;

public class Reservada extends EstadoHabitacion{
	public Reservada() {
		this.estadoDetalle = "Reservada";
	}

	
	public void liberar() {
		this.estado = new Disponible();
	}
}
