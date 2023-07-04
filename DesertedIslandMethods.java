package Arrays;

import java.util.Random;

public class DesertedIslandMethods 
{
	public Character[][] InitialIsland(Character[][] IslandArray)
	{
		// fill the island array with water spaces 'X' first
		for(int r=0; r<IslandArray.length; r++)
		{
			for(int c=0; c<IslandArray.length; c++)
			{
				IslandArray[r][c]='X';
			}
		}
		
		// fill the inner spaces with 'c', positions where the person can be dropped
		for(int r=1; r<5; r++)
		{
			for(int c=1; c<5; c++)
			{
				IslandArray[r][c]='c';
			}
		}
		
		return IslandArray;
	}
	
	public Character[][] GenerateBridges(Character[][] IslandArray)
	{
		int row=0, column=0;
		
		// determine where the bridges (O) will fall by randomly generating them
		for(int x=0; x<4; x++)
		{
			Random generator = new Random();
			row=generator.nextInt(6);
			column=generator.nextInt(6);
					
			// regenerate a position for the bridge if it's in a corner, in the inner space, or a bridge is already there
			while(((row==0)&&(column==0))||((row==0)&&(column==5))||((row==5)&&(column==0))||((row==5)&&(column==5))||(IslandArray[row][column]=='c')||(IslandArray[row][column]=='O'))
			{
				row=generator.nextInt(6);
				column=generator.nextInt(6);
			}
						
			IslandArray[row][column]='O';
		}
		
		return IslandArray;
	}
}