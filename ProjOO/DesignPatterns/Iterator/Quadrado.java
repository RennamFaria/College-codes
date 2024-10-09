public class Quadrado implements Figura {
	int tamLado;
	float area;
  
	public Quadrado(){
	  tamLado = 3;
	}
  
	@Override
	public float area() {
	  area = tamLado * tamLado;
  
	  return area;
	}

	@Override
	public void print(){
		System.out.println("Quadrado: ");
		System.out.println("\ttamLado = " + tamLado);
		System.out.println("\tarea = "+ area());
	}
}