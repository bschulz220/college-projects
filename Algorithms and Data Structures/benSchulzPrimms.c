#include <stdio.h>
#include <limits.h>
#include <stdbool.h>

void showOutput(int dist[], int prev[]) 
{
	printf("      a b c d\nCost: ");
	int i = 0;
	for (i = 0; i < 4; i++)
	{
		printf("%i ", dist[i]);
	}
	printf("\nPrev: ");
	
	for (i = 0; i < 4; i++)
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
	
	int adj[4][4] = {{min, 8, 1, min}, {8, min, 6, 3}, {1, 6, min, 2}, {min, 3, 2, min}};
	
	bool visited[4] = {false, false, false, false};
	
	int dist[4] = {0, min, min, min};
	int prev[4] = {-1, from, from, from};
	int current = from;
	
	min = 0;
	int next = from;
	int x = 0;
		
	for (x = 0; x < 4; x++)
	{
		int tempMin = INT_MAX-min;
		
		int i = 0;
		for (i = 0; i < 4; i++)
		{
			
			if (visited[i] == false && i != current)
			{
				if ((adj[current][i]) < dist[i])
				{
					dist[i] = (adj[current][i]);
					prev[i] = current;
				}
			}
		}
		
		for (i = 0; i < 4; i++)
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

		min = tempMin;
		visited[current] = true;
		current = next;
	}
	
	showOutput(dist, prev);
}

