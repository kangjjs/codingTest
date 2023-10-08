package section01;

import java.util.*;
class S02 {
    public String solution(String s){

        StringBuilder answer= new StringBuilder();

        for(Character c : s.toCharArray()){
            if('a'<=c&&c<='z')
                answer.append(Character.toUpperCase(c));
            else if('A'<=c&&c<='Z')
                answer.append(Character.toLowerCase(c));
        }

        return answer.toString();
    }

    public static void main(String[] args){
        S02 T = new S02();
        Scanner kb = new Scanner(System.in);
        String s = kb.next();

        System.out.println(T.solution(s));
    }
}