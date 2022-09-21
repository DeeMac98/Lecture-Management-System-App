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
import org.joda.time.DateTime;

/**
 *
 * @author David
 */
public class CourseTest {
    
    private static Course instance;
    private static Module module;
    private static ArrayList<Module> modules;
    private static Student student;
    private static ArrayList<Student> students;
    private static DateTime start;
    private static DateTime end;
    private static Course noStudents;
    private static Course noModules;
    
    public CourseTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
        instance = new Course("4BCT");
        
        module = new Module("Software Engineering", "CT417");
        modules = new ArrayList<>();
        modules.add(module);
        
        student = new Student("David McIntyre", "20-02-1998");
        students = new ArrayList<>();
        students.add(student);
        
        start = new DateTime(2022, 9, 5, 0, 0, 0);
        end = new DateTime(2023, 5, 20, 0, 0, 0);
        
        noStudents = new Course("4BCT");
        noModules = new Course("4BCT");
        noStudents.setStartDate(start);
        noStudents.setEndDate(end);
        noModules.setStartDate(start);
        noModules.setEndDate(end);
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        instance.removeModules(modules);
        instance.removeStudents(students);
        instance.setStartDate(start);
        instance.setEndDate(end);
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of setStartDate method, of class Course.
     */
    @Test
    public void testSetStartDate() {
        System.out.println("setStartDate");
        DateTime newStart = new DateTime(2022, 9, 28, 0, 0, 0);
        instance.setStartDate(newStart);
        assertTrue(instance.getStartDate().equals(newStart));
    }
    
    /**
     * Test of getStartDate method, of class Course
     */
    @Test
    public void testGetStartDate() {
        System.out.println("getStartDate");
        assertTrue(instance.getStartDate().equals(start));
    }
    
    /**
     * Test of setEndDate method, of class Course.
     */
    @Test
    public void testSetEndDate() {
        System.out.println("setEndDate");
        DateTime newEnd = new DateTime(2023, 6, 10, 0, 0, 0);
        instance.setEndDate(newEnd);
        assertTrue(instance.getEndDate().equals(newEnd));
    }
    
    /**
     * Test of getEndDate method, of class Course
     */
    @Test
    public void testGetEndDate() {
        System.out.println("getEndDate");
        assertTrue(instance.getEndDate().equals(end));
    }

    /**
     * Test of addStudents method, of class Course.
     */
    @Test
    public void testAddStudents() {
        System.out.println("addStudents");
        instance.addStudents(students);
        assertFalse(noStudents.equals(instance));
    }

    /**
     * Test of removeStudents method, of class Course.
     */
    @Test
    public void testRemoveStudents() {
        instance.removeStudents(students);
        assertTrue(noStudents.equals(instance));
    }

    /**
     * Test of addModules method, of class Course.
     */
    @Test
    public void testAddModules() {
        System.out.println("addModules");
        instance.addModules(modules);
        assertFalse(noModules.equals(instance));
    }

    /**
     * Test of removeModules method, of class Course.
     */
    @Test
    public void testRemoveModules() {
        System.out.println("removeModules");
        instance.removeModules(modules);
        assertTrue(noModules.equals(instance));
    }

    /**
     * Test of getName method, of class Course.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        String expResult = "4BCT";
        assertTrue(instance.getName().equals(expResult));
    }

    /**
     * Test of toString method, of class Course.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String expResult = "Course Name: 4BCT \n"
                           + "Start Date: 05/09/2022 \n"
                           + "End Date: 20/05/2023\n";
        assertTrue(expResult.equals(instance.toString()));
    }
    
}
