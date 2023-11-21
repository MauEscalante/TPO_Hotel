package HABITACION;

import java.util.ArrayList;

public class FiltroCapacidad extends SistemaFiltrado{

	public FiltroCapacidad(SistemaFiltrado siguienteFiltro) {
		super(siguienteFiltro);
	}

	@Override
	public ArrayList<Habitacion> manejar(Peticion peticion,Habitacion h) {
		if(peticion.esDeTipo(TipoPeticion.CAPACIDAD)) {
			if(h.getCapacidad()==Integer.valueOf(peticion.getValor())) {
				habEncontradas.add(h);
			}
		}else if(this.siguienteFiltro!=null) {
			return this.siguienteFiltro.manejar(peticion,h);
		}
		
		return this.habEncontradas;
	}

	

}
