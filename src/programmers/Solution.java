package programmers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public int solution(String s) {

        int ans = 0;

        for (int i = 0; i < s.length() - 2; i++) {
            if(s.charAt(i)==s.charAt(i+1)&&s.charAt(i)==s.charAt(i+2))
                ans = Math.max(ans,Integer.parseInt(s.substring(i,i+3)));
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution("122223"));
    }
}
