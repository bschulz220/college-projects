package program2;
//Ben Schulz

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BabySurfer 
{
	
	public static void display(BabyName baby)//Step 4
	{
		System.out.println("Name: " + baby.getName());
		int[] rankArray = baby.getRanks();
		for (int i = 1900, x = 0; i <= 2000; i += 10, x++)
		{
			System.out.print(i + " ");
			int asterisks = 0;
			if (rankArray[x] >= 1 && rankArray[x] <= 99)
				asterisks = 10;
			else if (rankArray[x] >= 100 && rankArray[x] <= 199)
				asterisks = 9;
			else if (rankArray[x] >= 200 && rankArray[x] <= 299)
				asterisks = 8;
			else if (rankArray[x] >= 300 && rankArray[x] <= 399)
				asterisks = 7;
			else if (rankArray[x] >= 400 && rankArray[x] <= 499)
				asterisks = 6;
			else if (rankArray[x] >= 500 && rankArray[x] <= 599)
				asterisks = 5;
			else if (rankArray[x] >= 600 && rankArray[x] <= 699)
				asterisks = 4;
			else if (rankArray[x] >= 700 && rankArray[x] <= 799)
				asterisks = 3;
			else if (rankArray[x] >= 800 && rankArray[x] <= 899)
				asterisks = 2;
			else if (rankArray[x] >= 900 && rankArray[x] <= 1000)
				asterisks = 1;
			
			while (asterisks > 0)
			{
				System.out.print("*");
				asterisks--;
			}//while
			if (rankArray[x] != 0)
				System.out.print(" " + rankArray[x]);
			System.out.println();
		}//for
	}//display

	public static void main(String[] args) //Step 5
	{
		LinkedQueue<BabyName> nameQ = new LinkedQueue<BabyName>();
		File inputFile = new File("names-data.txt");
		Scanner file = null;
		try 
		{
			file = new Scanner(inputFile);
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
					rankCount++;
				}//if
						
			}//for
			nameQ.enqueue(new BabyName(name, ranks));
		}//while
		
		Scanner textScanner = new Scanner(System.in);
		System.out.println("What name do you want the statistics for?");
		String inputName = "";
		inputName = textScanner.nextLine();
		BabyName test = nameQ.dequeue();
		String testName = test.getName();
		int[] rankArray = new int[11];
		
		while (!nameQ.isEmpty() && !testName.equals(inputName))
		{
			test = nameQ.dequeue();
			testName = test.getName();
//			System.out.println(testName);
		}//while
		
		if (!testName.equals(inputName))
			System.out.println("That name isn't on the list.");
		else
		{
			display(test);
		}//else
		
	}//main

}//BabySurfer
