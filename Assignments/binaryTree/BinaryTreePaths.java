package binaryTree;

import java.util.ArrayList;
import java.util.Scanner;

public class BinaryTreePaths {
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

    public BinaryTreePaths() {
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

    /* Height of Binary Trees */
    public int height() {
        return height(root);
    }

    private int height(Node root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return 1 + Math.max(leftHeight, rightHeight);
    }


    /* Check for Balanced Tree*/
    public boolean isBalancedTree() {
        return dfsHeight(root) != -1;
    }

    private int dfsHeight(Node root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = dfsHeight(root.left);
        if (leftHeight == -1) {
            return -1;
        }
        int rightHeight = dfsHeight(root.right);
        if (rightHeight == -1) {
            return -1;
        }
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        return 1 + Math.max(leftHeight, rightHeight);
    }


    /* Diameter (Max Distance with b/w two nodes) */
    public int diameter() {
        int[] max = new int[1];
        diameter(root, max);
        return max[0];
    }

    private int diameter(Node root, int[] max) {
        if (root == null) {
            return 0;
        }
        int leftH = diameter(root.left, max);
        int rightH = diameter(root.right, max);
        max[0] = Math.max(max[0], leftH + rightH);
        return 1 + Math.max(leftH, rightH);
    }


    /* Symmetric Tree */
    public boolean isSymmetricTree() {
        return root == null || isSymmetricTree(root.left, root.right);
    }

    private boolean isSymmetricTree(Node p, Node q) {
        if (p == null || q == null) {
            return p == q;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSymmetricTree(p.left, q.right) && isSymmetricTree(p.right, q.left);
    }


    /* Root to Given Node Path */
    public void rootToNode(int tar) {
        ArrayList<Integer> ans = rootToNode(root, tar);
        System.out.println(ans);
    }

    private ArrayList<Integer> rootToNode(Node root, int tar) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        rootToNode(root, tar, list);
        return list;
    }

    private boolean rootToNode(Node root, int tar, ArrayList<Integer> list) {
        if (root == null) {
            return false;
        }
        list.add(root.val);
        if (root.val == tar) {
            return true;
        }
        if (rootToNode(root.left, tar, list) || rootToNode(root.right, tar, list)) {
            return true;
        }
        list.remove(list.size() - 1);
        return false;
    }


    //Child Sum Property
    public void childSumProperty() {
        childSumProperty(root);
    }

    private void childSumProperty(Node root) {
        if (root == null) {
            return;
        }
        int childSum = 0;
        if (root.left != null) {
            childSum += root.left.val;
        }
        if (root.right != null) {
            childSum += root.right.val;
        }
        if (childSum >= root.val) {
            root.val = childSum;
        } else {
            if (root.left != null) {
                root.left.val = root.val;
            }
            if (root.right != null) {
                root.right.val = root.val;
            }
        }
        childSumProperty(root.left);
        childSumProperty(root.right);
        int totalSum = 0;
        if (root.left != null) {
            totalSum += root.left.val;
        }
        if (root.right != null) {
            totalSum += root.right.val;
        }
        if (root.left != null || root.right != null) {
            root.val = totalSum;
        }
    }

    /* Path Sum */
    public int maxPathSum() {
        int[] max = new int[1];
        max[0] = Integer.MIN_VALUE;
        maxPathSum(root, max);
        return max[0];
    }

    private int maxPathSum(Node root, int[] max) {
        if (root == null) {
            return 0;
        }
        int leftT = Math.max(0, maxPathSum(root.left, max));
        int rightT = Math.max(0, maxPathSum(root.right, max));
        max[0] = Math.max(max[0], leftT + rightT + root.val);
        return root.val + Math.max(leftT, rightT);
    }

    private boolean pathSum(Node root, int targetSum, int cSum) {
        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {
            if (cSum + root.val == targetSum) {
                return true;
            }
        }
        boolean leftAns = pathSum(root.left, targetSum, cSum + root.val);
        boolean rightAns = pathSum(root.right, targetSum, cSum + root.val);
        return leftAns || rightAns;
    }


    /* Count Nodes */
    public int countNodes() {
        return countNodes(root);
    }

    private int countNodes(Node root) {
        if (root == null) {
            return 0;
        }

        int leftA = countNodes(root.left);
        int rightA = countNodes(root.right);

        int total = leftA + rightA + 1;
        return total;
    }

    int res;

    public int sumNumbers() {
        res = 0;
        sumNumbers(root, 0);
        return res;
    }

    public void sumNumbers(Node root, int ans) {

        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            ans = ans * 10 + root.val;
            res += ans;
            return;
        }
        sumNumbers(root.left, ans * 10 + root.val);
        sumNumbers(root.right, ans * 10 + root.val);
    }
}
