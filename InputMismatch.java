import java.util.*;

class InputMismatchException extends Exception
{
	InputMismatchException(String message)
	{
		super(message);
	}
}

class InputMismatch
{
	static void test(int x)
	{
		try
		{
			if(x==5 || x==6 || x==7)
			{
				System.out.println("Valid input!");
				System.out.println("Entered input: "+x);
			}
			else
			{
				throw new InputMismatchException("Entered input is not 5, 6 or 7!"); 
			}
		}
		catch(InputMismatchException e)
		{
			System.out.println("Input Mismatch Exception caught: "+e);
		}
	}		 	

	public static void main(String args[])
	{
		System.out.println("Leena Vasyani C33-182");
		System.out.println("Program to accept any integer from the user and if the entered number is not any of 5 or 6 or 7 then create an exception and catch it.");
		System.out.println();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter any integer: ");
		int x = sc.nextInt();
		
		test(x);
	}
}
	
