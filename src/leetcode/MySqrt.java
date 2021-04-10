package leetcode;

public class MySqrt {
    public static void main(String[] args) {
        System.out.println(mySqrt(17));
    }

    public static int mySqrt(int x) {
        int left = 1, right = x;
        while(left <= right) {
            int mid = left + (right - left) / 2;

            if(mid == x / mid) {
                return mid;
            } else if (mid < x / mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }
    public int mySqrt2(int x) {
        int left = 1, right = x;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid == x / mid) {
                return mid;
            } else if (mid < x / mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }
}
