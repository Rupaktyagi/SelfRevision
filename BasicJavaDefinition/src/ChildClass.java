
public class ChildClass extends AbstractJavaClassA {

	@Override
	int sum(int a, int b) {
		
		return a+b;
	}

	
	public int sum(double a) {
		return (int) (a+15);
	}
	
}
