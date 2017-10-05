package ca.edumedia.jaff0021.hilo;

import android.util.Log;

public final class RandomNumberV2 extends RandomNumber { // this is the derived class that inherits the base class that was given
	
	protected int minimum;
	protected int maximum;
	
	public RandomNumberV2() //default constructor 
	{
		maximum = 1000;
		minimum = 1;
	}
	
	public RandomNumberV2(int min, int max) //overriding constructor 
	{

		if(setMax(max) != true)
		{
			Log.i("Invalid", ": " + max);//if max or min fail the validation they are given negative numbers and a message is outputted indicating negative numbers
			maximum = -1;
		}
		
		if(setMin(min) != true)
		{
			Log.i("Invalid", ": " + min);
			minimum = -1;
		}

	}
	
	
	@Override
	public int generateRandomNumber() //this function generates a random number using the given max and min values 
	{
		currentRandomNumber = random.nextInt(maximum - minimum + 1) + minimum;
		return currentRandomNumber;
	}
	
	//get methods
	public int getMax() { return maximum; }
	public int getMin() { return minimum; }
	
	
	
	//set methods these also act as the validation methods to make sure the data passed in is within the required ranges
	public boolean setMax(int max) //these 
	{	
		if(max == 1000)
		{
			this.maximum = max;
			return true;
		}
		return false;
	}
	
	public boolean setMin(int min)
	{
		if(min == 1)
		{
			this.minimum = min;
			return true;
		}
		return false;
	}
}

