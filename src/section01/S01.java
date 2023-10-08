package section01;

import java.util.*;
class S01 {
    public int solution(String s,char c){

        int answer=0;

        for(Character x: s.toCharArray()){
            if(c==x)
                answer++;
        }

        return answer;
    }

    public static void main(String[] args){
        S01 T = new S01();
        Scanner kb = new Scanner(System.in);
        String str=kb.next();
        char c =kb.next().charAt(0);
        str=str.toLowerCase();
        c=Character.toLowerCase(c);

        System.out.print(T.solution(str,c));
    }
}
