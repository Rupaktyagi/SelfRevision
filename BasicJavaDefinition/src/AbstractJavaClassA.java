
public abstract class AbstractJavaClassA {

	abstract int sum(int a,int b);
	
	public static int  sum(int a)
	{
		
		return a+10;
	}
	
	
	public int sum(int a,int b,int c)
	{
		int d=a+b+c;
		
		return d;
		
	}
	
	public static void main(String[] args)
	{
		
		
			System.out.println(sum(10));
		
		
	}
	
}
