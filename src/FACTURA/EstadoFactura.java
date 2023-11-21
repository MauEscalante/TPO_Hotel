package FACTURA;



public abstract class EstadoFactura {
	protected String estadoDetalle;
	protected EstadoFactura estado;
	protected Factura factura;
	
	public  String getEstado() {
		return estadoDetalle;
	}
	public abstract void cambiarEstado();
}
