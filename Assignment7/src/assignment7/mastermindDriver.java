package assignment7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class mastermindDriver {

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
		
		/*Generate Secret Code*/
		
		/*Wait for guess (Repeat until 0 guesses left or guess correct)*/
			//validate guess (error proof)
			//interpret guess
			//print results (white&black pegs)
		
		
	}
}
