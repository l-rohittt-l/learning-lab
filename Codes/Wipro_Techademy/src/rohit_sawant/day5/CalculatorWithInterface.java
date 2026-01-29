package rohit_sawant.day5;

interface calculator{
	static void add (int a, int b)
	{
		System.out.println(a+b);
	}
}
public class CalculatorWithInterface {
 
	public static void main(String[] args)
	{
calculator.add(10, 20);
	}
}