# csci152
My solutions to the Performance and Data Structure course

##COURSE OVERVIEW

Students will learn about common abstract data types such as stacks, queues, sets, and maps, study how they can be utilized to solve different problems, and implement them using the Java language.  The pros and cons of using different internal representations such as arrays, linked-lists, binary search trees, and hash tables will be examined.  Students will be required to assess problems and choose appropriate data structures and relevant algorithms to improve performance and understand the practical limits of computability.

##LEARNING OUTCOMES

###By the end of this course:

*Students will understand the concept of abstract data types (ADTs), and how they are supported by the interface construct in the Java language;
*Students will be familiar with the most important ADTs used in the storage and retrieval of information in modern software systems, including stack, queue, set, and map.
*Students will be able to design and implement these ADTs using both static memory (i.e., arrays) and dynamic methods;
*Students will be able to examine the relative performance of the data structures, and the scalability of the structures as the size of data sets increases;
*Students will be able to develop and test the data structures using component-based software engineering techniques;
*Students will understand basic object-oriented concepts, such as inheritance and polymorphism, though their implementation and use of ADTs in the Java language.

###Lab1:
1.Write some Java code in the main method of a class that accomplishes the following tasks:

*For a box with dimensions l, w, and h, compute and output the volume and surface area
*For a circle with radius r, compute and output its circumference and area. Use the type double for your variables.
*Create and output an ACSII art picture of your choice.

###Lab2:

LAB EXERCISES

1.  Notice at the end of the lesson that when we try to use and display the internal values of multiple Automobile objects via toString(), it is somewhat hard to tell them apart just from the String outputs.  What is needed is an additional field that allows us to distinguish one Automobile from another.  One possible idea is to add a third field of type String to the class that models the license plate value.  For this exercise, make the necessary changes to the Automobile class so that it stores this value (which should be set by the constructor) and is used as part of the output of toString().  Don’t forget to also make necessary changes to your testing method main to show that this works.

2.  First, create a new project using the Clock class from the last lesson, whose code is provided below.  (It will be easier to simply create your own Clock class file in the project, and then copy-and-paste the code shown here into the file.)


```// You will need to add a package declaration here
public class Clock {
  
    // Fields
    private int hours;
    private int minutes;
    private int seconds;

    // Constructor
    public Clock(int h, int m, int s) {
        hours = h; minutes = m; seconds = s;
    }

    // Reset method
    public void resetToMidnight() {
        hours = 0; minutes = 0; seconds = 0;
    }

    // Check if morning method
    public boolean isMorning() {
        return hours > 12;
    }

    // Advance one second method
    public void tick() {
        seconds++;
        if (seconds >= 60) {
            seconds = 0;
            // need to increment mins, etc.
        }
    }
}
// You will need to add a package declaration here
 
public class Clock {
  
    // Fields
    private int hours;
    private int minutes;
    private int seconds;
 
    // Constructor
    public Clock(int h, int m, int s) {
        hours = h; minutes = m; seconds = s;
    }
 
    // Reset method
    public void resetToMidnight() {
        hours = 0; minutes = 0; seconds = 0;
    }
 
    // Check if morning method
    public boolean isMorning() {
        return hours > 12;
    }
 
    // Advance one second method
    public void tick() {
        seconds++;
        if (seconds >= 60) {
            seconds = 0;
            // need to increment mins, etc.
        }
    }
}```
Now, make the following additions to your Clock project:

*Add proper getters and setters to your Clock class.  In cases where people try to provide bad values, simply ignore them, and do not change the values of the Clock object.
*Similarly, modify the constructor so that if any of the values of h, m, or s are not valid, simply set all three fields to 0 (which represents midnight)
*Add a reasonable toString() method to Clock.  If you want to be creative, try to take care of cases where a field value might be less than 10 and output a leading zero.  For example, instead of outputting the String 12:4:9, you output 12:04:09.  (Hint: use if-statements.)
*Fix the tick() method so that minutes and hours may be incremented when we “roll over” into the next minute or hour.
*Add another class with a main method that instantiates a Clock object, and tests the methods of the Clock class.
