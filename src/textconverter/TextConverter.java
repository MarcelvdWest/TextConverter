package textconverter;

import testsuite.*;
/**
 *
 * @author Marcel van der Westhuizen
 */

public class TextConverter implements CaseUtil{
    
    String errorMessage = "";
    boolean errorState = false;
    
    @Override
    public String asCamelCase(String text){
        //Create an array that has the size of the characters in the string 
        //without spaces
        char[] charArr = new char[text.replaceAll(" ", "").length()];
        errorState = false;
        int spaceCount = 0;
        
        //Loop through String 
        for(int i = 0 ; i < text.length() ; i++){
          
            try{
                //Checks if the current character is a space
                if(text.charAt(i) != ' '){
                    //Check whether the fisrt character is a letter and makes is lowercase
                    if(i == 0 && Character.isAlphabetic(text.charAt(i))){
                            charArr[i] = Character.toLowerCase(text.charAt(i));
                    //This looks for spaces and makes sure letter after it is converted to a uppercase    
                    }else if(text.charAt(i-1) == ' ' && Character.isAlphabetic(text.charAt(i))) {
                        charArr[i - spaceCount] = Character.toUpperCase(text.charAt(i));
                    //This handles all other letters    
                    }else if(Character.isAlphabetic(text.charAt(i))){
                        charArr[i - spaceCount] = Character.toLowerCase(text.charAt(i));
                    //This handles all characters that aren't alphabetical    
                    }else{
                        errorState = true;
                        if(i == 0){
                            throw new IllegalArgumentException("The input must start with a letter.");
                        }else{
                            throw new IllegalArgumentException("You can only use alphabetical characters and spaces with this method.");
                        }
                    }
                }else{
                    if(i == 0){
                        errorState = true;
                        throw new IllegalArgumentException("The input must start with a letter.");
                    }else{
                        //If there is a space this fixes the index of the character in the char[]
                        spaceCount = spaceCount + 1;
                    }
                }
            }catch(IllegalArgumentException e){
                errorMessage = e.getMessage();
                return errorMessage;         
            }
        }
        
            return String.valueOf(charArr);
    }
            
    @Override        
    public String asSnakeCase(String text){
        //convert string into a array of charcters
        char[] charArr = new char[text.length()];
        errorState = false;
        
        //Loop through String 
        for(int i = 0 ; i < text.length() ; i++){
            
            try{
                //This checks for spaces and replaces them with an underscore
                if(text.charAt(i) == ' ' && i != 0){
                    charArr[i] = '_';
                //This changes all characters to lowercase    
                }else if(Character.isAlphabetic(text.charAt(i))){
                    charArr[i] = Character.toLowerCase(text.charAt(i));
                //This adds any other characters    
                }else{
                    errorState = true;
                    if(i == 0){
                        throw new IllegalArgumentException("The input must start with a letter.");
                    }else{
                        throw new IllegalArgumentException("You can only use alphabetical characters and spaces with this method.");
                    }
                }
            }catch(IllegalArgumentException e){
                errorMessage = e.getMessage();
                return errorMessage;
            }    
        }
        
            return String.valueOf(charArr);
  
    }
    
    @Override
    public String asHumanReadableText(String text){
        //convert string into a array of charcters
        char[] charArr;
         errorState = false;
        
        if(text.charAt(text.length() - 1) != '.'){
            charArr = new char[text.length() + 1];
            charArr[charArr.length - 1] = '.';
        }else{
            charArr = new char[text.length()];
        }
        
        //Loop through String 
        for(int i = 0 ; i < text.length() ; i++){
            
             try{
                //This checks for underscores and replaces them with a space
                if(i != 0 && text.charAt(i) == '_' || i != 0 && text.charAt(i) == ' '){
                    charArr[i] = ' ';           
                //This changes all characters to lowercase except the first character   
                }else if(Character.isAlphabetic(text.charAt(i))){
                    //Changes first character to uppercase
                    if(i == 0){
                        charArr[i] = Character.toUpperCase(text.charAt(i));
                    }else{
                        charArr[i] = Character.toLowerCase(text.charAt(i));
                    }                    
                //This adds any other characters    
                }else if(i == text.length() - 1 && text.charAt(i) == '.'){
                    charArr[i] = text.charAt(i);
                }else{
                    errorState = true;
                    if(i == 0){
                        throw new IllegalArgumentException("The input must start with a letter.");
                    }else{
                        throw new IllegalArgumentException("You can only use alphabetical characters, spaces and underscores with this method.");
                    }
                }
                //Handles first character, if alphabetical
                /*if(Character.isAlphabetic(text.charAt(i)) && i == 0){
                    charArr[i] = Character.toUpperCase(text.charAt(i));
                }*/
            }catch(IllegalArgumentException e){
                errorMessage = e.getMessage();
                return errorMessage;
            } 
        }
        
            return String.valueOf(charArr);

    }
    
    public static void main(String args[]){
        new TextConverterTestRunner();
    }
    
    
}
