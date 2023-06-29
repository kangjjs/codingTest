package section01;

import java.util.Scanner;

public class S06 {
    public String solution(String str){
        StringBuilder sb =new StringBuilder();
        int [] c =new int[26];

        for(char x:str.toCharArray()){
            int k=(int) x -97;
            if(c[k]==0){
                sb.append(x);
                c[k]=1;
            }
        }

        return sb.toString();
    }

    public static void main(String[] args){
        S06 T = new S06();
        Scanner kb = new Scanner(System.in);
        String str=kb.nextLine();
        System.out.print(T.solution(str));
    }
}
