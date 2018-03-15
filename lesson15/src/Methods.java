import adt.Set;
import impl.LLQueueSet;


public class Methods {

    public static boolean isSusbset(Set<Integer> set1, Set<Integer> set2){
        Set<Integer> temp = new LLQueueSet<>();
        boolean bool = true;
        while(set1.getSize() != 0){
            try{
                int val = set1.removeAny();
                temp.add(val);
                if(set2.contains(val)) continue;
                bool = false;
                break;
            } catch (Exception ex){
            }
        }
        while(temp.getSize() != 0){
            try{
                set1.add(temp.removeAny());
            } catch (Exception ex){
            }
        }
        return bool;
    }


        public static Set<Integer> intersection(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> result = new LLQueueSet<>();
        Set<Integer> save = new LLQueueSet<>();
        int size = set1.getSize(), val = 0;

        for(int i = 0; i<size; i++) {
            try {
                val = set1.removeAny();
                if(set2.contains(val)) result.add(val);
                save.add(val);
            } catch (Exception ex) {
            }
        }


        for(int i = 0; i<size; i++) {
            try {
                set1.add(save.removeAny());
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
        return result;
    }

    public static Set<String> union(Set<String> set1, Set<String> set2) {
        Set<String> result = new LLQueueSet<>();
        Set<String> back1 = new LLQueueSet<>();
        Set<String> back2 = new LLQueueSet<>();

        int size = set1.getSize();
        String val;

        for(int i = 0; i<size; i++) {
            try {
                val = set1.removeAny();
                back1.add(val);
                if(set2.contains(val)) {
                    set2.remove(val);
                    back2.add(val);
                }
                result.add(val);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }

        size = set2.getSize();
        for(int i = 0; i<size; i++) {
            try {
                val = set2.removeAny();
                result.add(val);
                back2.add(val);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }

        size = back1.getSize();
        for(int i = 0; i<size; i++) {
            try {
                set1.add(back1.removeAny());
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }

        size = back2.getSize();
        for(int i = 0; i<size; i++) {
            try {
                set2.add(back2.removeAny());
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }

        return result;
    }
}
