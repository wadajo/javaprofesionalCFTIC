package principal;

import java.util.ArrayList;
import java.util.Scanner;

import model.Movimiento;
import service.CuentaServiceMovimiento;

public class Cajero {
	/*
	 * Saldo inicial Límite de cantidades Luego Menú: Ingresar Extraer Consulta de
	 * movimientos y saldo Salir
	 */
	public static void main(String[] args) {
		CuentaServiceMovimiento servicio = new CuentaServiceMovimiento(0, 100);
		Scanner sc = new Scanner(System.in);
		int selector = 0;
		System.out.println("Gracias por abrir tu cuenta en nuestro banco.\nTu saldo es de "+servicio.getSaldo()+" euros y tu límite, "+servicio.getLimite()+" euros.");
		System.out.println("Elige tu operación: ");
	do {
		menu();
		selector = Integer.parseInt(sc.nextLine());
		switch (selector) {
		case 1:
			System.out.println("Introduce la cantidad a ingresar: ");
			servicio.ingresar(Double.parseDouble(sc.nextLine()));
			break;
		case 2:
			System.out.println("Introduce la cantidad a extraer: ");
			servicio.extraer(Double.parseDouble(sc.nextLine()));
			break;
		case 3:
			consultarMovimientos(servicio);
			break;
		case 4:
			System.out.println("Saldo actual: "+servicio.getSaldo()+" euros.\n"); 
			break;
		case 0:
			System.out.println("Has salido. ¡Hasta luego!");
			break;
		default:
			System.out.println("Ingresa una opción válida.");
		}
	}while (selector!=0);
	sc.close();
	}

	private static void consultarMovimientos(CuentaServiceMovimiento servicio) {
		ArrayList<Movimiento> misMovimientos = servicio.mostrarMovimientos();
		for (Movimiento m : misMovimientos) {
			int i=1;
			System.out.println("Movimiento "+i+": "+m);
			i++;
		}
		System.out.println("Saldo actual: "+servicio.getSaldo()+" euros.\n"); 
	}

	private static void menu() {
		System.out.println("1. Ingresar dinero");
		System.out.println("2. Extraer dinero");
		System.out.println("3. Consultar movimientos");
		System.out.println("4. Consultar saldo");
		System.out.println("0. Salir");
	}

}
