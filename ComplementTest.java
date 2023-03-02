import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.Test;
public class ComplementTest {
    StringBuffer word1  =  new StringBuffer("000");
    StringBuffer word2  =  new StringBuffer("101");
    String word3  =  "10110";
    String word4  =  "00001";
    String word5  =  "70001";
    int int1 = 1;
    int int2 = 2;

    @Test
    public void twosComplementTrue(){
        assertTrue(Complement.findTwoscomplement(word1).equals("1000"));
    }
    @Test
    public void twosComplementFalse(){
        assertFalse(Complement.findTwoscomplement(word2).equals("110"));
    }
    @Test
    public void endsWith001True(){
        assertTrue(Complement.endsWith(word4.toCharArray()));
    }
    @Test
    public void endsWith001False(){
        assertFalse(Complement.endsWith(word3.toCharArray()));

    }
    @Test
    public void isValid(){
        assertTrue(Complement.checkValidity(word3));

    }
    @Test
    public void isNotValid(){
        assertFalse(Complement.checkValidity(word5));

    }    
}
