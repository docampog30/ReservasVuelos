package co.com.reservas.domain;

public class Vuelos {
	private int 	id;
	private String 	ruta;
	private int 	estado;
	private int 	hora;
	private Integer tarifa;
	
	public Vuelos(int id, String ruta, int estado, int hora, Integer tarifa) {
		super();
		this.id = id;
		this.ruta = ruta;
		this.estado = estado;
		this.hora = hora;
		this.tarifa = tarifa;
	}

	public Vuelos() {
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public int getHora() {
		return hora;
	}

	public void setHora(int hora) {
		this.hora = hora;
	}

	public Integer getTarifa() {
		return tarifa;
	}

	public void setTarifa(Integer tarifa) {
		this.tarifa = tarifa;
	}
}
