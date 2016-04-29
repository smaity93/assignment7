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

import java.util.ArrayList;


public class code extends mastermindDriver{
	
	public ArrayList<Character> contents = new ArrayList<Character>();
	public pegs codePegs;

	//changes input string to type code
	public code(String s){
		char[] codeChar = s.toCharArray();
		for(int i = 0; i<s.length(); i++){
			this.contents.add(codeChar[i]);
		}
		
		this.codePegs = new pegs();
	}
	
	//generates new random code
	public code(){
		
		this.codePegs = new pegs();
		
		for(int i=0; i<pegCount; i++){
		 int randomNum = (int) (Math.random()*5); //between 0 and 5
		 char color = this.codePegs.pickColor(randomNum);
		 this.contents.add(color);
		}
	
		
	}
	
	public String toStr(){
		
		char[] characters = new char[pegCount];
		for(int i=0; i<pegCount; i++){
			characters[i] = this.contents.get(i);
		}
		String s = new String(characters);
		
		return s;
	}
	
	public code copy(){
		
		String s = this.toStr();
		code result = new code(s);
		return result;
		
	}
	
	//sets pegs.indicator based on compare results
	public code compare(code secret){
		
		ArrayList<Integer> scratch = new ArrayList<Integer>();
		
		//clear indicators from last turn
		this.codePegs.indicatorClear();
		
		//if color in guess in right place in secret, indicator = black
		for (int i = 0; i<pegCount; i++){
			if(contents.get(i).equals(secret.contents.get(i))){
				this.codePegs.indicator[i] = 'b';
				scratch.add(i);
			}
		}
		
		//if color in guess in wrong place in secret, indicator = white
		//first remove colors that have already been marked black, mark with x
		code secret2 = secret.copy();
		
		for(int i=0; i<scratch.size(); i++){
				secret2.contents.set(scratch.get(i),'x');
				
		}
		
		for(int i = 0; i<pegCount; i++){
			char currentColor = this.contents.get(i);
			
			if(secret2.contents.get(i) == 'x'){
				//skip this letter
			}
			
			else if((secret2.contents.contains(currentColor))){
				this.codePegs.indicator[i] = 'w';
			}
		}	
		
		scratch.clear();
		return this;
		
		
	}
	
	//makes sure code input is valid input
	public boolean validCode(){
		if(this.contents.size() != pegCount){
			return false;
		}
		
		for(int i=0; i<contents.size(); i++){
			if(this.codePegs.validColor(this.contents.get(i)) == false){
				return false;
			}
		}
		
		return true;
	}
}