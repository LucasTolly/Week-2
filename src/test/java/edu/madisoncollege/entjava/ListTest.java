package edu.madisoncollege.entjava;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Practice working with JUnit by writing some test cases for the Interface List<E>:
 * 1.1 void add(int index, E e)
 * 1.2 void remove(int index)
 * 1.3 void get(int index)
 *
 * Add at least one test for an exception.
 */
public class ListTest {

    private List<String> myList;

    @Before
    public void setup() {
        myList = new ArrayList<String>();
        myList.add("Item 1");
        myList.add("Item 2");
        myList.add("Item 3");
    }

    /**
     * This method tests the add method of the list interface.
     */
    @Test
    public void testAddSuccess() {
        String elementToInsert = "Item 4";

        myList.add(elementToInsert);
        assertEquals("List size is incorrect", 4, myList.size());
        assertTrue("List missing inserted element", myList.contains(elementToInsert));
    }

    /**
     * This method tests the remove method of the list interface.
     */
    @Test
    public void testRemove() {
        myList.remove(2);
        assertEquals("List size is incorrect, should be 3", 2, myList.size());
    }

    /**
     * This method tests the get method of the list interface.
     */
    @Test
    public void testGet() {
        assertEquals("Index 0 string is incorrect", "Item 1", myList.get(0));
    }

    /**
     * This method tests the out of bounds exception returned from
     * accessing a non-existent index.
     */
    @Test
    public void testOutOfBoundsException() {
        Boolean didItCorrectlyFail = false;
        try {
            myList.get(10);
        } catch (Exception e) {
            didItCorrectlyFail = true;
        } finally {
            assertTrue("The exception did not pass.", didItCorrectlyFail);
        }
    }
}