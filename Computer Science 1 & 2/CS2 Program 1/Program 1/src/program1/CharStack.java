package program1;
//Ben Schulz

public class CharStack
{
	private final int MAX_CAPACITY = 100;
	private char[] s;
	private int top;

	public CharStack()
	//PRE:
	//POS:
	//TAS: Create an empty stack with a default capacity
	{
		s = new char[MAX_CAPACITY];
		top = -1;
	}//constructor
	
	public void push(char element)
	//PRE:
	//POS:
	//TAS: Add a new item to the stack
	{
		top++;
		s[top] = element;
	}//push
	
	public char pop()
	//PRE: top > -1
	//POS: top<exit> == top<entry>-1
	//TAS: remove and return the item on the top of the stack
	{
		char x = s[top];
		top--;
		return x;
	}//pop

	public char peek()
	//PRE:
	//POS:
	//TAS:
	{
		return s[top];
	}//peek

	public String toString()
	//PRE:
	//POS:
	//TAS:
	{
		String temp = "";
		for (int i = 0; i < s.length; i++)
			temp += s[i];
		return temp;
	}//toString

	public boolean isEmpty()
	//PRE:
	//POS:
	//TAS: Return whether or not the stack is empty.
	{
		if (top >= 0)
			return false;
		else
			return true;
	}//isEmpty

	public boolean isFull()
	//PRE:
	//POS:
	//TAS: Return whether or not the stack is full
	{
		return top == MAX_CAPACITY-1;
	}//isFull
}
