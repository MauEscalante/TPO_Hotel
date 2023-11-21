package FACTURA;

import java.time.LocalDate;

import HOTEL.Cliente;
import RESERVA.Reserva;

public class Factura {
	private int nroFactura;
	private static int nroSig=1;
	private Cliente cliente;
	private LocalDate fechaEmision;
	private double monto;
	private Reserva reserva;
	private LocalDate fechaVencimiento;
	private EstadoFactura estado=new PendienteDePago(this);
	private MetodoPago CVU=new MercadoPago();
	
	
	public Factura(Cliente cliente,LocalDate fEmision,double monto,Reserva reserva) {
		this.nroFactura=nroSig;
		nroSig++;
		this.cliente=cliente;
		this.fechaEmision=fEmision;
		this.reserva=reserva;
		this.fechaVencimiento=fEmision.plusDays(1);
		this.monto=monto;
	}
	
	public void setEstado(EstadoFactura estado) {
		this.estado=estado;
	}
	
	public double getMonto() {
		return this.monto;
	}
	
	public void cambiarEstadoFactura() {
		estado.cambiarEstado();
		reserva.cambiarEstado();
	}
	
	public String getEstadoFactura() {
		return this.estado.getEstado();
	}
	
	
	
	public void pagar(AdapterMetodoPago metodo) {
		CVU.setMetodoPago(metodo);
		CVU.pagarFactura(this,getMonto());
		cambiarEstadoFactura();
	}


	public int getNroFactura() {
		return nroFactura;
	}

	public LocalDate getFechaVencimiento() {
		return fechaVencimiento;
	}

	public MetodoPago getCVU() {
		return CVU;
	}
	
}
