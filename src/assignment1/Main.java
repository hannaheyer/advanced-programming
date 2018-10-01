package assignment1;

import java.util.IdentityHashMap;
import java.util.Scanner;
import java.util.regex.Pattern;


public class Main {

    private static int MAX_IDS = 10;

    private Set querySet(String query, Scanner inputReader){

        boolean answerIsCorrect = false;
        String[] idStrings = new String[MAX_IDS];
        while(!answerIsCorrect){
            System.out.println(query);
            String answer = inputReader.nextLine();
            // check answer
            Scanner answerReader = new Scanner(answer);
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
                                    if(idIdx > (MAX_IDS -1)){ // already 10 identifiers in set
                                        System.out.println("No more than 10 identifiers allowed in set!");
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

        Identifier[] identifiers = new Identifier[MAX_IDS];
        for(int i = 0; i < MAX_IDS; i++){
            identifiers[i] = new Identifier(idStrings[i]);
        }
        Set result = new Set(identifiers);
        return result;
    }

    public void start() {
        Scanner inputReader = new Scanner(System.in);
        while(true){

            // Ask Q1
            Set firstSet = querySet("Give the first set: ", inputReader);

            //lengthFirst = firstSet.getLength();
            Set secondSet = querySet("Give the second set: ", inputReader);





            // Check A1


            // Ask Q2


            // Check A2


            // Do set op on A1 & A2


            // report result


        }

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


    public static void main(String[] argv){
        new Main().start();


    }
}




