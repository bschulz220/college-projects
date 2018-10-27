package programmingassignment2;
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

import javax.swing.JOptionPane;

public class PasswordTester 
{
	public static void main(String[] args) 
	{
		boolean good = false;
		String pass = JOptionPane.showInputDialog("Please input a password: ");
		
		char a = pass.charAt(0);
		char z = pass.charAt(pass.length()-1);
		String aString = (a + "" + a + a);
		String zString = (z + "" + z + z);
		if (pass.contains("!") || pass.contains("@") || pass.contains("$")) {
			good = true;
		}
		if (pass.length() < 8) {
			good = false;
		}
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
			JOptionPane.showMessageDialog(null, "Password strength is weak. Try again");
	}//main
}//class
