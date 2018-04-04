/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

public class Student implements Comparable<Student> {

    private int ID;
    private String name;

    public Student(String name, int ID) {
        this.ID = ID;
        this.name = name;
    }

    public int compareTo(Student s) {
        if(this.ID < s.getID()) return -1;
        else if(this.ID > s.getID()) return 1;
        else return 0;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "{name:" + this.name + "; ID:"+ this.ID + "}";
    }

    @Override
    public int hashCode(){
        return getID();
//        return 42;
    }
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Student) {
            Student sobj = (Student) obj;
            return ID == sobj.ID && name == sobj.name;
        }
        return false;
    }
}