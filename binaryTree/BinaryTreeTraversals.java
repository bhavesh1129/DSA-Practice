package binaryTree;

import java.util.*;

public class BinaryTreeTraversals {
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

    public BinaryTreeTraversals() {
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

    /* Traversals */
    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node root) {
        if (root == null) {
            return;
        }

        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }

    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node root) {
        if (root == null) {
            return;
        }

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val + " ");
    }

    public void lineOrderTraversal() {
        List<List<Integer>> ans = lineOrderTraversal(root);
        System.out.println(ans);
    }

    private List<List<Integer>> lineOrderTraversal(Node root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) {
            return lists;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node front = queue.poll();
            ArrayList<Integer> l = new ArrayList<>();
            l.add(front.val);
            if (front.left != null) {
                queue.add(front.left);
            }
            if (front.right != null) {
                queue.add(front.right);
            }
            lists.add(l);
        }
        return lists;
    }

    public void zigzagTraversal() {
        List<List<Integer>> ans = zigzagTraversal(root);
        System.out.println(ans);
    }

    private List<List<Integer>> zigzagTraversal(Node root) {
        List<List<Integer>> mainList = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        boolean zigzag = false;
        if (root == null) {
            return mainList;
        }
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> list = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                Node front = queue.poll();
                if (zigzag) {
                    list.addFirst(front.val);
                } else {
                    list.add(front.val);
                }
                if (front.left != null) {
                    queue.add(front.left);
                }
                if (front.right != null) {
                    queue.add(front.right);
                }
            }
            zigzag = !zigzag;
            mainList.add(list);
        }
        return mainList;
    }

    //Vertical Level Order, Top View, Bottom View Traversals
    private class Pair {
        Node currNode;
        int vertLvl;

        private Pair(Node currNode, int vertLvl) {
            this.currNode = currNode;
            this.vertLvl = vertLvl;
        }
    }

    public void verticalLevelOrder() {
        verticalLevelOrder(root);
    }

    private void verticalLevelOrder(Node root) {
        Queue<Pair> queue = new LinkedList<>();
        Map<Integer, List<Integer>> map = new TreeMap<>();
        List<List<Integer>> res = new ArrayList<>();
        queue.add(new Pair(root, 0));
        while (!queue.isEmpty()) {
            Pair front = queue.poll();
            Node currNode = front.currNode;
            int currLvl = front.vertLvl;
            if (currNode.left != null) {
                queue.add(new Pair(currNode.left, currLvl - 1));
            }
            if (currNode.right != null) {
                queue.add(new Pair(currNode.right, currLvl + 1));
            }
            List<Integer> list = map.getOrDefault(currLvl, new ArrayList<>());
            list.add(currNode.val);
            map.put(currLvl, list);
        }
        List<Integer> topViewLevelOrder = new ArrayList<>();
        List<Integer> bottomViewLevelOrder = new ArrayList<>();
        for (List<Integer> i : map.values()) {
            res.add(i);
            topViewLevelOrder.add(i.get(0));
            bottomViewLevelOrder.add(i.get(i.size() - 1));
        }
        System.out.println("Vertical Level Order -> " + res);
        System.out.println("Top View Level Order -> " + topViewLevelOrder);
        System.out.println("Bottom View Level Order -> " + bottomViewLevelOrder);
    }

    public void leftViewTree() {
        List<Integer> list = new ArrayList<>();
        leftViewTree(root, 0, list);
        System.out.println("Left View Level Order -> " + list);
    }

    private void leftViewTree(Node root, int level, List<Integer> list) {
        if (root == null) {
            return;
        }
        if (level == list.size()) {
            list.add(root.val);
        }
        leftViewTree(root.left, level + 1, list);
        leftViewTree(root.right, level + 1, list);
    }

    public void rightViewTree() {
        List<Integer> list = new ArrayList<>();
        rightViewTree(root, 0, list);
        System.out.println("Right View Level Order -> " + list);
    }

    private void rightViewTree(Node root, int level, List<Integer> list) {
        if (root == null) {
            return;
        }
        if (level == list.size()) {
            list.add(root.val);
        }
        rightViewTree(root.right, level + 1, list);
        rightViewTree(root.left, level + 1, list);
    }
}