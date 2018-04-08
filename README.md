# +csci152+
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

## Lab6

1.  Complete the implementation of ArrayIntStack as directed in the videos above.  Don’t forget to fix the push and pop implementations! To test out your implementation, create a separate class whose main method does the following:

* Creates a new stack and tries to pop from the empty stack
* Pushes 12 items on the stack using a loop, and then prints the stack contents and its size afterwards
* Pop several items from the stack, and print its contents and resulting size
* Clear the stack, and print its contents and resulting size
* Push 22 more items to the stack using a loop, and again print its contents and resulting size

## Lab7

1.  Complete the implementation of ArrayIntQueue using a circular array as directed in the videos above.  To test out your implementation, create a separate class whose main method does the following:

* Creates a new queue and tries to dequeue from the empty queue
* Enqueues 8 items on the queue using a loop, and then prints its contents and size afterwards
* Dequeue 3 items from the queue, and print its contents and resulting size
* Create a for loop that iterates 9 times, where the body enqueues two items, and then dequeues two items.  Print the * queue’s contents and size after each iteration.
* Clear the queue, and print its contents and resulting size
* Enqueue 22 more items to the queue using a loop, and again print its contents and resulting size

## Lab8

It is critical that you have thoroughly tested and debugged your ArrayIntStack and ArrayIntQueue implementations before you begin the exercises below.  If they are currently not working properly, be sure to fix them first.

The basic instructions for the exercises are as follows: implement the following static methods in another testing class without using arrays.  Also, DO NOT MODIFY YOUR STACK AND QUEUE IMPLEMENTATIONS SO THAT THEY AID IN SOLVING THE BELOW PROBLEMS.  You can make fixes to your implementations if you do find bugs in them, however.  The intent here is to practice using and solving problems using Stacks and Queues.

For the Module Exercises, choose four of the below methods to implement — two from 1, 2, 3, 4, and another two from 5, 6, 7, 8.

1. The evenCount method, which returns the number of even integers stored in the stack stk, where stk is “preserved” — in other words, it contains the same items in the same order at the end of execution of the method, as it had at the beginning.  (Hint:  You will need to empty out the contents of stk into another temp stack which you declare in the body.)

``` public static int evenCount(IntStack stk)```

2.  The copyStack method, which creates and returns a copy of the stack orig, where orig is “preserved”.  (Hint:  Declare two new stacks in the body; a temp stack to store the items in reversed order, and another to store the copy to be returned.)

```public static IntStack copyStack(IntStack orig)```

3.  The copyQueue method, which creates and returns a copy of the queue orig, where orig is “preserved”.  Try implementing this by creating only one additional queue in the method body.

```public static IntQueue copyQueue(IntQueue orig)```

4. The reverseStack method, which reverses the order of the elements stored in the stack toRev.  Note that you cannot simply create a new stack object with the items reversed, and set toRev to that — Java is “pass by reference-value”, and does not allow you to redirect a parameter reference to another object.  In other words, you are forced to work with the incoming object referenced by toRev.  (Hint:  You may want to use a queue for this.)

```public static void reverseStack(IntStack toRev)```

5. The reverseQueue method, which reverses the order of the elements stored in the queue toRev.

```public static void reverseQueue(IntQueue toRev)```

6. The isPalindrome method, which returns whether or not the given queue q represents a palindrome — i.e., the element values are the same when listed forwards or backwards.  Here, q should be preserved.

```public static boolean isPalindrome(IntQueue q)```

7.  The insert method, which modifies the contents of the stack st, so that the value val is inserted pos places from the bottom (you may assume that pos is non-negative, and less than or equal to the size of st.)

```public static void insert(IntStack st, int pos, int val)```

8.  The merge method, where s1 and s2 are stacks whose elements are in order (smallest at the bottom).  Merge their contents into a single sorted stack.  s1 and s2 should be empty when the method is done.

```public static IntStack merge(IntStack s1, IntStack s2)```

