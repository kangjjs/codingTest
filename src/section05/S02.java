package section05;

import java.util.Scanner;
import java.util.Stack;

public class S02 {

    public Stack<Character> solution(String str){
        Stack<Character> stack =new Stack<>();

        for(char x:str.toCharArray()){
            if(x==')'){
                while(stack.pop()!='(');
            }else
                stack.push(x);
        }

        return stack;
    }

    public static void main(String[] args) {
        S02 T = new S02();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();

        for(char x:T.solution(str)){
            System.out.print(x);
        }
    }
}
