package _leetcode;

public class AddTwoNumbers {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static void main(String[] args) {
//        ListNode l1 = new ListNode(9,new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))))));
//        ListNode l2 = new ListNode(9,new ListNode(9, new ListNode(9)));

        ListNode l1 = new ListNode(9);
        ListNode l2 = new ListNode(1,new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))))))))));

        System.out.println("reuslt " + addTwoNumbers(l1, l2));
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {


        Long nodeSum = nodeReverseInt(l1) + nodeReverseInt(l2);

        if(nodeSum < 1) {
            return new ListNode(0);
        }

        return nodeReverse(nodeSum);
    }

    public static Long nodeReverseInt(ListNode ln) {
        if(ln.next == null) {
            return Long.valueOf(ln.val);
        }

        return nodeReverseInt(ln.next)*10 + ln.val;
    }

    public static ListNode nodeReverse(Long x) {
        if(x < 1) {
            return null;
        }

        return new ListNode((int)(x%10), nodeReverse(x/10));
    }
}
