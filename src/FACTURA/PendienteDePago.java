package FACTURA;

import javax.swing.JOptionPane;

public class PendienteDePago extends EstadoFactura{

	public PendienteDePago() {
		this.estadoDetalle="Pendiente de pago";
	}

	@Override
	public void cambiarEstado() {
		if(factura.getMontoRecibido()>=factura.getMonto()) {
			this.estado=new FacturaPagada();
		}else {
			this.estado=new FacturaVencida();
		}
	}
}
