package principal;

import java.util.Scanner;

public class Buscador12 {

	public static void main(String[] args) {
		String titulos="La biblia de Java, Python básico,Angular en un día, Programación Web con Java EE, Spring Boot, Fundamentos de Python, Java y Spring, la biblia de php";
		String[] titulosSeparados = titulos.split(", |,");
				
		System.out.println("Introduce tu búsqueda: ");
		Scanner sc = new Scanner(System.in);
		String textoBuscado = sc.nextLine();
		
		System.out.println("Estos son los libros que resultan de tu búsqueda: ");
		
		for (String n:titulosSeparados) {	
			if(n.toLowerCase().indexOf(textoBuscado.toLowerCase())!=-1) {
				System.out.println(n);
			}		
	}
		sc.close();
	}
}

