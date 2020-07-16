package principal;

interface MyInterface1 {
	default void met() {
		System.out.println("Método default de la interfaz 1.");
	}
}

interface MyInterface2 {
	default void met() {
		System.out.println("Método default de la interfaz 2.");
	}
}

class Clase1 implements MyInterface1, MyInterface2 {
	/*public void met() {
		System.out.println("Método en la clase."); //puedo definirle de nuevo el método
	}*/
	public void met() {
		MyInterface1.super.met(); //o puedo decirle que haga lo mismo que alguno de los dos de las interfaces
	}
}

public class Test implements MyInterface1 {

	public static void main(String[] args) {
		Clase1 c1 = new Clase1();
		c1.met();
	}

}
