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

public class pegs extends mastermindDriver{
	
	ArrayList<Character> colors = new ArrayList<Character>();
	char[] indicator = new char[pegCount];
	public int winStatus = 0;
	
	public pegs(){
		colors.add('B'); colors.add('G'); colors.add('O'); colors.add('P'); colors.add('R'); colors.add('Y');
		for (int j=0; j<pegCount; j++){
			indicator[j] = 'n';
		}
		//indicator[0] = 'n'; indicator [1] = 'n'; indicator [2] = 'n'; indicator[3] = 'n';
		
	}
	
	public char pickColor(int i){
		return this.colors.get(i);
	}
	
	public void indicatorClear(){
		
		for (int j=0; j<pegCount; j++){
			indicator[j] = 'n';
		}
		
		//this.indicator[0] = 'n'; indicator [1] = 'n'; indicator [2] = 'n'; indicator[3] = 'n';
	}
	
	public void printIndicatorResults(){
		//indicator = black if right color in right place
		//indicator = white if right color in wrong place
		int whiteCount = 0;
		int blackCount = 0;
		
		for (int i = 0; i<pegCount; i++){
			if (this.indicator[i] == 'b'){blackCount++;}
			if (this.indicator[i] == 'w'){whiteCount++;}
		}
		
		System.out.println("Result: " + blackCount + " black pegs and " + whiteCount + " white pegs");
		System.out.println("");
		
		if(blackCount == pegCount){
			this.winStatus = 1;
		}
		
	}
	
	public boolean validColor(char c){
		//determine if input is valid color
		if(this.colors.contains(c)==true){
			return true;
		}
		
		else{
		return false;
		}
	}
	
	
	
	

}
