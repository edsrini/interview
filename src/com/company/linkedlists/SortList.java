package com.company.linkedlists;

public class SortList {
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode mid = new ListNode();
        while(fast != null && fast.next != null){
            mid = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        mid.next = null;
        ListNode list1 = sortList(head);
        ListNode list2 = sortList(slow);

        // merge
        ListNode dummy = new ListNode();
        ListNode runner = dummy;
        while(list1 != null || list2 != null){
            if(list1 != null && list2 != null){
                if(list1.val <= list2.val){
                    runner.next = list1;
                    list1 = list1.next;
                    runner = runner.next;
                }else{
                    runner.next = list2;
                    list2 = list2.next;
                    runner = runner.next;
                }
            }else{
                if(list1 != null){
                    runner.next = list1;
                    list1 = list1.next;
                    runner = runner.next;
                }else{
                    runner.next = list2;
                    list2 = list2.next;
                    runner = runner.next;
                }
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(7);
        l1.next.next.next = new ListNode(9);

        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(4);
        l2.next.next = new ListNode(5);


        ListNode[] lists = {l1, l2};

        SortList s = new SortList();
        s.sortList(l1);

    }
}


