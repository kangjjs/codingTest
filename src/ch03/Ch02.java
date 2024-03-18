package ch03;

import java.util.Stack;

class Ch02 {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        Stack<String> stack = new Stack<>();
        char[] chars = s.toCharArray();

        for (char x : chars) {
            if (x == ')') {
                String str = "";
                while (!stack.isEmpty()) {
                    String c = stack.pop();
                    if (c.equals("(")) {
                        String num = "";
                        while (!stack.isEmpty() && Character.isDigit(stack.peek().charAt(0))) {
                            num += stack.pop();
                        }
                        String res = "";
                        int cnt;
                        if (num.equals(""))
                            cnt = 1;
                        else
                            cnt = Integer.parseInt(num);
                        for (int i = 0; i < cnt; i++)
                            res += str;
                        stack.push(res);
                        break;
                    }
                    str = c+ str;
                }
            } else {
                stack.push(String.valueOf(x));
            }
        }

        for(String x:stack)
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
