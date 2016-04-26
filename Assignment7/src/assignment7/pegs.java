package assignment7;

import java.util.ArrayList;

public class pegs {
	
	static ArrayList<Character> colors = new ArrayList<Character>();
	static char[] indicator = new char[4];
	public static int winStatus = 0;
	
	public pegs(){
		colors.add('B'); colors.add('G'); colors.add('O'); colors.add('P'); colors.add('R'); colors.add('Y');
		indicator[0] = 'n'; indicator [1] = 'n'; indicator [2] = 'n'; indicator[3] = 'n';
		
	}
	
	public static char pickColor(int i){
		return colors.get(i);
	}
	
	public static void indicatorClear(){
		indicator[0] = 'n'; indicator [1] = 'n'; indicator [2] = 'n'; indicator[3] = 'n';
	}
	
	public static void printIndicatorResults(){
		//indicator = black if right color in right place
		//indicator = white if right color in wrong place
		int whiteCount = 0;
		int blackCount = 0;
		
		for (int i = 0; i<4; i++){
			if (indicator[i] == 'b'){blackCount++;}
			if (indicator[i] == 'w'){whiteCount++;}
		}
		
		System.out.println("Result: " + blackCount + " black pegs and " + whiteCount + " white pegs");
		System.out.println("");
		
		if(blackCount == 4){
			winStatus = 1;
		}
		
	}
	
	public static boolean validColor(char c){
		//TODO determine if color input is a valid color in colors array
		
		
		return true;
	}
	
	
	
	

}
