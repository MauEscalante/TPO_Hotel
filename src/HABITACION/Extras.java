package HABITACION;

public abstract class Extras extends Habitacion{
	private  Habitacion habitacion;
	
	public Extras(Habitacion habitacion) {
		super(habitacion.getTipoInstacia(),habitacion.getCapacidad(),habitacion.getPrecio(),habitacion.getExtras());
		this.habitacion=habitacion;
	}
	
	public  double getPrecio() {
		return this.habitacion.getPrecio();
		
	}

}
