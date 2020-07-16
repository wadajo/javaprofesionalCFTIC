package principal;

import java.util.Arrays;
import java.util.List;

import model.Persona;

public class Test5 {

	public static void main(String[] args) {
		List<Persona> lista = Arrays.asList(new Persona("Alex","al@gg.com",55555,20),				
				new Persona("Juan","alfd@gg.com.ar",55555,20),
				new Persona("Elena","al@gg.es",42332,17),
				new Persona("Marta","alaaoi@gg.com",121,34),
				new Persona("Lucas","alert@gg.org",6667,44),
				new Persona("Alicia","sdfl@gg.com",2121,14));
		
		lista.sort((p1,p2)->(p1.getEdad()>p2.getEdad())?1:-1);
		lista.sort((p1,p2)->(p1.getEdad()-(p2.getEdad()))); //otra manera de ordenarlos
		lista.forEach(p->System.out.println(p.getEdad()));
	}

}
