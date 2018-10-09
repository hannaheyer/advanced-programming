
package com.company;

public interface SetInterface{


    /** add
     * @precondition
     *	    identifier must be unique
     * @postcondition
     *	    adds id to Set just if identifier is new 
     **/
    public void add(Identifier identifier);


   /** size
     * @precondition
     *	    -
     * @postcondition
     *	    returns size of Set
     **/
    public int size();
    
    /** intersection
     * @precondition
     *	    two Sets
     * @postcondition
     *	    returns Set with the intersections of two Sets
     **/
    public Set intersection(Set Set2);
    
    /** difference
     * @precondition
     *	    two Sets
     * @postcondition
     *	    returns Set with the differences of two Sets
     **/
    public Set difference(Set Set2);
    
    /** union
     * @precondition
     *	    two Sets
     * @postcondition
     *	    returns Set with the unions of two Sets
     **/
    public Set union(Set Set2);
    
    /** symmetric difference
     * @precondition
     *	    two Sets
     * @postcondition
     *	    returns Set with the symmetric differences of two Sets
     **/
    public Set symdifference(Set Set2);
    
    /** has id
     * @precondition
     *	    -
     * @postcondition
     *	    returns true if identifier is in array
     **/
    public boolean has_ID(Identifier identifier);
    
    /** increase size
     * @precondition
     *	    -
     * @postcondition
     *	    increases the size of a Set
     **/
    public void increaseSize();
    
    /** print
     * @precondition
     *	    -
     * @postcondition
     *	    prints Set
     **/
    public void print();
    
    /** copy
     * @precondition
     *	    -
     * @postcondition
     *	    copies elements from Set
     **/
    public void copyElements(Identifier[] dest, Identifier[] src, int amount); //use copyconstructor or make it private or give not away the array


    // get() random element or one certain element, you cant use index, 
}