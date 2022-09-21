/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package Lecture_Mgmt_System;

import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Order;

/**
 *
 * @author David
 */
public class LecturerTest {
    
    private static Lecturer instance;
    private static Module module;
    private static ArrayList<Module> modules;
    
    public LecturerTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
        instance = new Lecturer("Michael Shukat", "25-07-1974");
        
        modules = new ArrayList<>();
        module = new Module("Software Engineering", "CT417");
        modules.add(module);
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        instance.setID(1);
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of createID method, of class Lecturer.
     */
    @Test
    @Order(1)    
    public void testCreateID() {
        System.out.println("createID");
        int expResult = 2;
        int result = Lecturer.createID();
        assertTrue(expResult == result);
    }

    /**
     * Test of getUsername method, of class Lecturer.
     */
    @Test
    @Order(2)    
    public void testGetUsername() {
        System.out.println("getUsername");
        String expResult = "michaelshukat48";
        assertTrue(expResult.equals(instance.getUsername()));
    }

    /**
     * Test of toString method, of class Lecturer.
     */
    @Test
    @Order(3)    
    public void testToString() {
        System.out.println("toString");
        String expResult = "Name: Michael Shukat \n"
                           + "DOB: 1974-07-25 \n"
                           + "Age: 48 \n"
                           + "Username: michaelshukat48 \n"
                           + "ID: 1\n";
        String result = instance.toString();
        assertTrue(expResult.equals(result));
    }
    
    /**
     * Test of setID method, of class Lecturer.
     */
    @Test
    @Order(4)
    public void testSetID() {
        System.out.println("setID");
        int expResult = 2;
        instance.setID(2);
        assertTrue(expResult == instance.getID());
    }

    /**
     * Test of getID method, of class Lecturer.
     */
    @Test
    @Order(5)    
    public void testGetID() {
        System.out.println("getID");
        int expResult = 1;
        int result = instance.getID();
        assertTrue(expResult == result);
    }
    
}
