package com.company;

public class Set {
	private Identifier[] idArray;
	private static final int MAX_AMOUNT_OF_ELEMENTS = 20;
	private int amountElements;

	public Set() {
		idArray = new Identifier[amountElements];
		amountElements = 0;
	}

	private void copyElements(Identifier[] dest, Identifier[] src, int amount) {
		for (int i = 0; i < amount; i++) {
			dest[i] = new Identifier(src[i]);
		}
	}

	public Set(Set src) {
		idArray = new Identifier[src.idArray.length];
		amountElements = src.amountElements;
		copyElements(idArray, src.idArray, amountElements);
	}
	
	public Set(Set src, int shorter) {
		idArray = new Identifier[src.idArray.length-shorter];
		amountElements = src.amountElements;
		copyElements(idArray, src.idArray, amountElements);
	}
	
	void init() {
		idArray = new Identifier[0];
		amountElements = 0;
	}
	
	public void add(Identifier identifier) {
		if (amountElements == idArray.length) {
			increaseSize();
		}
		idArray[amountElements] = new Identifier(identifier);
		amountElements += 1;
		
	}
	
	public int size() {
		return amountElements;
	}
	
	public void print() {
		for(int i=0; i<idArray.length; i++){
			System.out.print(idArray[i].identifier);
			if(i != idArray.length -1){
				System.out.print(" ");
			}
		}
		return;
	}
	
	private void increaseSize () {
		Identifier[] result = new Identifier[1 + idArray.length];
		if(idArray.length == MAX_AMOUNT_OF_ELEMENTS){
			System.out.println("Too many identifiers");
		}
		copyElements(result, idArray, amountElements);
	        idArray = result;
	    }
	
	public boolean isEmpty ()  {
		return amountElements == 0;
	}
	
	public Identifier getnextID(Set Set, int i) {
		Identifier identifierAt = Set.idArray[(amountElements-(i+1))];
		return identifierAt;
	}
	
	public boolean has_ID(Identifier identifier) {
		for(int j =0; j < size();j++){
			if(idArray[j].identifier.toString().equals(identifier.identifier.toString())){
				return true;
			}
		}
		return false;
	}
	
	public Set delete(Identifier identifier, Set difference){
		for (int i = 0; i < size(); i++) {
			if (difference.idArray[i].identifier.toString().equals(identifier.identifier.toString())){
				for (int j = i; j < size()-1; j++) {
					difference.idArray[j] = difference.idArray[j + 1];
				}
				difference.amountElements -= 1;
				difference = new Set(difference, 1);
				return difference;
			}
		}
		return difference;
	}
		
	

	public Set intersection(Set Set2) {
		Set intersection = new Set();
		for(int i=0; i < size() ;i++){
			for(int j =0; j < Set2.size();j++){
				if(idArray[i].identifier.toString().equals(Set2.idArray[j].identifier.toString())){
					intersection.add(idArray[i]);
			}
		}
		
	}
		return intersection;
	
}
	public Set difference(Set Set2) {
		Set difference = new Set(this);
		for(int i=0; i < size() ;i++){
			for(int j =0; j < Set2.size();j++){
				if(idArray[i].identifier.toString().equals(Set2.idArray[j].identifier.toString())){
					difference = difference.delete(idArray[i], difference);
				}
			}
		}
		
		return difference;
	
}
	public Set union(Set Set2) {
		Set union = new Set(this);
		for(int i=0; i < Set2.size() ;i++){
			if(has_ID(Set2.idArray[i]) == false){
				union.add(Set2.idArray[i]);
			}
		}
		return union;
		
	}
	
	public Set symdifference(Set Set2) {
		Set symdifference = new Set();
		Set add1 = new Set();
		Set add2 = new Set();
		add1 = this.difference(Set2);
		add2 = Set2.difference(this);
		symdifference = add1.union(add2);
		return symdifference;

}

//and use get and remove to see what is left
		
}