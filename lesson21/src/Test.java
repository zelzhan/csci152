import adt.Map;
import impl.KeyValuePair;
import impl.LinkedListQueue;
import impl.LLQueueMap;
import impl.LLStackMap;
import javax.sound.midi.SysexMessage;

public class Test {
    public static void main(String[] args){
        Map<Integer, String> map = new LLStackMap();
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
        map.define(122, "The");
        map.define(155, "Hell");
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
