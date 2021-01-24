package program3;

/**
 * LinkedList represents a linked implementation of a list.
 *
 * @author Dr. Lewis
 * @author Dr. Chase
 * @version 1.0, 08/13/08
 */

//Ben Schulz
import java.util.*;

public class LinkedList<T> implements ListADT<T>, Iterable<T>
{
   protected int count;
   protected LinearNode<T> head, tail;

   /**
    * Creates an empty list.
    */
   public LinkedList()
   {
      count = 0;
      head = tail = null;
   }
   
   public void addAlpha(T elem)
   {
        if (isEmpty())
           addHead(elem);
        else         
        {
          LinearNode current = head;
          boolean insertLocationFound = false;
          
          while ((current != null) && (!insertLocationFound))
          {
            if (((Comparable)current.getElement()).compareTo(elem) > 0)
        	//if (current.getElement().toString().compareTo(elem.toString()) > 0)
              insertLocationFound = true;
            else
              current = current.getNext();
          }//while
          
          if (current == null)
            addTail(elem);
          else if (current == head)
            addHead(elem);
          else				
        	  addBefore (current, elem);
         
        }//end else
         
   }// addAlpha

   
   public void swap(LinearNode one, LinearNode two)//doesn't work?
   {
	   System.out.println("Begin: " + one.getNext().getElement().toString());
	   LinearNode tempNext = one.getNext();
	   LinearNode tempPrev = one.getPrev();
	   one.setNext(two);
	   one.setPrev(two.getPrev());
	   System.out.println("Middle: " + tempNext.getElement().toString());
	   two.setNext(tempNext);
	   two.setPrev(one);
	   System.out.println("End: " + one.getNext().getElement().toString());
   }//swap
   
   public void addBefore(LinearNode current, T elem)//originally T target, T element
	{
	   /*
		if (isEmpty() || contains(target) == false)
			throw new EmptyCollectionException ("List");
		if (target.equals(head.getElement()))
			addHead(element);
		else
		{
		   boolean found = false;
		   LinearNode<T> insertNode = new LinearNode(element);
		   LinearNode<T> prev = head.getPrev();
		   LinearNode<T> current = head;
			while (current != null && !found)
			{
				if (target.equals (current.getElement()))
					found = true;
				else
				{
					current = current.getNext();
				}//else
				
			}//while
			prev = current.getPrev();
			insertNode.setPrev(prev);
			insertNode.setNext(current);
			prev.setNext(insertNode);
			current.setPrev(insertNode);
			
			count++;
		}//else
		*/ //original solution
		
	   //Create the new node
	   LinearNode insertNode = new LinearNode(elem);

	   //Link it into the list before current
	   current.getPrev().setNext(insertNode);
	   insertNode.setPrev(current.getPrev());
	   current.setPrev(insertNode);
	   insertNode.setNext(current);

	   //increment count
	   count++;

	}//addBefore
   
//   	public void upflip() //A-Z
//   	{
//   		boolean used = true;
////		String s = head.getElement().toString().substring(0, 1);
//   		LinearNode current = head;
//   		String min = head.getElement().toString().substring(0, 1);
//   		String s = "";
//   		int comp = 0;
//   		while (current != null)
//   		{
//   			s = current.getElement().getName();
//   			if (min.compareTo(s) > 0)//if s is higher than min
//   				min = s;
//   		}//while
//		
//	}//upflip
   	
//   	public LinkedList<T> snapshot()
//   	{
//   		LinkedList<T> temp = new LinkedList<T>();
//   		temp.se
//   		return temp;
//   	}
   
   	public void downflip()//Z-A
   	{
   		LinkedIterator<T> it = (LinkedIterator<T>) iterator();
   		while (it.prev() != null)
   			System.out.println(it.prev());
   	}//downflip
   	
   	public LinearNode getHead()
   	{
   		return head;
   	}//getHead
   	
   	public LinearNode getTail()
   	{
   		return tail;
   	}//getTail
   
