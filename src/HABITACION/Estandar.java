package HABITACION;

import java.util.ArrayList;

public class Estandar extends Habitacion{
	public Estandar(int capacidad,double precio) {
		super(capacidad,precio,"Estandar",new ArrayList<>());
	}

	@Override
	public double getPrecio() {
		return this.precio;
	}
}