## Lab9

1.  Using your previous code for IntStack, IntQueue, ArrayIntStack and ArrayIntQueue as a starting point, create their generic versions Stack<T>, Queue<T>, ArrayStack<T> and ArrayQueue<T>.  Also, make the necessary modifications to your testing classes from Lessons 6 and 7 to test out these new generics-based implementations.

2.  Make modifications to your static methods from the previous lesson’s exercises so that they use these new generic ADTs.  The types of your parameters will now be Stack<Integer> and Queue<Integer>, rather than IntStack and IntQueue.

## Lab10

1.  Complete the implementation of LinkedListStack<T> as directed in the videos above.  To test out your implementation, you can make some slight modifications to your Stack testing class from a few lessons ago, and use it with a new LinkedListStack object instead.  Again, this testing class’ main method should do the following:

* Creates a new stack and tries to pop from the empty stack
* Pushes 12 items on the stack using a loop, and then prints the stack contents and its size afterwards
* Pop several items from the stack, and print its contents and resulting size
* Clear the stack, and print its contents and resulting size
* Push 22 more items to the stack using a loop, and again print its contents and resulting size

2.  In a separate class, implement the following static method that returns true if and only if the contents of a stack st of doubles is in ascending order, with the smallest-valued number at the bottom.  Duplicate values are allowed, as long as they are next to one another in the stack.  At the end, st should be preserved.  Be sure to test out your implementation with testing code in the main method of this same class.

```public static boolean isIncreasing(Stack<Double> st);```
## Lab11

For the Module Exercises, do exercise 1, and then either 2 or 3 below (your choice).

1.  Complete the implementation of LinkedListStack<T> as directed in the videos above.  Again, be careful of the order in which you modify the links when implementing enqueue and dequeue.  To test out your implementation, make some small modifications to your Queue testing class from a few lessons ago, and use it with a new LinkedListQueue<T> object instead.  Again, this testing class’ main method should do the following:

* Creates a new queue and tries to dequeue from the empty queue
* Enqueues 8 items on the queue using a loop, and then prints its contents and size afterwards
* Dequeue 3 items from the queue, and print its contents and resulting size
* Create a for loop that iterates 9 times, where the body enqueues two items, and then dequeues two items.  Print the queue’s contents and size after each iteration.
* Clear the queue, and print its contents and resulting size
* Enqueue 22 more items to the queue using a loop, and again print its contents and resulting size

2.  In a separate class, write a static method that determines whether or not the given queue q represents a sequence of properly balanced grouping characters, i.e., ( ) [ ] { }.  For example, ( { [ ] } [ ] ) and [ { } ] ( [ ] [ ]) are balanced, whereas ( [ { ] } ) is not.  Note that the empty sequence is balanced in this sense.  At the end, q should be preserved.  An exception should be thrown if a given character is not a legal grouping character.  Be sure to test out your implementation using testing code in main of the same class.

```public static boolean isBalanced(Queue<Character> q) throws Exception;```

3.  In a separate class, write a static method that determines whether or not the given queue q of characters is a palindrome — in other words, the contents read the same backwards and forwards in the queue.  The implementation should be case-sensitive, e.g., the characters ‘A’ and ‘a’ should be treated as different characters.  Note that a queue of size 0 is a palindrome.  At the end, q should be preserved.  Be sure to test out your implementation using testing code in main of the same class.

```public static boolean isPalindrome(Queue<Character> q);```

## Lab12

1.  Complete the implementation of LinkedListSortedQueue<T> as directed in the videos above.  When you are finished, create a separate testing class which first creates a new LinkedListSortedQueue<Integer> object instead, and then does the following:

