package part3;
//Author: Ben Schulz
//Assignment: Programming Assignment 1
//Task: Convert four-digit binary values into base 10
//Test case 1: 1010 is 10
//Test case 2: 1011 is 11
//Test case 3: 0011 is 3
//Test case 4: 1100 is 12
//Test results: correct
import java.util.Scanner;

public class BinaryToBaseTen 
{

	public static void main(String[] args) 
	{
		Scanner intScanner = new Scanner(System.in);
		System.out.print("Please input the leftmost digit:  ");
		int first = intScanner.nextInt();
		System.out.print("Please input the next digit:      ");
		int second = intScanner.nextInt();
		System.out.print("Please input the next digit:      ");
		int third = intScanner.nextInt();
		System.out.print("Please input the last digit:      ");
		int last = intScanner.nextInt();
		
		System.out.println("The number is " + (first*8 + second*4 + third*2 + last*1) + " in base 10.");
	}//main

}//class
