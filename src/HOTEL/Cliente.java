package HOTEL;

public class Cliente extends GestorDeReservas{
	private String nombre;
	private String apellido;
	private String DNI;
	private int telefono;
	private String email;
	private ViaContacto preferenciaContacto;
	
	
	public Cliente(String nombre, String apellido, String DNI, int telefono, String email,
			ViaContacto preferenciaContacto) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.DNI = DNI;
		this.telefono = telefono;
		this.email = email;
		this.preferenciaContacto = preferenciaContacto;
	}


	public String getNombre() {
		return nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public String getDNI() {
		return DNI;
	}


	public int getTelefono() {
		return telefono;
	}


	public String getEmail() {
		return email;
	}


	public ViaContacto getPreferenciaContacto() {
		return preferenciaContacto;
	}
	
	
	
	
}
