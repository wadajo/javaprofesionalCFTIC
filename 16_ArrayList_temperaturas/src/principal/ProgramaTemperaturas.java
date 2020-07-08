package principal;

import java.util.ArrayList;
import java.util.Scanner;

import model.Registro;

public class ProgramaTemperaturas {

	public static void main(String[] args) {
		int selector = 0;
		ArrayList<Registro> temperaturas = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		
	do {	
		menu();
		selector = Integer.parseInt(sc.nextLine());
		switch (selector) {
		case 1:
			agregarTemperatura(temperaturas);			
			break;
		case 2:
			mostrarMedia(temperaturas);
			break;
		case 3:
			mostrarMayor(temperaturas);
			mostrarMenor(temperaturas);
			break;
		case 4:
			mostrarTodas(temperaturas);
			break;
		case 0:
			System.out.println("Has salido.");
			break;
		default:
			System.out.println("Elige una opción válida.");
		}
		
	}while (selector!=0);
	sc.close();
	}
	
	static void mostrarTodas(ArrayList<Registro> temperaturas) {
		System.out.println("Temperaturas registradas: ");
		for (Registro r:temperaturas) {
			System.out.print("Ciudad: "+r.getCiudad()+" con ");
			System.out.println(r.getTemperatura()+" grados.");
		}			
	}

	static Registro mostrarMenor(ArrayList<Registro> temperaturas) {
		Registro menor = temperaturas.get(0);
		double min=temperaturas.get(0).getTemperatura();
		for (Registro r:temperaturas) {
			min=(r.getTemperatura()<min)?r.getTemperatura():min;
			menor=r; //FIXME reemplazar el ternario por un if, porque si no, siempre carga acá el último registro
		}
		System.out.println("La temperatura mínima ha sido: "+menor.getTemperatura()+" grados en la ciudad "+menor.getCiudad());
		return menor;
	}
	
	static Registro mostrarMayor(ArrayList<Registro> temperaturas) {
		Registro mayor = temperaturas.get(0);
		double max=temperaturas.get(0).getTemperatura();
		for (Registro r:temperaturas) {
			max=(r.getTemperatura()>max)?r.getTemperatura():max;
			mayor=r; //FIXME reemplazar el ternario por un if, porque si no, siempre carga acá el último registro
		}
		System.out.println("La temperatura máxima ha sido: "+mayor.getTemperatura()+" grados en la ciudad "+mayor.getCiudad());
		return mayor;
	}

	static void mostrarMedia(ArrayList<Registro> temperaturas) {
		double suma=0;		
		for (Registro r:temperaturas) {
			suma+=r.getTemperatura();
		}
		System.out.println("Esta es la media de temperaturas: "+suma/temperaturas.size());
	}

	static void agregarTemperatura(ArrayList<Registro> temperaturas) {
		Scanner sc = new Scanner(System.in);		
		String ciudadNueva;
		
		System.out.println("Añade una ciudad: ");
		ciudadNueva=sc.nextLine();
		if (!hayCiudad(temperaturas, ciudadNueva)) {
			System.out.println("Añade una temperatura: ");		
			Double temperatura = Double.parseDouble(sc.nextLine());
			Registro r1 = new Registro(temperatura,ciudadNueva);
			temperaturas.add(r1);
			System.out.println("Has añadido un dato de temperatura.");
		} else {
			System.out.println("Ya has ingresado registros de esa ciudad, prueba otra...");
		}
	}
	
	static boolean hayCiudad (ArrayList<Registro> temperaturas, String ciudadNueva) {
		for (Registro r : temperaturas) {
			if (r.getCiudad().equalsIgnoreCase(ciudadNueva)) {
				return true;
			}
		}
		return false;
	}

	static void menu() {
		System.out.println("");
		System.out.println("Menú (pulsa número para seleccionar): ");
		System.out.println("1. Nueva temperatura");
		System.out.println("2. Temperatura media");
		System.out.println("3. Temperaturas extremas");
		System.out.println("4. Mostrar todas");
		System.out.println("0. Salir");
	}

}
