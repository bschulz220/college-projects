#include <stdio.h>
#include <limits.h>
#include <stdbool.h>

void showOutput(int dist[], int prev[]) 
{
	printf("      a b c d e f\nCost: ");
	int i = 0;
	for (i = 0; i < 6; i++)
	{
		printf("%i ", dist[i]);
	}
	printf("\nPrev: ");
	
	for (i = 0; i < 6; i++)
	{
		switch (prev[i])
		{
			case -1 :
				printf("- "); /* starting point; no previous point */
				break;
			case 0 :
				printf("a ");
				break;
			case 1 :
				printf("b ");
				break;
			case 2 :
				printf("c ");
				break;
			case 3 :
				printf("d ");
				break;
			case 4 :
				printf("e ");
				break;
			case 5 :
				printf("f ");
				break;
		}
		/*printf("%i ", prev[i]);*/
	}
	printf("\n");
}

void main(void) 
{
	int from = 0; /* from a */
	int to = 4;  /* to e */
	
	int min = INT_MAX-100;
	
	int adj[6][6] = {{min, 1, 3, min, min, min}, {1, min, 1, min, min, 1}, {3, 1, min, 2, 4, min}, {min, min, 2, min, 1, 2}, {min, min, 4, 1, min, 1}, {min, 1, min, 2, 1, min}};
	
	bool visited[6] = {false, false, false, false, false, false};
	
	int dist[6] = {0, min, min, min, min, min};
	int prev[6] = {-1, from, from, from, from, from};
	int current = from;
	
	min = 0;
	int next = from;
	int x = 0;
		
	for (x = 0; x < 6; x++)
	{
		int tempMin = INT_MAX-min;
		
		int i = 0;
		for (i = 0; i < 6; i++)
		{
			
			if (visited[i] == false && i != current)
			{
				if ((adj[current][i] + min) < dist[i])
				{
					dist[i] = (adj[current][i] + min);
					prev[i] = current;
				}
			}
		}
		
		for (i = 0; i < 6; i++)
		{
			if (visited[i] == false && i != current)
			{
				if (tempMin > dist[i])
				{
					tempMin = dist[i];
					next = i;
				}
			}
		}
		/*print out?*/
		min = tempMin;
		visited[current] = true;
		current = next;
	}
	
	printf("Shortest path between ");
	printf("%i", from);
	printf(" and ");
	printf("%i", to);
	printf(": ");
	
	next = to;
	while (next != from)
	{
		printf("%i", next);
		printf(" - ");
		next = prev[next];
	}
	printf("%i", from);
	printf("\n");
	
	showOutput(dist, prev);
}

