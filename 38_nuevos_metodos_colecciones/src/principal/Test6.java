package principal;

import java.util.HashMap;
import model.Persona;

public class Test6 {

	public static void main(String[] args) {
		HashMap<String,Persona> listaPersonas = new HashMap<>();
		listaPersonas.put("f2f", new Persona("Alex","al@gg.com",55555,20));
		listaPersonas.put("fsafas",new Persona("Juan","alfd@gg.com.ar",55555,20));
		listaPersonas.put("f35hf",new Persona("Elena","al@gg.es",42332,17));
		listaPersonas.put("da24fas",new Persona("Marta","alaaoi@gg.com",121,34));
		listaPersonas.put("fas3fg3",new Persona("Lucas","alert@gg.org",6667,44));
		listaPersonas.put("s35",new Persona("Alicia","sdfl@gg.com",2121,14));
		listaPersonas.forEach((k,v)->System.out.println(k+": "+v.getNombre()+", "+v.getEdad()));
		
		//devuelve todos con edad 10 años más
		listaPersonas.replaceAll((k,v)->new Persona(v.getNombre(),v.getEmail(),v.getTelefono(),v.getEdad()+10));
		listaPersonas.forEach((k,v)->System.out.println(k+": "+v.getNombre()+", "+v.getEdad()));
		
		//si la clave es mayor que 4 caracteres, le doy a esa persona 10 años más; si es de menos de
		// 4 caracteres, le doy un nuevo nombre que le concatena la edad
		listaPersonas.replaceAll((k,v)->k.length()>5?
				new Persona(v.getNombre(),v.getEmail(),v.getTelefono(),v.getEdad()+10):
					new Persona(v.getNombre()+v.getEdad(),v.getEmail(),v.getTelefono(),v.getEdad()));
		listaPersonas.forEach((k,v)->System.out.println(k+": "+v.getNombre()+", "+v.getEdad()));
	}

}
