package HABITACION;

public class Disponible extends EstadoHabitacion{
	
	public Disponible() {
		this.estadoDetalle = "Disponible";
	}

	
	public void reservar() {
		this.estado = new Reservada();
	
	}
}
