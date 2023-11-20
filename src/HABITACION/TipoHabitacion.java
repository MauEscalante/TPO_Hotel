package HABITACION;

import java.util.ArrayList;
import java.util.List;

public abstract class TipoHabitacion {
	protected String tipoHabitacion;
	

	public TipoHabitacion(String tipo) {
		this.tipoHabitacion=tipo;
	}

	public String getTipo() {
		return this.tipoHabitacion;
	}
}