* Inserts the integers 90, 80, 70, …, 10 in that order, and then prints its contents and size afterwards
* Dequeue 3 items from the queue, and print its contents and resulting size
* Inserts the integers 100, 200, 300, …, 900 in that order, and then prints its contents and size afterwards
* Dequeue 4 items from the queue, and print its contents and resulting size
* Inserts the integers 5, 15, 25, 35, …, 905, 915 in that order, and then prints its contents and size afterwards
* Create a for loop the dequeue’s all of the items from the queue, and then print its contents and resulting size
* Insert three integers (your choice), and print its contents and resulting size
* Clear the queue, and print its contents and resulting size
* Insert four more integers (your choice) to the queue and finally print its contents and resulting size

2.  Create a class Student which has at least two fields, an int to store their ID, and a String to store their name.  Also, Student should implement the Comparable interface, such that compareTo uses the numeric ordering of IDs for the comparison.  Then, in another testing class, create a new LinkedListSortedQueue<Student> object, and try inserting and dequeing Students from it to see if everything works properly.

3.  In the previous exercise, Students were sorted in the SortedQueue based on their IDs.  Make the necessary changes to the class Student so that now, students are sorted based on the lexicographic ordering of their names.  (Note that exercises 2 and 3 illustrate that sorted queues can only sort things in the one way specified by the element type T.)
## Lab13

1.  Complete the implementation of LinkedListDeque<T> as described in the videos above.  To test out your implementation, create a separate testing class that creates a LinkedListDeque<Integer> object, and does the following:

* Tries to pop from both the front and the back of the empty deque (an exception should be thrown in both cases.)  Be sure to print the contents and size afterwards to make sure everything is as expected.
* Pushes 5 items to the front of the deque, and print its contents and resulting size after each push.
* Pops the 5 items from the front of the deque, and print its contents and resulting size after each pop.
* Pushes 6 items to the front of the deque, and print its contents and resulting size after each push.
* Pops the 6 items from the back of the deque, and print its contents and resulting size after each pop.
* Pushes 7 items to the back of the deque, and print its contents and resulting size after each push.
* Pops the 7 items from the back of the deque, and print its contents and resulting size after each pop.
* Pushes 8 items to the back of the deque, and print its contents and resulting size after each push.
* Pops the 8 items from the front of the deque, and print its contents and resulting size after each pop.
* Repeat the following 10 times using a loop:
* Pushes an item to the front, and then to the back, and print the contents and resulting size
* Repeat the following 8 times using a loop:
* Pops an item from the front, and then from the back, and print the contents and resulting size
* Clear the remaining elements from the deque, and print its contents and resulting size
* Push some more items to the deque from either end, and print its contents and resulting size

2. Implement the Merge Sort algorithm for Deque<Integer> by implementing the following two methods in a separate class:


```public static Deque<Integer> merge(Deque<Integer> d1, Deque<Integer> d2) {
	/* assuming d1 and d2 are sorted, merge their contents
       into a single sorted Deque, and return it */
} 


public static Deque<Integer> mergeSort(Deque<Integer> deq) {
     /* Step 0:  base case???
        Step 1:  split deq into two Deques of relatively equal size
        Step 2:  pass both of these Deques into mergeSort
        Step 3:  pass the resulting Deques into merge, and return the result
     */
} 

public static Deque<Integer> merge(Deque<Integer> d1, Deque<Integer> d2) {
 /* assuming d1 and d2 are sorted, merge their contents
       into a single sorted Deque, and return it */
} 
 
 
public static Deque<Integer> mergeSort(Deque<Integer> deq) {
     /* Step 0:  base case???
        Step 1:  split deq into two Deques of relatively equal size
        Step 2:  pass both of these Deques into mergeSort
        Step 3:  pass the resulting Deques into merge, and return the result
     */
} 
```
Do not use SortedQueue in your implementations…. it makes the problem trivial.  Be sure to test out your implementation in the main method of this class.
## Lab14

There is no coding associated with this lesson’s lab.  However, during lab, you may be asked to provide the Big-O complexity of given algorithms, or methods that you have previously written.

## Lab15