	public void addAfter(T target, T element)
	{
		if (isEmpty() || contains(target) == false)
			throw new EmptyCollectionException ("List");
		if (target.equals(tail.getElement()))
			addTail(element);
		else
		{
		   boolean found = false;
		   LinearNode insertNode = new LinearNode(element);
		   LinearNode current = head;
		   LinearNode next = head.getNext();
			while (current != null && !found)
			{
				if (target.equals (current.getElement()))
					found = true;
				else
				{
					current = current.getNext();
					//if (current.getNext() != null)
						next = current.getNext();
				}//else
				
			}//while
				next = current.getNext();
			insertNode.setNext(next);
			insertNode.setPrev(current);
			next.setPrev(insertNode);
			current.setNext(insertNode);
			
			count++;
		}//else

	}//addAfter

	public void reverse()
	{
		/*
		LinearNode prev = null;
		LinearNode current = head;
		LinearNode next = null;
		while (current != null)
		{
			next = current.getNext();
			current.setNext(prev);
			prev = current;
			current = next;
		}//while
		head = prev;*/
		
		
		if (size() == 2)
		{
		  T temp = head.getElement();
		  head.setElement(tail.getElement());
		  tail.setElement(temp);
		}//if
		else if (size() > 2)
		{ 
			  LinearNode prev = head;
			  LinearNode curr = head.getNext();
			  LinearNode next = curr.getNext();
			  head.setNext(null); 
			  head.setPrev(curr);
			   
			  while (next != null)
			  {
			    curr.setNext(prev);
			    curr.setPrev(next);
				prev = curr;
				curr = next;
				next = next.getNext();
			  }//while
			   
		      curr.setNext(prev);
		      curr.setPrev(null);
		      tail = head; 
		      head = curr; 
		}//else

	}//reverse
	
	public void addTail(T element)
   {
           LinearNode insertNode = new LinearNode(element);
           LinearNode current = tail;
           if (current == null)//if it's the first one
           {
               tail = insertNode;
           }//if
			else
			{
               insertNode.setNext(null);
               current.setNext(insertNode);
				insertNode.setPrev(current);
               tail = insertNode;
			}//else
			if (count == 0)//sets head to the first inserted node
               head = insertNode;
           count++;
	}//addTail
	
	public  void addHead(T element)
	//PRE:	none – for simplicity sake we will not consider
	//	the !full precondition.
	//POS: 	list<exit> == list<entry> + element at front of
	//	list
	//TAS: 	Insert a new node at the front of the list
	{
		LinearNode insertNode = new LinearNode(element);
               LinearNode current = head;
               if (current == null)//if it's the first one
               {
                       head = insertNode;

               }//if
               else//not the first
               {
                       insertNode.setNext(current);
                       head = insertNode;//sets head to the argument
               }//else
               if (count == 0)//sets tail to the first inserted node
                       tail = insertNode;
               count++;
	}//addHead


   /**
    * Removes the first element in this list and returns a reference
    * to it.  Throws an EmptyListException if the list is empty.
    *
    * @return                           a reference to the first element of
    *                                   this list
    * @throws EmptyCollectionException  if an empty collection exception occurs
    */
   public T removeFirst() throws EmptyCollectionException
   {
      if (isEmpty())
         throw new EmptyCollectionException ("List");
	   /*
      LinearNode<T> result = head;
      head = head.getNext();
      if (head == null)
         tail = null;
	   head.setPrev(null);
      count--;
	   */
	   
	   LinearNode<T> temp = head;
	   if (head == tail)
	   {
		   System.out.println("This ran");
		   head = null;
		   tail = null;
	   }//if
	   else
	   {
		   head = head.getNext();
		   head.setPrev(null);
	   }//else
	   count--;
      return temp.getElement();
   }

