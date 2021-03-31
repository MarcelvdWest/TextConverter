/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testsuite;

import org.junit.runner.*;
import org.junit.runners.Suite;

/**
 *
 * @author marce
 */

@RunWith(Suite.class)

@Suite.SuiteClasses({
    TestUnitCamel.class,
    TestUnitSnake.class,
    TestUnitHumanText.class
})
public class TextConverterTestSuite {
}
