package program3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;

public class ContactClient 
{

	public static void main(String[] args) 
	{
		int lineCounter = 0;
		boolean first = false;
		
		LinkedList<Contact> contactList = new LinkedList<Contact>();
		File inputFile = new File("names.txt");
		Scanner file = null;
		try 
		{
			file = new Scanner(inputFile);
		}//try
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}//catch
		int counter = 0;
		while (file.hasNextLine())
		{
			lineCounter++;
			String s = file.nextLine();
			String[] parts = s.split(" ");
			String name = parts[0] + " " + parts[1];
			String phone = parts[2];
			String image = parts[3];
			Contact c = new Contact(name, phone, image);
//			System.out.println(c.toString());
			contactList.addAlpha(c);
			
//			LinkedList<Contact> temp = contactList;
//			System.out.println(contactList.isEmpty());
//			Contact tempHead = new Contact("fix", "this", "thing");
//			if (contactList.isEmpty())//adds in alphabetical order
//				contactList.addHead(c);
//				//first = true;
//				//tempHead = c;
//			if (counter <= 25)
//			{
//				contactList.addTail(c);
//				counter++;
//			}//if
			/*//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			else if (contactList.size() == 1)
   			{
				first = false;
				LinearNode current = temp.getHead();
	   			Contact minContact = ((Contact) current.getElement());
		   		String min = ((Contact) current.getElement()).getName();
   				System.out.println("size is one");
   				if (min.compareTo(c.getName()) > 0)
	   			{
	   				System.out.println("pants 43");
	   				contactList.addHead(c);
	   			}//if
   				else
   					contactList.addTail(c);
   			}//else if
			else
			{
				first = false;
				LinearNode current = temp.getHead();
	   			Contact minContact = ((Contact) current.getElement());
		   		String min = ((Contact) current.getElement()).getName();
   				System.out.println("size is > 1");
   				if (min.compareTo(c.getName()) < 0)
	   			{
	   				System.out.println("pants 43");
	   				contactList.addAfter(minContact, c);
	   			}//if
			}//else 
			*/ //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			
			//contactList.addTail(tempHead);//
			
	/*
			else
			{
			
			LinkedList<Contact> temp = contactList;
			System.out.println(contactList.isEmpty());
			
			if (contactList.isEmpty())//adds in alphabetical order
				contactList.addTail(c);
			else if (contactList.size() == 1)
   			{
				LinearNode current = temp.getHead();
	   			Contact minContact = ((Contact) current.getElement());
		   		String min = ((Contact) current.getElement()).getName();
   				System.out.println("size is one");
   				if (min.compareTo(c.getName()) > 0)
	   			{
	   				System.out.println("pants 43");
	   				contactList.addHead(c);
	   			}//if
   				else
   					contactList.addTail(c);
   			}//else if
			else
			{
				/*
				LinearNode current = temp.getHead();
	   			Contact minContact = ((Contact) current.getElement());
		   		String min = ((Contact) current.getElement()).getName();
		   		
	   			System.out.println("pants 2");
	   			if (min.compareTo(c.getName()) > 0)//if added name is above the head
	   			{
	   				System.out.println("pants 24");
	   				contactList.addHead(c);
	   			}//if
	   			else
	   			{
			   		while (current.getNext() != null)
			   		{
			   			
			   			minContact = ((Contact) current.getElement());
			   			min = minContact.getName();
			   			System.out.println("pants 1337: " + min + " " + min.compareTo(c.getName()));
			   			if (c.getName().compareTo(min) > 0)//if added name is higher than min
			   			{
			   				System.out.println("pants 4");
			   				contactList.addBefore((Contact) current.getElement(), c);
			   				break;
			   			}//if
			   			current = current.getNext();
			   		}//while
	   			}//else
	   			*/
			//}//else
			
			
			/*
			if (contactList.isEmpty())//first one
				contactList.addTail(c);
			else
			{
				LinearNode current = temp.getHead();
	   			Contact minContact = ((Contact) current.getElement());
		   		String min = ((Contact) current.getElement()).getName();
		   		
	   			System.out.println("pants 2");
	   			if (min.compareTo(c.getName()) > 0)//if added name is above the head
	   			{
	   				System.out.println("pants 24");
	   				contactList.addTail(c);
	   			}//if
	   			else if (contactList.size() == 1)
	   			{
	   				System.out.println("size is one");
	   				if (min.compareTo(c.getName()) > 0)
		   			{
		   				System.out.println("pants 43");
		   				contactList.addHead(c);
		   			}//if
	   				else
	   					contactList.addTail(c);
	   			}//else if
	   			else
	   			{
	   				System.out.println("check 1");
	   				
			   		while (current.getNext() != null)
			   		{
			   			
			   			minContact = ((Contact) current.getElement());
			   			min = minContact.getName();
			   			System.out.println("pants 3: " + min);
			   			if (min.compareTo(c.getName()) < 0)//if added name is higher than min
			   			{
			   				System.out.println("pants 42 " + current.getElement().toString());
			   				contactList.addAfter((Contact) current.getElement(), c);
			   				current = current.getNext();
			   				break;
			   			}//if
			   			else
			   			{
			   				System.out.println(c.toString() + " " + min.compareTo(c.getName()));
			   			}//else
			   			current = current.getNext();
			   		}//while
	   			}//else
	   			
				
				
			}//else
			
		
		}//while
		}//else

		contactList.addTail(contactList.removeFirst());
		contactList.reverse();
		*/
		}//while
		
		
//		try
//		{
//			System.out.println("what the pants: " + contactList.contains(new Contact("fix", "this", "thing")));
//			Contact getRidOf = (Contact) contactList.getTail().getElement();
//			while (contactList.contains(getRidOf))
//			{
//				System.out.println("this totally ran");
//				contactList.remove(getRidOf);
//			}//while
//		}//try
//		catch (ElementNotFoundException e)
//		{
//			
//		}//catch
		
//		System.out.println(contactList.getTail().getElement().equals(new Contact("fix", "this", "thing")));
//		System.out.println(contactList.getTail().getElement().toString());
//		while (contactList.getTail().getElement().toString().equals("fix this thing"))
//		{
//			System.out.println(contactList.getTail().getElement().toString());
//			System.out.println(contactList.size());
//			contactList.removeLast();
//		}//while
		
//		while (contactList.size() != lineCounter)------------------------------------------
//			contactList.removeLast();
		
//		try 
//		{
//			file = new Scanner(inputFile);
//		}//try
//		catch (FileNotFoundException e) 
//		{
//			e.printStackTrace();
//		}//catch
//		if (true)
//		{
//			String s = file.nextLine();
//			String[] parts = s.split(" ");
//			String name = parts[0] + " " + parts[1];
//			String phone = parts[2];
//			String image = parts[3];
//			Contact c = new Contact(name, phone, image);
//			contactList.addTail(c);
//		}//if
//		LinkedIterator<Contact> kjkjsfd = (LinkedIterator<Contact>) contactList.iterator();
//		while (kjkjsfd.hasNext())
//		{
//			System.out.println("next " + kjkjsfd.next());
//			//System.out.println("prev " + kjkjsfd.prev());
//		}//while
//		Contact one = contactList.removeLast();
//		System.out.println(one.toString());
//		Contact two = contactList.removeLast();
//		contactList.addTail(one);
//		contactList.addTail(two);
		
