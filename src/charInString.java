import java.util.HashMap;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;


//import java.util.regex;

public class charInString {
    static int ALL_CHARACTERS = -1;
    static int ALPHABETIC = 1;
    static int ONLY_FOUND = 0;
    static int ONLY_FOUND_ALPHABETIC = 2;
    public static void main(String[] args) throws IOException{
        HashMap<Character, Integer> charMap = new HashMap<Character, Integer>();

        //Bonus 1
        /*
        Scanner input = new Scanner(System.in);
        System.out.println("Type in your sentence:");
        String testString = input.nextLine();
        */

        //Super Bonus
        File inputFile = new File("src/file.txt");
        Scanner superInput = new Scanner(inputFile);
        StringBuffer buffer = new StringBuffer();
        String superTestString;

        while(superInput.hasNext()){
            superTestString = superInput.nextLine();
            buffer.append(" " + superTestString.toUpperCase());
        }

        String newString = buffer.toString();
        char[] charString = newString.toUpperCase().toCharArray();

        //String testString = "If the product of two terms is zero then common sense says at least one of the two terms has to be zero to start with. So if you move all the terms over to one side, you can put the quadratics into a form that can be factored allowing that side of the equation to equal zero. Once you’ve done that, it’s pretty straightforward from there.";
        // char[] charString = testString.toUpperCase().toCharArray(); //Bonus 2
        for( char c : charString){
            if(charMap.containsKey(c)){
                charMap.replace(c, charMap.get(c), charMap.get(c) + 1);
            } else {
                charMap.put(c, 1);
            }
        }

        //printHashMap(charMap, ALL_CHARACTERS);
        printHashMap(charMap, ALPHABETIC); //bonus 3
        //printHashMap(charMap, ONLY_FOUND);
    }
    //Bonus 3
    public static void printHashMap(HashMap<Character, Integer> charMap, int searchType){
        char startVal = 0, endVal = 0;
        if(searchType < 0){ // Print all characters = alphabetical, numerical, and punctuation
            startVal = 32;
            endVal = 96;
        // Bonus 3
        } else if (searchType == 1){ // Print only alphabetical characters
            startVal = 65;
            endVal = 91;
        } else if(searchType == 0) {    // Print only characters found in the string
            for(Character c : charMap.keySet()){
                System.out.println(c + ": " + charMap.get(c));
            }
            return;
        }

        for(char c = startVal; c < endVal; c++){
            if(charMap.containsKey(c)){
                System.out.println( c +": " + charMap.get(c));
            } else {
                System.out.println(c + ": 0");
            }
        }
    }
}
