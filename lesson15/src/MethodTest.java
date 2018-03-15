import java.lang.reflect.Method;
import adt.Set;
import impl.LLQueueSet;

public class MethodTest {
    public static void main(String[] args){
        Set<Integer> set1 = new LLQueueSet<>();
        Set<Integer> set2 = new LLQueueSet<>();
        Methods method = new Methods();
        set1.add(5);
        set1.add(12);
        set1.add(40);
        set2.add(33);
        set2.add(5);
        set2.add(55);
        set2.add(12);
        set2.add(60);
        set2.add(40);
        System.out.println(set1);
        System.out.println(set2);

        System.out.println(method.isSusbset(set2, set1));

        System.out.println(set1);
        System.out.println(set2);

//        for (int i = 0; i < 15; i++) set1.add(i);
//        for (int j = 0; j < 20; j++) set2.add(j);
//
//        System.out.println(set1);
//        System.out.println(set2);
//
//        Set<Integer> result = Methods.intersection(set1, set2);
//        System.out.println(result);
//
//        System.out.println(Methods.isSubset(set1, set2));

//        try{
//            set1.add(1);
//            set1.add(2);
//            set1.add(3);
//            set1.add(4);
//            set1.removeAny();
//            set1.removeAny();
//            set1.removeAny();
//            set1.removeAny();
//            set1.removeAny();
//            set1.add(5);
//        } catch (Exception ex){
//            System.out.println("Hello");
//            set1.add(1000);
//
//        }
//        System.out.println(set1);


    }
}
