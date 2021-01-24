#include <stdio.h>
#include <stdlib.h>

void main(int argc, char ** argv)
{
	/* I used this to fill a file with random numbers
	srand(time(NULL));
	FILE * inFile = fopen("in.txt", "w");
	int x = 0;
	for (x = 0; x < 1000; x++)
	{
		int r = rand()%10;
		char c = (char)(r + 48);
		fputc(c, inFile);
	}
	fclose(inFile);
	*/

	//FILE * inFile = fopen("in.txt", "r");
	//FILE * outFile = fopen("out.txt", "w");
	
	if (argc == 3)
	{
		FILE * inFile = fopen(argv[1], "r");
		FILE * outFile = fopen(argv[2], "w");
		
		
		int listSize = 1000;
		
		int * freq = (int*)calloc(10, sizeof(int));;
		
		char c;
		//printf("%d\n", i);
		int x;
		for (x = 0; x < listSize; x++)
		{
			//fscanf(inFile, "%c", &c);
			c = fgetc(inFile);
			int i = ((int)c ) - 48;
			//printf("%d", i);
			freq[i] = freq[i]+1;
		}
		for (x = 0; x < 10; x++)
		{
			int z;
			for (z = 0; z < freq[x]; z++)
			{
				//printf("%d", x);
				char c = (char)(x + 48);
				fputc(c, outFile);
			}
		}
		//printf("\n");
		
		fclose(inFile);
		fclose(outFile);
	}
	else
	{
		printf("Wrong number of arguments.\n");
	}
}