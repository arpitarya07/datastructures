package LinkedList;

import java.net.SocketOption;

public class BasicLLProblems {
    public static void main(String[] args) {
        printLL(getSampleLL());
        System.out.println();
        printLL(insertAtHead(getSampleLL(), 6));
        System.out.println();
        printLL(insertAtTail(getSampleLL(), 6));
        System.out.println();
        printLL(insertAtMiddle(getSampleLL(), 6, 2));
        System.out.println();
        System.out.println(search(getSampleLL(), 5));
        System.out.println();
        printLL(delete(getSampleLL(), 5));
        System.out.println();
        printLL(reverse(getSampleLL()));
    }

    public static LinkedList getSampleLL() {
        LLNode llNode5 = new LLNode(5, null);
        LLNode llNode4 = new LLNode(4, llNode5);
        LLNode llNode3 = new LLNode(3, llNode4);
        LLNode llNode2 = new LLNode(2, llNode3);
        LLNode llNode1 = new LLNode(1, llNode2);
        LinkedList list = new LinkedList();
        list.setHead(llNode1);
        return list;
    }

    public static void printLL(LinkedList list) {
        LLNode llNodeHead = list.getHead();
        LLNode temp = llNodeHead;

        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public static LinkedList insertAtHead(LinkedList list, int newData) {
        LLNode llNodeHead = list.getHead();
        LLNode newNode = new LLNode(newData);
        newNode.next = llNodeHead;
        list.setHead(newNode);
        return list;
    }

    public static LinkedList insertAtTail(LinkedList list, int newData) {
        LLNode llNodeHead = list.getHead();
        LLNode temp = llNodeHead;
        LLNode newNode = new LLNode(newData);
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        return list;
    }

    public static LinkedList insertAtMiddle(LinkedList list, int newData, int givenData) {
        LLNode llNodeHead = list.getHead();
        LLNode temp = llNodeHead;
        LLNode newNode = new LLNode(newData);
        while (temp.data != givenData) {
            temp = temp.next;
        }
        newNode.next = temp.next;
        temp.next = newNode;
        return list;
    }

    public static LLNode findMiddleNode(LinkedList list) {
        LLNode fast, slow;
        fast = list.getHead();
        slow = list.getHead();
        while(fast!=null && fast.next!=null) {
            fast = fast.next.next;
            slow=slow.next;
        }
        return slow;

    }

    public static LLNode search(LinkedList list, int givenData) {
        LLNode llNodeHead = list.getHead();
        LLNode temp = llNodeHead;
        while (temp != null && temp.data != givenData) {
            temp = temp.next;
        }
        return temp;
    }

    public static LinkedList delete(LinkedList list, int givenData) {
        LLNode llNodeHead = list.getHead();
        LLNode givenNode = new LLNode(givenData);
        if(llNodeHead.data == givenData) {
            list.setHead(llNodeHead.next);
        }
        else {
            LLNode temp = llNodeHead;
            while (temp.next.data != givenData) {
                temp = temp.next;
            }
            LLNode currNode = temp.next;
            temp.next = currNode.next;
        }
        return list;
    }

    public static LinkedList reverse(LinkedList list) {
        if(list.getHead() == null) {
            return null;
        }
        LLNode prev = null;
        LLNode curr = list.getHead();
        LLNode next = curr.next;

        while (next != null) {
            curr.next = prev;
            prev = curr;
            curr = next;
            next = curr.next;
        }
        curr.setNext(prev);
        list.setHead(curr);
        return list;
    }
}