		Scanner textScanner = new Scanner(System.in);
		while (true)
		{
			System.out.println("What would you like to do?");
			System.out.println("U	Upflip\r\n" + 
					"D	Downflip\r\n" + 
					"A	Add new contact\r\n" + 
					"R	Remove existing contact\r\n" + 
					"Q	Quit\r\n");
			String input = textScanner.nextLine();
			
			if (input.equals("U"))//upflip
			{
				Iterator<Contact> contactIterator = contactList.iterator();
				while (contactIterator.hasNext())
					System.out.println(contactIterator.next());
				
//				LinearNode current = contactList.getHead();
//				LinearNode next;
//				for (int i = 0; i <= contactList.size(); i++)
//				{
//					System.out.println("1");
//					while (current != null)
//					{
//						System.out.println("2");
//						next = current.getNext();
//						String currentName = ((Contact) current.getElement()).getName();
//						
//						if (next != null)
//						{
//							System.out.println("3");
//							String nextName = ((Contact) next.getElement()).getName();
//							if (currentName.compareTo(nextName) > 0)
//								contactList.swap(current, next);
//						}//if
//						current = current.getNext();
//					}//while
//				}//for
//				System.out.println("got out of the for loop");
			}//if U
			else if (input.equals("D"))//downflip
			{
				LinearNode tailTemp = contactList.getTail();
				while (tailTemp.getPrev() != null)
				{
					System.out.println(tailTemp.getElement().toString());
					tailTemp = tailTemp.getPrev();
				}//while
				System.out.println(contactList.getHead().getElement().toString());
			}//else if D
			else if (input.equals("A"))//add
			{
				System.out.println("Insert a contact in the format: First Last PhoneNumber ImageName");
		   		String s = textScanner.nextLine();
				String[] parts = s.split(" ");
				String name = parts[0] + " " + parts[1];
				String phone = parts[2];
				String image = parts[3];
				Contact c = new Contact(name, phone, image);
				
				contactList.addAlpha(c);
				
				/*original solution
				contactList.addTail(c);*/
				
				/*second solution
				LinkedList<Contact> temp = contactList;
				if (contactList.isEmpty())//adds in alphabetical order
					contactList.addTail(c);
				else if (((Contact) contactList.getTail().getElement()).getName().compareTo(name) < 0)
					contactList.addTail(c);
				else//FIX 2043900239-59-0395-94306048560980983098590280982038408209840983094844309803948609840698
				{
					LinearNode current = temp.getHead();
		   			Contact minContact = ((Contact) current.getElement());
			   		String min = ((Contact) current.getElement()).getName();
			   		
			   		s = "";
			   		int comp = 0;
		   			System.out.println("pants 2");
		   			if (min.compareTo(c.getName()) > 0)//if added name is above the head
		   			{
		   				System.out.println("pants 24");
		   				contactList.addHead(c);
		   			}//if
		   			else
		   			{
				   		while (current.getNext() != null)
				   		{
				   			
				   			minContact = ((Contact) current.getElement());
				   			min = minContact.getName();
				   			System.out.println("pants 3: " + min);
				   			if (min.compareTo(c.getName()) > 0)//if added name is higher than min
				   			{
				   				System.out.println("pants 4");
				   				contactList.addAfter((Contact) current.getPrev().getElement(), c);
				   				break;
				   			}//if
				   			current = current.getNext();
				   		}//while
		   			}//else
				}//else
				*/ //second solution
				
			}//else if A
			else if (input.equals("R"))//remove
			{
				System.out.println("Who would you like to remove from the contact list?");
		   		String target = textScanner.nextLine();
		   		
		   		if (contactList.isEmpty())
		            System.out.println("The contacts list is already empty.");
		   		else
		   		{
			         boolean found = false;
	
			         LinearNode current = contactList.getHead();
	
			         while (current != null && !found)
			            if (current.getElement().toString().contains(target))
			               found = true;
			            else
			               current = current.getNext();
			         if (found)
			         {
				         Contact c = (Contact) current.getElement();
				         System.out.println(contactList.remove(c) + " removed.");
			         }//if
			         else
			        	 System.out.println("That name isn't in the contacts list.");
		   		}//else
		   		
			}//else if R
			else if (input.equals("Q"))
				break;
			else
				System.out.println("That's not a command.");
			
			System.out.println("Size: " + contactList.size());
		}//while
	}//main

}//ContactClient
