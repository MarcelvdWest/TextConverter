
package textconverter;

import testsuite.*;

/**
 *
 * @author Marcel van der Westhuizen
 */

public class TextConverter implements CaseUtil {
    
    String errorMessage = "";
    boolean errorState = false;
    
    @Override
    public String asCamelCase(String text) {
        //Removes leading and trailing spaces
        String textTrim = text.trim();
        //Create an array that has the size of the characters in the string 
        //without spaces
        char[] charArr = new char[textTrim.replaceAll(" ", "").length()];
        errorState = false;
        int spaceCount = 0;
        
        //Loop through String 
        for (int i = 0 ; i < textTrim.length() ; i++) {
          
            try {
                //Checks that the current caracter is not a space is a aphabetical
                if (textTrim.charAt(i) != ' ' && Character.isAlphabetic(textTrim.charAt(i))) {
                    //Changes fisrt character to lowercase
                    if (i == 0) {
                            charArr[i] = Character.toLowerCase(textTrim.charAt(i));
                    //Checks for a preceding space in the initail input and then capatilises character if applicable   
                    } else if (textTrim.charAt(i-1) == ' ') {
                        charArr[i - spaceCount] = Character.toUpperCase(textTrim.charAt(i));
                    //This changes all other alphabetical characters to lower case    
                    } else {
                        charArr[i - spaceCount] = Character.toLowerCase(textTrim.charAt(i));    
                    }
                  //If there is a space in the trimmed text input the adjusted value of spaceCount is used to adjust the index position of the character in the new char[]  
                } else if (textTrim.charAt(i) == ' '){
                    
                    spaceCount = spaceCount + 1;
                  //This this will throw an error if there are any non-alphabetical charaters in the text input, the catch then stops processing  
                } else {
                    errorState = true;
                    throw new IllegalArgumentException("You can only use alphabetical characters and spaces with this method.");
                }
            } catch (IllegalArgumentException e) {
                errorMessage = e.getMessage();
                return errorMessage;         
            }
        }
            return String.valueOf(charArr);
    }
            
    @Override        
    public String asSnakeCase(String text) {
        //Removes leading and trailing spaces
        String textTrim = text.trim();
        //Create String Array
        char[] charArr = new char[textTrim.length()];
        errorState = false;
        
        //Loop through String 
        for (int i = 0 ; i < textTrim.length() ; i++) {
            
            try {
                //This checks for spaces and replaces them with an underscore
                if (textTrim.charAt(i) == ' ') {
                    charArr[i] = '_';
                //This changes all characters to lowercase    
                } else if(Character.isAlphabetic(textTrim.charAt(i))) {
                    charArr[i] = Character.toLowerCase(textTrim.charAt(i));
                //This this will throw an error if there are any non-alphabetical charaters in the text input, the catch then stops processing   
                } else {
                    errorState = true;
                    throw new IllegalArgumentException("You can only use alphabetical characters and spaces with this method.");
                }
            } catch(IllegalArgumentException e) {
                errorMessage = e.getMessage();
                return errorMessage;
            }    
        }
            return String.valueOf(charArr);
    }
    
    @Override
    public String asHumanReadableText(String text) {
        //Removes leading and trailing spaces
        String textTrim = text.trim();
        //Create string array
        char[] charArr = new char[textTrim.length() + 1];
        charArr[charArr.length - 1] = '.';
        errorState = false;
        
        //Loop through String 
        for (int i = 0 ; i < textTrim.length() ; i++) {
            
             try {
                //This checks for underscores and space and enters spaces into the char array in their place
                if (textTrim.charAt(i) == '_' || textTrim.charAt(i) == ' ') {
                    charArr[i] = ' '; 
                } else if(Character.isAlphabetic(textTrim.charAt(i))) {
                    //Changes first character to uppercase
                    if (i == 0) {
                        charArr[i] = Character.toUpperCase(textTrim.charAt(i));
                    //This changes all other characters to lowercase
                    } else {
                        charArr[i] = Character.toLowerCase(textTrim.charAt(i));
                    }                    
                //This this will throw an error if there are any non-alphabetical charaters in the text input, the catch then stops processing    
                } else {
                    errorState = true;
                    throw new IllegalArgumentException("You can only use alphabetical characters, spaces and underscores with this method.");
                }
            } catch(IllegalArgumentException e) {
                errorMessage = e.getMessage();
                return errorMessage;
            } 
        }
            return String.valueOf(charArr);
    }
    
    public static void main(String args[]) {
        new TextConverterTestRunner();
    }
}
