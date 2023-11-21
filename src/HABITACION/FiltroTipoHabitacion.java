package HABITACION;

import java.util.ArrayList;

public class FiltroTipoHabitacion extends SistemaFiltrado{

	public FiltroTipoHabitacion(SistemaFiltrado siguienteFiltro) {
		super(siguienteFiltro);
	}

	@Override
	public ArrayList<Habitacion> manejar(Peticion peticion, Habitacion h) {
		if(peticion.esDeTipo(TipoPeticion.TIPO_HABITACION)) {
			if(peticion.getValor().equalsIgnoreCase(h.getTipoHabitacion())) {
				this.habEncontradas.add(h);
			}
		}else if(this.siguienteFiltro!=null) {
				return this.siguienteFiltro.manejar(peticion,h);
			}
		return this.habEncontradas;
	}

	
}
