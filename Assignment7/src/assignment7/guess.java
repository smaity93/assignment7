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

public class guess {

	public ArrayList<String> table;
	
	public guess(){
		this.table = new ArrayList<String>();
	}
	
	public void save(String s){
		this.table.add(s);
	}
	
	public void print(){
		for(int i=0; i<this.table.size(); i++){
			System.out.print(this.table.get(i)+"\n");
		}
		
		System.out.println("");
	}
	
}

