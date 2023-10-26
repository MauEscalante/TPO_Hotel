package FACTURA;

public class MercadoPago {
	private MetodoPago metodo;
	
	public void  pagarFactura(Factura factura,double monto) {
		metodo.procesarPago(monto);
	}
	
	public void setMetodoPago(MetodoPago metodo) {
		this.metodo=metodo;
	}
	
	

	
}
