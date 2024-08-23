package leetcode;

public class String_M_5 {
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len == 1) {
            return s;
        }

        String ans = String.valueOf(s.charAt(0));
        int max = 1;

        for (int i = 0; i < len; i++) {
            int lt = i, rt = i;
            int cnt = 1;
            while (lt >= 0 && rt < len) {
                if (s.charAt(lt) != s.charAt(rt)) break;
                lt--;
                rt++;
                cnt += 2;
            }
            if (max < cnt) {
                max = cnt;
                ans = s.substring(lt + 1, rt);
            }


            if (i < len - 1 && s.charAt(i) == s.charAt(i + 1)) {
                lt = i;
                rt = i + 1;
                cnt = 2;
                while (lt >= 0 && rt < len) {
                    if (s.charAt(lt) != s.charAt(rt)) break;
                    lt--;
                    rt++;
                    cnt += 2;
                }
                if (max < cnt) {
                    max = cnt;
                    ans = s.substring(lt + 1, rt);
                }
            }
        }

        return ans;
    }
}
