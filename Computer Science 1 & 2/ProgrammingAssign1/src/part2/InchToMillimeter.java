package part2;
//Author: Ben Schulz
//Assignment: Programming Assignment 1
//Task: Convert 2, 5, and 10 inches into millimeters
//Test case 1: 2 inches is 50.8mm
//Test case 2: 5 inches is 127mm
//Test case 3: 10 inches is 254mm
//Test results: correct
public class InchToMillimeter 
{

	public static void main(String[] args) 
	{
		final double INCH_TO_MM = 25.4;
		System.out.println("2 inches = " + (2.0 * INCH_TO_MM) + " millimeters.");
		System.out.println("5 inches = " + (5.0 * INCH_TO_MM) + " millimeters.");
		System.out.println("10 inches = " + (10.0 * INCH_TO_MM) + " millimeters.");

	}//main

}//class
