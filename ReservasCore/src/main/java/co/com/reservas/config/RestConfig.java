package co.com.reservas.config;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import co.com.reservas.application.rest.AdminReservaService;

public class RestConfig extends Application
{
   @Override
   public Set<Class<?>> getClasses(){
      Set<Class<?>> classes = new HashSet<>();
      classes.add(AdminReservaService.class);
      return classes;
   }
}
