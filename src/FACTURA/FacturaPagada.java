package FACTURA;

import javax.swing.JOptionPane;

public class FacturaPagada extends EstadoFactura{
	
	public FacturaPagada() {
		this.estadoDetalle="Pagada";
	}

	@Override
	public void cambiarEstado() {
		JOptionPane.showMessageDialog( null, "Factura pagada",
				"Error", JOptionPane.ERROR_MESSAGE);
	}

}
