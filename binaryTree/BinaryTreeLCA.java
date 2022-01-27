package binaryTree;

import java.util.Scanner;

public class BinaryTreeLCA {
    private Scanner s = new Scanner(System.in);

    private class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }

    private Node root;

    public BinaryTreeLCA() {
        root = construct();
    }

    private Node construct() {
        // 1.user se input
        // 2. tree banate jaenge
        int v = s.nextInt();
        if (v == -1) {
            return null;
        }
        Node nn = new Node(v);

        nn.left = construct();// left subtree de dia
        nn.right = construct();// right subtree de dia
        return nn;
    }

    public void display() {
        display(root);
    }

    private void display(Node root) {

        if (root == null) {
            return;
        }
        String str = "";
        if (root.left != null) {
            str += root.left.val;
        } else {
            str += '_';
        }

        str += " -> " + root.val + " <- ";

        if (root.right != null) {
            str += root.right.val;
        } else {
            str += '_';
        }

        System.out.println(str);

        display(root.left);
        display(root.right);
    }

    //LCA
    public void lcaOfBT(Node p, Node q) {
        Node ans = lcaOfBT(root, p, q);
        System.out.println(ans.val);
    }

    private Node lcaOfBT(Node root, Node p, Node q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        Node left = lcaOfBT(root.left, p, q);
        Node right = lcaOfBT(root.right, p, q);
        if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        } else {
            return root;
        }
    }
}
