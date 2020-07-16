package principal;

import java.util.Arrays;
import java.util.List;

import model.Persona;

public class Test4 {

	public static void main(String[] args) {
		List<Persona> lista = Arrays.asList(new Persona("Alex","al@gg.com",55555,20),				
				new Persona("Juan","alfd@gg.com.ar",55555,20),
				new Persona("Elena","al@gg.es",42332,17),
				new Persona("Marta","alaaoi@gg.com",121,34),
				new Persona("Lucas","alert@gg.org",6667,44),
				new Persona("Alicia","sdfl@gg.com",2121,14));
		
		lista.forEach(p->p.setEdad(p.getEdad()+1));
		lista.forEach(p->System.out.println(p.getEdad()));
	}

}
