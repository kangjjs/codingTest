package section05;

import java.util.*;

class S01 {

    public String solution(String str) {
        String answer="NO";

        Stack<Character> stack =new Stack<>();

        for(char x:str.toCharArray()){
            if(x=='(')
                stack.push(x);
            else {
                if(stack.isEmpty())
                    return "NO";
                stack.pop();
            }
        }

        if(stack.isEmpty())
            return "YES";

        return answer;
    }

    public static void main(String[] args) {
        S01 T = new S01();
        Scanner kb = new Scanner(System.in);

        String str= kb.next();

        System.out.print(T.solution(str));
    }
}

