/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lecture_Mgmt_System;

import static Lecture_Mgmt_System.Student.createID;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author David
 */
public class Lecturer {
    
    private static int idCounter = 1;
    private String name;
    private int age = 0;
    private LocalDate dob;
    private int id;
    private String username;
    private Module modules[];
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyy");
    
    public Lecturer(String name, String dob) {
        this.name = name;
        this.dob = LocalDate.parse(dob, formatter);
        this.age = Period.between(this.dob, LocalDate.now()).getYears();
        this.id = createID();
        this.username = getUsername();
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
    
    public void setID(int id) {
        this.id = id;
    }
    
    public int getID() {
        return this.id;
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
    
    @Override
    public String toString() {
        return "Name: "+this.name+" \nDOB: "+this.dob+" \nAge: "+this.age+" \nUsername: "+this.username+" \nID: "+this.id+"\n";
    }
}
