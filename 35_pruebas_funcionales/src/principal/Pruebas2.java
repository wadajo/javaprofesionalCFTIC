package principal;

import java.util.function.Predicate;

import service.TestingPares;
import service.TestingPrimos;

public class Pruebas2 {

	public static void main(String[] args) {
		int[] numeros = {2,6,4,7,13,11,16,18,19};
		comprobaciones(numeros, new TestingPares(), new TestingPrimos());
		
	}

	private static void comprobaciones (int[] numeros, Predicate<Integer> t1, Predicate<Integer> t2) {
		for (int n : numeros) {
			TestingPares espar = new TestingPares();
			System.out.println("El número "+n+" ¿es par?: "+espar.test(n));
			TestingPrimos esprimro = new TestingPrimos();
			System.out.println("El número "+n+" ¿es primo?: "+esprimro.test(n));
		}
	}

}
