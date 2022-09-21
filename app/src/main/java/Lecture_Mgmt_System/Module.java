/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lecture_Mgmt_System;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author David
 */
public class Module {

    private String name;
    private String id;
    private ArrayList<Student> students = new ArrayList<>();
    private ArrayList<Course> courses = new ArrayList<>();
    private Lecturer lecturer;

    public Module(String name, String id) {
        this.name = name;
        this.id = id;
    }
    
    @Override
    public boolean equals (Object o) {
        if (o == this)
            return true;
        if(!(o instanceof Module))
            return false;
        Module module = (Module)o;
        if(this.hashCode() != o.hashCode())
            return false;
        return module.name.equals(this.name)  && module.id.equals(this.id) && (module.courses == null) ? ((this.courses == null) ? true : false) : module.courses.containsAll(this.courses) && this.courses.containsAll(module.courses) && (module.students == null) ? ((this.students == null) ? true : false) : module.students.containsAll(this.students) && this.students.containsAll(module.students);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.name);
        hash = 59 * hash + Objects.hashCode(this.id);
        hash = 59 * hash + Objects.hashCode(this.courses);
        hash = 59 * hash + Objects.hashCode(this.lecturer);
        return hash;
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

    public Lecturer getLecturer() {
        return this.lecturer;
    }

    public void setLecturer(Lecturer lecturer) {
        this.lecturer = lecturer;
    }

    public String getID() {
        return this.id;
    }
    
    @Override
    public String toString() {
        return "Module Name: "+this.name+" \nModule ID: "+this.id+" \nLecturer: "+this.lecturer.getUsername()+"\n";
    }
}
