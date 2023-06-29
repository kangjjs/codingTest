package section01;

import java.util.Scanner;

public class S09 {
    public int solution(String str){
        StringBuilder sb=new StringBuilder();

        for(char x:str.toCharArray()){
            if('0'<=x&&x<='9')
                sb.append(x);
        }

        if(sb.charAt(0)=='0')
            sb.deleteCharAt(0);
        return Integer.parseInt(sb.toString());
    }

    public static void main(String[] args){
        S09 T = new S09();
        Scanner kb = new Scanner(System.in);
        String str=kb.nextLine();
        System.out.print(T.solution(str));
    }
}