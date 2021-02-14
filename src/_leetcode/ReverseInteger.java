package _leetcode;

public class ReverseInteger {
    public static void main(String[] args) {

    }

    public static int reverse(int x) {
        boolean isMinus = false;
        if(x < 0) {
            isMinus = true;
            x = Math.abs(x);
        }

        String[] splitInt = Integer.toString(x).split("");

        StringBuilder sb = new StringBuilder();
        for(int i=splitInt.length-1; i >= 0; i--) {
            sb.append(splitInt[i]);
        }
        try {
            int result = Integer.parseInt(sb.toString());

            return isMinus ? result * -1 : result;
        }catch (NumberFormatException nfe) {
            return 0;
        }
    }

    public static int reverse2(int x) {
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

    public int reverse3(int n) {
        long res = 0;
        while(n != 0)
        {
            res = res*10 + n%10;
            n = n/10;
        }
        if(res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) return 0;
        return (int) res;
    }
}
