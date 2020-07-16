package principal;

import java.util.ArrayList;
import java.util.Scanner;
import model.Pedido;
import service.PedidosService;

public class Home {
	
	public static void main(String[] args) {
		
		PedidosService servicio = new PedidosService();
		Scanner sc = new Scanner(System.in);
		int selector = 0;
		System.out.println("Gestión de pedidos: ");
		do {
			menu();
			selector = Integer.parseInt(sc.nextLine());
			switch (selector) {
			case 1:				
				System.out.println("Introduce los datos del pedido: ");
				System.out.println("Código del pedido: ");
				String id = sc.nextLine();
				System.out.println("Producto: ");
				String producto = sc.nextLine();
				System.out.println("Precio: ");
				int precio = Integer.parseInt(sc.nextLine());
				servicio.agregarPedido(id, producto, precio);
				break;
			case 2:
				System.out.println("Se ha procesado el primer pedido en la cola, cuyo Código era "+servicio.procesarPedido().getId());
				break;
			case 3:
				//priorizar pedido
				break;
			case 4:
				 //mostrar total de precios sumados de los productos de la cola
				break;
			case 5:
				System.out.println("Pedidos pendientes: ");
				servicio.mostrarPendientes();
				break;
			case 6:
				System.out.println("Introduce el código del pedido a procesar: ");
				String idAProcesar = sc.nextLine();
				if (servicio.procesarPedido(idAProcesar)) {
					System.out.println("Se ha procesado el Pedido: "+idAProcesar);
				} else {
					System.out.println("No se ha podido procesar el Pedido: "+idAProcesar);
				}
				break;
			case 7:	
				System.out.println("Introduce parte del nombre de los productos a procesar: ");
				String producto2 = sc.nextLine();
				servicio.procesarPedidoProducto(producto2);
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
	
	private static void menu() {
		System.out.println("\n1. Agregar pedido.");
		System.out.println("2. Procesar pedido.");
		System.out.println("3. Priorizar pedido.");
		System.out.println("4. Facturación pendiente.");
		System.out.println("5. Pedidos pendientes.");
		System.out.println("6. Procesar un pedido particular.");
		System.out.println("7. Procesar pedidos de ciertos productos.");
		System.out.println("0. Salir");
	}

}
