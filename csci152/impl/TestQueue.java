/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci152.impl;

import csci152.adt.Queue;

import csci152test.Student;

/**
 *
 * @author Karina
 */
public class TestQueue {
    public static void main(String[] args){
        Student s1 = new Student("Bob","Marley",1234);
        Student s2 = new Student("Jane","Doe",4321);
        Student s3 = new Student("Rick","Smith",4566);
        Student s4 = new Student("Jimmy","Joe",9845);
        
        Queue<Student> stQueue = new ArrayQueue();
        stQueue.enqueue(s4);
        stQueue.enqueue(s1);
        stQueue.enqueue(s2);
        stQueue.enqueue(s3);
        
        System.out.println(stQueue);
        
        try{
            Student sd = stQueue.dequeue();
            System.out.println("dequeue " + sd);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println(stQueue);
        stQueue.clear();
        System.out.println(stQueue);
        
        
        
    }
}
