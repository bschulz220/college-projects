package dalgo;

public class dalgo 
{

	public static void main(String[] args) 
	{
		int from = 0; //from a
		int to = 4;   //to e
		
		int min = Integer.MAX_VALUE-100; //MAX_INT
		
		int[][] adj = {{min, 1, 3, min, min, min}, {1, min, 1, min, min, 1}, {3, 1, min, 2, 4, min}, {min, min, 2, min, 1, 2}, {min, min, 4, 1, min, 1}, {min, 1, min, 2, 1, min}};
		
		boolean[] visited = {false, false, false, false, false, false};
		
		int[] dist = {0, min, min, min, min, min};
		int[] prev = {-1, from, from, from, from, from};
		int current = from;
		
		min = 0;
		int next = from;
		for (int x = 0; x < 6; x++)
		{
			int tempMin = Integer.MAX_VALUE-min;
			
			for (int i = 0; i < 6; i++)
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
			
			for (int i = 0; i < 6; i++)
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
			printOut(dist, prev);
			min = tempMin;
			//System.out.println(min);
			visited[current] = true;
			current = next;
		}
		
		System.out.println("Shortest path between " + from + " and " + to + ": ");
		next = to;
		while (next != from)
		{
			System.out.print(next + " - ");
			next = prev[next];
		}
		System.out.print(from);
		
	}

	public static void printOut(int[] dist, int[] prev)
	{
		System.out.println("{-----------------------------");
		System.out.println(" a b c d e f");
		System.out.print(" ");
		for (int i = 0; i < 6; i++)
		{
			System.out.print(dist[i] + " ");
		}
		System.out.println();
		for (int i = 0; i < 6; i++)
		{
			System.out.print(prev[i] + " ");
		}
		System.out.println();
		System.out.println("-----------------------------}");

	}
}
