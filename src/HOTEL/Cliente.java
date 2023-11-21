package HOTEL;

import java.util.ArrayList;

import FACTURA.AdapterMetodoPago;
import FACTURA.Factura;
import FACTURA.MetodoPago;
import RESERVA.GestorDeReservas;

public class Cliente extends GestorDeReservas implements IGestionarCliente{
	private String nombre;
	private String apellido;
	private String DNI;
	private int telefono;
	private String email;
	private ViaContacto preferenciaContacto;
	private ArrayList<Factura> facturas=new ArrayList<>();
	
	
	public Cliente(String nombre, String apellido, String DNI, int telefono, String email,
			ViaContacto preferenciaContacto) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.DNI = DNI;
		this.telefono = telefono;
		this.email = email;
		this.preferenciaContacto = preferenciaContacto;
	}
	
	public ArrayList<Factura> getFacturas(){
		return this.facturas;
	}
	
	public void agregarFactura(Factura factura) {
		facturas.add(factura);
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
	
	public void pagarFactura(int nroFactura,AdapterMetodoPago metodo) {
		Factura f = null;
		for(Factura fa:facturas) {
			if(fa.getNroFactura()==nroFactura) {
				f=fa;
			}
		}
		if(f!=null) {
			f.pagar(metodo);
		}
	}


	@Override
	public void agregarCliente(String nombre, String apellido, String DNI, int telefono, String email,
			ViaContacto preferenciaContacto) {
		Cliente cliente=new Cliente(nombre,apellido,DNI,telefono,email,preferenciaContacto);
		Hotel.getInstance().setCliente(cliente);
	}

	@Override
	public void eliminarCliente(String dni) {
		Hotel.getInstance().eliminarCliente(dni);
		
	}

	
	public void notificar(String mensaje) {
		System.out.println("Tu reserva fue "+ mensaje);
		
	}
	
	
}
