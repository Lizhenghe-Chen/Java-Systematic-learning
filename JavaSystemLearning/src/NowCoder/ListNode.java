package NowCoder;

import java.util.ArrayList;
import java.util.List;

import MyTools.Tools;

public class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    /**
     * print the ListNode
     * 
     * @param print if print is true, print the ListNode, else only return the
     *              String
     * @return the String of the ListNode
     */
    public String toString(Boolean print) {
        String result = "";
        ListNode temp = this;
        if (print)
            System.out.print("[");
        while (temp != null) {
            result = temp.next == null ? result + temp.val : result + temp.val + ",";
            temp = temp.next;
        }
        if (print) {
            System.out.print(result);
            System.out.print("]\n");
        }
        return result;
    }

    /**
     * convert the array to ListNode
     * 
     * @param nums the int[] array to convert
     * @return the ListNode converted from the array
     */
    public static ListNode arrayToListNode(int[] nums) {
        ListNode list = new ListNode(nums[0]);// create a ListNode to store the list's head
        ListNode temp = list;// create a temp ListNode to store the list's head，这里的temp和list指向同一个ListNode！！！
        for (int i = 1; i < nums.length; i++) {
            temp.next = new ListNode(nums[i]);// 这一步其实已经改变list的next，因为temp和list指向同一个ListNode！！！
            // System.out.println(temp.val + "->" + temp.next.val);
            temp = temp.next;// 这一步相当于重置了temp，让temp指向了list的next，此时temp指向了list的next
            // System.out.println(temp.val );
        }
        return list;
    }
}

class Mian {
    public static void main(String[] args) {
        // ListNode linkedList = arrayToListNode(new int[] { 1, 2, 3, 4, 5, 6, 7 });
        // linkedList.toString(true);
        // System.out.println(linkedList.next.next.val);
        addTwoNumbers(ListNode.arrayToListNode(new int[] { 2, 4, 3 }),
                ListNode.arrayToListNode(new int[] { 5, 6, 4 })).toString(true);
    }

    /**
     * //
     * https://www.nowcoder.com/practice/75e878df47f24fdc9dc3e400ec6058ca?tpId=295&tqId=23286&ru=/exam/oj&qru=/ta/format-top101/question-ranking&sourceUrl=%2Fexam%2Foj
     * 
     * @param head
     * @return
     */
    public static ListNode ReverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = null;
        ListNode temp = null;
        while (head != null) {
            // 1. a temp node to store the next node and it's linked ListNodes, prepare to
            // instead the previous node(remove the head's Head node):
            temp = head.next;//
            // 2. link the newHead after the head's Head node:
            head.next = newHead;// head->newHead->null
            // 3. move the newHead to the head's Head node:
            newHead = head;
            // 4. remove the head's Head node, which means move the head to the next node
            head = temp;
        }
        return newHead;
    }

    /**
     * https://leetcode.com/problems/add-two-numbers/description/
     * 
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int previous = 0;
        ListNode head = new ListNode(0);
        ListNode temp = head;
        ListNode t1 = l1, t2 = l2;
        while (t1 != null || t2 != null) {
            if (t1 != null) {
                previous += t1.val;
                t1 = t1.next;
            }
            if (t2 != null) {
                previous += t2.val;
                t2 = t2.next;
            }
            temp.next = new ListNode(previous % 10);
            temp = temp.next;
            previous /= 10;
        }
        if (previous >= 1) {
            temp.next = new ListNode(1);
        }
        return head.next;// skip the new ListNode(0);
    }

    public static ListNode anotherReverseList(ListNode head) {

        ListNode result = null;
        ArrayList<Integer> nums = new ArrayList<>();
        while (head != null) {
            nums.add(head.val);
            head = head.next;
        }
        System.out.println(nums.toString());

        for (int i = 0; i < nums.size(); i++) {
            if (result == null) {
                result = new ListNode(nums.get(i));
            } else {
                ListNode temp = new ListNode(nums.get(i));
                temp.next = result;
                result = temp;
            }
        }
        return result;
    }
}
