//Ben Schulz
package program2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Tester
{
	public static void main(String [] args)
	{
		//Step 1 ----------------------------------------------
		int[] popularity = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
		BabyName testFull = new BabyName("Tom", popularity);
		BabyName testEmpty = new BabyName();
		
		System.out.println(testFull.getName());
		System.out.println(testFull.getRanks());
		System.out.println(testFull.toString());
		
		System.out.println(testEmpty.getName());
		System.out.println(testEmpty.getRanks());
		System.out.println(testEmpty.toString());
		//-----------------------------------------------------
		
		//Step 2 ----------------------------------------------
		File inputFile = new File("names-data.txt");
		Scanner file = null;
		try 
		{
			file = new Scanner(inputFile);
			System.out.println("pants");
		}//try
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}//catch
		while (file.hasNextLine())
		{
			String s = file.nextLine();
			String name = "";
			int[] ranks = new int[11];
			//System.out.println(s);
			int rankCount = 0;
			boolean first = true;
			for (int i = 0; i < s.length(); i++)
			{
				
				if (s.charAt(i) == ' ')
				{
					if (first)
					{
						name = s.substring(0, i);
						System.out.print(name + " ");
						first = false;
					}//if
					int x = i;
					if (rankCount < 10)
					{
						do 
						{
							x++;
							//System.out.println("x " + x);
						}while (s.charAt(x) != ' ');
					}//if
					else
						x = s.length();
					ranks[rankCount] = Integer.parseInt(s.substring(i+1, x));
					System.out.print(ranks[rankCount] + " ");
					rankCount++;
				}//if
						
			}//for
			System.out.println(); 
		}//while 
		//-----------------------------------------------------
	}//main
}//Tester