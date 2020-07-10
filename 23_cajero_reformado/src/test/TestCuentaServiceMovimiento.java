package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import service.CuentaService;
import service.CuentaServiceMovimiento;

public class TestCuentaServiceMovimiento {
	CuentaServiceMovimiento service;
	
	
	@Before
	public void setUp() throws Exception {
		service = new CuentaServiceMovimiento(1000, 100);
	}
	@Test
	public void testExtraer() {
		service.extraer(80);
		assertEquals(920, service.getSaldo(),0);
	}

	@Test
	public void testIngresar() {
		service.ingresar(200);
		assertEquals(1200, service.getSaldo(),0);
	}

	@Test
	public void testMostrarMovimientos() {
		service.mostrarMovimientos();
		//assertArrayEquals(Movimiento[], actuals);
	}

}
