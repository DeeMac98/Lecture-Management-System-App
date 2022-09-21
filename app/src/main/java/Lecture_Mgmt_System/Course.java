/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lecture_Mgmt_System;

import java.util.ArrayList;
import java.util.Objects;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

/**
 *
 * @author David
 */
public class Course {

    private String name;
    private ArrayList<Module> modules = new ArrayList<>();
    private ArrayList<Student> students = new ArrayList<>();
    private DateTime startDate;
    private DateTime endDate;

    public Course(String name) {
        this.name = name;
    }
    
    @Override
    public boolean equals (Object o) {
        if (o == this)
            return true;
        if(!(o instanceof Course))
            return false;
        Course course = (Course)o;
        if(this.hashCode() != o.hashCode())
            return false;
        return course.name.equals(this.name) && (course.modules == null) ? ((this.modules == null) ? true : false) : course.modules.containsAll(this.modules) && this.modules.containsAll(course.modules) && (course.students == null) ? ((this.students == null) ? true : false) : course.students.containsAll(this.students) && this.students.containsAll(course.students);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.name);
        hash = 17 * hash + Objects.hashCode(this.modules);
        hash = 17 * hash + Objects.hashCode(this.students);
        hash = 17 * hash + Objects.hashCode(this.startDate);
        hash = 17 * hash + Objects.hashCode(this.endDate);
        return hash;
    }
    
    public DateTime getStartDate() {
        return this.startDate;
    }
    
    public void setStartDate(DateTime start) {
        this.startDate = start;
    }
    
    public DateTime getEndDate() {
        return this.endDate;
    }
    
    public void setEndDate(DateTime end) {
        this.endDate = end;
    }
    
    public void addStudents(ArrayList<Student> students) {
        for (Student x : students) {
            this.students.add(x);
        }
    }

    public void removeStudents(ArrayList<Student> students) {
        for (Student x : students) {
            this.students.removeIf(test -> test.getID() == x.getID());
        }
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

    public String getName() {
        return this.name;
    }
    
    @Override
    public String toString() {
        return "Course Name: "+this.name+" \nStart Date: "+this.startDate.toString(DateTimeFormat.shortDate())+" \nEnd Date: "+this.endDate.toString(DateTimeFormat.shortDate())+"\n";
    }
}
