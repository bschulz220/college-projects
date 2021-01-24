#include <stdio.h>
#include <stddef.h>
#include <stdlib.h>
#include <string.h>

struct node 
{
	char * word;
	struct node * next;
};

int first = 1; //queue is empty

char * dequeue (struct node ** head, struct node ** tail)
{
	struct node * temp = (struct node*)calloc(1, sizeof(struct node));
	char * tempStr = NULL;
	
	if ((**head).next == NULL) //last node in the queue
	{
		//printf("hit the last node in dq\n");
		tempStr = (**head).word;
		//free(head);
		//free(tail);
		//*head = NULL;
		first = 1;
	}
	else if (*head != NULL)
	{
		temp = *head;
		//temp = (**head).next;
		tempStr = (**head).word;
		if ((**head).next == NULL)
		{
			*tail = NULL;
			first = 1;
		}
		(*head) = (*temp).next;//segfault
		//(*head) = (**head).next;
		//(*head) = temp;
		//free(temp);
	}
	
	if ((*head) == NULL)//((**head).next == NULL) //or if head == tail before head is dequeued
	{
		//printf("**head.next is null\n");
		first = 2;
		//**tail = (**head);
	}
	free(temp);
	return tempStr;
}

void main(void) 
{
	struct node * front = (struct node*)calloc(1, sizeof(struct node));
	struct node * back = (struct node*)calloc(1, sizeof(struct node));
	int count = 0; //should end at 100,012
	
	srand(time(NULL));
	
	int i = 0;
	
	int x = 0;
	for (x = 0; x < 10; x++) //first part; enqueue 10 nodes
	{
		char * s = (char*)calloc(1000000, sizeof(char));
		for (i = 0; i < 1000000; i++)
		{
			int r = rand()%26+65;
			s[i] = r;
		}
		
		enqueue(s, &front, &back);
		//count++;
		//printf("%d\n", count);
	}
	
	for (x = 0; x < 100000; x++) //2nd part; will run 100,000 times in final
	{
		char * s = (char*)calloc(1000000, sizeof(char));
		for (i = 0; i < 1000000; i++)
		{
			int r = rand()%26+65;
			s[i] = r;
		}
		
		if (enqueue(s, &front, &back) == 0)
		{
			printf("%d\n", count);
			x = 100000;//end for loop
		}
		else
		{
			free(dequeue(&front, &back));
			count++;
			//printf("%d\n", count);
		}
	}
	
	for (x = 0; x < 12; x++) //3rd part; dequeue 12 times
	{
		
		//char * tempStr = dequeue(&front, &back);
		/*
		printf("made it this far %d\n", x);
		//printf("%s\n", tempStr);
		
		if (tempStr != NULL)
		{
			printf("ran this part %d\n", x);
			free(tempStr);
		}
		else // if (tempStr == NULL)
		{
			printf("it's null\n");
		}*/
		if (first == 0 || first == 2) //(first != 2 && first != 1)
		{
			//printf("first is 0 or 2: %d\n", x);
			free(dequeue(&front, &back));
		}
		//dequeue(&front, &back);
		count++;
	}
	
	printf("%d\n", count); //should end at 100,012 in final
	
	//free(front);
	//free(back);
}

int enqueue (char * string, struct node ** head, struct node ** tail)
{
	struct node * newNode = (struct node*)calloc(1, sizeof(struct node));
	if (newNode == NULL)
	{
		//printf("this thing is NULL");
		return 0;
	}
	(*newNode).word = string;
	
	if (first == 1)//nothing in the queue yet
	{
		//printf("ran1\n");
		**head = (*newNode);
		**tail = (**head);
		first = 2;
	}
	else if (first == 2)//one thing in the queue
	{
		//printf("ran2\n");
		(**head).next = newNode;
		*tail = (**head).next;
		first = 0;
	}
	else //more than 1 thing in the queue
	{
		//printf("ran0\n");
		(**tail).next = newNode;
		if ((**head).next == NULL)
		{
			printf("head.next is null\n");
		}
		*tail = (**tail).next;
	}
	return 1;
}