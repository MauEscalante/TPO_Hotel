package HOTEL;

public interface IGestionarCliente {
	public void agregarCliente(String nombre, String apellido, String DNI, int telefono, String email,ViaContacto preferenciaContacto);
	public void eliminarCliente(String dni);
}
