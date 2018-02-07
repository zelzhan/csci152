/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci152test;

/**
 *
 * @author Karina
 */
public class Student {
        private String firstName;
        private String secondName;
        private int id;
        private int year;
        
        public Student(String fName, String lName, int sid){
            firstName = fName;
            secondName= lName;
            year =1;
            id = sid;
        }
        /**
         * increases year by one
         */
        public void incrementYear(){
            setYear(getYear() + 1);
        }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the secondName
     */
    public String getSecondName() {
        return secondName;
    }

    /**
     * @param secondName the secondName to set
     */
    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the year
     */
    public int getYear() {
        return year;
    }

    /**
     * @param year the year to set
     */
    public void setYear(int year) {
        this.year = year;
    }
    
    public String toString(){
        return firstName + " "+secondName+" ID: "+id+" Year "+ year+"\n";
    }
    
}
