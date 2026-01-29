package rohit_sawant.day5;

@FunctionalInterface   //Annotation
interface validator {
	boolean validator(String input);
}
 
public class FunctionalInterfaceDemo {
	public static void main(String[] args) {
		validator emailCheck=email->email.contains("@");
		System.out.println(emailCheck.validator("test@gmail.com"));
	}
}