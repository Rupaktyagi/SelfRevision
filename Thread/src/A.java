
public class A extends Thread{

	@Override
	public void run() {
		int a=10;
		while(a-->=0)
		{
			System.out.println("A    "+a);
		}
	}

	
	
}
