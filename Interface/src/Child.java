
public  class Child implements A,B {

	

	

//@Override
	public void run() {
		System.out.println("Intside run function of both interface");
		
	}

	@Override
	public void funB() {
		System.out.println("Inside funB of interface B");
		
	}

	@Override
	public void funA() {
		System.out.println("Inside funA of interface A");
		
	}

	//  Having a same method name in both interface must have same return type
	
	public static void main(String[] args)
	{
		
		A objA=new Child();
		objA.funB();
		
		
		
	}
	
	
	
}
