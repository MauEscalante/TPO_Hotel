package HABITACION;

public class Peticion {
	private TipoPeticion tipo;
	private String valor;
	
	public Peticion(TipoPeticion tipo,String valor) {
		this.tipo=tipo;
		this.valor=valor;
	}

	public boolean esDeTipo(TipoPeticion tipo) {
		return this.tipo.equals(tipo);
	}

	public String getValor() {
		return valor;
	}
	
	
}
