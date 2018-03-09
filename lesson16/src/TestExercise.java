import impl.TreeNode;
public class TestExercise {
    public static void main(String[] args){
        TreeNode<Integer> root = new TreeNode(12);
        root.setLeft(new TreeNode(25));
        root.setRight(new TreeNode<>(17));
        root.getLeft().setLeft(new TreeNode<>(85));
        root.getRight().setLeft(new TreeNode<>(-46));
        root.getRight().setRight(new TreeNode<>(15));

    }
}
