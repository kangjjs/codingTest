package section01;

import java.util.Scanner;

public class S05 {
    public String solution(String str){

        int n=str.length();
        char [] s= str.toCharArray();
        int lt=0,rt=n-1;

        while(lt<rt){
            if(!Character.isAlphabetic(s[lt])){
                lt++;
            }else if(!Character.isAlphabetic(s[rt])){
                rt--;
            }else{
                char tmp=s[lt];
                s[lt]=s[rt];
                s[rt]=tmp;
                lt++;
                rt--;
            }
        }

        return String.valueOf(s);
    }

    public static void main(String[] args){
        S05 T = new S05();
        Scanner kb = new Scanner(System.in);
        String str=kb.nextLine();
        System.out.print(T.solution(str));
    }
}