1.  Complete the implementation of LLQueueSet<T> as described in the videos above.  To test out your implementation, create a separate testing class that creates a LLQueueSet<Student> object, where Student is the class described above, and then runs the following test cases:

* First tries to removeAny from the empty set — catch the exception, and print the set’s contents and size afterwards to make sure you didn’t break it. 🙂
* Add 5 unique Students to the set, and print its contents and size
* Remove a specific Student from the set using a different object with the same values as the Student to be removed, and print the set’s contents and size
* Try to remove a Student from the set whose value is not there, and print the set’s contents and size
* Attempt to add 2 new Student objects that have the same values as those already in the set, and print the set’s contents and size afterwards
* Add 3 new Students to the set whose values are not already present, and print the set’s contents and size
* Call removeAny twice on the set, and output the values of those Students who were removed, as well as the resulting contents and size of the set
* Clear the set, and print its contents and resulting size
* Finally, add 2 new Students to the set, and print the set’s contents and size

2.   Create another implementation of Set called LLStackSet<T>, which uses a single field of type LinkedListStack<T> to contain the elements.  The approach should be very similar to the one used in the videos to implement LLQueueSet<T>.  Use a separate testing class with the same tests listed in the previous exercise to check your implementation.

3. In a separate class, write a static method that returns true if and only if set1 is a subset of set2, where both are sets of integers.  In other words, every element of set1 is contained in set2.  For example, the sets {-12} and {8, 33, 5} and {1, 33, 2, 5} are all subsets of {22, 33, 1, 5 -12, 2, 8}, but {22, 33, 99} is not.  Keep in mind that a set with no elements (the empty set) is a subset of any set.  At the end, both set1 and set2 should be preserved.  Be sure to write suitable testing code in the main method of this class.

```public static boolean isSubset(Set<Integer> set1, Set<Integer> set2);```

4. In a separate class, write a static method that creates and returns a new set, which is the union of set1 and set2, which are both sets of Strings.  For example, the union of sets {“Larry”, “Moe”, “Curly”} and {“Shemp”, “Larry”, “Joe”} is {“Larry”, “Moe”, “Shemp”, “Curly”, “Joe”}.  At the end, both set1 and set2 should be preserved.  Be sure to write suitable testing code in the main method of this class.

```public static Set<String> union(Set<String> set1, Set<String> set2);```

5.  In a separate class, write a static method that creates and returns a new set, which is the intersection of set1 and set2, which are both sets of integers.  For example, the intersections of sets {8, 33, 5} and {1, 33, 2, 5} is {33, 5}; while the intersection of sets {13, 25, 7} and {16, 45, 2, -18} is the empty set.  Keep in mind that the intersection of any set with the empty set results in the empty set. At the end, both set1 and set2 should be preserved.  Be sure to write suitable testing code in the main method of this class.

```public static Set<Integer> intersection(Set<Integer> set1, Set<Integer> set2);```

Hint for preserving sets in methods:  In the implementations for exercises 3, 4, and 5, you will need to go through all of the contents of a set without knowing what might be in there beforehand.  Furthermore, you will have to restore the contents of this set before you return from the method.  The simple way to do this is to:

* Step 1:  Create a temporary set
* Step 2:  Use a while loop to empty out the contents of the set in question, where removeAny is used to get the individual elements, and the elements are added to the temporary set as you go along
* Step 3:  Before you return from the method, restore the set’s contents by using another while loop which empties out the contents of the temporary set, and adds them to the original set

Keep in mind that the Set ADT does not require any particular ordering of the elements, although what you use to implement it may enforce a particular ordering.  For this reason, it is possible to output the contents of the same Set, where the elements may be printed in a different order.

## Lab16

1.  Complete the implementation of BSTSet<T>, except for the remove and removeAny methods as described in the videos above.  To test out your implementation, create a separate testing class that creates a BSTSet<Integer> object, and then runs the following test cases:

