package rohit_sawant.techademyPortalLecturesCodes;

public class TypeCastingExample {
	public static void main(String[] args) {
		int a = 5 , b = 10;
		double c = 12 , d = 15;
		
		System.out.println("While Printing");
		System.out.println("int/int = int");
		System.out.println("int/double = double");
		System.out.println("double/int = double");
		System.out.println("double/double = double");
		System.out.println(a/b); //int/int
		System.out.println(a/c); //int/double
		System.out.println(c/a); //double/int
		System.out.println(c/d); //double/double
		
		System.out.println("\nWhile Storing double in an integer variable: ");
		System.out.println("int / double: ");
		int result = a/(int)c;
		System.out.println("Result: "+result);
		System.out.println("double / int: ");
		int result2 = (int)c/a;
		System.out.println("Result: "+result2);
		System.out.println("double / double: ");
		int result3 = (int)d/(int)c;
		System.out.println("Result: "+result3);
		
		System.out.println("\nWhile Storing integer in a double variable: ");
		System.out.println("int / double: ");
		double result4 = a/c;
		System.out.println("Result: "+result4);
		System.out.println("double / int: ");
		double result5 = c/a;
		System.out.println("Result: "+result5);
		System.out.println("double / double: ");
		double result6 = d/c;
		System.out.println("Result: "+result6);
		
		System.out.println("Observation Made: When going from a smaller size datatype to bigger one, we use typecasting.");
		System.out.println("When going from a big size datatype to smaller one, typecasting is not needed. It is handled automatically.");
		
	}
}
