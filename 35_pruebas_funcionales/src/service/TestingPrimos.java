package service;

import java.util.function.Predicate;

public class TestingPrimos implements Predicate<Integer> {

	@Override
	public boolean test(Integer numero) {
		for (int i=2;i<numero;i++) {
			if (numero%i==0)
				return false;
		}
		return true;
	}

}
