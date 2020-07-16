package principal;

import service.TestingPares;
import service.TestingPrimos;

public class Pruebas {

	public static void main(String[] args) {
		int[] numeros = {2,6,4,7,13,11,16,18,19};
		
		for (int n : numeros) {
			TestingPares espar = new TestingPares();
			System.out.println("El número "+n+" ¿es par?: "+espar.test(n));
			TestingPrimos esprimro = new TestingPrimos();
			System.out.println("El número "+n+" ¿es primo?: "+esprimro.test(n));
		}
	}

}
