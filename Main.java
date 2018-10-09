package com.company;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {

    boolean system_on;
    boolean read_set;
    Identifier identifier1;
    Identifier identifier2;
    Scanner inputReader;
    Set Set1 = new Set();
    Set Set2 = new Set();
    Set intersection = new Set();
    Set difference = new Set();
    Set union = new Set();
    Set symdifference = new Set();


    public static void main(String[] args) {
        new Main().start();

    }

    private static int MAX_IDS = 20;


    private Set querySet(String query, Scanner inputReader){

        boolean answerIsCorrect = false;
        String[] idStrings = new String[MAX_IDS];
        while(!answerIsCorrect){
            System.out.println(query);
            String answer = inputReader.nextLine();
            Scanner answerReader = new Scanner(answer);
            // check answer        
            answerReader.useDelimiter("");
                        if(!nextCharIs(answerReader, '{')){
                System.out.println("First character should be {");
                continue; // error, ask question again.
            }else{
                nextChar(answerReader); // remove { from buffer
            }
            idStrings = new String[MAX_IDS];
            String idString = "";
            boolean invalidEntry = false;
            boolean hasClosingBracket = false;
            int idIdx = 0; // index for storing index of idStrings
            while(answerReader.hasNext()){
                if(!nextCharIsDigit(answerReader)){
                    if(!nextCharIsLetter(answerReader)){
                        if(!nextCharIs(answerReader,'}')){
                            if(!nextCharIs(answerReader, ' ')){
                                System.out.println("Only alpha numeric characters allowed!");
                                invalidEntry = true;
                                break;
                            }else { // character is a space
                                if (idString.length() > 1) {
                                    if(idIdx > (MAX_IDS -1)){ // already 20 identifiers in set
                                        System.out.println("No more than 20 identifiers allowed in set!");
                                        invalidEntry = true;
                                        break;
                                    }
                                    idStrings[idIdx] = idString; // store old idString
                                    idIdx++;
                                    idString = "";// make new idString
                                } // else its a trailing space, don't do anything
                                nextChar(answerReader); // consume space char
                            }
                        }else{ // character is }
                            hasClosingBracket = true;
                            nextChar(answerReader); // consume bracket
                            idStrings[idIdx] = idString; // store old idString
                            idIdx++;
                            break;
                        }
                    }else { // character is letter
                        idString += nextChar(answerReader);
                    }
                }else{ // character is number
                    if (idString.length() > 0 ){
                        // character is not the first in identifier
                        idString += nextChar(answerReader);
                    }else{
                        System.out.println("First char of an identifier can't be numeric.");
                        invalidEntry = true;
                        break;
                    }
                }
            }

            if(invalidEntry){
                continue;
            }
            if(answerReader.hasNext()){ // scanner still has characters after closing brackets
                System.out.println("No characters allowed after '}' ");
                continue;
            }
            if(!hasClosingBracket){
                System.out.println("Missing '}' ");
                continue;
            }
            answerIsCorrect = true;

        }

        //Identifier[] identifiers = new Identifier[MAX_IDS];
        Set result = new Set();
        for(int i = 0; i < MAX_IDS; i++){
            result.add(new Identifier(idStrings[i]));
            //identifiers[i] = new Identifier(idStrings[i]);
        }

        return result;
    }

    private char nextChar(Scanner input){
        return input.next().charAt(0);
    }


    private boolean nextCharIs(Scanner input, char c){
        return input.hasNext(Pattern.quote(c+""));
    }


    private boolean nextCharIsDigit(Scanner input){
        return input.hasNext("[0-9]");
    }


    private boolean nextCharIsLetter(Scanner input){
        return input.hasNext("[a-zA-Z]");
    }







    public void start() {

        Scanner inputReader = new Scanner(System.in);


        // Ask Q1
        Set Set1 = querySet("Give the first set: ", inputReader);






        Set Set2 = querySet("Give the second set: ", inputReader);
        parse_operations();


    }




    private void result(Set Set) {
        System.out.print("{");
        Set.print();
        System.out.println("}");
    }

    private void parse_operations() {
        difference = Set1.difference(Set2);
        intersection = Set1.intersection(Set2);
        union = Set1.union(Set2);
        symdifference = Set1.symdifference(Set2);
        System.out.print("intersection: ");
        result(intersection);
        System.out.print("difference: ");
        result(difference);
        System.out.print("union: ");
        result(union);
        System.out.print("symmetric difference: ");
        result(symdifference);
    }

    private void empty_set(Set Set){
        Set.init();
    }

    private void empty_sets(){
        Set1.init();
        Set2.init();
    }


}