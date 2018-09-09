package socket.operacion.ataque;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

import socket.operacion.dto.MensajeSecretoDTO;

public class SoldadoTerminalCliente {
	
	private static final int PuertoUltraSecreto = 5544;
	private static final String HostTorreControl = "localhost";
	
	public static void main(String[] args) {
		try {
			System.out.println("Soldado Delta 1 - Intentando conectarse.");
			Socket socket = new Socket(HostTorreControl, PuertoUltraSecreto);
			
			ObjectOutputStream flujoSalida = new ObjectOutputStream(socket.getOutputStream());
			System.out.println("Preparando envio de mensaje.");
			
			
			MensajeSecretoDTO mensaje = new MensajeSecretoDTO();
			mensaje.setIdSoldadp( "Delta1");
			mensaje.setCoordenada("LT. 14.44.44");
			mensaje.setMensajeSoldado("Objetivo en la Mira permiso para atcar");
			flujoSalida.writeObject(mensaje);
			
			MensajeSecretoDTO mensaje1 = new MensajeSecretoDTO();
			mensaje1.setIdSoldadp( "Delta1");
			mensaje1.setCoordenada("LT. 14.44.44");
			mensaje1.setMensajeSoldado("Objetivo en la Mira permiso para atcar");
			
			List<MensajeSecretoDTO> lista = new  List<MensajeSecretoDTO>() ;
			
			
			flujoSalida.writeObject(mensaje);
			System.out.println("Mensaje enviado.");
			
			ObjectInputStream flujoEntrada = new ObjectInputStream(socket.getInputStream());
			
			MensajeSecretoDTO msj = (MensajeSecretoDTO) flujoEntrada.readObject();
			
			System.out.println("Respuesta de control "+msj.getRespuestaTorre());
			
			
			
			socket.close();
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Conexi�n F�llida");
		}
	}
}
