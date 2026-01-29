package rohit_sawant.day7;

public class MultipleCatchExample2 {
	public static void main(String[] args)
	{
		try {
			try													
			{
				int a=10/0;
			}
			catch (ArithmeticException e)
			{
				System.out.println("Inner catch: Divide by zero");
			}
			int arr[]= {1, 2, 3};
			System.out.println(arr[5]);
		}
catch(ArrayIndexOutOfBoundsException e)
{
	System.out.println("Outer Catch : Array index error");
}
}
}
 