package HABITACION;

import java.util.ArrayList;

public class FiltroEstado extends SistemaFiltrado{

	public FiltroEstado(SistemaFiltrado siguienteFiltro) {
		super(siguienteFiltro);
	}

	@Override
	public ArrayList<Habitacion> manejar(Peticion peticion, Habitacion h) {
		
		if(peticion.esDeTipo(TipoPeticion.ESTADO_HABITACION)) {
			if(peticion.getValor().equalsIgnoreCase(h.getEstado())) {
				this.habEncontradas.add(h);
			}
		}else if(this.siguienteFiltro!=null) {
				
				return this.siguienteFiltro.manejar(peticion,h);
			}
		return this.habEncontradas;
	}

	

}
