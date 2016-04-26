package assignment7;

import java.util.ArrayList;
import java.util.Random;

public class code {
	
	ArrayList<Character> contents = new ArrayList<Character>();

	//changes input string to type code
	public code(String s){
		char[] codeChar = s.toCharArray();
		for(int i = 0; i<4; i++){
			contents.add(codeChar[i]);
		}
	}
	
	//generates new random code
	public code(){
		
		for(int i=0; i<4; i++){
		 int randomNum = (int) (Math.random()*5); //between 0 and 5
		 char color = pegs.pickColor(randomNum);
		 contents.add(color);
		}
		
	}
	
	//sets pegs.indicator based on compare results
	public static void compare(code guess, code secret){
		
		ArrayList<Integer> scratch = new ArrayList<Integer>();
		
		//clear indicators from last turn
		pegs.indicatorClear();
		
		//if color in guess in right place in secret, indicator = black
		for (int i = 0; i<4; i++){
			if(guess.contents.get(i).equals(secret.contents.get(i))){
				pegs.indicator[i] = 'b';
				scratch.add(i);
			}
		}
		
		//if color in guess in wrong place in secret, indicator = white
		//first remove colors that have already been marked black, mark with X
		code secret2 = secret;
		for(int i=0; i<scratch.size(); i++){
			//TODO change all black pegs to X
		}
		
		for(int i = 0; i<4; i++){
			char currentColor = guess.contents.get(i);
			if((secret.contents.contains(currentColor)) && (secret.contents.get(i)!=currentColor)){
				pegs.indicator[i] = 'w';
			}
		}				
		
		
	}
}
