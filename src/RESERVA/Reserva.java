package RESERVA;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import FACTURA.EstadoFactura;
import FACTURA.Factura;
import HOTEL.*;
import HABITACION.Extras;
import HABITACION.Habitacion;
import HABITACION.Paquete;

public class Reserva {
	private ITiempoReservado fechaReservado;
	private LocalDate CheckIn;
	private LocalDate CheckOut;
	private Cliente cliente;
	private ArrayList<Huesped> huesped=new ArrayList<>();
	private EstadoReserva estado=new Registrada();
	private Habitacion habitacion;
	private double monto;
	private Paquete packExtras;
	private Factura factura;
	
	public Reserva(LocalDate checkIn, LocalDate checkOut, Cliente cliente, ArrayList<Huesped> huesped,Habitacion habitacion, ArrayList<Extras> extras) {
		LocalDate fActual=LocalDate.now();
		
		//esta raro estos ifs
		if(ChronoUnit.MONTHS.between(fActual,checkIn)>=2) {
			this.fechaReservado=new Dos_Meses_Anticipado();
		}else if(ChronoUnit.DAYS.between(fActual,checkIn)>=15) {
			this.fechaReservado=new Quince_DiasAnticipado();
		}else {
			this.fechaReservado=new SinAnticipacion();
		}
		
		this.packExtras=new Paquete(extras);
		this.CheckIn = checkIn;
		this.CheckOut = checkOut;
		this.cliente = cliente;
		this.huesped = huesped;
		this.habitacion = habitacion;
		
		this.monto=habitacion.getPrecio() + packExtras.calcularMonto();
		
		double descuento=( monto * this.fechaReservado.getDescuento())/100;
		monto-= descuento;
		
	}
	
	private double getPrecioExtras() {
		return this.packExtras.calcularMonto();
	}
	
	public String getEstadoFactura() {
		return this.factura.getEstadoFactura().getEstado();
	}
	
	
	public void pagar() {
		cambiarEstado();
	}
	
	public void cambiarEstado() {
		estado.cambiarEstado();
		notificar();
	}
	
	
	
	public void agregarExtra(Extras nuevo) {
		this.packExtras.agregarExtra(nuevo);
	}
	
	public void quitarExtra(Extras sacar) {
		this.packExtras.sacarExtra(sacar);
	}
	
	public void notificar() {
		//desarrollar
	}
	
}
