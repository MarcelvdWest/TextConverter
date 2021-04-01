
package testsuite;

import org.junit.runner.*;
import org.junit.runner.notification.*;

/**
 *
 * @author Marcel van der Westhuizen
 */

public class TextConverterTestRunner {
    public static void main(String args[]) {
        Result result = JUnitCore.runClasses(TextConverterTestSuite.class);
        
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        
        System.out.println("All test cases were Successful: " + result.wasSuccessful());
    }
}
