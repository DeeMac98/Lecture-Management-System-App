/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lecture_Mgmt_System;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.Period;
import java.util.ArrayList;
import java.util.Objects;
/**
 *
 * @author David
 */
public class Student {
    
    private static int idCounter = 1;
    private String name;
    private int age = 0;
    private LocalDate dob;
    private int id;
    private String username;
    private ArrayList<Course> courses = new ArrayList<>();
    private ArrayList<Module> modules = new ArrayList<>();
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyy");
    
    public Student(String name, String dob) {
        this.name = name;
        this.dob = LocalDate.parse(dob, formatter);
        this.age = Period.between(this.dob, LocalDate.now()).getYears();
        this.id = createID();
        this.username = getUsername();
    }
    
    @Override
    public boolean equals (Object o) {
        if (o == this)
            return true;
        if(!(o instanceof Student))
            return false;
        Student student = (Student)o;
        if(this.hashCode() != o.hashCode())
            return false;
        return student.name.equals(this.name) && student.dob == this.dob && student.id == this.id && student.username.equals(this.username) && (student.courses == null) ? ((this.courses == null) ? true : false) : student.courses.containsAll(this.courses) && this.courses.containsAll(student.courses) && (student.modules == null) ? ((this.modules == null) ? true : false) : student.modules.containsAll(this.modules) && this.modules.containsAll(student.modules);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + Objects.hashCode(this.name);
        hash = 83 * hash + Objects.hashCode(this.dob);
        hash = 83 * hash + this.id;
        hash = 83 * hash + Objects.hashCode(this.username);
        hash = 83 * hash + Objects.hashCode(this.courses);
        hash = 83 * hash + Objects.hashCode(this.modules);
        return hash;
    }
    
    @Override
    public String toString() {
        return "Name: "+this.name+" \nDOB: "+this.dob+" \nAge: "+this.age+" \nUsername: "+this.username+" \nID: "+this.id+"\n";
    }
    
    /**
     * createID()
     * Method to incrementally assign a unique ID
     * Uniqueness ensured with static global variable + synchronized method
     * @return idCounter++ 
     */
    public static synchronized int createID() {
        return idCounter++;
    }
    
    /**
     * getUsername()
     * Creates a username by concatenating name + age
     * Converts to lowercase, and removes white space
     * @return username (e.g. samplename30)
     */
    public String getUsername() {
        username = (this.name+this.age).toLowerCase();
        username = username.replaceAll("\\s", "");
        return username;
    }
    
    public int getID() {
        return this.id;
    }
    
    public void setID(int id) {
        this.id = id;
    }
    
    public ArrayList<Course> getCourses() {
        return this.courses;
    }
    
    public void addCourses(ArrayList<Course> courses) {
        for (Course x : courses) {
            this.courses.add(x);
        }
    }

    public void removeCourses(ArrayList<Course> courses) {
        for (Course x : courses) {
            this.courses.removeIf(test -> test.getName().equals(x.getName()));
        }
    }
    
    public ArrayList<Module> getModules() {
        return this.modules;
    }
    
    public void addModules(ArrayList<Module> modules) {
        for (Module x : modules) {
            this.modules.add(x);
        }
    }

    public void removeModules(ArrayList<Module> modules) {
        for (Module x : modules) {
            this.modules.removeIf(test -> test.getID().equals(x.getID()));
        }
    }
}   
