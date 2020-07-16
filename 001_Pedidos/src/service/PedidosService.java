package service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

import model.Pedido;

public class PedidosService {
	private List<Pedido> pedidos = new ArrayList<>();
	private double facturacion=0.0;
	
	private Pedido obtenerPedido (String idAObtener) {
		for(Pedido p:pedidos) {
			if(p.getId().equalsIgnoreCase(idAObtener)) {
				return p;
			}
		}
		return null;
	}
	
	public Pedido agregarPedido (String id, String producto, int precio) {
		Pedido pNuevo = new Pedido(id,producto,precio);
		if (!comprobar(pedidos, p->pedidos.contains(pNuevo))) {
			pedidos.add(pNuevo);
			return pNuevo;
		} else {
			System.out.println(pNuevo+" ya existe en la base.");
			return null;}
	}
	
	public Pedido procesarPedido () {
		if (!pedidos.isEmpty()) {
			System.out.print("Se ha procesado el primer pedido en la cola, "+ pedidos.get(0));
			return pedidos.remove(0);
		}
		else {
			System.out.println("No hay más pedidos en la cola.");
			return null;
		}
	}
	
	public boolean procesarPedidoXId (String idAProcesar) {
		//usando método comprobar definido por mí utilizando interfaces funcionales y exp lambda
		if (comprobar(pedidos, p->idAProcesar.equalsIgnoreCase(p.getId()))) {
			pedidos.remove(pedidos.indexOf(obtenerPedido(idAProcesar)));
			return true;
			}	
		return false;
		
		//otra manera, más simple
		//return pedidos.removeIf(p->idAProcesar.equalsIgnoreCase(p.getId()));
	}
	
	public void procesarPedidoXProducto (String producto) {
		if (pedidos.removeIf(p->p.getProducto().contains(producto)))
			System.out.println("Se han procesado los pedidos de productos "+producto);;
	}
	
	public double facturacionPendiente() {
		facturacion=0.0; //ñapa, pensar otra manera
		pedidos.forEach(p->facturacion+=p.getPrecio());
		return facturacion;
	}	
	
	public Pedido priorizarPedido (String pNuevo) {
		Pedido prioritario,anterior;
		prioritario=obtenerPedido(pNuevo);
		if(prioritario!=null) {
			int pos=pedidos.indexOf(prioritario);
			//confirmo que no esté ya en la primera posición
			if(pos>0) {
				//se cambia por el auxiliar, que va en su lugar, menos prioritario
				anterior=pedidos.get(pos-1);
				pedidos.set(pos-1, prioritario);
				pedidos.set(pos, anterior);
			}
		}
		return prioritario;
	}
	
	public void mostrarPendientes() {
		pedidos.forEach(p->System.out.print(p+", ")); 
	}
	/* otra manera
	public List<Pedido> mostrarPendientes() {
		return pedidos;
	}
	*/
	
	//usada OK, para comprobar si existe un Pedido en la lista con determinado ID
	public boolean comprobar (List<Pedido> pedidos, Predicate<Pedido> condicion) {
		for (Pedido p : pedidos) {
			if (condicion.test(p)) {				
			return true;
	}	
	}return false;
	}
	
	//no usada, podría servir para ingresar pedidos tras comprobar que no existan con ese ID
	public void procesar (List<Pedido> pedidos, Predicate<Pedido> condicion, Consumer<Pedido> hacer) {
		for (Pedido p : pedidos) {
			if (condicion.test(p)) {
				hacer.accept(p);
			}
		}
	}
	
	//no usada, podría obtener productos a partir de ID tras comprobar que existan en la base
	public Pedido obtenerProducto (List<Pedido> pedidos, Predicate<Pedido> condicion, Supplier<String> devolver) {
		for (Pedido p : pedidos) {
			if (condicion.test(p)) {
				return obtenerPedido(devolver.get());
			}			
		}
		return null;		
	}
}
