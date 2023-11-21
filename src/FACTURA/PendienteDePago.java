package FACTURA;

import javax.swing.JOptionPane;

public class PendienteDePago extends EstadoFactura{

	public PendienteDePago(Factura factura) {
		this.factura=factura;
		this.estadoDetalle="Pendiente de pago";
	}

	@Override
	public void cambiarEstado() {
		if(factura.getCVU().seAceptoPago()) {
			factura.setEstado(new FacturaPagada());
		}else {
			factura.setEstado(new FacturaVencida());
		}
			
		}
		
	
	
}
