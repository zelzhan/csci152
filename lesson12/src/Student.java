import impl.LinkedListSortedQueue;
import adt.SortedQueue;

public class Student implements Comparable<Student>{
    private int iD;
    private String name;

    public Student (int iD, String name){
        this.iD = iD;
        this.name = name;
    }

    public int getID(){
        return iD;
    }

    public String getName(){
        return name;
    }

    @Override
    public int compareTo(Student std) {
        if(iD > std.getID()) return 1;
        else return -1;

        //return name.compareTo(std.getName());
    }

    @Override
    public String toString() {
        return "Name:" + this.name + " " +  "ID:"+ this.iD + ";";
    }
}
