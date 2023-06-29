package section01;

import java.util.Scanner;

public class S07 {

    public String solution(String str){
        int n=str.length();
        int lt=0,rt=n-1;

        while(lt<rt){
            if((str.charAt(rt)==str.charAt(lt)||((int)str.charAt(lt)-(int)str.charAt(rt)==32)||((int)str.charAt(rt)-(int)str.charAt(lt)==32))){
                lt++;
                rt--;
            }else
                return "NO";
        }
        return "YES";
    }

    public static void main(String[] args){
        S07 T = new S07();
        Scanner kb = new Scanner(System.in);
        String str=kb.nextLine();
        System.out.print(T.solution(str));
    }
}
