package section01;

import java.util.Scanner;

public class S03 {
    public String solution(String str){
        String [] strings = str.split(" ");
        String answer="";
        int max=0;
        for(String s:strings){
            max=Math.max(max,s.length());
            if(max==s.length())
                answer=s;
        }

        return answer;
    }

    public static void main(String[] args){
        S03 T = new S03();
        Scanner kb = new Scanner(System.in);
        String str=kb.nextLine();
        System.out.print(T.solution(str));
    }
}
