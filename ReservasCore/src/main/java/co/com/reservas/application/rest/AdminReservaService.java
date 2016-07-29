package co.com.reservas.application.rest;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import co.com.reservas.domain.Vuelos;
import co.com.reservas.domain.repositories.IRepositoryReserva;

@Path("reserva")
public class AdminReservaService {
	
	@Inject
	@Named("ReservasRepositoryStubImpl")
	private IRepositoryReserva reservasRepository;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("listarHorario/{horaInicial}/{horaFinal}")
	public List<Vuelos> listarByHora(@PathParam("horaInicial")Integer horaInicial,@PathParam("horaInicial")Integer horaFinal){
		return reservasRepository.listarReservasPorHora(horaInicial,horaFinal);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("listarTarifa/{horaInicial}/{horaFinal}")
	public List<Vuelos> listarByTarifa(@PathParam("min")Integer horaInicial,@PathParam("horaInicial")Integer horaFinal){
		return reservasRepository.listarReservasPorTarifa(horaInicial,horaFinal);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("listarEstado/{estado}")
	public List<Vuelos> listarByTarifa(@PathParam("estado")String estado){
		return reservasRepository.listarReservasPorEstado(estado);
	}
	
	
}