   /**
    * Removes the last element in this list and returns a reference
    * to it.  Throws an EmptyListException if the list is empty.
    *
    * @return                           the last element in this list
    * @throws EmptyCollectionException  if an empty collection exception occurs
    */
   public T removeLast() throws EmptyCollectionException
   {
      if (isEmpty())
         throw new EmptyCollectionException ("List");
		/*
      LinearNode<T> previous = null;
      LinearNode<T> current = head;

      while (current.getNext() != null)
      {
         previous = current;
         current = current.getNext();
      }

      LinearNode<T> result = tail;
      tail = previous;
      if (tail == null)
         head = null;
      else
         tail.setNext(null);
      count--;
	   */
	   
	   LinearNode<T> temp = tail;
	   if (head == tail)
	   {
		   head = null;
		   tail = null;
	   }//if
	   else
	   {
		   tail = tail.getPrev();
		   tail.setNext(null);
	   }//else
	   count--;
  
      return temp.getElement();
   }
 

 public T remove (T targetElement) throws EmptyCollectionException,//doesn't work for middle names
         ElementNotFoundException
   {
      if (isEmpty())
         throw new EmptyCollectionException ("List");

      boolean found = false;
      LinearNode<T> previous = null;
      LinearNode<T> current = head;
		/*
      while (current != null && !found)
         if (targetElement.equals (current.getElement()))
            found = true;
         else
         {
            previous = current;
            current = current.getNext();
         }

      if (!found)
         throw new ElementNotFoundException ("List");

      if (size() == 1)
         head = tail = null;
      else if (current.equals (head))
         head = current.getNext();
      else if (current.equals (tail))
      {
         tail = previous;
         tail.setNext(null);
      }
      else
         previous.setNext(current.getNext());
		*/
		
		while (current != null && !found)
		{
			if (targetElement.equals (current.getElement()))
				found = true;
			else
			{
				current = current.getNext();
				//previous = current.getPrev();
			}//else
			
		}//while
		if (!found)
			throw new ElementNotFoundException ("List");
		if (count == 1)
			head = tail = null;
		else if (current.equals (head))
		{
			removeFirst();
			count++;
		}//else if
		else if (current.equals (tail))
		{
           removeLast();
			count++;
		}//else if
		else
		{
			//System.out.println("current thing: " + current.getNext().getElement().toString());
			previous = current.getPrev();
			//System.out.println("previous: " + previous.getElement().toString());
			current.getPrev().setNext(current.getNext());
			current.getNext().setPrev(previous);
		}//else
       count--;
		
      return current.getElement();
   }

   /**
    * Returns true if the specified element is found in this list and
    * false otherwise.  Throws an EmptyListException if the specified
    * element is not found in the list.
    *
    * @param targetElement              the element that is sought in the list
    * @return                           true if the element is found in
    *                                   this list
    * @throws EmptyCollectionException  if an empty collection exception occurs
    */
   public boolean contains (T targetElement) throws
         EmptyCollectionException
   {
      if (isEmpty())
         throw new EmptyCollectionException ("List");

      boolean found = false;
      Object result;

      LinearNode<T> current = head;

      while (current != null && !found)
         if (targetElement.equals (current.getElement()))
            found = true;
         else
            current = current.getNext();

      return found;
   }

   /**
    * Returns true if this list is empty and false otherwise.
    *
    * @return  true if this list is empty
    */
   public boolean isEmpty()
   {
      return (count == 0);
   }

   /**
    * Returns the number of elements in this list.
    *
    * @return  the integer representation of the number of elements in this list
    */
   public int size()
   {
      return count;
   }


   /**
    * Returns a string representation of this list.
    *
    * @return  a string representation of this list
    */
   public String toString()
   {
      LinearNode<T> current = head;
      String result = "";

      while (current != null)
      {
         result = result + (current.getElement()).toString() + "";
         current = current.getNext();
      }

      return result;
   }

   /**
    * Returns an iterator for the elements currently in this list.
    *
    * @return  an iterator over the elements of this list
    */
   public Iterator<T> iterator()
   {
      return new LinkedIterator<T>(head, count);
   }

   /**
    * Returns the first element in this list.
    *
    * @return  the first element in this list
    */
   public T first()
   {
      return head.getElement();
   }

   /**
    * Returns the last element in this list.
    *
    * @return  the last element in this list
    */
   public T last()
   {
      return tail.getElement();
   }


}


