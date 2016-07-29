package co.com.reservas.infrastructure.repositories.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

import javax.inject.Named;

import co.com.reservas.domain.Vuelos;
import co.com.reservas.domain.repositories.IRepositoryReserva;

@Named("ReservasRepositoryStubImpl")
public class ReservasRepositoryStubImpl implements IRepositoryReserva{
	
	private static Map<Integer,String> rutas = new HashMap<>();
	static{
		rutas.put(1, "Medellin-Cali");
		rutas.put(2, "Medellin-Bogota");
		rutas.put(3, "Medellin-Barranquilla");
		rutas.put(4, "Medellin-San Andres");
	}

	private List<Vuelos> getData(int number) {
		List<Vuelos> reservas = new ArrayList<>();
		for (int i = 0; i < number; i++) {
			
			reservas.add(getReserva());
		}
		return reservas;
	}
	
	public Vuelos getReserva(){
		int id =ThreadLocalRandom.current().nextInt(1, 20);
		int tarifa = ThreadLocalRandom.current().nextInt(100000, 2000000);
		int hora   = ThreadLocalRandom.current().nextInt(0, 24);
		int estado = ThreadLocalRandom.current().nextInt(1, 3);
		return new Vuelos(id,rutas.get(estado),estado,hora,tarifa);
	}

	@Override
	public List<Vuelos> listarReservasPorHora(Integer horaInicial,	Integer horaFinal) {
		return getData(4);
	}

	@Override
	public List<Vuelos> listarReservasPorTarifa(Integer min, Integer max) {
		return getData(7);
	}

	@Override
	public List<Vuelos> listarReservasPorEstado(String estado) {
		return getData(5);
	}

}
