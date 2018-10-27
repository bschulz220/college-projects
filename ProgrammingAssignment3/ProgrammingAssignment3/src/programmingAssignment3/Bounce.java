package programmingAssignment3;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Bounce 
{

	public static void main(String[] args) throws IOException 
	{
		File inputFile = new File("bouncedata.txt");
		Scanner file = new Scanner(inputFile);
		int dropHeight = 0;
		int bounceHeight = 0;
		int bounceCount = 0;
		double bounceIndex = 0;
		int i = 1;
		
		while (file.hasNextInt())
		{
			if (i == 1) 
			{
				dropHeight = file.nextInt();//set dropHeight to first int in data set
				i++;
			}//if
			else if (i == 2)
			{
				bounceHeight = file.nextInt();//set bounceHeight to second int in data set
				i++;
			}//else if
			else
			{
				bounceCount = file.nextInt();//set bounceCount to third int in data set
				i = 1;//reset i for next data set
				bounceIndex = (double)bounceHeight/(double)dropHeight;//set bounceIndex to bounceHeight divided by dropHeight
				bounce(bounceIndex, bounceCount, dropHeight, bounceHeight);
				System.out.println("End of this bounce.");
				System.out.println();
			}//else
			
		}//while
	}//main
	
	//Uses data from a given data set to simulate a bouncing ball
	public static void bounce(double bounceIndex, int bounceCount, double dropHeight, double bounceHeight)
	{
		int bounceNum = 1;//keeps count of how many times the ball bounces
		double totalHeight = 0;
		double up = dropHeight*bounceIndex;
		boolean negligible = true;
		
		while (negligible && bounceNum != bounceCount+1)
		{
			if (up < 0.001)//checks to see if the bounce height has become negligible
				negligible = false;
			up = dropHeight*bounceIndex;//finds bounce height with dropHeight multiplied by the bounciness index
			System.out.println("Bounce #" + bounceNum + ":");
			System.out.println("Down:           " + dropHeight);
			System.out.println("Up:             " + up);
			System.out.println("Distance:       " + (dropHeight+up));//finds distance travelled with dropHeight added to the bounce height
			totalHeight += dropHeight+up;//adds the dropHeight and bounce height to the total
			System.out.println("Total distance: " + totalHeight);
			dropHeight = up;//sets the dropHeight for the next bounce to the height that the ball bounced to on the current bounce
			bounceNum++;
		}//while
		
	}//bounce()
	
}//class
