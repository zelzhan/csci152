import adt.Set;
import impl.LLQueueSet;
import impl.LLStackSet;

public class StackTest {
    public static void main(String[] args){
        Set<Student> set = new LLStackSet<>();
        try{
            set.removeAny();
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }

        set.add(new Student("Daulet", 12345));
        set.add(new Student("kau2et", 123425));
        set.add(new Student("baul4et", 123454));
        set.add(new Student("naule5t", 123455));
        set.add(new Student("maul6et", 123457));

        System.out.println(set);
        Student daulet = new Student("baul4et", 123454);
        set.remove(daulet);

        System.out.println(set);

        System.out.println(set.remove(daulet));

        set.add(new Student("baul4et", 123454));
        set.add(new Student("baul4et", 123454));
        System.out.println(set);
        set.add(new Student("baul42et", 1263454));
        set.add(new Student("baul34et", 12325454));
        set.add(new Student("bagul4et", 1273454));
        System.out.println(set);

        set.clear();

        System.out.println(set);

        set.add(new Student("baul34et", 12325454));
        set.add(new Student("bagul4et", 1273454));

        System.out.println(set);



    }
}
