
package testsuite;

import org.junit.runner.*;
import org.junit.runners.Suite;

/**
 *
 * @author Marcel van der Westhuizen
 */

@RunWith(Suite.class)

@Suite.SuiteClasses({
    TestUnitCamel.class,
    TestUnitSnake.class,
    TestUnitHumanText.class
})
public class TextConverterTestSuite { }
