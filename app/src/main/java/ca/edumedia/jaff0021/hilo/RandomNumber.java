package ca.edumedia.jaff0021.hilo;

import java.util.Random;


public class RandomNumber //this class was the one provided by you the teacher our guide through the deadly OOP
{
		protected Random random;
        protected int currentRandomNumber;
    
	public RandomNumber() 
	{
		currentRandomNumber = 0;
		random = new Random();
	}
	
	public int generateRandomNumber()
	{
		currentRandomNumber = random.nextInt();
		return currentRandomNumber;
	}
	
	public int getCurrentRandomNumber() { return currentRandomNumber; }
}
