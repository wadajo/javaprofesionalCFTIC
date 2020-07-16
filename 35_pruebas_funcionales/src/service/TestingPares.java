package service;

import java.util.function.Predicate;

public class TestingPares implements Predicate<Integer> {

	@Override
	public boolean test(Integer numero) {
		return numero%2==0;
	}

}
