package service;

import java.util.Collection;
import java.util.HashMap;
import model.Contacto;

/* Nuevo contacto, Recuperar contacto, Elminar contacto, Mostrar todos
 * 
 */

public class AgendaService {
	HashMap<String, Contacto> misContactos = new HashMap<>();
	
	public boolean agregarContacto (Contacto c1) {
		if (!existeContacto(c1.getEmail())) {
			misContactos.put(c1.getEmail(), c1);
			return true;
		}
		return false;
	}
	
	public Contacto buscarContacto(String busqueda) {
		return misContactos.get(busqueda);		
	}
	
	public boolean eliminarContacto (String busqueda) {
		if (misContactos.containsKey(busqueda)){
			misContactos.remove(busqueda);
			return true;
		}
		return false;
	}
	
	public Contacto[] mostrarContactos(){		
		Collection<Contacto> valores=misContactos.values();
		return valores.toArray(new Contacto[0]);
	}

	private boolean existeContacto(String emailComprobar) {
		Collection<Contacto> miArray = misContactos.values();
		for (Contacto c : miArray) {
			if (c.getEmail().equalsIgnoreCase(emailComprobar)) {
				return true;
			}
		}
		return false;
	}
}
