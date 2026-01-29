package rohit_sawant.day8;

public class ATM {	 
	synchronized void withdraw(String Name) {
		System.out.println(Name + " is withdrawing money");
		
		try {
			Thread.sleep(2000);
		}
		catch(Exception e){	
		}
		
		System.out.println(Name + " Withdrawal completed");
	}	
	public static void main(String[] args) {
		ATM atm=new ATM();
		
		new Thread(() -> atm.withdraw("User-1")).start();
		new Thread(() -> atm.withdraw("User-2")).start();
	 
		}
}
 