package section05;

import java.util.*;

class S02 {

    public String solution(String str) {
        String answer="";

        Stack<Character> stack =new Stack<>();

        for(Character x: str.toCharArray()){
            stack.push(x);
            if(x==')'){
                while(stack.pop()!='('){

                }
            }
        }

        for(Character x: stack){
            answer+=x;
        }

        return answer;
    }

    public static void main(String[] args) {
        S02 T = new S02();
        Scanner kb = new Scanner(System.in);

        String str= kb.next();

        System.out.print(T.solution(str));
    }
}
