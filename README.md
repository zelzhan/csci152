# csci152
My solutions to the Performance and Data Structure course

## COURSE OVERVIEW

Students will learn about common abstract data types such as stacks, queues, sets, and maps, study how they can be utilized to solve different problems, and implement them using the Java language.  The pros and cons of using different internal representations such as arrays, linked-lists, binary search trees, and hash tables will be examined.  Students will be required to assess problems and choose appropriate data structures and relevant algorithms to improve performance and understand the practical limits of computability.

## LEARNING OUTCOMES

### By the end of this course:

* Students will understand the concept of abstract data types (ADTs), and how they are supported by the interface construct in the Java language;
* Students will be familiar with the most important ADTs used in the storage and retrieval of information in modern software systems, including stack, queue, set, and map.
* Students will be able to design and implement these ADTs using both static memory (i.e., arrays) and dynamic methods;
* Students will be able to examine the relative performance of the data structures, and the scalability of the structures as the size of data sets increases;
* Students will be able to develop and test the data structures using component-based software engineering techniques;
* Students will understand basic object-oriented concepts, such as inheritance and polymorphism, though their implementation and use of ADTs in the Java language.


## LAB EXERCISES
### Lab1:
1.Write some Java code in the main method of a class that accomplishes the following tasks:

* For a box with dimensions l, w, and h, compute and output the volume and surface area
* For a circle with radius r, compute and output its circumference and area. Use the type double for your variables.
* Create and output an ACSII art picture of your choice.

### Lab2:

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
}
```
Now, make the following additions to your Clock project:

* Add proper getters and setters to your Clock class.  In cases where people try to provide bad values, simply ignore them, and do not change the values of the Clock object.
* Similarly, modify the constructor so that if any of the values of h, m, or s are not valid, simply set all three fields to 0 (which represents midnight)
* Add a reasonable toString() method to Clock.  If you want to be creative, try to take care of cases where a field value might be less than 10 and output a leading zero.  For example, instead of outputting the String 12:4:9, you output 12:04:09.  (Hint: use if-statements.)
* Fix the tick() method so that minutes and hours may be incremented when we “roll over” into the next minute or hour.
* Add another class with a main method that instantiates a Clock object, and tests the methods of the Clock class.

## Lab3

1.  Using either the Clock example from this or the previous lesson, make changes so that exceptions are thrown whenever bad inputs are provided to a constructor or a setter.  Also, add JavaDoc comment specifications for all of your methods and constructor(s).  Use the annotations @param, @return, and @throws, as appropriate.  Finally, make changes to the main method in your testing class so that it properly checks what happens when bad inputs are provided — main should handle, and not throw exceptions.

2.  Make changes to the Automobile example from Lesson 1, adding exceptions and proper JavaDoc specifications as appropriate.  Feel free to make additions and enhancements to your class to make it more interesting.

## Lab4

1. Think of an example (other than Pets or Animals), where you may have one parent class, and at least three different subclasses.  Your parent class should have at least four different methods (including toString(), but not including getters and setters), and the subclasses should override some (but not all) of the parent class methods.  The toString() method should always be overridden.  Some of the subclasses should also have their own fields, and methods that are different from the other classes.  Examples include:

* Mobile devices, with iPhones, iPads, and Galaxy Tablets as subclasses
* Library materials, with books, DVDs, eBooks, and magazines as subclasses
* NU people, with faculty, students, administrators, TAs, etc., as subclasses
* Please add JavaDoc specifications to your methods, but don’t worry about being overly-detailed in your descriptions.

## Lab5

1.  Make the following additions and modifications to the example project from the lesson:

* a)  Add some more method signatures to the Animal interface, which represent things that all animals can do (albeit differently).  Don’t forget the JavaDoc specifications.

* b)  Notice that both the Tiger and Cow classes have an age field, as well as a getAge() getter and an ageOneYear() incrementor method which both have the same code.  A better approach might be to create an intermediate class AnimalImpl that implements Animal, and includes these common things, and have the Tiger and Cow classes simply inherit them by extending AnimalImpl.  The following UML class diagram summarizes these relationships:

animalchallenge

Don’t forget to remove the age-related code from Tiger and Cow — it is no longer needed there because it is inherited from AnimalImpl.  Since AnimalImpl needs to implement the whole Animal interface, you will need to put in default implementations for the other methods declared in Animal.

* c)  Now that we have all of the age-related stuff in one place, AnimalImpl, add two additional fields to AnimalImpl: an int maxAge and a boolean isAlive.  Modify the method ageOneYear() so that it updates isAlive appropriately when the animal tries to age past its maxAge.

* d)  Add a third class to the example that extends the AnimalImpl class (and thus implicitly implements the Animal interface).

* e)  Finally, don’t forget to update your testing class to try all of these new features out.

