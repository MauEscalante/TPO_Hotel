package FACTURA;

import javax.swing.JOptionPane;

public class PendienteDePago extends EstadoFactura{

	public PendienteDePago() {
		this.estadoDetalle="Pendiente de pago";
	}

	@Override
	public void cambiarEstado() {

			this.estado=new FacturaVencida();
		}
		
	public void saldar() {
		this.estado=new FacturaPagada();
	}
	
}