* Add the integers 5, 12, 3, 6, 14, 2, -6, 8, and 0 to the set in that order, and print its contents and size
* Attempt to re-add the integers 14, -6, and 5 to the set, and print the set’s contents and size afterwards
* Call contains on the integers 12, 7, 2, -8, and 5, and verify that the returned results are correct.  You may also want to print the set’s contents and size to verify that contains did not change it
* Clear the set, and print its contents and resulting size
* Finally, add the integers 55, 24, 78, and 51 to the set, and print the set’s contents and size

2.  Try instantiating your BSTSet using Students instead of integers, and run the test cases (minus the remove and removeAny parts) from the previous lesson.

## Lab17

1.  Complete the implementation of BSTSet<T> from the last lesson by adding remove and removeAny methods using standard TreeNodes as described in the videos above.  To test out your implementation, modify the testing class for BSTSet<Integer> objects from before so that it adds the steps shown in green below.

* Add the integers 5, 12, 3, 6, 14, 2, -6, 8, and 0 to the set in that order, and print its contents and size
* Attempt to re-add the integers 14, -6, and 5 to the set, and print the set’s contents and size afterwards
* Call contains on the integers 12, 7, 2, -8, and 5, and verify that the returned results are correct.  You may also want to print the set’s contents and size to verify that contains did not change it
* Remove the integers 0, 6, and 3 in that order, and print the set’s contents and size afterwards
* Add the integers 6, 13, 99 and 11 to the set in that order, and print its contents and size
* Remove the integer 12 from the set, and print the set’s contents and size
* Remove the integer 5 from the set (the root!), and print the set’s contents and size
* Call removeAny three times, and print the set’s contents and size
* Clear the set, and print its contents and resulting size
* Finally, add the integers 55, 24, 78, and 51 to the set, and print the set’s contents and size

2.  Create the second implementation of Set<T> described in the lesson, BST2Set<T>, by using OnOffTreeNodes.  Test it out using the same test cases as described in the previous exercise.
  
## Lab18

1.  Complete the implementation of LLQHashTableSet<T> as described in the lesson above.  To test out your implementation, create a separate testing class that creates a LLQHashTableSet<Integer> object, and runs the following test cases:

* First tries to removeAny from the empty set — catch the exception, and print the set’s contents and size afterwards
* Add the integers 1 through 20 to the set, and print its contents and size
* Remove the even integers 2, 4, 6,…, 20, from the set and print the set’s contents and size
* Try to remove the values 10 and 100 from the set, and verify that remove returns a false in both cases.  Print the set’s contents and size afterwards
* Now add the integers 1 to 30 to the set, and print the set’s contents and size afterwards
* Call removeAny 10 times on the set, and output the values that were removed, as well as the resulting contents and size of the set
* Clear the set, and print its contents and resulting size
* Finally, add the odd values 51, 53,…, 79 to the set, and print the set’s contents and size

2.  Timing tests.  For this exercise, you will compare the performance between implementations of LLQHashTableSet which use a different numbers of buckets to store items.  To begin, create a new testing class which contains the following main method:


```public static void main(String[] args) {
     
     Set<Integer> set = new LLQHashTableSet(10);

     System.out.println("Starting timing tests...");
     long time1, time2, duration;
     time1 = System.currentTimeMillis();
     
     for (int i = 0; i < 500000; i++) {
          set.add(i);
     }
   
     time2 = System.currentTimeMillis();
     duration = time2 - time1;

     System.out.println("Time taken in ms: " + duration);
}

public static void main(String[] args) {
     
     Set<Integer> set = new LLQHashTableSet(10);
 
     System.out.println("Starting timing tests...");
     long time1, time2, duration;
     time1 = System.currentTimeMillis();
     
     for (int i = 0; i < 500000; i++) {
          set.add(i);
     }
   
     time2 = System.currentTimeMillis();
     duration = time2 - time1;
 
     System.out.println("Time taken in ms: " + duration);
}
```

This is a fairly standard way of checking the amount of time needed to complete a large number of tests.  Note that:

