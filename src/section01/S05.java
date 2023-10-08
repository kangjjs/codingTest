package section01;

import java.util.*;
class S05 {
    public String solution(String str){
        String answer="";
        char [] c =str.toCharArray();

        int lt=0,rt=c.length-1;

        while(lt<rt){
            if(!Character.isAlphabetic(c[lt]))
                lt++;
            else if(!Character.isAlphabetic(c[rt]))
                rt--;
            else{
                char tmp=c[lt];
                c[lt]=c[rt];
                c[rt]=tmp;
                lt++;
                rt--;
            }
        }

        for(char x:c){
            answer+=x;
        }

        return answer;
    }

    public static void main(String[] args){
        S05 T = new S05();
        Scanner kb = new Scanner(System.in);

        String str=kb.next();

        System.out.print(T.solution(str));

    }
}

