package leetcode;

public class String_125 {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        String str = "";
        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c))
                str += c;
        }

        int lt = 0;
        int rt = str.length() - 1;

        while (lt < rt) {
            if (str.charAt(lt++) != str.charAt(rt--)) {
                return false;
            }
        }

        return true;
    }
}
