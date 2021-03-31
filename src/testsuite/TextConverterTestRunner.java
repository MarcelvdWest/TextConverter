/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testsuite;

import org.junit.runner.*;
import org.junit.runner.notification.*;

/**
 *
 * @author marce
 */
public class TextConverterTestRunner {
    public static void main(String args[]){
        Result result = JUnitCore.runClasses(TextConverterTestSuite.class);
        
        for(Failure failure : result.getFailures()){
            System.out.println(failure.toString());
        }
        
        System.out.println("All test cases were Successful: " + result.wasSuccessful());
    }
}
