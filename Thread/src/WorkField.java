
public class WorkField {

	public void print()
	{
		System.out.println("Inside print method");
	}
	
	
	public static void main(String[] args) {
		WorkField mainobj=new WorkField();
		mainobj.print();
		A obja=new A();
		obja.start();
		B objb=new B();
		objb.start();
				
		
	}
	
}
