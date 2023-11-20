package HABITACION;

import java.util.ArrayList;

public class Suite extends Habitacion{
	public Suite(int capacidad,double precio) {
		super(capacidad,precio,"suite", new ArrayList<>());
	}

	@Override
	public double getPrecio() {
		return this.precio;
	}
}
