package co.com.reservas.infrastructure.repositories.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import co.com.reservas.domain.Vuelos;
import co.com.reservas.domain.repositories.IRepositoryReserva;
import co.com.reservas.domain.repositories.database.IDatabaseOperations;
import co.com.reservas.infrastructure.constants.ApplicationConstant;

@Named("ReservasRepositoryImpl")
public class ReservasRepositoryImpl implements IRepositoryReserva {
	@Inject
	private IDatabaseOperations databaseOperations;

	@Override
	public List<Vuelos> listarReservasPorHora(Integer horaInicial,Integer horaFinal) {
		Map<String, Object> parametros = getMap();
		parametros.put("horaInicial", horaInicial);
		parametros.put("horaFinal", horaFinal);
		return databaseOperations.listar(ApplicationConstant.BUSCAR_POR_HORA, parametros,Vuelos.class);
	}

	@Override
	public List<Vuelos> listarReservasPorTarifa(Integer min, Integer max) {
		Map<String, Object> parametros = getMap();
		parametros.put("tarifamin", min);
		parametros.put("tarifamax", max);
		return databaseOperations.listar(ApplicationConstant.BUSCAR_POR_TARIFA,parametros,Vuelos.class);
	}

	@Override
	public List<Vuelos> listarReservasPorEstado(String estado) {
		Map<String, Object> parametros = getMap();
		parametros.put("estado", estado);
		return databaseOperations.listar(ApplicationConstant.BUSCAR_POR_ESTADO, parametros,Vuelos.class);
	}
	
	private Map<String, Object> getMap() {
		return new HashMap<>();
	}
}
