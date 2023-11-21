package FACTURA;

import javax.swing.JOptionPane;

public class FacturaVencida extends EstadoFactura{

	public FacturaVencida() {
		this.estadoDetalle="Vencida";
	}

	@Override
	public void cambiarEstado() {
		JOptionPane.showMessageDialog( null, "Factura vencida",
				"Error", JOptionPane.ERROR_MESSAGE);
	}


	
}
