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
public class StudentTest {
    
    private static Student instance;
    private static Module module;
    private static ArrayList<Module> modules;
    private static Course course;
    private static ArrayList<Course> courses;
    private static Student noCourses;
    private static Student noModules;
    
    public StudentTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
        instance = new Student("David McIntyre", "20-02-1998");
        
        modules = new ArrayList<>();
        module = new Module("Software Engineering", "CT417");
        modules.add(module);
        
        courses = new ArrayList<>();
        course = new Course("4BCT");
        courses.add(course);
        
        noCourses = new Student("David McIntyre", "20-02-1998");
        noModules = new Student("David McIntyre", "20-02-1998");
        noCourses.setID(1);
        noModules.setID(1);
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp(){
        instance.setID(1);
        instance.removeModules(modules);
        instance.removeCourses(courses);
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of toString method, of class Student.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String expResult = "Name: David McIntyre \n"
                           + "DOB: 1998-02-20 \n"
                           + "Age: 24 \n"
                           + "Username: davidmcintyre24 \n"
                           + "ID: 1\n";
        String result = instance.toString();
        assertTrue(expResult.equals(result));
    }

    /**
     * Test of createID method, of class Student.
     */
    @Test    
    public void testCreateID() {
        System.out.println("createID");
        int expResult = instance.getID();
        int result = Student.createID();
        assertTrue(expResult < result);
    }

//   /**
//    * Test of getUsername method, of class Student.
//    */
    @Test    
    public void testGetUsername() {
        System.out.println("getUsername");
        String expResult = "davidmcintyre24";
        assertTrue(expResult.equals(instance.getUsername()));
    }
    
    /**
     * Test of setID method, of class Student
     */
    @Test
    public void testSetID() {
        System.out.println("setID");
        int expResult = 2;
        instance.setID(2);
        assertTrue(expResult == instance.getID());
    }

    /**
     * Test of getID method, of class Student.
     */
    @Test   
    public void testGetID() {
        System.out.println("getID");
        int expResult = 1;
        int result = instance.getID();
        assertTrue(expResult == result);
    }

    /**
     * Test of addCourses method, of class Student.
     */
    @Test    
    public void testAddCourses() {
        System.out.println("addCourses");
        instance.addCourses(courses);
        assertFalse(noCourses.equals(instance));
    }

    /**
     * Test of removeCourses method, of class Student.
     */
    @Test    
    public void testRemoveCourses() {
        System.out.println("removeCourses");
        instance.removeCourses(courses);
        assertTrue(noCourses.equals(instance));
    }

    /**
     * Test of addModules method, of class Student.
     */
    @Test   
    public void testAddModules() {
        System.out.println("addModules");
        instance.addModules(modules);
        assertFalse(noModules.equals(instance));
    }

    /**
     * Test of removeModules method, of class Student.
     */
    @Test   
    public void testRemoveModules() {
        System.out.println("removeModules");
        instance.removeModules(modules);
        assertTrue(noModules.equals(instance));
    }
    
}
