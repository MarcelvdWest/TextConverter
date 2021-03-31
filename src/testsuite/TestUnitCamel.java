package testsuite;

import textconverter.TextConverter;
import org.junit.*;
import static org.junit.Assert.assertEquals;

/**
 *
 * @author marce
 */
public class TestUnitCamel {
    TextConverter tc = new TextConverter();
    String[] testCamel = new String[]{"Hello World2", " I love java" , "I love java", "Hello World"};
    String[] expectedCamel = new String[]{"You can only use alphabetical characters and spaces with this method.", "The input must start with a letter.", "iLoveJava", "helloWorld"};
      
    @Test
    public void testAsCamelCase(){
        System.out.println("Testing asCamelCase()");
        
        for(int i = 0 ; i < testCamel.length ; i++){
            assertEquals(expectedCamel[i], tc.asCamelCase(testCamel[i]));
        }
    }
}
