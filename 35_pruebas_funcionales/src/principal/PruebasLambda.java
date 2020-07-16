package principal;

import java.util.function.Predicate;

import service.TestingPares;
import service.TestingPrimos;

public class PruebasLambda {

	public static void main(String[] args) {
		int[] numeros = {2,6,4,7,13,11,16,18,19};
		Predicate<Integer> tpares = i->i%2==0;
		Predicate<Integer> tprimos = t-> {for (int i=2;i<t;i++) {
			if (t%i==0) {
				return false;
		}
	}
		return true;
	};

	comprobaciones(numeros, tpares, tprimos);
	
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

