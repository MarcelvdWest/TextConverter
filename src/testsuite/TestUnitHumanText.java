package testsuite;

import org.junit.*;
import textconverter.TextConverter;
import static org.junit.Assert.assertEquals;


/**
 *
 * @author marce
 */
public class TestUnitHumanText {
    TextConverter tc = new TextConverter();
    String[] testHumanText = new String[]{" hello World", "I love 2 java", "i LOVE java", "hello_world"};
    String[] expectedHumanText = new String[]{"Hello world.", "You can only use alphabetical characters, spaces and underscores with this method.", "I love java.", "Hello world."};
     
    @Test
    public void testTextConverter() {
        System.out.println("Testing asHumanReadableText()");
        
        for (int i = 0 ; i < testHumanText.length ; i++) {
            assertEquals(expectedHumanText[i], tc.asHumanReadableText(testHumanText[i]));
        }
    }
}
