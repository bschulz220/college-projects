import java.util.Random;
import java.util.Scanner;

public class Prog5 
{

	public static void main(String[] args) throws InterruptedException 
	{
		Scanner scan = new Scanner(System.in);
		Random rand = new Random();
		int[] nums = new int[1000];
		
		System.out.print("[");
		for (int x = 0; x < 1000; x++)//fills an array with 1000 random integers
		{
			int r = rand.nextInt(10);//between 0-9
			nums[x] = r;
			if (x < 999)
				System.out.print(r + ", ");
			else
				System.out.print(r);
		}
		System.out.println("]");
		
		int t = 0;
		boolean checkInt = true;
		while (checkInt)//makes sure that the user inputs an integer target
		{
			System.out.println("What would you like to search for?");
			if (scan.hasNextInt())
			{
				t = scan.nextInt();
				checkInt = false;
			}
			else
			{
				System.out.println("Please input an integer.");
				scan.next();
			}
		}
		
		LinSearchThread thread1 = new LinSearchThread(nums, 0, nums.length/2, t);
		LinSearchThread thread2 = new LinSearchThread(nums, nums.length/2, nums.length, t);
		
		thread1.start();
		thread2.start();
		
		thread1.join();
		thread2.join();

	}

}

class LinSearchThread extends Thread
{
	int[] a; 
	int low, high, target;
	public LinSearchThread(int[] a, int low, int high, int target) 
	{
		this.a = a;
		this.low = low;
		this.high = high;
		this.target = target;
	}
	
	public void run()
	{
		for (int i = low; i < high; i++)
		{
			if (a[i] == target)
			{
				System.out.println(i);
			}
		}
	}
}

