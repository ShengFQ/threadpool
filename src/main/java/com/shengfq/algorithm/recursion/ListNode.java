package com.shengfq.algorithm.recursion;
/**
 * demo:翻转单链表
 * */
public class ListNode {
    int date;
    //链表的
    ListNode next;
    //翻转函数
    private static ListNode reverseList(ListNode head){
        if(head==null || head.next==null){
            return head;
        }
        //递归翻转子链表
        ListNode newlist=reverseList(head.next);
        //
        ListNode t1=head.next;
        t1.next=head;
        head.next=null;
        return newlist;
    }

    public static void main(String[] args) {

    }
}
