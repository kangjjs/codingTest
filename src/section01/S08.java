package section01;

import java.util.Scanner;

public class S08 {
    public String solution(String str){
        str=str.toUpperCase().replaceAll("[^A-Z]", "");
        String tmp=new StringBuilder(str).reverse().toString();
        if(str.equals(tmp))
            return "YES";
        return "NO";
    }

    public static void main(String[] args){
        S08 T = new S08();
        Scanner kb = new Scanner(System.in);
        String str=kb.nextLine();
        System.out.print(T.solution(str));
    }
}
