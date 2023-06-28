package section01;

import java.util.*;

public class S02 {
    public String solution(String str){
        StringBuilder answer= new StringBuilder();

        for(Character c:str.toCharArray()){
            if('a'<=c&&c<='z')
                c=Character.toUpperCase(c);
            else if('A'<=c && c<='Z')
                c=Character.toLowerCase(c);
            answer.append(c);
        }

        return answer.toString();
    }

    public static void main(String[] args){
        S02 T = new S02();
        Scanner kb = new Scanner(System.in);
        String str=kb.next();
        System.out.print(T.solution(str));
    }
}
