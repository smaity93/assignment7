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
			System.out.print(this.table.get(i)+" ");
		}
		
		System.out.println("");
	}
	
}
