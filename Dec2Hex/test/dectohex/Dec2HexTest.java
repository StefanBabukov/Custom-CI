package dectohex;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import java.io.*;
import static org.junit.Assert.*;

/**
 * @author Stefan Babukov - Computing
 */

public class Dec2HexTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    public Dec2HexTest() {
        
    }

    @Before
    public void beforeEach() throws Exception {
        // start recording System.out calls
       System.setOut(new PrintStream(outContent));
    }

    @After
    public void afterEach() throws Exception {
       // clear logs after each test
       System.setOut(originalOut);
    }

    @Test
    public void doesDenyNullInput(){
        //checks the output log if method is called with no arguments
        String args[] = {};
        new Dec2Hex().main(args);
        assertEquals("No value provided\n", outContent.toString());
    }
    
    @Test 
    public void doesDenyNotNumbers(){
        //checks the output log if method is called with invalid non-numeric arguments
        String args[] ={"a String"};
        new Dec2Hex().main(args);
        assertEquals(args[0] + " is not a number!\n", outContent.toString());
    }
    
    @Test
    public void convertsNumbers(){
        //tests if a decimal number is converted correctly to hexadecimal
        String args[] ={"1234567"};
        new Dec2Hex().main(args);
        assertEquals("Converting the Decimal Value 1234567 to Hex...\n"
                + "Hexadecimal representation is: 12D687\n", outContent.toString());
    }
}
