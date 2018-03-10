import adt.Set;
import impl.BSTSet;
public class Test {
    public static void main(String[] args){
        Set<Integer> bst = new BSTSet<>();
        bst.add(5);
        bst.add(12);
        bst.add(3);
        bst.add(6);
        bst.add(14);
        bst.add(2);
        bst.add(-6);
        bst.add(8);
        bst.add(0);
        bst.add(2);
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
        System.out.println("Size " + bst.getSize());
        bst.clear();
        System.out.println(bst);

    }
}
