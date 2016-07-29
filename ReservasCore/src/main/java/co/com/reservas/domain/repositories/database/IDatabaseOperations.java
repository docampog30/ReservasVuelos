package co.com.reservas.domain.repositories.database;

import java.util.List;
import java.util.Map;

public interface IDatabaseOperations {
	<T> List<T> listar(String namedQueryName, Map<String, Object> parametros,Class<T> clazz);
}