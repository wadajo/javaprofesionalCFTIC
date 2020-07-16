package principal;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

import model.Persona;
import service.PersonaService;

public class ManipularPersonas {

	public static void main(String[] args) {
		List<Persona> lista = Arrays.asList(new Persona("Alex","al@gg.com",55555,20),				
				new Persona("Juan","alfd@gg.com.ar",55555,20),
				new Persona("Elena","al@gg.es",42332,17),
				new Persona("Marta","alaaoi@gg.com",121,34),
				new Persona("Lucas","alert@gg.org",6667,44),
				new Persona("Alicia","sdfl@gg.com",2121,14));
		PersonaService service = new PersonaService();
		
		System.out.println("Personas mayores de edad: ");
		service.imprimir(lista, p->p.getEdad()>=18);
		/*
		System.out.println("Buscar personas con email cuyo dominio finalice en... ");
		Scanner sc = new Scanner(System.in);
		String contiene = sc.nextLine();	
		service.imprimir(lista, p->p.getEmail().endsWith(contiene));
	
		System.out.println("Dadme un número de teléfono y te diré los números menores que aquel: ");
		Scanner sc2 = new Scanner(System.in);
		int numero = Integer.parseInt(sc2.nextLine());
		service.imprimir(lista, n->n.getTelefono()<=numero);
		sc2.close();
		*/
		
		//parte 4 imprime el email de las personas cuya edad esté comprendida entre 20 y 40
		service.imprimir(lista, p->p.getEdad()>=20&&p.getEdad()<=40, p->p.getEmail());
		
		//parte 5: imprime el email de las personas cuyo nombre empiece por A
		service.procesar(lista, p->p.getNombre().startsWith("A"), p->{System.out.println("Personas cuyo nombre empieza por A (sus emails): "+p.getEmail());});
	}

}
