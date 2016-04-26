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
		
		/*initialize board game*/
		pegs game = new pegs();
		
		/*Generate Secret Code*/
		code secretCode = new code();
		String secretString = secretCode.contents.toString();
		
		/*Wait for guess (Repeat until 0 guesses left or guess correct)*/
			//compare guess with secret code
			//print results from indicator pegs (black or white)
			//repeat until guess is correct or 0 guesses left
		System.out.println("You have " + guessCount + " guesses left. Enter your next guess");
		wait = true;
		while(wait == true){
			
			try {
				s = br.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			code guessCode = new code(s);
			code.compare(guessCode, secretCode);
			pegs.printIndicatorResults();
			
			guessCount--;
			
			if(pegs.winStatus == 1){
				System.out.println("You win");
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