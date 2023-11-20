package HABITACION;

import java.util.ArrayList;

public abstract class SistemaFiltrado {
	protected SistemaFiltrado siguienteFiltro;
	protected Habitacion habitacion;
	protected ArrayList<Habitacion> habEncontradas=new ArrayList<Habitacion>();

	
	public SistemaFiltrado(SistemaFiltrado siguienteFiltro) {
		this.siguienteFiltro=siguienteFiltro;
	}
	
	
	public abstract  ArrayList<Habitacion> manejar(Peticion peticion,Habitacion h);


	
}
