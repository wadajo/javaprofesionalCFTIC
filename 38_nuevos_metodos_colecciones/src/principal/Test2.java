package principal;

import java.util.ArrayList;

public class Test2 {
	
	
	public static void main(String[] args) {
		ArrayList<Integer> nums = new ArrayList<>();
		nums.add(20);
		nums.add(444);
		nums.add(345);
		nums.add(234);
		nums.add(345);
		nums.add(756);
		nums.add(8);
		
		nums.forEach(n->System.out.println("Todos los números: "+n));
		
		/*for (Integer n : nums) {
			if (n<limite){
				nums.remove(nums.indexOf(n));
			}
		}no funciona porque modfiica al mismo tiempo que intenta borrar: Excepción ConcurrentModification*/ 
		
		//nums.forEach(n->System.out.println(n));
		int limite=150; //funciona como "constante efectiva", como si fuera final: no la modifico
		
		nums.removeIf(n->n>limite);
		nums.forEach(n->System.out.println("Números menores que el límite: "+n));
		
		nums.replaceAll(n->n*n); //reemplaza cada número por su cuadrado
		nums.forEach(n->System.out.println("Números al cuadrado: "+n));

	}

}
