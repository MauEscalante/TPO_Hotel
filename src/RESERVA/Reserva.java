package RESERVA;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import FACTURA.EstadoFactura;
import FACTURA.Factura;
import HOTEL.*;
import HABITACION.Extras;
import HABITACION.Habitacion;

public class Reserva {
	private ITiempoReservado fechaReservado;
	private LocalDate CheckIn;
	private LocalDate CheckOut;
	private Cliente cliente;
	private ArrayList<Huesped> huesped=new ArrayList<>();
	private EstadoReserva estado=new Registrada(this);
	private Habitacion habitacion;
	private double monto;
	private Factura factura;
	
	public Reserva(LocalDate checkIn, LocalDate checkOut, Cliente cliente, ArrayList<Huesped> huesped,Habitacion habitacion) {
		LocalDate fActual=LocalDate.now();
		
		//esta raro estos ifs
		if(ChronoUnit.MONTHS.between(fActual,checkIn)>=2) {
			this.fechaReservado=new Dos_Meses_Anticipado();
		}else if(ChronoUnit.DAYS.between(fActual,checkIn)>=15) {
			this.fechaReservado=new Quince_DiasAnticipado();
		}else {
			this.fechaReservado=new SinAnticipacion();
		}
		
		this.CheckIn = checkIn;
		this.CheckOut = checkOut;
		this.cliente = cliente;
		this.huesped = huesped;
		this.habitacion = habitacion;
		
		this.monto=habitacion.getPrecio();
		
		double descuento=( monto * this.fechaReservado.getDescuento())/100;
		monto-= descuento;
		
		generarFactura();
		
	}
	
	
	public String getEstadoFactura() {
		return this.factura.getEstadoFactura();
	}
	
	public Habitacion getHabitacion() {
		return this.habitacion;
	}
	
	public void pagar() {
		cambiarEstado();
	}
	
	public void cambiarEstado() {
		estado.cambiarEstado();
		notificar();
	}
	
	public void setEstado(EstadoReserva estado) {
		this.estado=estado;
	}
	
	public void notificar() {
		cliente.notificar(getEstadoFactura());
	}
	
	public void generarFactura() {
		Factura factura= new Factura(cliente, LocalDate.now(), monto, this);
		cliente.agregarFactura(factura);
		this.factura=factura;
	}
	
	public LocalDate getCheckIN() {
		return this.CheckIn;
	}
	
	public LocalDate getCheckOUT() {
		return this.CheckOut;
	}
	public String getEstadoReserva() {
		return this.estado.getEstado();
	}
	
}
