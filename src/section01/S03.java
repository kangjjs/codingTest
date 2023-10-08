package section01;

import java.util.*;
class S03 {
    public String solution(String s){

        String answer="";
        String [] str =s.split(" ");
        int max=Integer.MIN_VALUE;

        for(String x:str){
            int n= x.length();
            if(max<n){
                max=n;
                answer=x;
            }
        }

        return answer;
    }

    public static void main(String[] args){
        S03 T = new S03();
        Scanner kb = new Scanner(System.in);
        String s = kb.nextLine();

        System.out.println(T.solution(s));
    }
}
