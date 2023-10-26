package RESERVA;

public class Registrada extends EstadoReserva {
	
	public Registrada() {
		this.estadoDetalle="Registrada";
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
