package principal;

import java.util.Scanner;
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
				servicio.procesarPedido();
				break;
			case 3:
				System.out.println("Introduce el Código del pedido a priorizar: ");
				String idAPriorizar = sc.nextLine();
				servicio.priorizarPedido(idAPriorizar);
				System.out.println("Has priorizado el Pedido "+idAPriorizar);
				break;
			case 4:
				 System.out.println("La facturación pendiente es de "+servicio.facturacionPendiente()+" euros.");
				break;
			case 5:
				System.out.println("Pedidos pendientes: ");
				servicio.mostrarPendientes();
				break;
			case 6:
				System.out.println("Introduce el código del pedido a procesar: ");
				String idAProcesar = sc.nextLine();
				if (servicio.procesarPedidoXId(idAProcesar)) {
					System.out.println("Se ha procesado el Pedido: "+idAProcesar);
				} else {
					System.out.println("No se ha podido procesar el Pedido: "+idAProcesar);
				}
				break;
			case 7:	
				System.out.println("Introduce parte del nombre de los productos a procesar: ");
				String producto2 = sc.nextLine();
				servicio.procesarPedidoXProducto(producto2);
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
