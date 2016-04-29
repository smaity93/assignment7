/******************
 * EE422C - Assignment 7 - Bonus
 * @author Sharmistha Maity
 *         EID: sm47767
 *         Section: Thursday 11AM
 * @author Sneha Vasantharao
 *         EID: sv8398
 *         Section: Thursday 11AM
 ******************/

package assignment7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class mastermindDriver {
	
	static int guessCount;

	public static void main(String[] args){
		
		boolean playgame = false;
		
		/*Print Out Rules*/
		System.out.println("Rules");
		System.out.println("Welcome to Mastermind.  Here are the rules. This is a text version of the classic board game Mastermind."
				+ "\nThe computer will think of a secret code. The code consists of colored pegs. "
				+ "\nThe pegs may be one of six colors: blue, green, orange, purple, red, or yellow. "
				+ "\nA color may appear more than once in the code. You try to guess what colored pegs are in the code and what order they are in.   "
				+ "\nAfter you make a valid guess the result (feedback) will be displayed. "
				+ "\nThe result consists of a black peg for each peg you have guessed exactly correct (color and position) in your guess.  "
				+ "\nFor each peg in the guess that is the correct color, but is out of position, you get a white peg.  "
				+ "\nFor each peg, which is fully incorrect, you get no feedback."
				+ "\nOnly the first letter of the color is displayed. B for Blue, R for Red, and so forth. "
				+ "\nWhen entering guesses you only need to enter the first character of each color as a capital letter."
				 + "\nYou have 12 guesses to figure out the secret code or you lose the game.");
		
		/*Stream Input*/
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		/*Wait for input to be ready to play*/
		System.out.println("Ready to Play? Y/N");
		String s = "";
		boolean wait=true;
		
		while(wait == true){
			try {
				s = br.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(s.equals("Y")){
				System.out.println("Yay, let's go!");
				wait = false;
				playgame = true;
			}
			else if (s.equals("N")){
				System.out.println("Okay, goodbye");
				wait = false;
			}
			else{
				System.out.println("Incorrect input, please try again.");
		
			}
		}
		
		wait=true;	
		if (playgame == true){
			System.out.println("Please enter the number of guesses you'd like");
		}
		while ( wait == true && playgame == true) {
			try {
				s = br.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			guessCount = Integer.parseInt(s);
			wait = false;
		}

		/*Initialize Table of Guesses*/
		guess guessHistory = new guess();
		
		/*Generate Secret Code*/
		code secretCode = new code();
		String secretString = secretCode.contents.toString();
		
		/*Wait for guess (Repeat until 0 guesses left or guess correct)*/
			//compare guess with secret code
			//print results from indicator pegs (black or white)
			//repeat until guess is correct or 0 guesses left
		if (playgame == true) {
		System.out.println("For debugging purposes, the secret code is " + secretString);
		}
		
		wait = true;
		while(wait == true && playgame == true){
			boolean waitForGuess = false;
			code guessCode = new code();
			while(waitForGuess == false){
				System.out.println("You have " + guessCount + " guesses left. Enter your next guess");
				try {
					s = br.readLine();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				guessCode = new code(s);
				
				//check if input is valid
				
				waitForGuess = guessCode.validCode();
				if(waitForGuess == false){
					if(s.equals("history")){
						guessHistory.print();
					}
					else{
						System.out.println("Incorrect input, please try again");
					}
				}
				else{
					guessHistory.save(guessCode.toStr());
				}
			}
			
			code result = guessCode.compare(secretCode);
			result.codePegs.printIndicatorResults();
			
			guessCount--;
			
			if(result.codePegs.winStatus == 1){
				System.out.println("You win!!!");
				System.out.println("The secret code was " + secretString);
				wait = false;
			}
			else if(guessCount == 0){
				System.out.println("You have no guesses left. You lose :/.");
				System.out.println("The secret code was " + secretString);
				wait = false;
			}
		
			
		}	
			
		
		
	}
}
