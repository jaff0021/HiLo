package ca.edumedia.jaff0021.hilo;

import android.util.Log;

/**
 * Created by zaheedjaffer on 2017-09-25.
 */

public class Game {
    private int totalGuesses;
    private RandomNumberV2 theNumber;
    private int userGuess;

    public Game() //default constructor
    {
        totalGuesses = 0; //default value is 0 because the user hasn't guessed yet
        userGuess = 0; //initialzed the user iput string as an empty string
        theNumber = new RandomNumberV2();
        theNumber.generateRandomNumber();
        Log.i("The number", ":" + theNumber.getCurrentRandomNumber());
    }

    public String setUser(String userGuess){
        Log.i("The number", ":" + theNumber.getCurrentRandomNumber());
        if(validateUserGuess(userGuess)){
            return checkUserGuess();
        }else{
            return "Please enter a number between 1 - 1000";
        }
    }

    private boolean validateUserGuess(String userGuess){
        try{
            this.userGuess = Integer.parseInt(userGuess);
        }
        catch(Exception e){
            Log.i("Validaiton Error", "user input is not a number");
            return false;
        }
        if(this.userGuess >= 1 && this.userGuess <= 1000){
            return true;
        }
        this.userGuess = 0;
        return false;
    }

    private String checkUserGuess(){

        if(this.totalGuesses > 10){
            return "Please Reset";
        }

        if(this.userGuess > theNumber.getCurrentRandomNumber()){
            this.totalGuesses += 1;
            return "Too High";
        } else if(this.userGuess < theNumber.getCurrentRandomNumber()) {
            this.totalGuesses += 1;
            return "Too Low";
        } else if(this.userGuess == theNumber.getCurrentRandomNumber())
        {
            //TODO figure out how to handle user guesses
            if(this.totalGuesses <= 5){
                this.totalGuesses = 100;
                return "Superior Win!";
            } else if(this.totalGuesses > 5 && this.totalGuesses < 10){
                this.totalGuesses = 100;
                return "Excellent Win!";
            }
        }
        return "Invalid";
    }

    //Get Method
    public int getTheNumber(){return theNumber.getCurrentRandomNumber();}

}

/*if the user takes 5 or less guesses, display a Toast message: "Superior win!";
if the user takes 6 to 10 guesses, display a Toast message: "Excellent win!";
if the user takes more than 10 guesses, display a Toast message: "Please Reset!"

The guess button will only display the "Please Reset" message if the user takes more than 10 guesses.
It will not recognize correct guesses after this point.

 */