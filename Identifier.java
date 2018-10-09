package com.company;

public class Identifier implements IdentifierInterface{
	//add modifier private
		
	StringBuffer identifier;
	
	Identifier(){
		identifier = new StringBuffer();
	}	
	Identifier(Identifier src){
		identifier = new StringBuffer();
		identifier.append(src.getChar());
	}
	
	Identifier(String c){
		identifier = new StringBuffer();
		identifier.append(c);
	}
	
	public void addChar(String x){
		identifier.append(x);
		return;
	}

	public String getChar(){
		return identifier.toString();
	}
	
	public int length() {
		return identifier.length();
	}

	public void init() {
		identifier = new StringBuffer();
	}
	
	public String print() {
		String print  = identifier.toString();
		return print;
	}
	

}

//Sets should be 20 identifiers, 10 in the main 