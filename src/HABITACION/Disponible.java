package HABITACION;

public class Disponible extends EstadoHabitacion{
	
	public Disponible(Habitacion hab) {
		super(hab);
		this.estadoDetalle = "Disponible";
		
	}

	

	@Override
	public void cambiarEstado() {
		hab.setEstado(new Reservada(hab));
		
	}
}
