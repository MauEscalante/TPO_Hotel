package HABITACION;

public class Television extends Extras{
	private double costo;
	
	
	public Television(Habitacion habitacion,double precio) {
		super(habitacion);
		this.costo=precio;
		habitacion.agregar("Television");
	}
	
	public double getPrecio() {
		return (super.getPrecio()+this.costo);
	}
	

}
