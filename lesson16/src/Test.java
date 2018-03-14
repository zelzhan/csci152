import adt.Set;
import impl.BSTSet;
import impl.BST2Set;
public class Test {
    public static void main(String[] args){
        BST2Set<Integer> bst = new BST2Set<>();
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
        System.out.println("Size " + bst.getSize());
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
            System.out.println((bst.removeAny()));
            System.out.println((bst.removeAny()));
            System.out.println((bst.removeAny()));

        } catch (Exception ex){
        }
        System.out.println(bst.getSize());
        System.out.println(bst);
    }
}
