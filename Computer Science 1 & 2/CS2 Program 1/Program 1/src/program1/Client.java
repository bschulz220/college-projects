package program1;
//Ben Schulz
import java.util.Scanner;

public class Client 
{

	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		CharStack s = new CharStack();
		System.out.println("Please enter a valid base 10 number.");
		while (true) 
		{
			if (scan.hasNextInt() == false) 
			{
				System.out.println("That's not a valid base 10 number.");
				scan.next();
			}//if
			else
				break;
		}//while
		int num = scan.nextInt();
		System.out.println(num);
		
		while (num > 0)
		{
			int bit = num % 2;
			if (bit == 1)
				s.push('1');
			else
				s.push('0');
			num /= 2;
		}//while
		
		while (!s.isEmpty())
		{
			System.out.print(s.pop());
		}//while
		
	}//main

}//class
