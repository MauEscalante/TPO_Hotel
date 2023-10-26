package RESERVA;

import javax.swing.JOptionPane;

public class Confirmada extends EstadoReserva{

	public Confirmada() {
		this.estadoDetalle="Confirmada";
	}
	
	@Override
	public void cambiarEstado() {
		JOptionPane.showMessageDialog( null, "Reserva ya confirmada",
				"Error", JOptionPane.ERROR_MESSAGE);
		
	}
	
	

}
