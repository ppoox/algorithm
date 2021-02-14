package timestamp;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.*;

public class TestTimestamp {
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


    public static int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }
}
