package linkedlist;

import java.util.Scanner;

public class LinkedList {
    static Node head;

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    static Node reverse(Node head) {
        if (head == null || head.next == null)
            return head;
        Node rest = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return rest;
    }

    static void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    static void push(int data) {
        Node temp = new Node(data);
        temp.next = head;
        head = temp;
    }

    private static int middleNode() {
        Node fast = head, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return fast.data;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                list.push(sc.nextInt());
            }

        }
        list.print();
        int ans = list.middleNode();
    }
}
