import adt.HashTableMap;
import adt.Map;
import impl.BSTHashTableMap;
import impl.BSTMap;
import impl.LLQHashTableMap;
import impl.LLStackMap;

public class Test {
    public static void main(String[] args){
        HashTableMap<Integer, String> map = new BSTHashTableMap<>(10);
        try{
            System.out.println(map.removeAny());


        } catch (Exception ex){
            System.out.println(ex.getMessage());

        }
        System.out.println(map);

        try{
            map.removeAny();
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        for(int i =0; i<5; i++){
            map.define(i, i + "" + i*i);
        }
        System.out.println(map);
        System.out.println(map.getSize());
        map.remove(2);
        System.out.println(map);
        System.out.println(map.getSize());
        map.remove(100);
        System.out.println(map);
        System.out.println(map.getSize());
        map.define(3, "Hello world");
        map.define(4, "Hello csci152");
        System.out.println(map);
        System.out.println(map.getSize());
        map.define(120, "What");

        map.define(155, "Hell");
        map.define(122, "The");
        System.out.println(map);
        System.out.println(map.getSize());
        try{
            System.out.println(map.removeAny());
            System.out.println(map.removeAny());
        } catch (Exception ex){
        }
        System.out.println(map);
        System.out.println(map.getSize());
        map.clear();
        System.out.println(map);
        System.out.println(map.getSize());
        map.define(1, "1");
        map.define(2, "2");
        System.out.println(map);
        System.out.println(map.getSize());

    }
}
