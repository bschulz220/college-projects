package part1;
//Author: Ben Schulz
//Assignment: Programming Assignment 1
//Task: Calculate the square of each integer from 1 to 5
//Test case 1: 1^2 = 1
//Test case 2: 2^2 = 4
//Test case 3: 3^2 = 9
//Test case 4: 4^2 = 16
//Test case 5: 5^2 = 25
//Test result: correct
public class Squares 
{

	public static void main(String[] args) 
	{
		for (int x = 1; x <= 5; x++) 
		{
			System.out.println(x + " squared = " + x*x);
		}//for
		
	}//main

}//class
