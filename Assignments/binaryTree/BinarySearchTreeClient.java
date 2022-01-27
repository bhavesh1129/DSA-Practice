package binaryTree;

public class BinarySearchTreeClient {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        int[] arr = {-10, -3, 0, 5, 9};
        bst.construct(arr);
        bst.display();
//        System.out.println(bst.min());
//        System.out.println(bst.max());
//        System.out.println(bst.search(30));
//        System.out.println("------------------");
//        bst.delete(10);
//        bst.display();
    }
}
