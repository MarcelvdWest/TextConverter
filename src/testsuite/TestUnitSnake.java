package testsuite;

import org.junit.*;
import textconverter.TextConverter;
import static org.junit.Assert.assertEquals;

/**
 *
 * @author marce
 */
public class TestUnitSnake {
    TextConverter tc = new TextConverter();
    String[] testSnake = new String[]{" Hello World", "2 many Stuffs", "I love java", "Hello World"};
    String[] expectedSnake = new String[]{"hello_world", "You can only use alphabetical characters and spaces with this method.", "i_love_java", "hello_world"};
     
    @Test
    public void testTextConverter() {
        System.out.println("Testing asSnakeCase()");
        
        for (int i = 0 ; i < testSnake.length ; i++) {
            assertEquals(expectedSnake[i], tc.asSnakeCase(testSnake[i]));
        }
    }
}
