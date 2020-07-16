package principal;

import java.util.ArrayList;

public class Test1 {
	static int suma;
	public static void main(String[] args) {
		ArrayList<Integer> nums = new ArrayList<>();
		nums.add(20);
		nums.add(444);
		nums.add(345);
		nums.add(234);
		nums.add(345);
		nums.add(756);
		nums.add(8);
		
		for (Integer n : nums) {
			System.out.println("Elemento "+(nums.indexOf(n)+1)+" del array: "+n);
		}
		
		nums.forEach(n->System.out.println(n));
		
		nums.forEach(n->suma+=n); //deja usar variables solo estáticas (atributos de clase)
		System.out.println("La media es: "+suma/nums.size());
	}	
}
