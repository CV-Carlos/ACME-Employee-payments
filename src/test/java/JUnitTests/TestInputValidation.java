package JUnitTests;

import Helpers.InputValidation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class TestInputValidation {

    @Test
    void testHelpPattern()
    {
        assertTrue(InputValidation.inputIsCorrect("  ?  "));
        assertTrue(InputValidation.inputIsCorrect("?"));
        assertFalse(InputValidation.inputIsCorrect("? Something else"));
        assertFalse(InputValidation.inputIsCorrect("something ? Something else"));
    }

    @Test
    void testExitPattern()
    {
        assertTrue(InputValidation.inputIsCorrect(" exit  "));
        assertTrue(InputValidation.inputIsCorrect("exit"));
        assertTrue(InputValidation.inputIsCorrect(" eXiT  "));
        assertTrue(InputValidation.inputIsCorrect("EXIT"));
        assertFalse(InputValidation.inputIsCorrect("exit Something else"));
        assertFalse(InputValidation.inputIsCorrect("something exit Something else"));
    }

    @Test
    void testFilePattern()
    {
        assertTrue(InputValidation.inputIsCorrect(" file  fileName "));
        assertTrue(InputValidation.inputIsCorrect("fIle FileName"));
        assertTrue(InputValidation.inputIsCorrect(" FILE filename"));
        assertFalse(InputValidation.inputIsCorrect("fileFilename"));
        assertFalse(InputValidation.inputIsCorrect("fileFilename  filename"));
    }

    @Test
    void testEmployeeInformationPatternIncorrect()
    {
        assertFalse(InputValidation.inputIsCorrect("ASTRIDMO10:00-12:00"));
        assertFalse(InputValidation.inputIsCorrect("ASTRID="));
        assertFalse(InputValidation.inputIsCorrect("ASTRID=MO10:0012:00"));
        assertFalse(InputValidation.inputIsCorrect("ASTRID=MO10;00-12;00"));
        assertFalse(InputValidation.inputIsCorrect("MO10:00-12:00"));
        assertFalse(InputValidation.inputIsCorrect("ASTRID=10;00-12;00"));
        assertFalse(InputValidation.inputIsCorrect("ASTRID=SQ10;00-12;00"));
        assertFalse(InputValidation.inputIsCorrect("ASTRID=MO11;00-08;00"));
    }

    @Test
    void testEmployeeInformationPatternCorrect()
    {
        assertTrue(InputValidation.inputIsCorrect("ASTRID=MO10:00-12:00"));
        assertTrue(InputValidation.inputIsCorrect("asTRID=MO10:00-12:00"));
        assertTrue(InputValidation.inputIsCorrect("ASTRID=MO10:00-12:00,TH12:00-14:00"));
    }

}
