package _leetcode.topliked100;

import java.util.*;
import java.util.stream.Collectors;

public class LinkedListCycle {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static void main(String[] args) {
        // 3 2 0 -4
//        ListNode one = new ListNode(3);
//        ListNode two = new ListNode(2);
//        ListNode three = new ListNode(0);
//        ListNode four = new ListNode(-4);
//
//        one.next = two;
//        two.next = three;
//        three.next = four;
//
//        new LinkedListCycle().hasCycle(one);
//        isHappy(2);

//        System.out.println(firstUniqChar("aabb"));

//        int[] ts = {-1,0,1,2,-1,-4};
//        int[] ts1 = {};
//        int[] ts2 = {0};
//        System.out.println(threeSum(ts));
//        System.out.println(threeSum(ts1));
//        System.out.println(threeSum(ts2));


        System.out.println(longestPalindrome("abcba"));
//        System.out.println(longestPalindrome("civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth"));

    }
    private static int lo, maxLen;

    public static String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2)
            return s;

        for (int i = 0; i < len-1; i++) {
            extendPalindrome(s, i, i);  //assume odd length, try to extend Palindrome as possible
            extendPalindrome(s, i, i+1); //assume even length.
        }
        return s.substring(lo, lo + maxLen);
    }

    private static void extendPalindrome(String s, int j, int k) {
        System.out.println("j: " + j + " / k: " + k + " / char(j): " + s.charAt(j) + " / char(k): " + s.charAt(k));
        while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
            j--;
            k++;
        }
        System.out.println("------ maxlen: " + maxLen + " / k-j-1: " + (k-j-1) + " / j: " + j + " / k: " + k);
        if (maxLen < k - j - 1) {
            lo = j + 1;
            maxLen = k - j - 1;
        }
    }


    public boolean hasCycle(ListNode head) {
        ListNode temp = head;
        while (temp.next == null) {
            System.out.println();
            Map<Integer, Integer> map = new HashMap<>();
            for (Integer m : map.keySet()) {

            }
        }
        Set<Integer> set = new HashSet<>();
        int[] ints = set.stream().mapToInt(Integer::intValue).toArray();

        String digits = "23";

        Arrays.stream(digits.split("")).mapToInt(Integer::parseInt).toArray();
        Arrays.stream(digits.split("")).collect(Collectors.toList());



        List<Integer> list = new ArrayList<>();


        return false;
    }

    public static boolean isHappy(int n) {
        boolean isHappy = false;
        int number = n ;
        Set<Integer> his = new HashSet<>();
        while (number < Integer.MAX_VALUE) {
            System.out.println(":::: number " + number);
            List<Integer> list = new ArrayList<>();

            while (number > 0) {
                int digit = number % 10;
                number /= 10;
                list.add(digit);
            }

            System.out.println(":::: list " + Arrays.toString(list.toArray()));

            number = list.stream()
                    .map(x -> x * x)
                    .reduce(0, Integer::sum);

            if (number == 1) {
                isHappy = true;
                break;
            }

            int prevSize = his.size();
            his.add(number);
            if (prevSize + 1 != his.size()) {
                isHappy = false;
                break;
            }
        }

        return isHappy;
    }

    public static int firstUniqChar(String s) {
        int result = -1;
        System.out.println("tt" + "abc".lastIndexOf("e"));
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            boolean isUnique = true;
            for (int j = i; j < chars.length; j++) {
                if (chars[i] == chars[j]) {
                    isUnique = false;
                }
            }

            if (isUnique) {
                result = i;
            }
        }


        return result;
    }

    public static List<List<Integer>> threeSum(int[] num) {
        Arrays.sort(num);
        System.out.println(Arrays.toString(num));
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < num.length-2; i++) {
            if (i == 0 || num[i] != num[i-1]) {
                int lo = i+1, hi = num.length-1, sum = -num[i];
                while (lo < hi) {
                    if (num[lo] + num[hi] == sum) {
                        res.add(Arrays.asList(num[i], num[lo], num[hi]));
                        while (lo < hi && num[lo] == num[lo+1]) lo++;
                        while (lo < hi && num[hi] == num[hi-1]) hi--;
                        lo++;
                        hi--;
                    } else if (num[lo] + num[hi] < sum) {
                        lo++;
                    } else {
                        hi--;
                    }

                    System.out.println("i: " + i + " / lo: " + lo + " / num[lo]: " + num[lo] + " hi: " + hi + " / num[hi]: " + num[hi]);
                }
            }
        }
        return res;
    }

    public int romanToInt(String s) {
        Map<String, Integer> symbolMap = new HashMap<>();
        symbolMap.put("I", 1);
        symbolMap.put("V", 10);
        symbolMap.put("X", 10);
        symbolMap.put("L", 50);
        symbolMap.put("C", 100);
        symbolMap.put("D", 500);
        symbolMap.put("M", 1000);


        int result = 0;
        int idx = 0;
        char[] sChars = s.toCharArray();
        while (idx < sChars.length) {
            if (idx == sChars.length-1) {
                result += symbolMap.get(String.valueOf(sChars[idx]));
            } else if (sChars[idx] == 'I') {
                if (sChars[idx++] == 'V') {
                    result += 4;
                } else if (sChars[idx++] == 'X') {
                    result += 9;
                } else {
                    result += symbolMap.get(String.valueOf(sChars[idx]));
                }
            } else if (sChars[idx] == 'X') {
                if (sChars[idx++] == 'L') {
                    result += 40;
                } else if (sChars[idx++] == 'C') {
                    result += 90;
                } else {
                    result += symbolMap.get(String.valueOf(sChars[idx]));
                }
            } else if (sChars[idx] == 'C') {
                if (sChars[idx++] == 'D') {
                    result += 400;
                } else if (sChars[idx++] == 'M') {
                    result += 900;
                } else {
                    result += symbolMap.get(String.valueOf(sChars[idx]));
                }
            } else {
                result += symbolMap.get(String.valueOf(sChars[idx]));
            }
            idx++;
        }

        String[] ss = "babad".split("");

        List<String> list = new ArrayList<>();
        list.stream().map(x -> x.length()).max((x, xx) -> xx);

        return result;
    }
}
