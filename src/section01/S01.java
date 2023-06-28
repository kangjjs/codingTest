package section01;

import java.util.Scanner;

public class S01 {
    public int solution(String s,char c){
        int answer =0;

        for(Character character: s.toCharArray()){
            if(c==character)
                answer++;
        }
        return answer;
    }

    public static void main(String[] args){
        S01 m =new S01();
        Scanner in=new Scanner(System.in);
        String str = in.next().toLowerCase();
        char c = in.next().toLowerCase().charAt(0);
        System.out.print(m.solution(str,c));
    }
}
