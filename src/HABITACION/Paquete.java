package HABITACION;

import java.util.ArrayList;

public class Paquete {
	private ArrayList<Extras> agregados=new ArrayList<>();
	
	public Paquete(ArrayList<Extras> agregar) {
		this.agregados.addAll(agregar);
	}
	
	public ArrayList<Extras> getExtras(){
		return agregados;
	}
	
	public void agregarExtra(Extras agregar) {
		this.agregados.add(agregar);
	}
	
	public void sacarExtra(Extras sacar) {
		this.agregados.remove(sacar);
	}
	
	public double calcularMonto() {
		int costo=0;
		for(Extras agregado: agregados) {
			costo+=agregado.getCosto();
		}
		return costo;
	}
}
