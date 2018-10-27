package program2;

import java.io.*; 
import java.util.*; 

public class LinkedQueue<T> implements QueueADT<T>
{
 

private int count; // the current number of elements in the queue 
private LinearNode<T> front; // references the front item in the queue
private LinearNode<T> rear; // references the rear item in the queue

public LinkedQueue()
//POS: count == 0; front == null; rear == null
//TAS: Creates an empty queue.
{
  count = 0;
  front = null;
  rear = null;
}//LinkedQueue

public void enqueue (T element)
//PRE: init<element>
//POS: queue<exit> == queue<entry>+new element at rear
//TAS: Adds element to the queue
{
  LinearNode<T> node = new LinearNode<T> (element);

  if (isEmpty())
    front = node;
  else
    rear.setNext(node);
  rear = node;
  count++;
}//enqueue

public T dequeue() //throws EmptySetException
//PRE: !isEmpty()
//POS: queue<exit> == queue<entry> - front item
//TAS: removes the front element from the queue
{
  T result = front.getElement();
  front = front.getNext();
  count--;  
  if (isEmpty())
    rear = null;
  return result;
}//dequeue 

public T front()
//PRE: !isEmpty()
//POS: none
//TAS: returns w/o romoving the front element in the queue
{
  return front.getElement();
} //front 

public boolean isEmpty()
//PRE: none
//POS: none
//TAS: returns true if the queue has no elements; false otherwise
{
  return (count == 0);
}//isEmpty

public int size()
//PRE: none
//POS: none
//TAS: returns the number of elements in the queue
{
  return count;
}//size

public boolean isFull()
//PRE: none
//POS: none
//TAS: returns false
{
  Object test = new Object();
  return (test == null);
}//isFull 

public String toString()
//PRE:
//POS:
//TAS: Returns a string representation of the queue
{
  return " ";
}//toString
 

}//LinkedQueue
 