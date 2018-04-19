import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.TreeMap;



public class Test1 {
    public static void bstTest(){
        Set<Integer> bst = new HashSet<>();
        bst.add(5);
        bst.add(12);
        bst.add(3);
        bst.add(6);
        bst.add(14);
        bst.add(2);
        bst.add(-6);
        bst.add(8);
        bst.add(0);
        System.out.println(bst);
        bst.add(14);
        bst.add(-6);
        bst.add(5);
        System.out.println(bst);
        System.out.println(bst.contains(12));
        System.out.println(bst.contains(7));
        System.out.println(bst.contains(2));
        System.out.println(bst.contains(-8));
        System.out.println(bst.contains(5));
        System.out.println("Size " + bst.size());
        bst.remove(0);
        bst.remove(6);
        bst.remove(3);
        System.out.println(bst);
        bst.add(6);
        bst.add(3);
        bst.add(99);
        bst.add(11);
        System.out.println(bst);
        bst.remove(12);
        System.out.println(bst);
        bst.remove(5);
        System.out.println(bst);
        try{
            System.out.println((bst.remove(0)));
            System.out.println((bst.remove(1)));
            System.out.println((bst.remove(2)));

        } catch (Exception ex){
        }
        System.out.println(bst.size());
        System.out.println(bst);
    }

    public static void stackTest(){
        List<Integer> stk = new Stack();
        try{
            stk.remove(0);
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        }

        for( int i =0; i < 12; i++) stk.add(i);
        System.out.println(stk);
        System.out.println(stk.size());
        stk.remove(0);
        stk.remove(0);
        stk.remove(0);
        System.out.println(stk);
        System.out.println(stk.size());
        stk.clear();
        System.out.println(stk);
        System.out.println(stk.size());
        for(int j = 0; j < 44; j+=2) stk.add(j);
        System.out.println(stk);
        System.out.println(stk.size());
    }

    public static void mapTest(){
        Map<Integer, String> map = new TreeMap();
        try{
            System.out.println(map.remove(0));
        } catch (Exception ex){
            System.out.println(ex.getMessage());

        }
        System.out.println(map);
        try{
            map.remove(1);
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        for(int i =0; i<5; i++){
            map.put(i, i + "" + i*i);
        }
        System.out.println(map);
        System.out.println(map.size());
        map.remove(2);
        System.out.println(map);
        System.out.println(map.size());
        map.remove(100);
        System.out.println(map);
        System.out.println(map.size());
        map.put(3, "Hello world");
        map.put(4, "Hello csci152");
        System.out.println(map);
        System.out.println(map.size());
        map.put(120, "What");

        map.put(155, "Hell");
        map.put(122, "The");
        System.out.println(map);
        System.out.println(map.size());
        try{
            System.out.println(map.remove(3));
            System.out.println(map.remove(2));
        } catch (Exception ex){
        }
        System.out.println(map);
        System.out.println(map.size());
        map.clear();
        System.out.println(map);
        System.out.println(map.size());
        map.put(1, "1");
        map.put(2, "2");
        System.out.println(map);
        System.out.println(map.size());
    }

    public static void main(String[] args){
        stackTest();
        bstTest();
        mapTest();
    }
}
