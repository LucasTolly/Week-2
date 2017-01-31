package edu.madisoncollege.entjava;

import org.apache.log4j.Logger;

import java.util.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
/**
 * Created by paulawaite on 9/7/16.
 *
 * This exercise is taken from the 2015 Advent of Code challenge, Day 1 (http://adventofcode.com/day/1). It will provide you
 * with more practice in our environment, reading files, logging and unit testing.
 *
 * Here is the problem to solve:
 *
 * "Santa is trying to deliver presents in a large apartment building, but he can't find the right floor -
 * the directions he got are a little confusing. He starts on the ground floor (floor 0) and then follows
 * the instructions one character at a time.
 *
 * An opening parenthesis, (, means he should go up one floor, and a closing parenthesis, ), means he should go down one floor.
 *
 * The apartment building is very tall, and the basement is very deep; he will never find the top or bottom floors.
 *
 * For example:
 * (()) and ()() both result in floor 0.  <= this would make a good unit test!
 * ((( and (()(()( both result in floor 3. <= another unit test
 * ))((((( also results in floor 3. <= another unit test
 * ()) and ))( both result in floor -1 (the first basement level).
 * ))) and )())()) both result in floor -3."
 *
 * Your goal is to determine what floor Santa will be on when he uses the directions in the file SantaUpDown.txt
 *
 * Do NOT create a main method in your application: you will use only unit tests to run your code.
 * Add log4j to your code.  At minimum you should log an error if there is a problem reading the file.
 *
 * When submitting your code, include screenshots showing
 * 1) The answer, i.e., what floor is Santa on?
 * 2) How much code coverage you achieved (what percent?).
 *
 */

public class SantaInAnElevator {

    private int currentFloor;
    private List<String> floorDirections;
    private final Logger logger = Logger.getLogger(this.getClass());

    /**
     * This constructor first initializes the floorDirections list,
     * sets the current floor to 0, reads the floor directions,
     * and then calculates the current floor.
     * @param filePath This is the path to the file that will be read
     */
    public SantaInAnElevator(String filePath) {
        floorDirections = new ArrayList<String>();
        currentFloor = 0;
        readFloorDirections(filePath);
        calculateCurrentFloor();
    }

    /**
     * This is a getter for currentFloor
     * @return The current floor
     */
    int getCurrentFloor() {
        return currentFloor;
    }

    /**
     * This method reads the floor directions, in the form of open and close
     * parenthesis, from the target file.
     * @param filePath This is the path to the file that will be read
     */
    private void readFloorDirections(String filePath) {

        FileReader fileReader = null;
        BufferedReader bufferedReader = null;

        try {
            fileReader = new FileReader(filePath);
            bufferedReader = new BufferedReader(fileReader);

            String currentLine;

            while ((currentLine = bufferedReader.readLine()) != null) {
                String[] currentLineCharacters = currentLine.split("");
                for (String character : currentLineCharacters) {


                    if (character.equals("(") || character.equals(")")) {
                        floorDirections.add(character);
                    }
                }
            }

        } catch (IOException e) {
            logger.error("Encountered an IOException: ", e);
        } catch (Exception e) {
            logger.error("Encountered an Exception: ", e);
        } finally {

            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (fileReader != null) {
                    fileReader.close();
                }
            } catch (IOException e) {
                logger.error("Encountered an IOException: ", e);
            } catch (Exception e) {
                logger.error("Encountered an Exception: ", e);
            }
        }
    }

    /**
     * This method calculates the current method based on the
     * floorDirections list.
     */
    private void calculateCurrentFloor() {
        for (String floorDirection : floorDirections) {
            if (floorDirection.equals("(")) {
                currentFloor += 1;
            } else if (floorDirection.equals(")")) {
                currentFloor += -1;
            }
        }
        logger.info(String.valueOf(currentFloor));
    }
}
