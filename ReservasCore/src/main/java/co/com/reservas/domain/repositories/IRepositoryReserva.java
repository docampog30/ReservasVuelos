package co.com.reservas.domain.repositories;

import java.util.List;

import co.com.reservas.domain.Vuelos;


public interface IRepositoryReserva {
	List<Vuelos> listarReservasPorHora(Integer horaInicial, Integer horaFinal);
	List<Vuelos> listarReservasPorTarifa(Integer min, Integer max);
	List<Vuelos> listarReservasPorEstado(String estado);
}
