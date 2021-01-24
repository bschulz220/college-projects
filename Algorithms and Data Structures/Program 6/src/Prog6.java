import java.util.Random;
import java.util.Scanner;

public class Prog6 
{

	public static void main(String[] args) throws InterruptedException 
	{
		Scanner scan = new Scanner(System.in);
		Random rand = new Random();
		int[] nums = new int[1000];
		
		System.out.print("Random: [");
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
		
		int[] counter = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		
		CounterSortThread cs1 = new CounterSortThread(nums, 0, nums.length/2);
		CounterSortThread cs2 = new CounterSortThread(nums, nums.length/2, nums.length);
		
		cs1.start();
		cs2.start();
		
		cs1.join();
		cs2.join();
		
		int[] temp1 = cs1.getArray();
		int[] temp2 = cs2.getArray();
		for (int z = 0; z < 10; z++)
		{
			counter[z] += (temp1[z] + temp2[z]);
		}
		
//		for (int i = 0; i < 10; i++)
//		{
//			System.out.println(counter[i]);
//		}
		
		
		
		System.out.print("Sorted: [");
		for (int x = 0; x < 10; x++)//prints the sorted array
		{
			for (int y = 0; y < counter[x]; y++)
			{
				if (x != 9 || y < counter[x]-1)
					System.out.print(x + ", ");
				else
					System.out.print(x);
			}
		}
		System.out.println("]");
	}

}

class CounterSortThread extends Thread
{
	int[] counter = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
	int[] a;
	int low, high;
	public CounterSortThread(int[] a, int low, int high) 
	{
		this.a = a;
		this.low = low;
		this.high = high;
	}
	public void run()
	{
		for (int i = low; i < high; i++)
		{
			counter[a[i]]++;
		}
	}
	
	public int[] getArray()
	{
		return this.counter;
	}
}