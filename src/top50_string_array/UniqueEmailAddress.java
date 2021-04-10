package top50_string_array;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddress {

    public static void main(String[] args) {
        String[] emails = {"test.email+alex@leetcode.com",
                "test.e.mail+bob.cathy@leetcode.com",
                "testemail+david@lee.tcode.com"};
        System.out.println(new UniqueEmailAddress().numUniqueEmails(emails));
    }

    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();

        for (String email : emails) {
            StringBuilder sb = new StringBuilder();
            char[] chars = email.toCharArray();
            for(char c : chars) {
                if(c == '.') {
                    continue;
                }
                if(c == '+') {
                    break;
                }

                sb.append(c);
            }

            set.add(sb.toString() + email.substring(email.indexOf("@")));
        }

        return set.size();
    }

}
