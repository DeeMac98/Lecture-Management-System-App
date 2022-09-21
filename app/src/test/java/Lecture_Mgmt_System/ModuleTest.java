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
public class ModuleTest {
    
    private static Module instance;
    private static Student student;
    private static ArrayList<Student> students;
    private static Course course;
    private static ArrayList<Course> courses;
    private static Module noStudents;
    private static Module noCourses;
    private static Lecturer lecturer;
    
    public ModuleTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
        instance = new Module("Software Engineering", "CT417");
        
        lecturer = new Lecturer("Michael Shukat", "25-07-1974");
        instance.setLecturer(lecturer);
        
        student = new Student("David McIntyre", "20-02-1998");
        students = new ArrayList<>();
        students.add(student);
                
        course = new Course("4BCT");
        courses = new ArrayList<>();
        courses.add(course);
        
        noStudents = new Module("Software Engineering", "CT417");
        noCourses = new Module("Software Engineering", "CT417");
        noStudents.setLecturer(lecturer);
        noCourses.setLecturer(lecturer);
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        instance.removeStudents(students);
        instance.removeCourses(courses);
        instance.setLecturer(lecturer);
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of addStudents method, of class Module.
     */
    @Test    
    public void testAddStudents() {
        System.out.println("addStudents");
        instance.addStudents(students);
        assertFalse(noStudents.equals(instance));
    }

    /**
     * Test of removeStudents method, of class Module.
     */
    @Test   
    public void testRemoveStudents() {
        System.out.println("removeStudents");
        instance.removeStudents(students);
        assertTrue(noStudents.equals(instance));
    }

    /**
     * Test of addCourses method, of class Module.
     */
    @Test
    public void testAddCourses() {
        System.out.println("addCourses");
        instance.addCourses(courses);
        assertFalse(noCourses.equals(instance));
    }

    /**
     * Test of removeCourses method, of class Module.
     */
    @Test   
    public void testRemoveCourses() {
        System.out.println("removeCourses");
        instance.removeCourses(courses);
        assertTrue(noCourses.equals(instance));
    }

    /**
     * Test of getLecturer method, of class Module.
     */
    @Test    
    public void testGetLecturer() {
        System.out.println("getLecturer");
        assertTrue(lecturer.equals(instance.getLecturer()));
    }

    /**
     * Test of setLecturer method, of class Module.
     */
    @Test
    public void testSetLecturer() {
        System.out.println("setLecturer");
        Lecturer newLecturer = new Lecturer("Enda Barrett", "16-07-1980");
        instance.setLecturer(newLecturer);
        assertTrue(newLecturer.equals(instance.getLecturer()));
    }

    /**
     * Test of getID method, of class Module.
     */
    @Test
    public void testGetID() {
        System.out.println("getID");
        String expResult = "CT417";
        assertTrue(expResult.equals(instance.getID()));
    }

    /**
     * Test of toString method, of class Module.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String expResult = "Module Name: Software Engineering \n"
                           + "Module ID: CT417 \n"
                           + "Lecturer: michaelshukat48\n";
        assertTrue(expResult.equals(instance.toString()));
    }
    
}
