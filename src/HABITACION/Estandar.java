package HABITACION;

public class Estandar extends Habitacion{
	public Estandar(int capacidad,double precio) {
		this.estado=new Disponible();
		this.capacidad=capacidad;
		this.precio=precio;
	}
}
