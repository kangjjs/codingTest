package ch06;

import java.util.*;

class Ch05 {

    LinkedList<String> tmp;
    ArrayList<String> res;

    public void dfs(int st, String s) {
        if (tmp.size() == 4 && st == s.length()) {
            String Ts = "";
            for (String x : tmp)
                Ts += x + '.';
            res.add(Ts.substring(0, Ts.length() - 1));
        } else {
            for (int i = st; i < s.length(); i++) {
                if (s.charAt(st) == '0' && i > st)
                    return;
                String num = s.substring(st, i + 1);
                if (Integer.parseInt(num) > 255)
                    return;
                tmp.add(num);
                dfs(i + 1, s);
                tmp.pollLast();
            }
        }
    }

    public String[] solution(String s) {
        tmp = new LinkedList<>();
        res = new ArrayList<>();
        dfs(0, s);
        String[] answer = new String[res.size()];
        for (int i = 0; i < res.size(); i++) {
            answer[i] = res.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        Ch05 T = new Ch05();
        System.out.println(Arrays.toString(T.solution("2025505")));
        System.out.println(Arrays.toString(T.solution("0000")));
        System.out.println(Arrays.toString(T.solution("255003")));
        System.out.println(Arrays.toString(T.solution("155032012")));
        System.out.println(Arrays.toString(T.solution("02325123")));
        System.out.println(Arrays.toString(T.solution("121431211")));
    }
}
