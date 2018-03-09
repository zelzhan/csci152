import java.lang.reflect.Method;
import adt.Set;
import impl.LLQueueSet;

public class MethodTest {
    public static void main(String[] args){
        Set<Integer> set1 = new LLQueueSet<>();
        Set<Integer> set2 = new LLQueueSet<>();

        for (int i = 0; i < 15; i++) set1.add(i);
        for (int j = 0; j < 20; j++) set2.add(j);

        System.out.println(set1);
        System.out.println(set2);

        Set<Integer> result = Methods.intersection(set1, set2);
        System.out.println(result);

        System.out.println(Methods.isSubset(set2, set1));


    }
}
