package com.company;

public interface IdentifierInterface {

    /** ADT for the class Identifier.
     *
     *
     **/

        /** adds a character
         * @precondition
         *	    -
         * @postcondition
         *	    adds a String c to Identifier
         **/
        public void addChar(String x); // check whether it adds char or string, add char immediatley


        /** changes identifier to string
         * @precondition
         *	    identifier in char
         * @postcondition
         *	 identifier is changed to string
         **/
        public String getChar();


        /** length
         * @precondition
         *	    -
         * @postcondition
         *	    return length of Identifier
         **/
        public int length();


        /** Returns new identifier
         * @precondition
         *	    -
         * @postcondition
         *	    returns empty identifier  //length can't be 0, initiaze 1 letter, dummy character, default constructor cant be empty
         **/
        public void init();
    }
