package Arrays;

import java.util.Random;

public class DesertedIslandMain 
{

	public static void main(String[] args) 
	{
		Character[][] IslandArray = new Character[6][6];
		DesertedIslandMethods object = new DesertedIslandMethods();
		Random generator = new Random();
		
		int personRow, personColumn;
		char position='c';
		int direction;
		int trialCounter=1, stepCounter=0, sharkCounter=0, drownCounter=0, bridgeCounter=0;
		
		// start at 1 of the 16 random places on the island
			// randomize your walk across the island
			// you can take 1 step at a time, either horizontal or vertical
				// a random number 1-4 will chose your direction
		// you drown if you hit the water and get to safety if you step on a bridge
			// if you take 10 steps, on the island, the water is deep enough for a shark to eat you
			// if you get to safety, get eaten by shark, or down, restart the process by putting yourself back on the island
		// try again for 5 tries
			// randomize your position each time, it can be the same as the last
			// randomize the four bridges on the outside of the island
			// display each bridge as you are walking
			// display whether or not you made it to safety
			// keep track of the number of times you were eaten by a shark, drown or got off safely

		
		for(int i=1; i<=5; i++)
		{
			// generate the initial island
			IslandArray=object.InitialIsland(IslandArray);
			
			// generate positions of bridges
			IslandArray=object.GenerateBridges(IslandArray);
			
			// generate a spot where the person will be dropped
			personRow=generator.nextInt(4)+1;
			personColumn=generator.nextInt(4)+1;
			IslandArray[personRow][personColumn]='Z';
			
			// print what trial is being simulated (1 to 5)
			System.out.println("Trial "+trialCounter);
			trialCounter++;
			
			// print the board
			for(int r=0; r<IslandArray.length; r++)
			{
				for(int c=0; c<IslandArray.length; c++)
				{
					System.out.print(IslandArray[r][c]);
				}
				
				System.out.println("");
			}
			
			System.out.println("");

			// determine which way the person will move
			while((position!='X')&&(position!='O')&&(stepCounter<10))
			{
				IslandArray[personRow][personColumn]='c';
				
				direction=generator.nextInt(4)+1;
				stepCounter++;
				
				// move north
				if(direction==1)
				{
					personRow--;
					System.out.println("up");
				}
				
				// move south
				if(direction==2)
				{
					personRow++;
					System.out.println("down");
				}
				
				// move west
				if(direction==3)
				{
					personColumn--;
					System.out.println("left");
				}
				
				// move west
				if(direction==4)
				{
					personColumn++;
					System.out.println("right");
				}
				
				// store the character position in a temporary variable
				position=IslandArray[personRow][personColumn];
				
				// count how many times the person landed in the water or on a bridge
				if(((position=='X')&&(stepCounter>=10))||(position=='c')&&(stepCounter==10))
				{
					sharkCounter++;
				}
				else if((position=='X')&&(stepCounter<10))
				{
					drownCounter++;
				}
				else if((position=='O')&&(stepCounter<10))
				{
					bridgeCounter++;
				}
				
				// reassign the position as the place where the person no stands
				IslandArray[personRow][personColumn]='Z';
				
				// print the board
				for(int r=0; r<IslandArray.length; r++)
				{
					for(int c=0; c<IslandArray.length; c++)
					{
						System.out.print(IslandArray[r][c]);
					}
					
					System.out.println("");
				}
				
				System.out.println("");
			}
			
			// print how many steps the person took
			System.out.println("You took "+stepCounter+" step(s).");
			
			// print if, in this trial, the person landed in the water or on a bridge
			if(((position=='X')&&(stepCounter>=10))||(position=='c')&&(stepCounter==10))
			{
				System.out.println("You got eaten by a shark!");
			}
			else if((position=='X')&&(stepCounter<10))
			{
				System.out.println("You landed in the water, and you drowned!");
			}
			else if((position=='O')&&(stepCounter<10))
			{
				System.out.println("You landed on a bridge! You're safe.");
			}
			
			System.out.println("");
			
			position='c';
			stepCounter=0;
		}
		
		// print the counters at the end, after 5 trials of the game
		System.out.println("You got eaten by a shark "+sharkCounter+" time(s).");
		System.out.println("You drowned "+drownCounter+" time(s).");
		System.out.println("You landed on a bridge "+bridgeCounter+" time(s).");
	}
}