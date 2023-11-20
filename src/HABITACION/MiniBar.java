package HABITACION;

public class MiniBar extends Extras{
	private double costo;

	public MiniBar(Habitacion habitacion,double precio) {
		super(habitacion);
		this.costo=precio;
		habitacion.agregar("MiniBar");
	}


	public double getPrecio() {
		return (super.getPrecio()+this.costo);
	}
	
}