* We need to perform a large number of tasks in order to get reasonable timing data for comparisons, since doing a single operation takes such a small amount of time that the system clock cannot accurately capture how long it would take.
* We do not do any extra stuff, such as System.out.println’s, between the places where we get the system time, since they can skew the timing data.  I/O operations actually take a lot of time to do, and can ruin timing trials.

Now, get out a sheet of paper, and do the following:

* Run the above code three times for the 10 buckets case, keeping track of the time taken for each trial.  Take the average time for the three trials.
* Modify your implementation to use 100 buckets, instead of 10, and run the time trials three more times.  Take the average time for these three trials.
* Again, modify your implementation, but this time, have it use 5000 buckets.  Run the time trials three times, and take the average.
* Looking at your timing results, can you draw any conclusions?  How many buckets do you think might be optimal for this particular task?  Try it out!

## Lab19

1.  Modify and complete your implementation of LLQHashTableSet<T> so that it implements the intermediate type interface HashTableSet as described in the lesson.

* a)  Next, create (or use your previous version of) the class Student which has the fields id, which should be an int, and name, which should be of type String.  Be sure to implement equals in Student so that it checks for equality of both the id’s and name’s of two Students.  Also implement a reasonable toString method, as well as a hashCode that simply returns the value 42.  (This is a legal hash function, though not a good one.)

Now, write a separate testing class which instantiates a LLQHashTableSet  with 10 buckets to store Student objects, and then add 200 Students to it, with the id’s 100, 101, 102, 103,…,299 but all with the name of “Bob”. 🙂  Print out the resulting load factor, and bucket size standard deviation for the hash table set, and record them on a separate sheet of paper which you will need to bring in during live grading.

* b)  Increase the number of buckets to 100, repeat the same tests as before, and record the resulting statistics on your paper.

* c) Now, change your hashCode method in Student to something more reasonable, where it outputs the id of the given Student.  Using 10 buckets in your hash table set, repeat the same tests as above, and record your results.

* d)  Using the same hashCode as in c), but increasing the number of buckets to 100, repeat the tests and record your results.

* e)  Answer the following questions on your sheet of paper:  Did any of the results surprise you?  What statistic is mainly impacted by the number of buckets in the hash table?  What statistic is mainly impacted by the hash function?

2. Implement the new class BSTHashTableSet<T>, which should also implement HashTableSet as described in the lesson.  Run the same tests as in Exercise 1, and record your results for questions (a) – (d).  Verify that these numbers are the same as those from Exercise 1.  On the same sheet of paper, explain why these numbers are the same for the two different implementations.

## Lab20

Be sure that you have successfully completed your implementations of LLQHashTableSet<T> and BSTHashTableSet<T> as outlined in the previous lesson before you begin the following timing exercises.

Don’t forget to also write down your answers to the conceptual questions below, and be sure you are able to explain these answers during live grading.

Timing Test 1.  Create a separate timing test class that creates a single LLQHashTableSet<Integer> object with 10 buckets, and adds the values 0 to 50000 to it in order, and outputs the time taken to do so using the approach from Exercise 2 from Lesson 18.  It should also output the resulting load factor and bucket size standard deviation at the end of the test.

Now, do the following:

* Run the above main method three times, recording all of your results on a separate sheet of paper.  Also record the average values of your results across the three trials.
* Run three more trials, but now using 100 buckets.  Record your results, along with the averages for the three trials.
* Run three more trials, using 5000 buckets this time.  Record your results, along with the averages for the three trials.
* Run the same set of trials for the bucket counts of 10, 100, and 5000 for the other implementation, BSTHashTableSet, recording your results and averages as you go.
* When testing using BST buckets, you might get a “stack overflow” exception, which simply means that the program ran out of memory when dealing with so many recursive calls.  To fix you, you can modify your add implementation so that it uses a loop, rather than recursion.  Another approach is to increase the memory stack size by going to the Run/Debug settings for your project, and setting the “VM arguments” field to -Xss5m.

