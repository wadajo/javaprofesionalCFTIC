package principal;

import java.util.ArrayList;
import java.util.Scanner;

public class ProgramaTemperaturas {

	public static void main(String[] args) {
		// 1. Nueva temperatura
		// 2. Temperatura media
		// 3. Temperaturas extremas
		// 4. Mostrar todas
		// 0. Salir
		int selector = 0;
		ArrayList<Double> temperaturas = new ArrayList<>();
		Scanner scNros = new Scanner(System.in);
		
	do {	
		menu();
		selector = scNros.nextInt();
		switch (selector) {
		case 1:
			agregarTemperatura(temperaturas);
			System.out.println("Has añadido un dato de temperatura.");
			break;
		case 2:
			mostrarMedia(temperaturas);
			break;
		case 3:
			mostrarExtremos(temperaturas);
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
	scNros.close();
	}
	
	static void mostrarTodas(ArrayList<Double> temperaturas) {
		System.out.println("Temperaturas registradas: ");
		for (Double n:temperaturas) {
			System.out.println(n+" grados.");
		}			
	}

	static void mostrarExtremos(ArrayList<Double> temperaturas) {
		double max=temperaturas.get(0);
		double min=temperaturas.get(0);
		for (Double n:temperaturas) {
			max=(n>max)?n:max;
			min=(n<min)?n:min;
		}
		System.out.println("La temperatura máxima ha sido: "+max+" grados y la mínima: "+min+" grados.");
	}

	static void mostrarMedia(ArrayList<Double> temperaturas) {
		double suma=0;		
		for (Double n:temperaturas) {
			suma+=n;
		}
		System.out.println("Esta es la media de temperaturas: "+suma/temperaturas.size());
	}

	static void agregarTemperatura(ArrayList<Double> temperaturas) {
		System.out.println("Añade una temperatura: ");		
		Scanner scNros = new Scanner(System.in);
		temperaturas.add(scNros.nextDouble());		
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
