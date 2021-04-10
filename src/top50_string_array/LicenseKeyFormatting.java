package top50_string_array;

public class LicenseKeyFormatting {

    public static void main(String[] args) {

        String S = "5F3Z-2e-9-w";
//		String S = "2-5g-3-J";
        int k = 4;
        System.out.println(licenseKeyFormatting(S, k));
    }

    public static String licenseKeyFormatting(String str, int k) {
        str = str.replaceAll("-", "");
        str = str.toUpperCase();

        StringBuilder sb = new StringBuilder(str);

        for(int i=k; i<str.length(); i=i+k) {
            sb.insert(str.length()-i, '-');
        }

        return sb.toString();
    }

}
