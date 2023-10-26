package RESERVA;

import javax.swing.JOptionPane;

public class Cancelada extends EstadoReserva {

	public Cancelada() {
		this.estadoDetalle="Cancelada";
	}

	@Override
	public void cambiarEstado() {
		JOptionPane.showMessageDialog( null, "Reserva ya cancelada",
				"Error", JOptionPane.ERROR_MESSAGE);
	}

}
