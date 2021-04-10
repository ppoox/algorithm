package leetcode;

public class TestStrom {
    public static void main(String[] args) {
        Storm rs = new RainStorm(3.1, 5.4, 5.4);
        Storm ss = new SnowStorm(3.1, 5.4, 5.4, 100.0);

        System.out.println(rs.eyeRadius);
        System.out.println(rs.getEyePositionX());
        System.out.println(rs.getEyePositionY());

        System.out.println("=============================");

        System.out.println(ss.eyeRadius);
        System.out.println(ss.getEyePositionX());
        System.out.println(ss.getEyePositionY());
    }
}
