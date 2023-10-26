package FACTURA;

import java.time.LocalDate;

import HOTEL.Cliente;
import RESERVA.Reserva;

public class Factura {
	private int nroFactura;
	private Cliente cliente;
	private LocalDate fechaEmision;
	private double monto;
	private double montoRecibido;
	private Reserva reserva;
	private LocalDate fechaVencimiento;
	private EstadoFactura estado;
	
	public Factura(Cliente cliente,LocalDate fEmision,double montoRecibido,double monto,Reserva reserva,LocalDate fVencimiento) {
		this.cliente=cliente;
		this.fechaEmision=fEmision;
		this.montoRecibido=montoRecibido;
		this.reserva=reserva;
		this.fechaVencimiento=fVencimiento;
		this.monto=monto;
	}
	
	public double getMontoRecibido() {
		return this.montoRecibido;
	}
	
	public double getMonto() {
		return this.monto;
	}
	
	public EstadoFactura getEstadoFactura() {
		return this.estado;
	}
}
