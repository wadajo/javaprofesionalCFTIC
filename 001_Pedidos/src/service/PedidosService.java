package service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import model.Pedido;

public class PedidosService {
	private List<Pedido> pedidos = new ArrayList<>();
	private double facturacion=0.0;
	
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
		return (pedidos.isEmpty())?null:pedidos.remove(0);
	}
	
	public boolean procesarPedido (String idAProcesar) {
		return pedidos.removeIf(p->idAProcesar.equalsIgnoreCase(p.getId()));
	}
	
	public void procesarPedidoProducto (String producto) {
		pedidos.removeIf(p->p.getProducto().contains(producto));
	}
	
	public double facturacionPendiente() {
		pedidos.forEach(p->facturacion+=p.getPrecio());
		return facturacion;
	}	
	/*
	public Pedido priorizarPedido (Pedido pNuevo) {
		if (comprobar(pedidos, p->pedidos.contains(pNuevo))) {
			//priorizar
		}
	}
	*/
	public void mostrarPendientes() {
		pedidos.forEach(p->System.out.print(p+", ")); 
	}
	/* otra manera
	public List<Pedido> mostrarPendientes() {
		return pedidos;
	}
	*/
	
	public boolean comprobar (List<Pedido> pedidos, Predicate<Pedido> condicion) {
		for (Pedido p : pedidos) {
			if (condicion.test(p)) {				
			return true;
	}	
	}return false;
	}
	
	public void procesar (List<Pedido> pedidos, Predicate<Pedido> condicion, Consumer<Pedido> hacer) {
		for (Pedido p : pedidos) {
			if (condicion.test(p)) {
				hacer.accept(p);
			}
		}
	}
}
