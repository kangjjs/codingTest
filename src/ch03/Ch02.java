package ch03;

import java.util.*;

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
                        StringBuilder res= new StringBuilder();
                        while (!st.empty() && Character.isDigit(st.peek().charAt(0))) {
                            num.insert(0, st.pop());
                        }

                        int count;

                        if (num.toString().equals(""))
                            count = 1;
                        else
                            count=Integer.parseInt(num.toString());

                        for(int i=0;i<count;i++){
                            res.append(tmp);
                        }

                        st.push(res.toString());
                        break;
                    }
                    tmp=c+tmp;
                }
            } else
                st.push(String.valueOf(x));
        }

        for(String x:st){
            answer.append(x);
        }

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
