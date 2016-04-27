package assignment7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class mastermindDriver {
	
	static int guessCount = 12;

	public static void main(String[] args){
		/*Print Out Rules*/
		System.out.println("Rules");
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
			}
			else if (s.equals("N")){
				System.out.println("Okay, goodbye");
				wait = false;
			}
			else{
				System.out.println("Incorrect input, please try again.");
		
			}
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
		System.out.println("For debugging purposes, the secret code is " + secretString);
		
		wait = true;
		while(wait == true){
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
				System.out.println("You win");
				System.out.println("The secret code was " + secretString);
				wait = false;
			}
			else if(guessCount == 0){
				System.out.println("You have no guesses left. You lose.");
				System.out.println("The secret code was " + secretString);
				wait = false;
			}
		
			
		}	
			
		
		
	}
}
