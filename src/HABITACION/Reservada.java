package HABITACION;

public class Reservada extends EstadoHabitacion{
	public Reservada(Habitacion hab) {
		super(hab);
		this.estadoDetalle = "Reservada";
	}

	
	@Override
	public void cambiarEstado() {
		hab.setEstado(new Disponible(hab));
		
	}
}
