package textconverter;

/**
 *
 * @author marce
 */
public interface CaseUtil {
    /** 
    * Accepts Strings and converts it to Camel Case. 
    * 
    * Input: Hello World 
    * Output: Hello World 
    * 
    * Input: I love java 
    * Output: iLoveJava 
    **/ 
    String asCamelCase(String text); 
    /** 
    * Accepts Strings and converts it to Snake Case. 
    * 
    * Input: Hello World 
    * Output: hello_world 
    * 
    * Input: I love java 
    * Output: i_love_java 
    **/ 
    String asSnakeCase(String text); 
    /** 
    * Accepts Strings and converts it to Human Readable Text. 
    * 
    * Input: hello_world 
    * Output: Hello world. 
    * 
    * Input: i LOVE java 
    * Output: I love java. 
    **/ 
    String asHumanReadableText(String text); 
}
