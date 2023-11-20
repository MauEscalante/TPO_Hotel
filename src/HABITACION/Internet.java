package HABITACION;

public class Internet extends Extras{

	private double costo;
	
	public Internet(Habitacion habitacion,double precio) {
		super(habitacion);
		habitacion.agregar("Internet");
		this.costo=precio;
	}

	public double getPrecio() {
		return (super.getPrecio()+this.costo);
	}

}
