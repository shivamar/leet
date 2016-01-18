
public class MyClass {

	public static void main(String[] args)
	{
		System.out.print(new MyClass().Foo());
	}
	
	String Foo()
	{
		try 
		{
			throw new Exception("An exception");
			//System.out.print("inside try");
		}
		catch(Exception ex)
		{
			return ex.getMessage();
		}
		finally
		{
			System.out.print("Finally");
		}
	}
	
}