Compare the results between the different bucket counts, and the different implementations.  On your paper, answer the following questions:

* Any initial surprises?  Can you explain why any surprising results came out as they did?
* Why are the load factors always the same for the same bucket count?
* Why are the standard deviations of the bucket sizes very low for all cases?
* Why is there not much difference between the two implementations in terms of speed?

Timing Test 2.  This is the same as Timing Test 1, except that in your testing code, instead of adding integers in order from 0 to 50000, add 50000 random integers to your Set implementation.  A random integer in Java can be generated using the call rand.nextInt(), where rand is an object of type Random.  Just be sure to declare and initialize your Random object at the beginning of main, before you even start your timing code.

Collect the same data as before, with the different bucket counts and different Hash Table-based Set implementations.  Then, answer the following questions:

* What is the biggest difference between the results from these trials, and those collected in Timing Test 1?
* Why are the load factors still roughly the same for the same bucket counts?
* Why are the standard deviations of the bucket sizes still low for all cases?
* Why do you think BSTHashTableSet does much better in terms of time performance in comparison to LLQHashTableSet?  Why * does it do better than the same trials for BSTHashTableSet in Timing Test 1?
 

## Lab21

1.  Complete the implementation of LLQueueMap<K, V> as described in the videos above.  To test out your implementation, create a separate testing class that creates a LLQueueMap<Integer, String> object, and then runs the following test cases:

* First tries to removeAny from the empty map — catch the exception, and print the map’s contents and size afterwards
* Define five unique mappings, and then print out the contents and size of the map
* Remove a specific mapping that is currently in the map, and print the resulting contents and size
* Try to remove a mapping where the key is not actually in the map, and print the resulting contents and size
* Define 2 new mappings that have the same keys but different values from those that are currently in the map; print the map’s contents and size afterwards
* Define 3 new mappings whose keys are not already present in the map, and print the resulting contents and size
* Call removeAny twice, and print the key-value pairs that were removed, as well as the resulting contents and size of the map
* Clear the map, and print its contents and resulting size
* Finally, add 2 new unique mappings to the map, and print it’s contents and size
 
2.   Create another implementation of Map called LLStackMap<K, V>, which uses a single field of type LinkedListStack<KeyValuePair<K,V>> to contain the mappings.  Use the same tests from exercise 1 to check your implementation.  Bonus Question:  How do we know that LLStackMap<K,V> will be less efficient than LLQueueMap<K,V>?

## Lab22

1.  Complete the implementation of BSTMap<K, V> as described in the lesson.  Don’t forget that K must implement the Comparable interface for this to work.  Use the stub code from the lesson to get started. To test out your implementation, use your testing class for Map from the previous lesson, but use an instantiated BSTMap<Integer, String> as your test object.

2.  Complete the implementation of LLQHashTableMap<K, V> as described in the lesson.  Here, use LinkedListQueue’s for your buckets.  Again, don’t forget to implement the methods of HashTableStats.  Use the same tests as with your other Map implementations, using an LLQHashTableMap<Integer, String> as your test object.

3.  Create an alternative Hash Table-based implementation of Map, BSTHashTableMap<K, V>, where instead of queues for buckets, you use Binary Search Trees.  Do not confuse this with using BSTSets or BSTMaps for the buckets — instead, each bucket is a TreeNode, which should represent the root for that BST.  Test your implementation using the same testing class as before with an instantiated BSTHashTableMap<Integer, String> object.

## Lab23

1.  Tower of Hanoi.  First, read the first two sections (or until you get bored) of this Wikipedia article on the game.  Next, you can see how to optimally move the disks to solve the 10-disk version of the game in the following video.  The two parts of this exercise are as follows:

