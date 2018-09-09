package socket.operacion.dto;

import java.io.Serializable;

public class MensajeSecretoDTO implements Serializable{
	
	 private String idSoldadp;
	 private String coordenada;
	 private String mensajeSoldado;
	 
	 private String respuestaTorre;
	 
	 
	public String getRespuestaTorre() {
		return respuestaTorre;
	}
	public void setRespuestaTorre(String respuestaTorre) {
		this.respuestaTorre = respuestaTorre;
	}
	public String getIdSoldadp() {
		return idSoldadp;
	}
	public void setIdSoldadp(String idSoldadp) {
		this.idSoldadp = idSoldadp;
	}
	public String getCoordenada() {
		return coordenada;
	}
	public void setCoordenada(String coordenada) {
		this.coordenada = coordenada;
	}
	public String getMensajeSoldado() {
		return mensajeSoldado;
	}
	public void setMensajeSoldado(String mensajeSoldado) {
		this.mensajeSoldado = mensajeSoldado;
	}
	 
	  
	 
}
