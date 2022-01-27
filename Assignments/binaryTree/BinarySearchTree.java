package binaryTree;

import java.util.Scanner;

public class BinarySearchTree {
    private Scanner s = new Scanner(System.in);

    private class Node {
        Node left;
        Node right;
        int val;

        public Node(int val) {
            this.val = val;
        }
    }

    private Node root;

    public int min() {
        return min(root);
    }

    public int min(Node root) {
        if (root.left == null) {
            return root.val;
        }
        return min(root.left);
    }

    public int max() {
        return max(root);
    }

    private int max(Node root) {
        if (root.right == null) {
            return root.val;
        }
        return max(root.right);
    }

    public void construct(int[] arr) {
        root = construct(arr, 0, arr.length - 1);
    }

    private Node construct(int[] arr, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = left + (right - left) / 2;
        Node nn = new Node(arr[mid]);
        nn.left = construct(arr, left, mid - 1);
        nn.right = construct(arr, mid + 1, right);
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

    public boolean search(int val) {
        return search(root, val);
    }

    private boolean search(Node root, int val) {
        if (root == null) {
            return false;
        }
        if (val > root.val) {
            return search(root.right, val);
        } else if (val < root.val) {
            return search(root.left, val);
        } else {
            return true;
        }
    }

    public Node insertIntoBST(Node root, int val) {
        if (root == null) {
            Node nn = new Node(val);
            root = nn;
        }
        insert(root, val);
        return root;
    }

    public void insert(Node root, int val) {
        if (val > root.val) {
            //insert in right tree
            if (root.right != null) {
                insert(root.right, val);
            } else {
                Node nn = new Node(val);
                root.right = nn;
            }
        } else if (val < root.val) {
            //insert in left tree
            if (root.left != null) {
                insert(root.left, val);
            } else {
                Node nn = new Node(val);
                root.left = nn;
            }
        }
    }

    public void delete(int val) {
        delete(root, val);
    }

    private Node delete(Node root, int val) {
        if (val < root.val) {
            root.left = delete(root.left, val);
        } else if (val > root.val) {
            root.right = delete(root.right, val);
        } else {
            if (root.right == null && root.left == null) {
                return null;
            } else if (root.right == null) {
                return root.left;
            } else if (root.left == null) {
                return root.right;
            } else {
                int inorderSucc = min(root.right);
                root.val = inorderSucc;
                root.right = delete(root.right, inorderSucc);
            }
        }
        return root;
    }
}
