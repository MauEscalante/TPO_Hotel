package RESERVA;

public class Registrada extends EstadoReserva {
	
	public Registrada(Reserva reserva) {
		this.estadoDetalle="Registrada";
		this.reserva=reserva;
	}

	

	@Override
	public void cambiarEstado( ) {
		if(reserva.getEstadoFactura()=="Pagada") {
			this.estado=new Confirmada();
		}else {
			this.estado=new Cancelada();
		}

	}

}
