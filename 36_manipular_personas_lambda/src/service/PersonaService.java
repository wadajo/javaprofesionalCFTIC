package service;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import model.Persona;

public class PersonaService {

	public void imprimir (List<Persona> personas, Predicate<Persona> condicion) {
		for (Persona p : personas) {
			if (condicion.test(p)) {
			System.out.println("Nombre de la persona que cumple: "+p.getNombre());
	}
	}
	}

	public void imprimir(List<Persona> personas, Predicate<Persona> condicion, Function<Persona,String> transformacion) {
		//en Function, el primer tipo genérico es el parámetro, 
		//y el segundo (String acá) es la devolución del método apply
		for (Persona p : personas) {
			if (condicion.test(p)) {
				System.out.println("Estas personas cumplen la otra condicion: "+transformacion.apply(p));
			}
		}
	}
	
	public void procesar (List<Persona> personas, Predicate<Persona> condicion, Consumer<Persona> hacer) {
		for (Persona p : personas) {
			if (condicion.test(p)) {
				hacer.accept(p);
			}
		}
	}
}