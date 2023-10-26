package FACTURA;

import java.time.LocalDate;

import HOTEL.Cliente;
import RESERVA.Reserva;

public class Factura {
	private int nroFactura;
	private static int nroSig;
	private Cliente cliente;
	private LocalDate fechaEmision;
	private double monto;
	private Reserva reserva;
	private LocalDate fechaVencimiento;
	private EstadoFactura estado=new PendienteDePago();
	private MercadoPago CVU;
	
	
	public Factura(Cliente cliente,LocalDate fEmision,double monto,Reserva reserva) {
		this.nroFactura=nroSig;
		nroSig++;
		this.cliente=cliente;
		this.fechaEmision=fEmision;
		this.reserva=reserva;
		this.fechaVencimiento=fEmision.plusDays(1);
		this.monto=monto;
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
	
	
	
	public void pagar(MetodoPago metodo) {
		CVU.setMetodoPago(metodo);
		CVU.pagarFactura(this,getMonto());
		this.estado.saldar();
		reserva.cambiarEstado();
	}



	public int getNroFactura() {
		return nroFactura;
	}

	public LocalDate getFechaVencimiento() {
		return fechaVencimiento;
	}

	public MercadoPago getCVU() {
		return CVU;
	}
	
}
