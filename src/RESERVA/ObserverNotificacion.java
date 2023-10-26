package RESERVA;

import HOTEL.Cliente;

public interface ObserverNotificacion {
	public void notificar(String mensaje,Cliente cliente);
}
