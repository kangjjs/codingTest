package ch03;

import java.util.Stack;

class Ch02 {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        Stack<String> st = new Stack<>();
        for (Character x : s.toCharArray()) {
            if (x == ')') {
                String tmp = "";
                while (!st.empty()) {
                    String c = st.pop();
                    if (c.equals("(")) {
                        StringBuilder num = new StringBuilder();
                        while (!st.empty() && Character.isDigit(st.peek().charAt(0))) {
                            num.append(st.pop());
                        }
                        StringBuilder res = new StringBuilder();
                        int cnt = 0;
                        if (num.toString().equals(""))
                            cnt = 1;
                        else
                            cnt = Integer.parseInt(num.toString());
                        for (int i = 0; i < cnt; i++)
                            res.append(tmp);
                        st.push(res.toString());
                        break;
                    }
                    tmp = c + tmp;
                }
            } else st.push(String.valueOf(x));
        }
        for (String x : st)
            answer.append(x);
        return answer.toString();
    }

    public static void main(String[] args) {
        Ch02 T = new Ch02();
        System.out.println(T.solution("3(a2(b))ef"));
        System.out.println(T.solution("2(ab)k3(bc)"));
        System.out.println(T.solution("2(ab3((cd)))"));
        System.out.println(T.solution("2(2(ab)3(2(ac)))"));
        System.out.println(T.solution("3(ab2(sg))"));
    }
}
