import impl.LinkedListSortedQueue;
import adt.SortedQueue;

public class StudentTest {

    public static void main(String[] args) {
        SortedQueue studs = new LinkedListSortedQueue<Student>();

        Student a = new Student(10, "Demezhan");
        Student b = new Student(13, "Adil");
        Student c = new Student(12, "Kairataitpaev");
        Student d = new Student(11, "Jangarishker");


        studs.insert(a);
        studs.insert(b);
        studs.insert(c);
        studs.insert(d);

        print(studs);
    }

    public static void print(Object msg) {
        System.out.println(msg);
    }

}