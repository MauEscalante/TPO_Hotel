package HABITACION;

public class Disponible extends EstadoHabitacion{
	
	public Disponible() {
		this.estadoDetalle = "Disponible";
		
	}

	

	@Override
	public void cambiarEstado() {
		this.estado = new Reservada();
		
	}
}
