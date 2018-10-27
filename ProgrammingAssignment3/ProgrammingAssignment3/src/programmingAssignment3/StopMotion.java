package programmingAssignment3;

import java.awt.Dimension;
import java.util.Scanner;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

public class StopMotion 
{
	public static void main(String[] args) 
	{
		JLabel imageLabel = null;
		JScrollPane sp;
		JFrame frame;
		ImageIcon[] images = new ImageIcon[11];
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Would you like to view the images forwards or backwards?");
		String input = scan.nextLine();
		boolean forwards = false;
		
		if (input.equals("forwards"))
			forwards = true;
		
		for (int i = 96, k = 0; i <= 106; i++, k++)
		{
			if (i < 100)
				images[k] = new ImageIcon("IMG_00" + i + ".jpg");
			else
				images[k] = new ImageIcon("IMG_0" + i + ".jpg");
		}//for
		
		frame = new JFrame("Stop Motion");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		if (forwards)
			imageLabel = new JLabel(new ImageIcon("IMG_0096.jpg"));
		else
			imageLabel = new JLabel(new ImageIcon("IMG_0106.jpg"));
		sp = new JScrollPane(imageLabel);
		sp.setPreferredSize(new Dimension(910, 680));

		frame.getContentPane().add(sp);
		frame.pack();
		frame.setVisible(true);
		
		while (true)
		{
			if (forwards)
			{
				for (int i = 1; i <= 10; i++)
				{
					try
				    {
				       Thread.sleep((int)(1000));//1 second
				    }//try
				     catch ( InterruptedException e )
				    {
				       e.printStackTrace();
				    }//catch
					imageLabel.setIcon(images[i]);
				}//for
			}//if
			else
			{
				for (int i = 10; i >= 1; i--)
				{
					try
				    {
				       Thread.sleep((int)(1000));//1 second
				    }//try
				     catch ( InterruptedException e )
				    {
				       e.printStackTrace();
				    }//catch
					imageLabel.setIcon(images[i]);
				}//for
			}//else
			
			System.out.println("Would you like to stop? (y/n)");
			input = scan.nextLine();
			if (input.equals("y"))
				break;
		}//while
	}//main
}//class
