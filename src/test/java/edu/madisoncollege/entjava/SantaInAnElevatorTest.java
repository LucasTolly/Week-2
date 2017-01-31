package edu.madisoncollege.entjava;

import org.apache.log4j.Logger;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * This is a test class for testing SantaInAnElevator
 */
public class SantaInAnElevatorTest {

    private String filePath;
    private final Logger logger = Logger.getLogger(this.getClass());

    /**
     * Initial setup, setting the file path to the text file that
     * will be read. Currently uses a full path, as I could not
     * figure out the smaller version.
     */
    @Before
    public void setup() {
        filePath = "C:\\Users\\tolly\\Documents\\MadisonCollegeSpring2017\\EnterpriseJava\\GitHub\\EnterpriseRepository\\week-2-exercise-LucasTolly\\src\\main\\resources\\SantaUpDown.txt";
    }

    /**
     * Tests a complete run of the application, which will calculate
     * the floor level Santa will end up on. In the file
     * linked above, the floor level ends up at 138.
     */
    @Test
    public void testFloorCalculator() {
        SantaInAnElevator testInstance = new SantaInAnElevator(filePath);
        assertEquals("Elevator count was incorrect.", 138, testInstance.getCurrentFloor());
    }

    /**
     * Tests an invalid file path, resulting in the application
     * throwing an IOException. Thus, the floor level will remain
     * at its default value, 0.
     */
    @Test
    public void testIOException() {
        String invalidFilePath = "asdfas";
        SantaInAnElevator testInstance = new SantaInAnElevator((invalidFilePath));
        assertEquals("Elevator count was incorrect.", 0, testInstance.getCurrentFloor());
    }
}
