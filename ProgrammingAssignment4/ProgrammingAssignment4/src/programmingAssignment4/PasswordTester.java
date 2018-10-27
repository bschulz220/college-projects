package programmingAssignment4;
//Ben Schulz
//Program: Programming Assignment 2 Part 1
//Task: Take in a potential password and tell the user if the password is strong enough
//Test Case 1: a!
//Test Case 2: longEnough!
//Test Case 3: missingSpecChar
//Test Case 4: notMissing!
//Test Case 5: !perfect
//Test Case 6: perfect!?
//Test Case 7: space  !
//Test Case 8: noSpace!
//Test Case 9: ssspace!
//Test Case 10: nnotQuite!
//Test Case 11: space!!!
//Test Case 12: notQuite!!
//Test results: correct

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class PasswordTester 
{
	private boolean good;
	private int counter;
	private String[] passwordCheckList;
	private String[] worstList = {"123456", "123456789", "qwerty", "12345678", "111111", "1234567890", "1234567", "password", "123123", "987654321", "qwertyuiop", "mynoob", "123321", "666666", "18atcskd2w", "7777777", "1q2w3e4r", "654321", "555555", "3rjs1la7qe", "google", "1q2w3e4r5t", "123qwe", "zxcvbnm", "1q2w3e"};
	private int wordCount;
	
	public PasswordTester()
	{
		System.out.println("this ran");
		findWordCount();
		System.out.println(wordCount);
		wordCount--;
		populateCheckList();
		good = false;
		counter = 0;
		for (String s: passwordCheckList) 
		{
			System.out.println(s);
		}//for
		test();
	}//constructor
	
	public void test()
	{
		while (!good && counter < 4)
		{
			String pass = JOptionPane.showInputDialog("Please input a password: ");
			
			char a = pass.charAt(0);
			char z = pass.charAt(pass.length()-1);
			String aString = (a + "" + a + a);
			String zString = (z + "" + z + z);
			if (pass.contains("!") || pass.contains("@") || pass.contains("$")) 
				good = true;
			if (pass.length() < 8) 
				good = false;
			if (pass.contains(" "))
				good = false;
			if (pass.charAt(0) == '!' || pass.charAt(0) == '?')
				good = false;
			if (pass.startsWith(aString))
				good = false;
			if (pass.endsWith(zString))
				good = false;
			if (good)
				JOptionPane.showMessageDialog(null, "Accepted");
			else
			{
				if (lazyPasswordChoice(pass))
					JOptionPane.showMessageDialog(null, "Password choice is lazy. Try again");
				else
					JOptionPane.showMessageDialog(null, "Password strength is weak. Try again");
			}//else
			counter++;
		}//while
		if (!(counter < 4))
			JOptionPane.showMessageDialog(null, "Your account has been locked.");
	}//test()
	
	public void findWordCount() 
	{
		File inputFile = new File("usa2.txt");
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
			wordCount++;
			System.out.println(file.nextLine());
			System.out.println(wordCount);
		}//while
	}//findWordCount()
	
	public void populateCheckList()
	{
		passwordCheckList = new String[wordCount+1];
		File inputFile = new File("usa2.txt");
		Scanner file = null;
		try 
		{
			file = new Scanner(inputFile);
		}//try
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}//catch
		for (int i = 0; i < passwordCheckList.length; i++)
		{
			passwordCheckList[i] = file.nextLine();
		}//for
	}//populateCheckList()
	
	public boolean lazyPasswordChoice(String pass)
	{
		for (int i = 0; i < passwordCheckList.length; i++)
		{
			if (passwordCheckList[i].equals(pass))
				return true;
		}//for
		for (int i = 0; i < worstList.length; i++)
		{
			if (worstList[i].equals(pass))
				return true;
		}//for
		return false;
	}//lazyPasswordChoice()
	
}//class