* a)  Complete the implementation of the class, TowerOfHanoi, using the stub .java file TowerOfHanoi.java as a starting point.  The idea is that we have an array of 3 stacks of integers to represent the “posts”, and the individual integers on a given stack are the “discs”, where a bigger number represents a bigger disc.  Furthermore, the class keeps track of the number of moves, and can also be asked if the puzzle has been completed.

* b)  Create a second class whose main method creates an instance of a TowerOfHanoi object with n discs, and then calls another static method to solve the problem in the fewest number of moves.  When it is finished, the total number of moves, and the String representation of the TowerOfHanoi object should be output to the console window.  Can you determine the formula for the minimum number of moves relative to n?

2.  Efficient Fibonacci Finder. Using the .java stub file here as a starting point, first implement the static method fibCalc1 which calculates the nth Fibonacci number using recursion.  Note the use of the “static field” callCount1, which is used to keep track of how many times fibCalc1 is called during a single computation.  (Also note that we have a testing method testFibCalc1 which helps in setting up this static field, and outputting relevant information during testing.)  Can you determine the formula for the number of calls to fibCalc1 needed to calculate the nth Fibonacci number?

Next, implement fibCalc2, which does the same thing, except that it uses an additional static Map, ansMap, which keeps track of previously calculated Fibonacci values.  This should help cut down on the number of recursive calls needed to calculate a particular value for n.

Such an approach, where we save previously calculated values to help in computing new values for a given function, is known as memoization, which is generally used in dynamic programming.

3.  Super Robot World.  For this exercise, download and unzip the following Java package, robot_world, into a new Java project in your IDE.  Browse through the code, and run the main method in Tester just to get an idea of what is going on.  Here are the four classes:

* RobotWorld. Contains a world map (a 2D array of chars) which shows walls, a robot pointed in one of the four compass directions, and a goal spot marked ‘G”.  In this class, you need to implement three methods, two which rotate the robot 90 degrees in one direction, and one that moves it forward one spot.  The updates are done by making modifications in the world map array, and in the case of moveForward, you need to update the position of the Robot.
* WorldMapReader.  Reads a world map file, and creates the inital 2D array used by RobotWorld.  This class is provided for your convenience… you don’t need to make any changes here.
* Tester.  Class which contains a main method that initializes the world, and allows you to rotate the robot and move it around.  Once you complete the implementation of RobotWorld, modify the code here so that the robot reaches the goal.  You can also experiment by creating new world map files, and initializing the RobotWorld object to use those.
* SuperRobotWorld.  In this class which extends RobotWorld, you are enhancing things so that you can “undo” and “redo” particular commands that are issued to the robot.  The idea is that if you don’t like one or more moves that you made, you can always “rewind” the scenario any number of steps.  Furthermore, if you decide that you actually were okay with some of the commands that you undid, you can redo them as well.  This is similar to chess programs that allow for players to “take back” moves.

To implement this undo/redo capability, you will want to use some ADTs which you have already implemented to store commands (big hint: use two Stacks of chars, where a char represents a single command).  You will also need to somehow keep track of calls to the rotate and moveForward methods as they are made (big hint: override these methods to add the necessary information to the ADTs mentioned before, and have them call the parent versions of these methods using the syntax: super.rotateClockwise(), etc.)

When you are finished with the undo/redo methods, test these new operations out in the Tester class.

## Lab24

1.  Create ArrayListStack<T>, an implementation of our generic Stack<T> ADT using a Java API ArrayList as the only field of the class.  Create a testing class that uses the same test cases as in Lesson 6.

2.  Find your test class for your implementation of BSTSet from Lesson 16, exercise 1.  Replace the use of our Set and BSTSet types, with the Java API Set and HashSet types, and make the necessary modifications to the method calls so that they adhere to the new interface.

3.  Find your test class for your Map implementation from Lesson 22, exercise 1.  Replace the use of our Map and LLQueueMap types, with the Java API Map and TreeMap types, delete the test cases for removeAny, and make the necessary modifications to the remaining method calls so that they adhere to the new interface.
