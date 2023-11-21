package FACTURA;

public abstract class MetodoPago {
	private AdapterMetodoPago metodo;
	private boolean pagoAceptado;
	
	public boolean procesarPago(double monto) {
		return true;
	}
	
	public boolean seAceptoPago() {
		return this.pagoAceptado;
	}
	
	public void  pagarFactura(Factura factura,double monto) {
		pagoAceptado=metodo.procesarPago(monto);
	}
	
	public void setMetodoPago(AdapterMetodoPago metodo) {
		this.metodo=metodo;
	}
}
