package co.com.reservas.infrastructure.repositories.database.impl;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import co.com.reservas.domain.repositories.database.DatabaseServiceLocator;
import co.com.reservas.domain.repositories.database.IDatabaseOperations;

public class DatabaseOperationsImpl implements IDatabaseOperations {

	@Override
	public <T> List<T> listar(String namedQueryName, Map<String, Object> parametros,Class<T> clazz){
		EntityManager entityManager = DatabaseServiceLocator.getEntityManager();
		Query query = entityManager.createNamedQuery(namedQueryName);
		if(parametros!= null){
			for (Map.Entry<String, Object> entry : parametros.entrySet()) {
				query.setParameter((String) entry.getKey(), entry.getValue());
			}
		}
		return query.getResultList();
	}
}
