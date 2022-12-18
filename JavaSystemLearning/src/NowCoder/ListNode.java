package NowCoder;

import java.util.ArrayList;

public class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }

    public static void ListNodeTest() {
        ListNode list = new ListNode(0);
        list.next = new ListNode(1);
        list.next.next = new ListNode(2);

        list.printAll();
        list = ListNode.anotherReverseList(list);
        list.printAll();
    }

    public void printAll() {
        ListNode p = this;
        while (p != null) {
            System.out.print(p.val + ", ");
            p = p.next;
        }
        System.out.println();
    }

    // https://www.nowcoder.com/practice/75e878df47f24fdc9dc3e400ec6058ca?tpId=295&tqId=23286&ru=/exam/oj&qru=/ta/format-top101/question-ranking&sourceUrl=%2Fexam%2Foj
    public static ListNode ReverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = null;
        ListNode temp = null;
        while (head != null) {
            // 1. a temp node to store the next node and it's linked ListNodes, prepare to
            // instead the previous node(remove the head's Head node):
            temp = head.next;
            // 2. link the newHead after the head's Head node:
            head.next = newHead;
            // 3. move the newHead to the head's Head node:
            newHead = head;
            // 4. remove the head's Head node, which means move the head to the next node
            head = temp;
        }
        return newHead;
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