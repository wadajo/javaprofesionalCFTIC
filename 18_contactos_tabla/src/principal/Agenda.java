package principal;

import java.util.Scanner;

import model.Contacto;
import service.AgendaService;

public class Agenda {

	public static void main(String[] args) {
		AgendaService servicio = new AgendaService();
		Scanner sc = new Scanner(System.in);
		int selector = 0;
	do {
		menu();
		selector = Integer.parseInt(sc.nextLine());
		switch (selector) {
		case 1:
			ingresarContacto(servicio);
			break;
		case 2:
			busqueda(servicio);
			break;
		case 4:
			mostrar(servicio);
			break;
		case 0:
			System.out.println("Has salido.");
			break;
		default:
			System.out.println("Elige una opción válida.");
		}	
	}while (selector!=0);
	}

	private static void mostrar(AgendaService servicio) {
		Contacto[] todos = servicio.mostrarContactos();
		for (Contacto c : todos) {
			System.out.println("Nombre: "+c.getNombre()+"| Teléfono: "+c.getTelefono()+"| Email: "+c.getEmail());
		}
	}

	private static void busqueda(AgendaService servicio) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Ingresa el email del contacto que deseas: ");
		String busqueda = sc.nextLine();
		if (null!=servicio.buscarContacto(busqueda)) {
			Contacto encontrado = servicio.buscarContacto(busqueda);
			System.out.println("Se ha encontrado el contacto. Además de ese email, sus datos son: ");
			System.out.println("Nombre: "+encontrado.getNombre());
			System.out.println("Teléfono: "+encontrado.getTelefono());
		}
	}

	private static void ingresarContacto(AgendaService servicio) {
		Scanner sc = new Scanner(System.in);		
		System.out.println("Añade el nombre del contacto: ");
		String nombre = sc.nextLine();
		System.out.println("Añade su email: ");
		String email = sc.nextLine();
		System.out.println("Añade su teléfono: ");
		String telefono = sc.nextLine();
		Contacto c1 = new Contacto(nombre, email, telefono);
		if (servicio.agregarContacto(c1)) {
			System.out.println("Has añadido un contacto con éxito.");
		} else {
			System.out.println("Ya has añadido ese contacto. Ingresa uno nuevo.");
		}
	}

	private static void menu() {
		System.out.println("\nMenú (pulsa número para seleccionar): ");
		System.out.println("1. Ingresar nuevo contacto");
		System.out.println("2. Buscar contacto");
		System.out.println("3. Eliminar contacto");
		System.out.println("4. Mostrar todos los contactos");
		System.out.println("0. Salir");
	}

}
