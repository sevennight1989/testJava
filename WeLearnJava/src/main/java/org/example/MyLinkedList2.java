package org.example;

/**
 * 双向链表
 */
public class MyLinkedList2 {
    ListNode head;
    ListNode last;
    int size = 0;

    public MyLinkedList2() {
        size = 0;
        head = new ListNode(0);
        last = new ListNode(0);
        head.next = last;
        last.pre = head;
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        ListNode cur;
        if (index + 1 < size - index) {//判断index 处于 size / 2 的前部分，加快查找速度
            cur = head;
            for (int i = 0; i < index + 1; i++) {
                cur = cur.next;
            }
        } else {
            cur = last;
            for (int i = 0; i < size - index; i++) {
                cur = cur.pre;
            }
        }
        return cur.val;
    }

    public void addAtHead(int val) {
        ListNode pre = head;
        ListNode succ = head.next;
        ListNode newNode = new ListNode(val);
        newNode.next = succ;
        newNode.pre = pre;
        head.next = newNode;
        succ.pre = newNode;
        size++;
    }

    public void addAtLast(int val) {
        ListNode succ = last;
        ListNode pre = last.pre;
        ListNode newNode = new ListNode(val);
        newNode.next = succ;
        newNode.pre = pre;
        head.next = newNode;
        succ.pre = newNode;
        size++;
    }

    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        if (index < 0) {
            index = 0;
        }
        ListNode pre;//插入index的前节点
        ListNode succ;//插入index的后节点
        if (index < size - index) {
            pre = head;
            for (int i = 0; i < index; i++) {
                pre = pre.next;
            }
            succ = pre.next;
        } else {
            succ = last;
            for (int i = 0; i < size - index; i++) {
                succ = succ.pre;
            }
            pre = succ.pre;
        }
        ListNode newNode = new ListNode(val);
        newNode.next = succ;
        newNode.pre = pre;
        succ.pre = newNode;
        pre.next = newNode;
        size++;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        ListNode pre;
        ListNode succ;
        if (index < size - index) {
            pre = head;
            for (int i = 0; i < index; i++) {
                pre = pre.next;
            }
            succ = pre.next.next;
        } else {
            succ = last;
            for (int i = 0; i < size - index; i++) {
                succ = succ.pre;
            }
            pre = succ.pre.pre;
        }
        pre.next = succ;
        succ.pre = pre;
        size--;
    }

}
