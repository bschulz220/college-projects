package program5;

import java.util.Random;
import java.util.Scanner;

public class TicTacToeGame 
{

	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		boolean human = true;
		GameBoard board = new GameBoard();
		int x = 0;
		int y = 0;
		while (board.validPlayCount() < 9 && board.checkWin() == 'n')
		{
			board.showBoard();
			if (human)
			{
				while (true)
				{
					System.out.println("Please enter a valid row.");
					x = scan.nextInt();
					System.out.println("Please enter a valid column.");
					y = scan.nextInt();
					if (board.play(human, x, y))
						break;
					else
						System.out.println("That's not a valid move.");
				}
			}
			else
			{
				Random rand = new Random();
				while (true)
				{
					x = rand.nextInt(3);
					y = rand.nextInt(3);
					if (board.play(human, x, y))
						break;
				}
			}
			human = !human;
		}
		board.showBoard();
		if (board.checkWin() == 'X')
			System.out.println("Congratulations! X wins!");
		else
			System.out.println("Sorry, you lost...");
	}
}
