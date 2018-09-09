package socket.operacion.ataque;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import java.util.List;

import socket.operacion.dto.MensajeSecretoDTO;
public class ServidorTorreControl {

	private static final int PuertoUltraSecreto = 5544;
	private static ServerSocket servidor = null;
	
	
	public static void main(String[] args)  {
 
		try {
				
			 LevantarServidor();
				
		} catch (Exception e) {
			// TODO: handle exception
		}		
		 
	}
	
	
	private static void LevantarServidor() throws Exception {
		
		System.out.println("Inicio LevantarServidor...");
		servidor = new ServerSocket(PuertoUltraSecreto);
		System.out.println("Torre de control escuchando mensajes.");
		System.out.println("Fin LevantarServidor...");
		Socket socket = servidor.accept();
		System.out.println("Torre de control detecto un mensaje.");
		ObjectInputStream flujoEntrada = new ObjectInputStream(socket.getInputStream());
		
		List<MensajeSecretoDTO> lista = (List<MensajeSecretoDTO>) flujoEntrada.readObject();
		for (MensajeSecretoDTO msj : lista) {
			System.out.println("ID Soldado "+msj.getIdSoldadp());
			System.out.println("Coordenadas " + msj.getCoordenada());
			System.out.println("Mensaje " + msj.getMensajeSoldado());
			
			
			System.out.println("--------------------- " );
		}
				
	
 
		
		/*msj.setRespuestaTorre("Atacar");
		ObjectOutputStream FlujoSalida  = new ObjectOutputStream(socket.getOutputStream());
		FlujoSalida.writeObject(msj);
		*/
		
		socket.close();
				
	}
	
}
