package HABITACION;

import java.util.ArrayList;

public class FiltroCapacidad extends SistemaFiltrado{

	public FiltroCapacidad(SistemaFiltrado siguienteFiltro) {
		super(siguienteFiltro);
	}

	@Override
	public ArrayList<Habitacion> manejar(Peticion peticion,Habitacion h) {
		if(peticion.esDeTipo(TipoPeticion.CAPACIDAD)) {
			if(this.habitacion.getCapacidad()==Integer.valueOf(peticion.getValor())) {
				habEncontradas.add(h);
				
			}
		}else if(this.siguienteFiltro!=null) {
			this.siguienteFiltro.manejar(peticion,h);
		}
		return this.habEncontradas;
	}

	

}
