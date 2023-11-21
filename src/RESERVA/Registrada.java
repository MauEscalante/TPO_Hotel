package RESERVA;

public class Registrada extends EstadoReserva {
	
	public Registrada(Reserva reserva) {
		this.estadoDetalle="Registrada";
		this.reserva=reserva;
	}

	

	@Override
	public void cambiarEstado( ) {
		if(reserva.getEstadoFactura().equalsIgnoreCase("Pagada")) {
			reserva.setEstado(new Confirmada());
		}else {
			reserva.setEstado(new Cancelada());
		}

	}

}
