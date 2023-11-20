package HABITACION;

public class Despertador extends Extras{
	private double costo;
	
	public Despertador(Habitacion habitacion) {
		super(habitacion);
		habitacion.agregar("Despertador");
	}

	
	public double getPrecio() {
		return (super.getPrecio()+this.costo);
	}
}
