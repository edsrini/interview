package com.company.linkedlists;

import java.util.PriorityQueue;

public class MergeKSortedLinkedLists {
    public ListNode mergeKLists(ListNode[] lists) {

        //Check empty list
        if (lists.length == 0) return null;

        //Check list with size 1
        if (lists.length == 1) return lists[0];

        //Heap will only hold elements equalling to the length of the list
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(lists.length, (node1, node2) -> node1.val - node2.val);

        //Insert the first elements of all the list to the heap
        for (ListNode node : lists) {
            if(node != null)
                minHeap.add(node);
        }

        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        while (!minHeap.isEmpty()) {
            tail.next = minHeap.poll();
            tail = tail.next;
            if (tail.next != null) {
                minHeap.offer(tail.next);
            }
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(7);

        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(4);
        l2.next.next = new ListNode(5);

        ListNode[] lists = {l1, l2};

        MergeKSortedLinkedLists m = new MergeKSortedLinkedLists();
        m.mergeKLists(lists);

    }
}

class ListNode{
    public int val;
    public ListNode next;

    public ListNode(int val){
        this.val = val;
        this.next = null;
    }

    public ListNode(){

    }
}
