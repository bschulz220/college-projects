package program5;

import java.util.Random;

public class GameBoard 
{
	private char[][] board = new char[3][3];
	private int plays;
	
	public GameBoard() 
	{
		plays = 0;
		for (int rows = 0; rows < board.length; rows++)
			for (int col = 0; col < board[0].length; col++)
				board[rows][col] = ' ';
		
	}
	
	public boolean play(boolean x, int row, int column)
	{
		if (x) //player's turn
		{
			if (board[row][column] == 'X' || board[row][column] == 'O')
				return false;
			else
			{
				board[row][column] = 'X';
				plays++;
				return true;
			}
		}
		else //computer's turn
		{
			if (board[row][column] == 'X' || board[row][column] == 'O')
				return false;
			else
			{
				board[row][column] = 'O';
				plays++;
				return true;
			}
		}
	}
	
	public int validPlayCount()
	{
		return plays;
	}
	
	public char checkWin()
	{
		if (board[0][0] == 'X' && board[0][1] == 'X' && board[0][2] == 'X')//start horizontal
			return 'X';
		else if (board[0][0] == 'O' && board[0][1] == 'O' && board[0][2] == 'O')
			return 'O';
		else if (board[1][0] == 'X' && board[1][1] == 'X' && board[1][2] == 'X')
			return 'X';
		else if (board[1][0] == 'O' && board[1][1] == 'O' && board[1][2] == 'O')
			return 'O';
		else if (board[2][0] == 'X' && board[2][1] == 'X' && board[2][2] == 'X')
			return 'X';
		else if (board[2][0] == 'O' && board[2][1] == 'O' && board[2][2] == 'O')//end horizontal
			return 'O';
		else if (board[0][0] == 'X' && board[1][0] == 'X' && board[2][0] == 'X')//start vertical
			return 'X';
		else if (board[0][0] == 'O' && board[1][0] == 'O' && board[2][0] == 'O')
			return 'O';
		else if (board[0][1] == 'X' && board[1][1] == 'X' && board[2][1] == 'X')
			return 'X';
		else if (board[0][1] == 'O' && board[1][1] == 'O' && board[2][1] == 'O')
			return 'O';
		else if (board[0][2] == 'X' && board[1][2] == 'X' && board[2][2] == 'X')
			return 'X';
		else if (board[0][2] == 'O' && board[1][2] == 'O' && board[2][2] == 'O')//end vertical
			return 'O';
		else if (board[0][0] == 'X' && board[1][1] == 'X' && board[2][2] == 'X')//start diagonal
			return 'X';
		else if (board[0][0] == 'O' && board[1][1] == 'O' && board[2][2] == 'O')
			return 'O';
		else if (board[0][2] == 'X' && board[1][1] == 'X' && board[2][0] == 'X')
			return 'X';
		else if (board[0][2] == 'O' && board[1][1] == 'O' && board[2][0] == 'O')//end diagonal
			return 'O';
		return 'n';//returns n if the game is still going
	}
	
	public void showBoard()
	{
		System.out.println(" " + board[0][0] + " | " + board[0][1] + " | " + board[0][2]);
		System.out.println("---+---+---");
		System.out.println(" " + board[1][0] + " | " + board[1][1] + " | " + board[1][2]);
		System.out.println("---+---+---");
		System.out.println(" " + board[2][0] + " | " + board[2][1] + " | " + board[2][2]);
	}
}