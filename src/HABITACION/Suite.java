package HABITACION;

public class Suite extends Habitacion{
	public Suite(int capacidad,double precio) {
		this.estado=new Disponible();
		this.capacidad=capacidad;
		this.precio=precio;
	}
}
