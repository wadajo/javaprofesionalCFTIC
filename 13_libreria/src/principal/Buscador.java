package principal;

import java.util.Scanner;

public class Buscador {
	static StringBuilder titulos = new StringBuilder("");
	static Scanner scNros = new Scanner(System.in);
	static Scanner scTxt = new Scanner(System.in);

	public static void main(String[] args) {
		int selector = 0;

		do {
			System.out.println("Menú (pulsa número para seleccionar): ");
			System.out.println("1. Agregar libro");
			System.out.println("2. Buscar libro");
			System.out.println("3. Eliminar libro");
			System.out.println("4. Mostrar títulos");
			System.out.println("5. Salir");

			selector = scNros.nextInt();

			switch (selector) {
			case 1:
				agregarTitulos(titulos);
				System.out.println("Has añadido el título. Actualmente están: " + titulos);
				break;
			case 2:
				buscarLibro();
				break;
			case 3:
				borrarLibros();
				break;
			case 4:
				mostrarTitulos();
				break;
			default:
				System.out.println("Has salido.");
			}
		} while (selector != 5);
		System.out.println("Hasta luego!");
		scNros.close();
		scTxt.close();
	}

	private static void mostrarTitulos() {
		String[] titulosSeparados = titulos.deleteCharAt(titulos.length() - 1).toString().split(", |,");
		System.out.println("Estos son los libros de la biblioteca: ");
		for (String n : titulosSeparados) {
				System.out.println(n);			
		}
	}

	static void buscarLibro() {
		String[] titulosSeparados = titulos.deleteCharAt(titulos.length() - 1).toString().split(", |,");

		System.out.println("Introduce tu búsqueda: ");
		String textoBuscado = scTxt.nextLine();

		System.out.println("Estos son los libros que resultan de tu búsqueda: ");

		for (String n : titulosSeparados) {
			if (n.toLowerCase().indexOf(textoBuscado.toLowerCase()) != -1) {
				System.out.println(n);
			}
		}

	}

	static void agregarTitulos(StringBuilder titulos) {
		System.out.println("Introduce un título para agregar: ");
		String titulo = scTxt.nextLine();
		titulos = titulos.append(titulo);
		titulos = titulos.append(", ");
	}



	static void borrarLibros() {
		String[] titulosSeparados = titulos.
				deleteCharAt(titulos.length()-1).
				toString().
				split(", |,");
	
		System.out.println("Introduce la búsqueda de libros a borrar: ");
		String textoBuscado = scTxt.nextLine();
	
		System.out.println("Estos son los libros que borrarás: ");
	
		for (String n:titulosSeparados) {	
			if(n.toLowerCase().indexOf(textoBuscado.toLowerCase())!=-1) {
				System.out.println("El libro"+ n);
				int inicio = n.indexOf(textoBuscado);
				int end = inicio+textoBuscado.length();
				System.out.println("¿Deseas borrar este libro? S / N");
				if (scTxt.nextLine().equalsIgnoreCase("S")) {
					titulos.delete(inicio, end);
					System.out.println("Has borrado el libro "+n);
				} else {
					System.out.println("No borrarás este libro.");
				}
			}		
		}
		
		
	}
	
}